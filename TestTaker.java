import java.util.ArrayList;

/**
 * 
 * @author Edward Phan, Tommy Vo Tran
 * 
 */
/**
 * Class TestTaker - creates an object for each person that takes the test
 */
public class TestTaker {
	private String name;
	private int score;

	/**
	 * default constructor
	 */
	public TestTaker() {
		
	}
	
	/**
	 * 
	 * @param testTakerName - the test takers name
	 * @param points - amount of points test taker scored
	 */
	public TestTaker(String testTakerName, int points) {
		name = testTakerName;
		score = points;
	}

	/**
	 * method getName - getter method for the name variable
	 * @return - TestTaker's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * method getScore - getter method for the score variable
	 * @return - TestTaker's score
	 */
	public int getScore(){
		return score;
	}

	/**
	 * method setName - setter method to set the name of the TestTaker
	 * @param takerName - what the name will be changed to
	 */
	public void setName(String takerName){
		name = takerName;
	}

	/**
	 * method setScore - setter method to set the score of the TestTaker
	 * @param points - what the points will be changed to
	 */
	public void setScore(int points){
		score = points;
	}
}
