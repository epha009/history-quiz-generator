
import java.util.Random;

/**
 * Class extends a bank of questions to a full-fledged quiz
 */
public class Quiz extends QuestionBank{

    int score = 0;

    /**
     *
     */
    public Quiz() {
        super();
        Random r = new Random();


        System.out.println("Quiz started.");
        for(int qNumber = 0; qNumber < 5; qNumber++) {
            //Start randomly pulling questions from question bank
            int indexOfQuestion = r.nextInt(qBank.size());
            Question myQuestion = qBank.get(indexOfQuestion);
            qBank.remove(indexOfQuestion); //Delete question if already used to prevent repeats.
            if(myQuestion.askQuestion()) {
                score++;
            }
            myQuestion.seeOptionsAndExplanations();
        }
    }
}