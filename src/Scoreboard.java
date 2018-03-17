
import java.io.File;
import java.util.*;
import java.util.Collections;

/**
 * class Scoreboard - creates a score board to hold all of the scores of
 * QuizTakers
 *
 * @author Edward Phan
 *
 */
public class Scoreboard {
	private ArrayList<QuizTaker> scoreBoard = new ArrayList<QuizTaker>();

	/**
	 * Constructor Scoreboard - sets the scoreBoard arraylist with QuizTakers from
	 * the file "scores.txt"
	 */
	public Scoreboard() {
		try {

			Scanner reader = new Scanner(new File("data/scores.txt"));

			while (reader.hasNext()) {
				String name = reader.next();
				int score = reader.nextInt();

				QuizTaker taker = new QuizTaker(name, score);
				scoreBoard.add(taker);
				// if name already exists than the score is added to that QuizTaker
				for (int i = 0; i < scoreBoard.size() - 1 && scoreBoard.size() > 0; i++) {
					if (scoreBoard.get(i).getName().equals(taker.getName())) {
						scoreBoard.get(i).addScore(score);
						Collections.sort(scoreBoard.get(i).getMyScores());
						Collections.reverse(scoreBoard.get(i).getMyScores());
						scoreBoard.remove(scoreBoard.size() - 1);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method highestScorer - sets the 0th index of the scoreboard to the highest
	 * scorer
	 */
	public void highestScorer() {
		int highestScorerIndex = 0;

		// runs through all the QuizTakers within the scoreBoard array and sets the
		// highest scoring QuizTaker to the index of 0 in the scoreBoard arraylist
		for (int i = 1; i < scoreBoard.size() && scoreBoard.size() > 1; i++) {
			if (scoreBoard.get(highestScorerIndex).getScore(0) <= scoreBoard.get(i).getScore(0)) {
				highestScorerIndex = i;
			}
		}
		scoreBoard.add(0, scoreBoard.get(highestScorerIndex));
		scoreBoard.remove(highestScorerIndex + 1);
	}

	/**
	 * method scoredA5 - prints out all Quiz Takers that scored a 5 on the quiz
	 */
	public void scoredA5() {
		for (int i = 0; i < scoreBoard.size() && scoreBoard.size() > 0; i++) {
			if (scoreBoard.get(i).getScore(0) == 5) {
				System.out.println(scoreBoard.get(i).getName());
			}
		}
	}

	/**
	 * method printScores - prints the name and scores of the highest scorer, then
	 * prints out the score of the player of choice
	 */
	public void printScores(String currentPlayerName) {
		highestScorer();
		System.out.println("SCORE BOARD:");
		System.out.print("--------------------");

		System.out.println("\nCURRENT QUIZ TAKER:");
		// prints out the current Quiz Takers: Name and past highest scores in
		// descending order
		for (int i = 0; i < scoreBoard.size() && scoreBoard.size() > 0; i++) {
			if (scoreBoard.get(i).getName().equals(currentPlayerName)) {
				System.out.println(scoreBoard.get(i).toString());
				break;
			}
		}

		// prints the score of the person that scored the highest score.
		System.out.println("\n(MOST RECENT) HIGHEST QUIZ SCORER:");
		System.out.println(scoreBoard.get(0).getName() + " " + scoreBoard.get(0).getScore(0));

		System.out.println("\nQUIZ TAKERS THAT HAVE SCORED A 5: ");
		scoredA5();

	}

}

