package Log;

import java.io.*;
import java.time.LocalDate;

public class MyLogger {
    private static File logFile;
    private static FileWriter fileWriter = null;

    public static String GetLogFileName() {
        return logFile.toString();
    }

    public static void Initialize(){
        try {
            logFile = new File("Logs/Logs.txt");
            fileWriter = new FileWriter(logFile, true);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void Info(String methodName, String message) {
        try {
            String defaultMessage = String.format(LocalDate.now() + methodName + message);
            fileWriter.append(defaultMessage);
            fileWriter.append("\n");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void Error(String methodName, String message){
        try {
            String defaultMessage = String.format(LocalDate.now() + methodName + message);
            fileWriter.append(defaultMessage);
            fileWriter.append("\n");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void Error(StackTraceElement[] stackTrace, Exception ex){
        try {
            ex.printStackTrace();
            fileWriter.append(ex.getMessage());
            fileWriter.append("\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void CloseLogging(){
        try {
            fileWriter.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
