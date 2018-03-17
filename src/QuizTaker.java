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
	private ArrayList<Comparable> myScores = new ArrayList<Comparable>(5); //an ArrayList representing the scores to the player's name

	/**
	 * default constructor
	 */
	public QuizTaker() {

	}

	/**
	 * Constructor to make a virtual representation of a quiz taker
	 *
	 * @param name
	 *            - the quiz taker's name
	 * @param points
	 *            - amount of points quiz taker has scored
	 */
	public QuizTaker(String name, int points) {
		this.name = name;
		myScores.add(points);
	}

	/**
	 * Getter method for the name variable
	 *
	 * @return - quiz taker's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets a myScores from a certain index from the quiz taker's list
	 * of scores
	 *
	 * @param index
	 *            - the myScores that you would like to get
	 * @return - the myScores at the certain index of the QuizTaker
	 */
	public Comparable getScore(int index) {
		return myScores.get(index);
	}

	/**
	 * method getMyScores - a overridden class to get the array of scores of the
	 * QuizTaker //TODO: More accurate documentation
	 *
	 * @return the ArrayList of scores of the quiz taker
	 */
	public ArrayList<Comparable> getMyScores() {
		return myScores;
	}

	/**
	 * Setter method to set the name of the quiz taker
	 *
	 * @param takerName
	 *            - what the name will be changed to
	 */
	public void setName(String takerName) {
		name = takerName;
	}

	/**
	 * Setter method to set a specific score of the quiz taker
	 *
	 * @param points
	 *            - what the points will be changed to
	 */
	public void setScore(int points, int index) {
		myScores.set(index, points);
	}

	/**
	 * method addScore - adds a score to the quiz taker's list of scores
	 *
	 * @param points
	 *            - the score
	 */
	public void addScore(int points) {
		myScores.add(points);
	}

	/**
	 * Writes the name and the score of the quiz taker to the
	 * file to store the information
	 *
	 * @param name
	 *            - the name of the player
	 * @param score
	 *            - the myScores that the player got on one of the Quiz runs
	 */
	public void addNewPlayer(String name, int score) {
		try {
			FileWriter writer = new FileWriter("data/scores.txt", true);

			writer.write(name + "\n");
			writer.write(score + "\n\n");

			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * String representation of quiz taker object
	 *
	 * @return name and scores of this quiz taker
	 */

	public String toString() {
		String nameAndScore = name;
		for (int i = 0; i < 5 && i < myScores.size(); i++) {
			nameAndScore += " " + getScore(i);
		}

		return nameAndScore;

	}
}

