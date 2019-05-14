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
                JFrame frame = new JFrame("PatientMenu");
                frame.setContentPane(new PatientFrame().getPatientMenu());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                mainFrame.setVisible(false);
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
