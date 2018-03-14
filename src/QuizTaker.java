package src;

/**
 * 
 * @author Edward Phan, Tommy Vo Tran
 * 
 */
/**
 * Class src.QuizTaker - creates an object for each student that takes the test
 */
public class QuizTaker {
	private String name;
	private int score;

	/**
	 * default constructor
	 */
	public QuizTaker() {
		
	}
	
	/**
	 * 
	 * @param quizTakerName - the test takers name
	 * @param points - amount of points test taker scored
	 */
	public QuizTaker(String quizTakerName, int points) {
		name = quizTakerName;
		score = points;
	}
}
