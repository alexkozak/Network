# abstract

component, window - медоты изменения размеров фрейма
setExtendedState(Frame.MAXIMIZED_BOTH) - фрейм с максимальными размрами
setResizable(false)  - запрет изменения размероф фрейма
setIconImage(new ImageIcon("src\\GUI\\logo.png").getImage()) - установить логотип
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


