
import java.util.*;

/**
 *
 * @author Tommy Vo Tran
 * Class extends a bank of questions to a full-fledged quiz, capable of keeping score and printing scores.
 */
public class Quiz extends QuestionBank{
    int score = 0;
    String name;
    Scanner reader = new Scanner(System.in);

    /**
     *Constructor to make the quiz, ask questions, then print scores.
     */
    public Quiz() {
        super();
        QuizTaker currentPlayer =  new QuizTaker();
        Random r = new Random();


        System.out.print("What is your name?: ");
        name = reader.next();
        currentPlayer.setName(name);
        System.out.println();
        for(int qNumber = 0; qNumber < 5; qNumber++) {
            //Start randomly pulling questions from question bank
            int indexOfQuestion = r.nextInt(qBank.size());

            Question myQuestion = qBank.get(indexOfQuestion);
            qBank.remove(indexOfQuestion); //Delete question if already used to prevent repeats.
            if(myQuestion.askQuestion()) {
                score++;
            }
            myQuestion.seeCorrectOption();
        }

        System.out.println("Your score for this run: " + score);
        System.out.println();
        //adds the name and the score to the score.txt file
        currentPlayer.addScore(score);
        currentPlayer.addNewTaker(name, score);

        //creates and prints the scoreboard
        Scoreboard scoreBoard = new Scoreboard();
        scoreBoard.printScores(name);

    }
}
