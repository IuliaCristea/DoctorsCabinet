import Classes.Patient;
import Console.MainApplicationConsole;
import DAO.JPAPatientDAO;
import Log.MyLogger;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            MyLogger.Initialize();
            MainApplicationConsole console = new MainApplicationConsole();
            console.PatientOrDoctor();
            JPAPatientDAO patientDAO = new JPAPatientDAO();
            List<Patient> patients = patientDAO.getAll();
//            for (Patient patient : patients) {
//                System.out.println(patient.getFirstName());
//                System.out.println(patient.getLastName());
//                System.out.println(patient.getCNP());
//                System.out.println(patient.getPhone());
//            }


        }
        catch(Exception ex){
            MyLogger.Error("Main", ex.toString());
            MyLogger.Error("Main", ex.getStackTrace().toString());
        }
        MyLogger.CloseLogging();
    }
}
