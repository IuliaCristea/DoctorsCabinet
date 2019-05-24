package SwingUI;

import Classes.Appointment;
import Classes.Consultation;
import Classes.Doctor;
import Classes.Patient;
import DAO.JPAAppointmentDAO;
import DAO.JPAConsultationDAO;
import DAO.JPADoctorDAO;
import DAO.JPAPatientDAO;
import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PatientMenu {
    private JFrame patientMenuFrame;
    private JPanel patientMenu;
    private JLabel iuliaClinic;
    private JPanel bar;
    private JLabel choices;
    private JLabel toDo;
    private JButton showApps;
    private JButton showSpecs;
    private JButton showDocs;
    private JPanel result;
    private JPanel show;
    private JPanel actions;
    private JPanel menu;
    private JButton makeApp;
    private JButton updateProfile;
    private JButton deleteAcc;
    private JList resultList;
    private JButton history;
    private Patient patient;
    private JPAAppointmentDAO jpaAppointmentDAO;
    private JPAPatientDAO jpaPatientDAO;

    public PatientMenu(Patient patient){
        this.patient = patient;
        this.jpaAppointmentDAO = new JPAAppointmentDAO();
        this.jpaPatientDAO = new JPAPatientDAO();

        patientMenuFrame = new JFrame("PatientMenu");
        patientMenuFrame.setContentPane(patientMenu);
        patientMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientMenuFrame.pack();
        patientMenuFrame.setVisible(true);


        showApps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Appointment> apps = new ArrayList<>();
                try {
                    apps = jpaAppointmentDAO.getAppointmentsByPatient(patient.getCNP());
                    String[] appointments = new String[100];
                    int i = 0;
                    for (Appointment a : apps) {
                        String s = a.getDate() + " " + a.getDoctor().getFirstName()+ " " + a.getDoctor().getLastName();
                        appointments[i] = s;
                        i++;
                    }
                    resultList.setListData(appointments);


                }
                catch(Exception ex)
                {
                    MyLogger.Error("show appointments for patient", ex.toString());
                }
            }
        });
        showSpecs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] specializations = {"Pediatrics" , "Neurology", "Cardiology", "Surgery",
                                            "Gastroenterology",
                                            "FamilyMedicine",
                                            "LaborMedicine",
                                            "Ophthalmology",
                                            "Psychology",
                                            "Dentistry"};
                resultList.setListData(specializations);

            }
        });
        showDocs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPADoctorDAO jpaDoctorDAO = new JPADoctorDAO();
                Set<Doctor> doctors = jpaDoctorDAO.getAll();
                String[] docsNames = new String[100];
                int i = 0;
                for(Doctor d : doctors)
                {
                    docsNames[i] = d.getFirstName() + " " + d.getLastName() + " "+ d.getCNP() + " " + d.getSpecialization();
                    i++;
                }

                resultList.setListData(docsNames);
            }
        });
        deleteAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpaPatientDAO.delete(patient);
                new MainFrame();
                patientMenuFrame.dispose();
            }
        });
        updateProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProfileForm();
                patientMenuFrame.dispose();
            }
        });
        makeApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeAppointmentFrame(patient);
                patientMenuFrame.dispose();
            }
        });
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPAConsultationDAO jpaConsultationDAO = new JPAConsultationDAO();
                List<Consultation> consultations2 = jpaConsultationDAO.getConsultationsByPatient(patient.getCNP());
                String[] cons = new String[100];
                int i = 0;
                for(Consultation c : consultations2)
                {
                    cons[i] = c.getDate() + " "+
                              c.getDoctor().getLastName()+ " " +
                              c.getDoctor().getFirstName()+ " " +
                              c.getDiagnosis() + " "+
                              c.getRecipe()+ " " +
                              c.getTicket().toString()+ " "+
                              c.getObservations();
                    i++;
                }

                resultList.setListData(cons);
            }
        });
    }
}
