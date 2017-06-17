package Test;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUIForm extends JFrame {
    private JPanel rootPanel;
    private JButton display;
    private JButton button1;

    public TestGUIForm() {
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("1");
            }
        });
    }


    public static void main(String[] args) {
        new TestGUIForm();
    }


}
