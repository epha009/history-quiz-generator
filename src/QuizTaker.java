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
	private ArrayList<Integer> myScores = new ArrayList<Integer>(5);

	/**
	 * default constructor
	 */
	public QuizTaker() {

	}

	/**
	 * 
	 * @param name
	 *            - the quiz taker's name
	 * @param score
	 *            - amount of points the quiz taker has scored in this attempt
	 */
	public QuizTaker(String name, int score) {
		this.name = name;
		myScores.add(score);
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
	 * method getMyScores - gets a myScores from a certain index from the QuizTakers list
	 * of scores
	 * 
	 * @param index
	 *            - the myScores that you would like to get
	 * @return - the myScores at the certain index of the QuizTaker
	 */
	public int getScore(int index) {
		return myScores.get(index);
	}

	public ArrayList<Integer> getMyScores() {
		return myScores;
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
	 * method setScore - setter method to set the myScores of the TestTaker
	 * 
	 * @param points
	 *            - what the points will be changed to
	 */
	public void setScore(int points, int index) {
		myScores.set(index, points);
	}

	/**
	 * method addScore - adds a myScores to the QuizTakers list of scores
	 * 
	 * @param point
	 *            - the myScores you want to add
	 */
	public void addScore(int point) {
		myScores.add(point);
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
	
	public void sort() {
		selectionSort(myScores);
	}

	/**
	 * method toString - prints out QuizTaker in correct format 
	 */
	
	public String toString() {
		String nameAndScore = name;
		for (int i = 0; i < 5 && i < myScores.size(); i++) {
			nameAndScore += " " + getScore(i);
		}
		
		return nameAndScore;
		
	}
}
