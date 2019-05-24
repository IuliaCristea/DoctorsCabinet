package SwingUI;

import Classes.Patient;
import DAO.JPAPatientDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class UpdateProfileForm {
    private JFrame updateProfileFrame;
    private JPanel updatePanel;
    private JLabel cnpLabel;
    private JTextField cnpTextField;
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
    private JButton updateButton;
    private JPanel base;

    public UpdateProfileForm(){
        updateProfileFrame = new JFrame("Update profile");
        updateProfileFrame.setContentPane(updatePanel);
        updateProfileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateProfileFrame.pack();
        updateProfileFrame.setVisible(true);


        updateButton.addActionListener(new ActionListener() {
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
                    JPAPatientDAO jpaPatientDAO = new JPAPatientDAO();
                    jpaPatientDAO.update(patient);
                    new PatientMenu(patient);
                    updateProfileFrame.dispose();

                }
                catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
