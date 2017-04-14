# abstract

component, window - медоты изменения размеров фрейма
setExtendedState(Frame.MAXIMIZED_BOTH) - фрейм с максимальными размрами
setResizable(false)  - запрет изменения размероф фрейма
setIconImage(new ImageIcon("src\\GUI\\logo.png").getImage()) - установить логотип
перерисовка (кога дойдет дело) - стр 497
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


