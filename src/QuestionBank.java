
import java.util.ArrayList;

public class QuestionBank {
    ArrayList<Question> qBank;

    private final static int spaceBetweenQuestions = 6;

    private static final int numberOfQuestions = 20;


    /**
     * Constructor to initialize array of questions with all questions in order
     */
    public QuestionBank() {
        qBank = new ArrayList<Question>(numberOfQuestions);
        for (int i = 0; i < numberOfQuestions; i++) {
            qBank.add(new Question(i));
        }
    }

    public static int getSpaceBetweenQuestions() {
        return spaceBetweenQuestions;
    }

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}