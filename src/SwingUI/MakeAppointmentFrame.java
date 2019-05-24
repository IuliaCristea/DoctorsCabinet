package SwingUI;

import Classes.Doctor;
import Classes.Patient;
import DAO.JPAAppointmentDAO;
import DAO.JPADoctorDAO;
import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeAppointmentFrame {
    private JFrame makeAppointmentFrame;
    private JPanel makeApp;
    private JPanel bar;
    private JLabel iuliaClinic;
    private JPanel menu;
    private JLabel mkApp;
    private JPanel infoCnp;
    private JLabel cnpDoc;
    private JTextField cnpInput;
    private JPanel infoData;
    private JLabel dateLabel;
    private JTextField dateInput;
    private JButton submitButton;
    private Patient patient;
    private JPAAppointmentDAO jpaAppointmentDAO;


    public MakeAppointmentFrame(Patient patient) {

        this.patient = patient;
        this.jpaAppointmentDAO = new JPAAppointmentDAO();

        this.makeAppointmentFrame = new JFrame("Make appointment");

        makeAppointmentFrame = new JFrame("PatientMenu");
        makeAppointmentFrame.setContentPane(makeApp);
        makeAppointmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeAppointmentFrame.pack();
        makeAppointmentFrame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String cnpDoctor = cnpInput.getText();
                    String date  = dateInput.getText();
                    JPADoctorDAO jpaDoctorDAO = new JPADoctorDAO();
                    Doctor doc = jpaDoctorDAO.getById(cnpDoctor);
                    DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                    Date d = formatter.parse(date);
                    patient.makeAppointment(doc, d);
                    new PatientMenu(patient);
                    makeAppointmentFrame.dispose();
                }
                catch (Exception ex) {
                    MyLogger.Error("submit button make app patient", ex.toString());
                }
            }
        });
    }
}
