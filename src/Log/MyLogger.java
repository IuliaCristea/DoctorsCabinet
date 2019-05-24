package Log;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;

public class MyLogger {
    private static File logFile;
    private static FileWriter fileWriter = null;

    public static String GetLogFileName() {
        return logFile.toString();
    }

    public static void Initialize(){
        try {
            logFile = new File("Logs/Logs.csv");

        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void Info(String methodName, String message) {
        try {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            Thread th = Thread.currentThread();
            fileWriter = new FileWriter(logFile, true);
            fileWriter.append(time.toString());
            fileWriter.append(",");
            fileWriter.append(methodName);
            fileWriter.append(",");
            fileWriter.append(message);
            fileWriter.append(",");
            fileWriter.append(th.getName());
            fileWriter.append("\n");
            CloseLogging();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void Error(String methodName, String message){
        try {
            fileWriter = new FileWriter(logFile, true);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            Thread th = Thread.currentThread();
            fileWriter.append(time.toString());
            fileWriter.append(",");
            fileWriter.append(methodName);
            fileWriter.append(",");
            fileWriter.append(message);
            fileWriter.append(",");
            fileWriter.append(th.getName());
            fileWriter.append("\n");
            CloseLogging();
        }
        catch(Exception ex){
            System.out.println(ex);
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
