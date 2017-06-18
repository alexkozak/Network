package MentalCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonPanel extends JFrame {
    private JPanel rootPanel;
    private JPanel displayPanel;
    private JPanel buttonPanel;
    private JButton taskButton;
    private JButton answerButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton enterButton;
    private JButton clearButton;
    private JButton button4;
    private JButton button0;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonGetResult;
    private JButton buttonNewGame;

    boolean getResult =false;

    Taskmanager taskmanager = new Taskmanager(1,2);


    public ButtonPanel() {

        //JOptionPane.showMessageDialog(null, "сообщение в диалоговом окне");

        answerButton.setText("");

        setFrameParam();

        addNumbers();

        addActions();

        newRound();
    }


    void newRound(){

        taskButton.setText(taskmanager.generateTask());

    }

    private void setFrameParam() {
        setContentPane(rootPanel);//TODO РАЗОБРАТЬСЯ ЧТО ДЕЛАЕТ МЕТОД.Если его убрать, что ничего не отображается
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //setSize((int) toolkit.getScreenSize().getWidth() / 2, (int) toolkit.getScreenSize().getHeight() / 2);
        setSize(300, 400);
        setLocation(600, 300);
        setResizable(false);
        setTitle("Mental Calculation");
    }

    private void addActions() {

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskmanager.checkTask(Integer.parseInt(answerButton.getText()));
                answerButton.setText("");

                if (!getResult){
                    newRound();
                }

            }
        });

        buttonGetResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getResult = true;
                taskButton.setText("result: "+taskmanager.getResult());

                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                enterButton.setEnabled(false);
                clearButton.setEnabled(false);
            }
        });

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getResult = false;
                taskmanager.newGame();
                newRound();

                button0.setEnabled(true);
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                enterButton.setEnabled(true);
                clearButton.setEnabled(true);
            }

        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton.setText("");
            }
        });


    }

    private void addNumbers() {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNumberAction(e);
            }
        });
    }

    private void buttonNumberAction(ActionEvent e) {
        answerButton.setText(answerButton.getText()+e.getActionCommand());
    }





    public static void main(String[] args) {
        new ButtonPanel();
    }
}
