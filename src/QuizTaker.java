
import java.util.ArrayList;

/**
 * 
 * @author Edward Phan, Tommy Vo Tran
 * 
 */
/**
 * Class QuizTaker - creates an object for each person that takes the test
 */
public class QuizTaker {
	private String name;
	private ArrayList<Integer> score = new ArrayList<Integer>(5);

	/**
	 * default constructor
	 */
	public QuizTaker() {

	}

	/**
	 * 
	 * @param testQuizName
	 *            - the test takers name
	 * @param points
	 *            - amount of points test taker scored
	 */
	public QuizTaker(String testTakerName, int points) {
		name = testTakerName;
		score.add(points);
	}

	/**
	 * method getName - getter method for the name variable
	 * 
	 * @return - TestTaker's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * method getScore - gets a score from a certain index from the QuizTakers list
	 * of scores
	 * 
	 * @param index
	 *            - the score that you would like to get
	 * @return - the score at the certain index of the QuizTaker
	 */
	public int getScore(int index) {
		return score.get(index);
	}

	/**
	 * method setName - setter method to set the name of the TestTaker
	 * 
	 * @param takerName
	 *            - what the name will be changed to
	 */
	public void setName(String takerName) {
		name = takerName;
	}

	/**
	 * method setScore - setter method to set the score of the TestTaker
	 * 
	 * @param points
	 *            - what the points will be changed to
	 */
	public void setScore(int points, int index) {
		score.set(index, points);
	}

	/**
	 * method addScore - adds a score to the QuizTakers list of scores
	 * 
	 * @param point
	 *            - the score you want to add
	 */
	public void addScore(int point) {
		score.add(point);
	}

	/**
	 * method selectionSort - helper method to sort the numbers in an array list
	 * 
	 * @param arr
	 *            - the arraylist you want to sort
	 */
	public static void selectionSort(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {

			int pos = i;
			for (int j = i; j < arr.size(); j++) {
				if (arr.get(j) < arr.get(pos))
					pos = j;
			}

			int min = arr.get(pos);
			arr.set(pos, arr.get(i));
			arr.set(i, min);

		}
	}

	/**
	 * method sortScores - sorts the scores of the QuizTaker
	 */
	public void sortScores() {
		selectionSort(score);
	}

	/**
	 * method toString - prints out QuizTaker in correct format 
	 */
	public String toString() {
		String nameAndScore = name;

		for (int i = 0; i < 5; i++) {
			name += " " + score.get(i);
		}
		
		return nameAndScore;
	}
}
