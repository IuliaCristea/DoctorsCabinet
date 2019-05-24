package SwingUI;

import Classes.Doctor;
import DAO.JPADoctorDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorFrame {
    private  JFrame doctorFrame;
    private JPanel doctorPanel;
    private JPanel signInPanel;
    private JButton signInButton;
    private JTextField cnpTextField;
    private JLabel invalidCnp;

    public DoctorFrame(){
        doctorFrame = new JFrame("SignInMenu");
        doctorFrame.setContentPane(signInPanel);
        doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctorFrame.pack();
        doctorFrame.setVisible(true);
        invalidCnp.setVisible(false);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpDoctor = cnpTextField.getText();
                JPADoctorDAO jpaDoctorDAO = new JPADoctorDAO();
                Doctor doctor = jpaDoctorDAO.getById(cnpDoctor);
                if(doctor == null)
                {
                    invalidCnp.setVisible(true);
                }
                else {
                    invalidCnp.setVisible(false);
                    new DoctorMenu(doctor);
                    doctorFrame.dispose();
                }


            }
        });
    }
}
