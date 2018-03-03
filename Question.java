import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Question {
    String ask;
    char correctOption;
    String tempA;
    String tempB;
    String tempC;
    String tempD;
    String optionA;
    String optionB;
    String optionC;
    String optionD;


    /**
     * @param questionNumber 0 to numberOfQuestions - 1
     */
    public Question(int questionNumber) {
        Random r = new Random();
        int indexOfAsk = 1 + QuestionBank.getSpaceBetweenQuestions() * questionNumber; //line number of the text to be asked

        //go through the file and parse the contents of that line into String ask
        try {
            Scanner in = new Scanner(new File("questions.txt"));
            int counter = 0;
            while (in.hasNext() && indexOfAsk > counter + 1) {
                counter++;
                in.nextLine();
            }
            ask = in.nextLine();
            tempA = in.nextLine();
            tempB = in.nextLine();
            tempC = in.nextLine();
            tempD = in.nextLine();

            if (findStop(tempA) == '*') {
                correctOption = 'A';
                optionA = tempA.substring(0, tempA.indexOf('*'));
                optionB = tempB.substring(0, tempB. indexOf('#'));
                optionC = tempC.substring(0, tempC. indexOf('#'));
                optionD = tempD.substring(0, tempD. indexOf('#'));
            } else if (findStop(tempB) == '*') {
                correctOption = 'B';
                optionB = tempB.substring(0, tempB. indexOf('*'));
                optionA = tempA.substring(0, tempA.indexOf('#'));
                optionC = tempC.substring(0, tempC. indexOf('#'));
                optionD = tempD.substring(0, tempD. indexOf('#'));
            } else if (findStop(tempC) == '*') {
                correctOption = 'C';
                optionC = tempC.substring(0, tempC. indexOf('*'));
                optionA = tempA.substring(0, tempA.indexOf('#'));
                optionB = tempB.substring(0, tempB. indexOf('#'));
                optionD = tempD.substring(0, tempD. indexOf('#'));
            } else if (findStop(tempD) == '*') {
                correctOption = 'D';
                optionD = tempD.substring(0, tempD. indexOf('*'));
                optionA = tempA.substring(0, tempA.indexOf('#'));
                optionB = tempB.substring(0, tempB. indexOf('#'));
                optionC = tempC.substring(0, tempC. indexOf('#'));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Determine whether the option is correct or not and find the stop symbol accordingly.
     * Stop symbol marks that an explanation is following the option.
     *
     * @param fullOptionLine String containing the option and explanation.
     * @return * if the option is correct
     * # if the option is incorrect.
     */
    private char findStop(String fullOptionLine) {
        char stop;
        switch (fullOptionLine.indexOf('*')) {
            case -1:
                stop = '#';
                break;
            default:
                stop = '*';
                break;
        }
        return stop;
    }

    public void askQuestion() {
        System.out.println(ask);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        System.out.println(optionD);
        System.out.print("Choose answer (A, B, C, D): ");
    }

    public void seeOptionsAndExplanations() {
        System.out.println(tempA);
        System.out.println(tempB);
        System.out.println(tempC);
        System.out.println(tempD);
    }
}