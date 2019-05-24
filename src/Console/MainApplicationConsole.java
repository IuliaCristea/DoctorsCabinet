package Console;

import Log.MyLogger;

import java.io.IOException;
import java.util.Scanner;

public class MainApplicationConsole {
    public String choice;
    public void PatientOrDoctor() throws IOException {
        try {
            System.out.println("Are you a doctor or a patient?");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();

            switch (choice){
                case "patient":
                    PatientConsole pc = new PatientConsole();
                    pc.PatientMenu();
                    break;
                case "doctor":
                    DoctorConsole dc = new DoctorConsole();
                    dc.DoctorMenu();
                    break;
                default:
                    throw new Exception("Invalit user input!");
            }
         }
        catch(Exception ex){
            MyLogger.Error("PatientOrDoctor", ex.toString());
        }
     }
}
