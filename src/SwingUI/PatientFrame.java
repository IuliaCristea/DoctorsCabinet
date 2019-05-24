package SwingUI;

import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientFrame {
    private JFrame patientFrame;
    private JPanel patientMenu;
    private JButton registerButton;
    private JButton signInButton;
    private JLabel signInLabel;
    private JLabel registerLabel;

    public PatientFrame() {
        patientFrame = new JFrame("PatientMenu");
        patientFrame.setContentPane(patientMenu);
        patientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientFrame.pack();
        patientFrame.setVisible(true);
        MyLogger.Info("patient frame", "patient menu");
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignInFrame();
                patientFrame.setVisible(false);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
                patientFrame.setVisible(false);
            }
        });
    }

    public JPanel getPatientMenu() {
        return patientMenu;
    }
}
