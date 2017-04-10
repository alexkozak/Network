package GUI;


import javax.swing.*;
import java.awt.*;

public class ComponentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
        {
            SecondFrame frame = new SecondFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SecondFrame extends JFrame{
    public SecondFrame(){
        add(new TestComponent());
//        add(new TestComponent2("Component2",500,100,600,600));
        pack();

    }
}

class TestComponent extends JComponent{

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        g.drawString("---==== Сообщение ====---",MESSAGE_X,MESSAGE_Y);
        g.drawString("---==== Сообщение 2 ====---",MESSAGE_X,MESSAGE_Y+20);
        g.drawString("---==== Сообщение 3 ====---",MESSAGE_X,MESSAGE_Y+40);
    }


    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}

class TestComponent2 extends JComponent{
    public int message_x;
    public int message_y;

    public int default_width;
    public int default_height;

    public String message;

    public TestComponent2(String message, int message_x, int message_y, int default_width, int default_height ) {
        this.message_x = message_x;
        this.message_y = message_y;
        this.default_width = default_width;
        this.default_height = default_height;
        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString(message,message_x,message_y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(default_width,default_height);
    }
}