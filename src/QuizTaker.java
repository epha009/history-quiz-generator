
import java.io.*;
import java.util.*;


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
	 * method getScore - a overridden class to get the array of scores of the
	 * QuizTaker
	 * 
	 * @return the array of scores of the QuizTaker
	 */
	public ArrayList<Integer> getScore() {
		return score;
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
	 * method addNewPlayer - adds the name and the score of the QuizTaker to the
	 * file to store the information
	 * 
	 * @param name
	 *            - the name of the player
	 * @param score
	 *            - the score that the player got on one of the Quiz runs
	 */
	public void addNewPlayer(String name, int score) {
		try {
			FileWriter writer = new FileWriter("Scores.txt", true);

			writer.write(name + "\n");
			writer.write(score + "\n\n");

			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method toString - prints out QuizTaker in correct format
	 */

	public String toString() {
		String nameAndScore = name;
		for (int i = 0; i < 5 && i < score.size(); i++) {
			nameAndScore += " " + getScore(i);
		}

		return nameAndScore;

	}
}
