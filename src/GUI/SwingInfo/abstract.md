# abstract

component, window - медоты изменения размеров фрейма
setExtendedState(Frame.MAXIMIZED_BOTH) - фрейм с максимальными размрами
setResizable(false)  - запрет изменения размероф фрейма
setIconImage(new ImageIcon("src\\GUI\\logo.png").getImage()) - установить логотип
кнопка.setEnable(false) - замораживает кнопку 
перерисовка (кога дойдет дело) - стр 497

есть 2 варианта добавления действия к кнопке:
    1 new JButton(yellowAction)
    2 yellowButton.addActionListener(yellowAction)

при наложении компоненты перекрывают (закрывают) друг друга
!!! exitButton.addActionListener(e -> System.exit(0)) - пример лямбды

пример анонимного внутреннего класса
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

пример привязки клавишь
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
        
существуюют книги по шаблонам проектирования:
1. пример объектно-ориентированого проектирования. Паттерны проектирования 2007г
2. система шаблонов 1996г
ссылка их хорстмана стр 561

изучить применение интерфейса ButtonModel стр 565

TODO прочитать про Serializable в java и вернуться к описанию Serializable в java.awt.Component
 
у каждого контейнера имеется свой диспетчер компоновки

add(buttonPanel, BorderLayout.NORTH); - пример граничной компоновки




