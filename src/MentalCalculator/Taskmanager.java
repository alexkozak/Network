package MentalCalculator;


public class Taskmanager {

    int correctAnswer;

    int cAnswers = 0;
    int fAnswers = 0;

    /*
         1. Числа однозначные
         2. Числа двухзначные
         ...
     */
    private int pow = 1;

    /*
        1. знаки +,-
        2. знаки +,-,*,/
     */
    private int lvlSing = 1;


    public Taskmanager(int pow, int lvlSing) {
        this.pow = pow;
        this.lvlSing = lvlSing;
    }

    String generateTask() {
        String task = "";
        char sign = generateSign();

        if (sign == '+'){
            task = signPlus();
        }

        if (sign == '-'){
            task = signMinus();
        }

        if (sign == '*'){
            task = signMultiply();
        }

        if (sign == '/'){
            task = signDivide();
        }


        return task;
    }

    int generateNumber(int pow) {
        return (int) (Math.random() * Math.pow(10, pow));
    }

    char generateSign() {
        char result = ' ';

        if (lvlSing == 1){
            if(generateNumber(1) % 2 == 0){
                result = '+';
            } else {
                result = '-';
            }
        }

        if (lvlSing == 2){
            if(generateNumber(1) % 2 == 0){
                    if(generateNumber(1) % 2 == 0){
                        result = '+';
                    } else {
                        result = '-';
                    }

            } else {
                if(generateNumber(1) % 2 == 0){
                    result = '*';
                } else {
                    result = '/';
                }
            }
        }

        return result;
    }

    String signPlus() {
        int taskNumber1 = generateNumber(pow);
        int taskNumber2 = generateNumber(pow);
        correctAnswer = taskNumber1 + taskNumber2;
        return taskNumber1 + " + " + taskNumber2;
    }

    String signMinus() {
        int taskNumber1 = generateNumber(pow);
        int taskNumber2 = generateNumber(pow);
        while (taskNumber1 - taskNumber2 < 0) {
            taskNumber1 = generateNumber(pow);
            taskNumber2 = generateNumber(pow);
        }
        correctAnswer = taskNumber1 - taskNumber2;
        return taskNumber1 + " - " + taskNumber2;

    }

    String signMultiply() {
        int taskNumber1 = generateNumber(pow);
        int taskNumber2 = generateNumber(pow);
        correctAnswer = taskNumber1 * taskNumber2;
        return taskNumber1 + " * " + taskNumber2;
    }

    String signDivide() {
        int taskNumber1 = generateNumber(pow);
        int taskNumber2 = generateNumber(pow);
        while (taskNumber2 == 0){
            taskNumber2 = generateNumber(pow);
        }
        while (taskNumber1 % taskNumber2 != 0) {
            taskNumber1 = generateNumber(pow);
            taskNumber2 = generateNumber(pow);
            while (taskNumber2 == 0){
                taskNumber2 = generateNumber(pow);
            }
        }

        correctAnswer = taskNumber1 / taskNumber2;
        return taskNumber1 + " / " + taskNumber2;
    }

    void checkTask(int answer) {
        if (answer == correctAnswer) {
            cAnswers++;
        } else {
            fAnswers++;
        }

    }

    String getResult() {
        return "correct: " + cAnswers + "     fault: " + fAnswers;
    }

    void newGame() {
        cAnswers = 0;
        fAnswers = 0;
    }





    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i+"    "+new Taskmanager(1,2).generateTask());

        }
    }
}


