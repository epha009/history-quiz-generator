import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class QuestionBank {
    Question[] qBank;



    private final static int spaceBetweenQuestions = 6;

    private static int numberOfQuestions;

    /**
     * Static initializer to calculate the number of Questions found in the source text file.
     */
    static  {
        Scanner in = null;
        try {
            in = new Scanner(new File("questions.txt"));
            int counter = 0;
            while(in.hasNext()) {
                counter++;
                in.nextLine();
            }
            numberOfQuestions  = counter / spaceBetweenQuestions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public QuestionBank() {
        qBank = new Question[spaceBetweenQuestions];
        for(int i = 0; i < qBank.length; i++) {
            qBank[i] = new Question(i);
        }
    }

    public static int getSpaceBetweenQuestions() {
        return spaceBetweenQuestions;
    }

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}