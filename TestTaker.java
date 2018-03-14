import java.util.ArrayList;

/**
 * 
 * @author Edward Phan, Tommy Vo Tran
 * 
 */
/**
 * Class TestTaker - creates an object for each student that takes the test
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
}
