package SwingUI;

import Classes.Doctor;
import Classes.PrescriptionTicket;
import DAO.JPAConsultationDAO;
import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeConsultationFrame {
    private JFrame makeConsultationframe;
    private JPanel makeCons;
    private JPanel bar;
    private JLabel iuliaClinic;
    private JPanel menu;
    private JPanel patient;
    private JLabel p;
    private JTextField cnpPatientInput;
    private JPanel diagnosis;
    private JLabel diagnosisLabel;
    private JTextField diagnosisInput;
    private JPanel obsPane;
    private JLabel obs;
    private JTextField observations;
    private JPanel recipePanel;
    private JLabel recipe;
    private JTextField recipeText;
    private JPanel ticketPanel;
    private JLabel ticketLabel;
    private JPanel datePanel;
    private JLabel dateLabel;
    private JTextField date;
    private JPanel submit;
    private JButton submitButton;
    private JTextField ticketInput;
    private JPAConsultationDAO jpaConsultationDAO;
    private Doctor doctor;


    public MakeConsultationFrame(Doctor doctor)
    {
        this.jpaConsultationDAO = new JPAConsultationDAO();
        this.doctor = doctor;

        makeConsultationframe = new JFrame("Make consultation");
        makeConsultationframe.setContentPane(makeCons);
        makeConsultationframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeConsultationframe.pack();
        makeConsultationframe.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String cnpPatient = cnpPatientInput.getText();
                    String diagnosis = diagnosisInput.getText();
                    String o  = observations.getText();
                    String r = recipeText.getText();
                    String pt = ticketInput.getText();
                    String d = date.getText();
                    DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                    Date date2 = formatter.parse(d);
                    PrescriptionTicket ti = PrescriptionTicket.None;
                    switch(pt)
                    {
                        case "ORL":
                             ti= PrescriptionTicket.ORL;
                            break;
                        case "XRays":
                            ti = PrescriptionTicket.XRays;
                            break;
                        case "Medical tests":
                            ti = PrescriptionTicket.MedicalTests;

                    }
                    doctor.makeConsultation(cnpPatient,date2,diagnosis,o,r,ti);
                    new DoctorMenu(doctor);
                    makeConsultationframe.dispose();
                }
                catch(Exception ex)
                {
                    MyLogger.Error("make consultation doc menu", ex.toString());
                }

            }
        });
    }
}
