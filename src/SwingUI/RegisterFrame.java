package SwingUI;

import Classes.Patient;
import Log.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class RegisterFrame {
    private JFrame registerFrame;
    private JPanel registerPanel;
    private JTextField cnpTextField;
    private JLabel cnpLabel;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JLabel birthDateLabel;
    private JTextField birthdateTextField;
    private JLabel genderLabel;
    private JTextField genderTextField;
    private JLabel addressLabel;
    private JTextField addressTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton savePatient;
    private JButton signInButton;
    private JLabel regSuceed;

    public RegisterFrame(){
        try {
            registerFrame = new JFrame("Register new patient");
            registerFrame.setContentPane(registerPanel);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registerFrame.pack();
            registerFrame.setVisible(true);
            regSuceed.setVisible(false);
            savePatient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cnpPatient = cnpTextField.getText();
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();
                    String birthDate = birthdateTextField.getText();
                    String gender = genderTextField.getText();
                    String address = addressTextField.getText();
                    String phone = phoneTextField.getText();

                    try {
                        Patient patient = new Patient(firstName, lastName, cnpPatient, birthDate, gender, address, phone);
                        patient.registerNewPatient();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    regSuceed.setVisible(true);
                    savePatient.setEnabled(false);
                }

            });
            signInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerFrame.dispose();
                    new SignInFrame();
                }
            });
        }
        catch(Exception ex)
        {
            MyLogger.Error("register new patient frame ", ex.toString());
        }

    }

}
