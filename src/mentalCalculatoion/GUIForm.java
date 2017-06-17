package mentalCalculatoion;

//программа: счет в уме

import javax.swing.*;
import java.awt.*;

public class GUIForm extends JFrame {

    private JPanel rootPanel;

    public GUIForm() {
        setContentPane(rootPanel);//TODO РАЗОБРАТЬСЯ ЧТО ДЕЛАЕТ МЕТОД.Если его убрать, что ничего не отображается
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setSize((int) toolkit.getScreenSize().getWidth() / 2, (int) toolkit.getScreenSize().getHeight() / 2);
        setLocation(100,50);
        setResizable(false);
        setTitle("Mental Calculation");

    }


    public static void main(String[] args) {
        new GUIForm();
    }

}
