import java.io.File;
import java.util.*;
import java.util.Collections;

/**
 * class ScoreBoard - creates a score board to hold all of the scores of
 * QuizTakers
 * 
 * @author Edward Phan, Tommy Vo Tran
 *
 */
public class ScoreBoard {
	private ArrayList<QuizTaker> scoreBoard = new ArrayList<QuizTaker>();

	/**
	 * Constructor ScoreBoard - sets the scoreBoard arraylist with QuizTakers from
	 * the file "Scores.txt"
	 */
	public ScoreBoard() {
		try {

			Scanner reader = new Scanner(new File("Scores.txt"));

			while (reader.hasNext()) {
				String name = reader.next();
				int score = reader.nextInt();
				

				QuizTaker taker = new QuizTaker(name, score);
				scoreBoard.add(taker);
				// if name already exists than the score is added to that QuizTaker
				for (int i = 0; i < scoreBoard.size() - 1 && scoreBoard.size() > 0; i++) {
					if (scoreBoard.get(i).getName().equals(taker.getName())) {
						scoreBoard.get(i).addScore(score);
						Collections.sort(scoreBoard.get(i).getScore());
						Collections.reverse(scoreBoard.get(i).getScore());
						scoreBoard.remove(scoreBoard.size() - 1);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method highestScorer - sets the 0th index to the highest scorer
	 */
	public void highestScorer() {
		int highestScorerIndex = 0;

		if (!scoreBoard.equals(null)) {
			for (int i = 1; i < scoreBoard.size() - 1 && scoreBoard.size() > 1; i++) {
				if (scoreBoard.get(highestScorerIndex).getScore(0) < scoreBoard.get(i).getScore(0)) {
					highestScorerIndex = i;
				}
			}
			scoreBoard.set(0, scoreBoard.get(highestScorerIndex));
		}
	}

	/**
	 * method printScores - prints the name and scores of each QuizTaker
	 */
	public void printScores() {
		highestScorer();
		System.out.print("Highest Scorer: ");
		System.out.println(scoreBoard.get(0).toString());
		
	}

}
