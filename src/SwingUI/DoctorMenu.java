package SwingUI;

import Classes.Appointment;
import Classes.Doctor;
import DAO.JPAAppointmentDAO;
import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DoctorMenu {
    private JFrame doctorMenuFrame;
    private JPanel docMenuPanel;
    private JPanel bar;
    private JLabel iuliaClinic;
    private JPanel menu;
    private JLabel welcome;
    private JPanel buttons;
    private JButton showApps;
    private JButton makeCons;
    private JPanel appList;
    private JList appsList;
    private Doctor doctor;
    private JPAAppointmentDAO jpaAppointmentDAO;

    public DoctorMenu(Doctor doctor)
    {
        this.jpaAppointmentDAO = new JPAAppointmentDAO();
        this.doctor = doctor;

        doctorMenuFrame = new JFrame("Doctor Menu");
        doctorMenuFrame.setContentPane(docMenuPanel);
        doctorMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctorMenuFrame.pack();
        doctorMenuFrame.setVisible(true);

        showApps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Appointment> apps = new ArrayList<>();
                try {
                    apps = jpaAppointmentDAO.getAppointmentsByDoctor(doctor.getCNP());
                    String[] appointments = new String[100];
                    int i = 0;
                    for (Appointment a : apps) {
                        String s = a.getDate() + " " + a.getPatient().getLastName()+ " " + a.getPatient().getFirstName();
                        appointments[i] = s;
                        i++;
                    }
                    appsList.setListData(appointments);


                }
                catch(Exception ex)
                {
                    MyLogger.Error("show appointments for doctor", ex.toString());
                }
            }
        });
        makeCons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeConsultationFrame(doctor);
                doctorMenuFrame.dispose();
            }
        });
    }
}
