package GUI;

import javax.swing.*;
import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        //настройка потока диспечризации собития
        EventQueue.invokeLater(()->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{

    public SimpleFrame(){
        // получаем размеры экрана
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeith = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2,screenHeith / 2);
        setLocationByPlatform(true);
        setIconImage(new ImageIcon("src\\GUI\\logo.png").getImage());

    }
}
