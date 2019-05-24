package SwingUI;

import Classes.Patient;
import DAO.JPAPatientDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInFrame {
    private JFrame signInFrame;
    private JPanel signInPanel;
    private JButton signInButton;
    private JTextField cnpTextField;
    private JLabel invalidCnp;

    public SignInFrame(){
        signInFrame = new JFrame("SignInMenu");
        signInFrame.setContentPane(signInPanel);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInFrame.pack();
        signInFrame.setVisible(true);
        invalidCnp.setVisible(false);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpPatient = cnpTextField.getText();
                JPAPatientDAO jpaPatientDAO = new JPAPatientDAO();
                Patient patient = jpaPatientDAO.getById(cnpPatient);
                if(patient == null)
                {
                    invalidCnp.setVisible(true);
                }
                else {
                    invalidCnp.setVisible(false);
                    new PatientMenu(patient);
                    signInFrame.dispose();
                }


            }
        });
    }
}
