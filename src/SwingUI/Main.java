package SwingUI;

import Log.MyLogger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            MyLogger.Initialize();
            new MainFrame();

        }
        catch(Exception ex){
            MyLogger.Error("SwingUI.MainFrame", ex.toString());
            MyLogger.Error("SwingUI.MainFrame", ex.getStackTrace().toString());
        }
        MyLogger.CloseLogging();
    }
}
