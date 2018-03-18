
import java.util.ArrayList;

/**
 * @author  Tommy Vo Tran
 *
 * Class simulates a question bank by having an ArrayList of Question objects
 */
public class QuestionBank {
    ArrayList<Question> qBank;

    private final static int spaceBetweenQuestions = 6;

    private static final int numberOfQuestions = 20;


    /**
     * Constructor to initialize ArrayList of questions with all questions in order
     */
    public QuestionBank() {
        qBank = new ArrayList<Question>(numberOfQuestions);
        for (int i = 0; i < numberOfQuestions; i++) {
            qBank.add(new Question(i));
        }
    }

    /**
     * Getter method for the spacing between each question found in data/questions.txt
     * @return number of lines between each question
     */
    public static int getSpaceBetweenQuestions() {
        return spaceBetweenQuestions;
    }

    /**
     * Getter method for the number of questions found in data/questions.txt
     * @return number of questions available
     */
    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}