
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Edward Phan
 */
/**
 * class Scoreboard - creates a score board to hold all of the scores of
 * QuizTakers
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
				// if name already exists then the score is added to that QuizTaker
				for (int i = 0; i < scoreBoard.size() - 1 && scoreBoard.size() > 0; i++) {
					if (scoreBoard.get(i).getName().equals(taker.getName())) {
						scoreBoard.get(i).addScore(score);
						Sorter.quickSort(scoreBoard.get(i).getMyScores(), 0,
								scoreBoard.get(i).getMyScores().size() - 1);
						scoreBoard.remove(scoreBoard.size() - 1);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * PRECONDITION: Constructor has already run, so that the highest score of any
	 * given QuizTaker is already in index 0 of his/her myScores Arraylist Method
	 * finds the highest score of any player
	 *
	 * @return highest score of any player
	 */
	public int findHighestScore() {
		int highest = 0;
		for (int i = 0; i < scoreBoard.size(); i++) {

			if (scoreBoard.get(i).getScore(0).compareTo(highest) > 0) {
				highest = (int) scoreBoard.get(i).getScore(0);
			}

		}
		return highest;
	}

	/**
	 * Method returns a String of all the people who have scored the highest score,
	 * in order of latest to most recent. Repeats of the highest score by the same
	 * name are not counted.
	 *
	 * @return every name that has achieved the highest score
	 */
	public String findHighestScorers() {
		String names = "";
		int highest = findHighestScore();
		for (int i = 0; i < scoreBoard.size(); i++) {
			for (int j = 0; j < scoreBoard.get(i).getNumberOfScores(); j++) {
				if (scoreBoard.get(i).getScore(0).compareTo(highest) == 0
						&& names.indexOf(scoreBoard.get(i).getName()) == -1) {
					names += scoreBoard.get(i).getName() + " ";
				}
			}
		}
		return names;
	}

	/**
	 * Print the top 5 highest scores of the current quiz taker, along with the most
	 * recent highest quiz score and anyone who has scored a 5.
	 * 
	 * @param currentPlayerName
	 *            - the name of the player u want to prin the scores of
	 */
	public void printScores(String currentPlayerName) {
		System.out.println("SCORE BOARD:");
		System.out.print("--------------------");

		System.out.println("\nTOP 5 SCORES OF CURRENT QUIZ TAKER");

		// prints out the current quiz taker's name and top 5 highest scores in
		// descending order
		for (int i = 0; i < scoreBoard.size() && scoreBoard.size() > 0; i++) {
			if (scoreBoard.get(i).getName().equals(currentPlayerName)) {
				System.out.println(scoreBoard.get(i).toString());
				break;
			}
		}

		System.out.println("\nHIGHEST SCORE EVER (" + findHighestScore() + ") WAS ACHIEVED BY");
		System.out.println(findHighestScorers());

	}

}
