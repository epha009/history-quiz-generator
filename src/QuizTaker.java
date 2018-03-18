import java.io.*;
import java.util.*;

/**
 *
 * @author Edward Phan
 *
 */
/**
 * Class QuizTaker - creates an object for each person that takes the test
 */
public class QuizTaker {
	private String name;

	// an ArrayList representing the scores to the quiz taker's name
	private ArrayList<Comparable> myScores = new ArrayList<Comparable>(5);

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
	 * Gets the score from a specified index of the quiz taker's list of scores
	 *
	 * @param index
	 *            - the index of the score desired
	 * @return the score at that index
	 */
	public Comparable getScore(int index) {
		return myScores.get(index);
	}

	/**
	 * Get the entire array of scores of the quiz taker
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
	 *
	 * @param points
	 *            - what the points will be changed to
	 * @param index
	 *            - the index of the ArrayList that you would like to change the
	 *            value of
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
	 * Writes the name and the score of the quiz taker to the file to store the
	 * information
	 *
	 * @param name
	 *            - the name of the quiz taker
	 * @param score
	 *            - the score that the quiz taker just got
	 */
	public void addNewTaker(String name, int score) {
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
	 * method getNumberOfScores - Get the number of scores the quiz taker has to
	 * his/her name
	 *
	 * @return the number of scores this quiz taker has received
	 */
	public int getNumberOfScores() {
		return myScores.size();
	}

	/**
	 * String representation of quiz taker object
	 *
	 * @return name and scores of this quiz taker
	 */
	public String toString() {
		String nameAndScore = name;

		// loop to print 5 scores
		for (int i = 0; i < 5 && i < myScores.size(); i++) {
			nameAndScore += " " + getScore(i);
		}
		return nameAndScore;
	}

}
