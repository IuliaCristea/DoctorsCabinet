package Console;

import Classes.*;
import DAO.JPAAppointmentDAO;
import DAO.JPAConsultationDAO;
import DAO.JPADoctorDAO;
import DAO.JPAPatientDAO;
import Log.MyLogger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PatientConsole {

    private Scanner scanner = new Scanner(System.in);
    private static JPAPatientDAO jpaPatientDAO = new JPAPatientDAO();
    private static Patient patient;

    public void PatientMenu() throws IOException {
        System.out.println("Are you a new patient? yes/no");
        try {
            var choice = scanner.next();
            switch (choice) {
                case "yes":
                    System.out.println("Do you want to register? yes/no");
                    var ch = scanner.next();
                    switch (ch) {
                        case "yes":
                            RegisterNewPatient();
                            break;
                        case "no":
                            Exit();
                            break;
                    }
                    break;
                case "no":
                    ExistingPatient();
                    break;
                default:
                    throw new Exception("Invalit user input!");
            }
        }
        catch(Exception ex)
        {
            MyLogger.Error("PatientMenu", ex.toString());
            MyLogger.Error("PatientMenu", ex.getStackTrace().toString());
        }
    }


    private void RegisterNewPatient() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String lastName, firstName, cnp, gender,phone,date;
        String address;
        int age;
        try{
        System.out.println("Introduce your last name: ");
        lastName = scanner.nextLine();
        System.out.println(lastName);
        System.out.println("Introduce your first name:");
        firstName= scanner.nextLine();
        System.out.println(firstName);
        System.out.println("Introduce your cnp:");
        cnp = scanner.nextLine();
        System.out.println(cnp);
        System.out.println("Introduce your date of birth:");
        date = scanner.nextLine();
        System.out.println(date);
        System.out.println("Introduce your gender:");
        gender = scanner.nextLine();
        System.out.println(gender);
        System.out.println("Introduce your address:");
        address = scanner.nextLine();
        System.out.println("Introduce your phone number:");
        phone = scanner.nextLine();

        //System.out.println("Introduce your address: street name:");
        //address.setStreet(scanner.nextLine());
        //System.out.println("street number:");
        //address.setStreetNumber(scanner.nextInt());
        //System.out.println("building:");
        //address.setBuilding(scanner.nextLine());
        //System.out.println("floor:");
        //address.setFloor(scanner.nextInt());
        //System.out.println("apartment number:");
        //address.setApartmentOrRoom(scanner.nextInt());


        Patient patient = new Patient(firstName,lastName, cnp, date, gender, address,phone);

        jpaPatientDAO.save(patient);
        System.out.println("Go to menu?");
        var choice = scanner.nextLine();
        switch(choice){
            case "yes":
                ExistingPatient();
                break;
            case"no":
                Exit();
                break;
        }
        }
        catch(Exception ex){
            MyLogger.Error("RegisterNewPatient", ex.toString());
            MyLogger.Error("RegisterNewPatient", ex.getStackTrace().toString());
        }
    }
    private void ExistingPatient() throws IOException {
        System.out.println("Introduce your cnp to log in:");
        try {
        int count  = 0;
        var cnp2 = scanner.next();
        var line = scanner.nextLine();
        while(count < 3)
        {
            patient = jpaPatientDAO.getById(cnp2);
            if(patient != null)
            {
                System.out.println("Wellcome " + patient.getFirstName());
                break;
            }
            if(count == 3)
            {
                System.out.println("You are not welcome anymore!");
                return;

            }

            System.out.println("Try Again");
            count ++;
            line = scanner.nextLine();

        }

        System.out.println("What do you want to do now?");
        System.out.println("Show specializations, show my appointments, show history, make appointment");
            var choice = scanner.nextLine();
            switch (choice) {
                case "specializations":
                    ShowSpecializations();
                    break;
                case "appointments":
                    ShowAppointments();
                    break;
                case "history":
                    ShowHistory();
                    break;
                case "make appointment":
                    MakeAppointment();
                    break;
                default:
                    throw new Exception("Invalit user input!");
            }
        }
        catch(Exception ex){
            MyLogger.Error("ExistingPatient", ex.toString());
            MyLogger.Error("ExistingPatient", ex.getStackTrace().toString());
        }
    }

    private void MakeAppointment() throws ParseException {
        System.out.println("what doctor? cnp");
        var cnp = scanner.nextLine();
        System.out.println("what date? date");
        var date = scanner.nextLine();

        JPADoctorDAO jdoc = new JPADoctorDAO();
        Doctor doc = jdoc.getById(cnp);
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        Date date2 = formatter.parse(date);
        //jpaPatientDAO.makeAppointment(this.patient,doc,date2);


    }

    private void ShowHistory() {
        try{
            JPAConsultationDAO jcons = new JPAConsultationDAO();
            List<Consultation> cons = new ArrayList<>();
            cons = jcons.getConsultationsByPatient(this.patient.getCNP());
            for (Consultation c : cons) {
                System.out.println(c.getDoctor().getFirstName() + " " + c.getDoctor().getLastName() + " "+ c.getSpecialization().toString() + "\n"+
                                    c.getDate() + "\n" +
                                    c.getDiagnosis() + "\n" +
                                    c.getObservations() + "\n" +
                                    c.getRecipe() + "\n" +
                                    c.getTicket().toString() +
                                    "\n");
            }
        }
        catch (Exception ex)
        {
            MyLogger.Error("Show history patient ", ex.toString());
        }

    }

    private void ShowAppointments() {
        try {
            JPAAppointmentDAO jpaAppointmentDAO = new JPAAppointmentDAO();
            List<Appointment> list = new ArrayList();
            list = jpaAppointmentDAO.getAppointmentsByPatient(patient.getCNP());
            for (Appointment app : list) {
                System.out.println(app.getDoctor().getFirstName() + " " + app.getDoctor().getLastName() + " "+ app.getDate());
            }
        }
        catch(Exception ex){
            MyLogger.Error("show appointments in patient console",ex.toString());
        }

    }

    private void ShowDoctors(String specialization) {

        try {
            JPADoctorDAO jpaDoctor = new JPADoctorDAO();
            List<Doctor> list = new ArrayList();
            list = jpaDoctor.getDoctorsBySpecialization(specialization);
            for (Doctor doc : list) {
                System.out.println(doc.getFirstName()+ " "+ doc.getLastName() + " "+ doc.getGender());
            }
        }
        catch(Exception ex){
            MyLogger.Error("show doctors in patient console",ex.toString());
        }


    }

    private void ShowSpecializations(){
        System.out.println("Choose the specialization you want: ");
        System.out.println(java.util.Arrays.asList(Specialization.values()));
        String spec = scanner.nextLine();

        System.out.println("Do you want to show doctors?");
        var choice = scanner.nextLine();
        switch (choice){
            case "yes":
                ShowDoctors(spec);
                break;
            default:
                //de facut
                break;

        }

    }

    private void Exit(){}
}
