package Console;

import Classes.Appointment;
import Classes.Doctor;
import Classes.PrescriptionTicket;
import DAO.JPAAppointmentDAO;
import DAO.JPADoctorDAO;
import Log.MyLogger;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DoctorConsole {
    private Scanner scanner = new Scanner(System.in);
    private JPADoctorDAO jpaDoctorDAO = new JPADoctorDAO();
    private Doctor doctor;

    public void DoctorMenu() throws IOException {

        System.out.println("Hello! Please register: introduce your cnp:");
        var cnp = scanner.nextLine();
        this.doctor = jpaDoctorDAO.getById(cnp);

        System.out.println(String.format("Hello {0}! What do you want to do?",doctor.getFirstName()+" " + doctor.getLastName()));
        System.out.println("Show appointments, make consultation");
        try {
            var choice = scanner.nextLine();
            switch (choice) {
                case "appointments":
                    ShowAppointments();
                    break;
                case "consultation":
                    MakeConsultation();
                    break;
                    default:
                    throw new Exception("Invalit user input!");
            }
        }
        catch(Exception ex){
            MyLogger.Error("DoctorMenu", ex.toString());
            MyLogger.Error("DoctorMenu", ex.getStackTrace().toString());
        }
    }

    private void MakeConsultation() throws ParseException {
        System.out.println("What patient?");
        String  cnp_p =  scanner.nextLine();
        System.out.println("date: ");
        String d = scanner.nextLine();
        Date date = new Date();
        System.out.println("diagnosis?");
        String diagnosis = scanner.nextLine();
        System.out.println("observations");
        String observations = scanner.nextLine();
        System.out.println("recipe");
        String recipe = scanner.nextLine();
        System.out.println("ticket");
        String ticket = scanner.nextLine();
        PrescriptionTicket ps = PrescriptionTicket.None;
        switch(ticket){
            case "Medical tests":
                ps = PrescriptionTicket.MedicalTests;
                break;
            case "XRays":
                ps = PrescriptionTicket.XRays;
                break;
        }
        doctor.makeConsultation(cnp_p,date,diagnosis,observations,recipe,ps);
    }

    private void ShowAppointments() {

        try {
            JPAAppointmentDAO jpaAppointmentDAO = new JPAAppointmentDAO();
            List<Appointment> list = new ArrayList();
            list = jpaAppointmentDAO.getAppointmentsByDoctor(doctor.getCNP());
            for (Appointment app : list) {
                System.out.println(app.getId()+ " "+ app.getPatient().getFirstName() + " "+ app.getPatient().getLastName() + " "+ app.getDoctor().getFirstName() + " " + app.getDoctor().getLastName() + " "+ app.getDate());
            }
        }
        catch(Exception ex){
            MyLogger.Error("show appointments in patient console",ex.toString());
        }

    }
}
