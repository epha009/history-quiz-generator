import java.io.File;
import java.util.*;

/**
 * class ScoreBoard - creates a score board to hold all of the scores of
 * QuizTakers
 * 
 * @author Edward Phan, Tommy Vo Tran
 *
 */
public class ScoreBoard {
	private ArrayList<QuizTaker> scoreBoard = new ArrayList<QuizTaker>();
	Scanner reader;

	/**
	 * Constructor ScoreBoard - sets the scoreBoard arraylist with QuizTakers from
	 * the file "Scores.txt"
	 */
	public ScoreBoard() {
		try {
			File scores = new File("Scores.txt");
			reader = new Scanner(scores);

			while (reader.hasNextLine()) {
				String name = reader.nextLine();
				int score = reader.nextInt();

				QuizTaker taker = new QuizTaker(name, score);

				// if name already exists than the score is added to that QuizTaker
				for (int i = 0; i < scoreBoard.size() - 1; i++) {
					if (scoreBoard.get(i).getName().equals(taker.getName()) ) {
						scoreBoard.get(i).addScore(score);
						scoreBoard.get(i).sortScores();
					} else {
						scoreBoard.add(taker);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method highestScorer - sets the 0th index to the highest scorer
	 */
	public void highestScorer() {
		int highestScorerIndex = 0;
		
		for (int i = 1; i < scoreBoard.size() - 1; i++) {
			if(scoreBoard.get(highestScorerIndex).getScore(0) < scoreBoard.get(i).getScore(0));
				highestScorerIndex = i;
		}
		scoreBoard.set(0, scoreBoard.get(highestScorerIndex));
	}
	
	/**
	 * method printScores - prints the name and scores of each QuizTaker
	 */
	public void printScores() {
		highestScorer();
		System.out.println("Highest Scorer: ");
		for (QuizTaker s : scoreBoard) {
			s.toString();
			System.out.println();
		}
	}

}
