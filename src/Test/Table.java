package Test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame {
    public static int DEFAULT_HEIGHT = 200;
    public static int DEFAULT_WIDTH = 300;

    public Table() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new TablePanel());
    }
}

class TablePanel extends JPanel {

    JPanel panel;
    JButton display;

    public TablePanel() {
        setLayout(new BorderLayout());

        display = new JButton();
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        display.setText("program has bean started");

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        MoveAction moveAction = new MoveAction();

        addButton("",null,false);
        addButton("up",moveAction, true);
        addButton("",null, false);
        addButton("left", moveAction, true);
        addButton("",null, false);
        addButton("right",moveAction, true);
        addButton("",null, false);
        addButton("down",moveAction, true);
        addButton("",null, false);
        add(panel);

    }

    void addButton(String label, ActionListener actionListener, Boolean enabledButton) {
        JButton button = new JButton(label);
        button.setEnabled(enabledButton);
        button.addActionListener(actionListener);
        panel.add(button);
    }

    private class MoveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("up")) {
                remove(display);
                add(display, BorderLayout.NORTH);
                display.setText("up");
                System.out.println("up");
            }
            if (command.equals("down")) {
                remove(display);
                add(display, BorderLayout.SOUTH);
                display.setText("down");
                System.out.println("down");
            }
            if (command.equals(("left"))) {
                remove(display);
                add(display, BorderLayout.WEST);
                display.setText("left");
                System.out.println("left");
            }
            if (command.equals("right")) {
                remove(display);
                add(display, BorderLayout.EAST);
                display.setText("right");
                System.out.println("right");
            }
        }

    }
}


class TableRun {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Table table = new Table();
            table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            table.setVisible(true);
        });
    }
}
