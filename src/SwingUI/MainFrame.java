package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private JFrame mainFrame;
    private JPanel MainMenu;
    private JButton patientButton;
    private JButton doctorButton;

    public MainFrame(){
        mainFrame= new JFrame("MainMenu");
        mainFrame.setContentPane(this.MainMenu);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"hi");
                new PatientFrame();
                mainFrame.dispose();
            }
        });

        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorFrame();
                mainFrame.dispose();
            }
        });
    }

    public JPanel getMainMenu() {
        return MainMenu;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
