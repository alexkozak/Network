package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFrame extends JFrame
{
    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        JButton exitButton = new JButton("Exit with sleep time");

        buttonPanel = new JPanel();

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);

        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        //ColorAction redAction = new ColorAction(Color.RED);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(e -> buttonPanel.setBackground(Color.RED));
        exitButton.addActionListener(e ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
                });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("фрейм закрыт");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("фрейм свернут");
            }
        });

    }

    private class ColorAction implements ActionListener{
        private Color backgroundColor;

        public ColorAction(Color c){
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

class ButtonManager{
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
        {
            ButtonFrame frame = new ButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
