
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question {
    //TODO: Consider making an Option class to prevent code repeat
    private String ask;
    private char correctOption;
    private String tempA;
    private String tempB;
    private String tempC;
    private String tempD;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


    /**
     * Constructor to initialize the Question based on a given question number
     * @param questionNumber 0 to numberOfQuestions - 1
     */
    public Question(int questionNumber) {
        int indexOfAsk = QuestionBank.getSpaceBetweenQuestions() * questionNumber; //indexOfAsk is line number of the text to be asked

        //go through the file and parse the contents of that line into String ask
        try {
            Scanner in = new Scanner(new File("data/questions.txt"));
            int lineAboutToBeRead = 0;
            while (in.hasNext() && indexOfAsk > lineAboutToBeRead) {
                in.nextLine();
                lineAboutToBeRead++;
            }
            ask = in.nextLine();
            tempA = in.nextLine();
            tempB = in.nextLine();
            tempC = in.nextLine();
            tempD = in.nextLine();

            //Find the correct option and read in all the options without their explanations.
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


        } catch (StringIndexOutOfBoundsException e) {
            System.out.print("Failed at question: " + ask);
            //e.printStackTrace();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
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

    /**
     * Prints the question along with options without explanations.
     *
     * @return Whether or not the user's input is correct
     */
    public boolean askQuestion() {
        System.out.println(ask);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        System.out.println(optionD);
        System.out.print("Choose answer (A, B, C, D): ");
        Scanner in = new Scanner(System.in);
        String userInput = in.next();
        char userAnswer = userInput.charAt(0);
        if(correctOption == userAnswer) {
            System.out.println("You are correct!");
            return true;
        } else {
            System.out.println("You are wrong!");
           return false;
        }


    }

    /**
     * Prints the options with explanations.
     */
    public void seeOptionsAndExplanations() {
        System.out.println(tempA);
        System.out.println(tempB);
        System.out.println(tempC);
        System.out.println(tempD);
        System.out.println();
    }


}