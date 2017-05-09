package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionFrame extends JFrame {

    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();

        //  определить действия
        Action yellowAction = new ColorAction("Yellow_1", new ImageIcon("src\\GUI\\img\\yellow-ball.png"), Color.YELLOW);
        Action redAction = new ColorAction("Red_2", new ImageIcon("src\\GUI\\img\\red-ball.png"), Color.RED);
        Action blueAction = new ColorAction("Blue_3", new ImageIcon("src\\GUI\\img\\blue-ball.png"), Color.BLUE);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        //привязка клавиш
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        //привязать надписи на кнопках панели к действиям
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);

    }





    public class ColorAction extends AbstractAction {

        ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel to " + name.toLowerCase());
            putValue("color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}

class PanelManager {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            ActionFrame frame = new ActionFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}