package Test.Calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 300;

    public Calculator() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //создаем три кнопки
        JButton fistButton = new JButton("1");
        JButton secondButton = new JButton("2");
        JButton plusButton = new JButton("+");
        JButton equalButton = new JButton("=");
        JButton clearButton = new JButton("Clear");

        JButton contanationButton = new JButton("a++");
        JButton exitButton = new JButton("exit");

        //создаем действия
        //TODO потом сделай вывод теекста во фрейм
        OneMessageAction fistMessageAction = new OneMessageAction("действие 1");
        OneMessageAction secondMessageAction = new OneMessageAction("действие 2");


        //привязываем несколько действий к одной кнопке
        fistButton.addActionListener(fistMessageAction);
        fistButton.addActionListener(secondMessageAction);
        fistButton.addActionListener(e -> {
            System.out.println("lambda");
        });

        contanationButton.addActionListener(new ContanationAction());
        exitButton.addActionListener(e -> {
            System.exit(0);
        });


        buttonPanel = new JPanel();
        add(buttonPanel);

        buttonPanel.add(fistButton);
        buttonPanel.add(secondButton);
        buttonPanel.add(plusButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(contanationButton);
        buttonPanel.add(exitButton);




        /*
        ComponentTest result = new ComponentTest(Integer.toString(new ContanationAction().result),500,200,100,100);
        add(result);
        */





    }
}


//вывод 1 сообщения
class OneMessageAction implements ActionListener {

    private String message;

    public OneMessageAction(String message) {
        this.message = message;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("OneMessageAction: " + message);
    }
}

class ContanationAction implements ActionListener{
    public int result = 0;


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(result++);

    }

}

class ComponentTest extends JComponent{
    public int message_x;
    public int message_y;

    public int default_width;
    public int default_height;

    public String message;

    public ComponentTest(String message, int message_x, int message_y, int default_width, int default_height) {
        this.message_x = message_x;
        this.message_y = message_y;
        this.default_width = default_width;
        this.default_height = default_height;
        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString(message, message_x, message_y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(default_width, default_height);
    }
}

class CalculatorMaster {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                    Calculator calculator = new Calculator();
                    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    calculator.setVisible(true);
                }
        );
    }
}
