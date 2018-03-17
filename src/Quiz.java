
import java.util.*;

/**
 * Class extends a bank of questions to a full-fledged quiz
 */
public class Quiz extends QuestionBank{
    int score = 0;
    String name;
    QuizTaker currentPlayer;
    Scanner reader = new Scanner(System.in);

    /**
     *Constructor Quiz - runs the quiz once
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

        //adds the name and the score to the score.txt file
        currentPlayer.addScore(score);
        currentPlayer.addNewPlayer(name, score);

        //creates and prints the scoreboard
        Scoreboard scoreBoard = new Scoreboard();
        scoreBoard.printScores(name);

    }
}
