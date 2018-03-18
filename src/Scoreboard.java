
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
    //ArrayList of QuizTakers for the Scoreboard
    private ArrayList<QuizTaker> myScoreboard = new ArrayList<QuizTaker>();

    /**
     * Constructor Scoreboard - Fills the myScoreboard ArrayList with QuizTakers from
     * the file "scores.txt"
     */
    public Scoreboard() {
        try {

            Scanner reader = new Scanner(new File("data/scores.txt"));

            while (reader.hasNext()) {
                String name = reader.next();
                int score = reader.nextInt();

                QuizTaker taker = new QuizTaker(name, score);
                myScoreboard.add(taker); //Add this new QuizTaker to the Scoreboard *NOTE1

                //If the QuizTaker already exists in the Scoreboard, then his/her new score is added to that QuizTaker
                for (int i = 0; i < myScoreboard.size() - 1; i++) {
                    if (myScoreboard.get(i).getName().equals(taker.getName())) { //If name has already been found
                        myScoreboard.get(i).addScore(score);
                        Sorter.quickSort(myScoreboard.get(i).getMyScores(), 0,
                                myScoreboard.get(i).getMyScores().size() - 1);
                        myScoreboard.remove(myScoreboard.size() - 1); //Remove the new QuizTaker object at NOTE1 to prevent duplicates
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
        for (int i = 0; i < myScoreboard.size(); i++) {

            if (myScoreboard.get(i).getScore(0).compareTo(highest) > 0) {
                highest = (int) myScoreboard.get(i).getScore(0);
            }

        }
        return highest;
    }

    /**
     * Method returns a String of all the people who have scored the highest score,
     * in order of latest to most recent. Repeats of the highest score by the same
     * name are not counted.
     *
     * @return Every name that has achieved the highest score
     */
    public String findHighestScorers() {
        ArrayList<String> names = new ArrayList<String>();
        String theirNames = "";

        int highest = findHighestScore();

        for (int i = 0; i < myScoreboard.size(); i++) {


            if (myScoreboard.get(i).getScore(0).compareTo(highest) == 0) {
                //note that each quiz taker's arraylist of scores is already sorted in descending order post-constructor
                boolean alreadyThere = false;
                for(String name: names) {
                    if(name.equals(myScoreboard.get(i).getName())) {
                        alreadyThere = true;
                    }
                }
                if (!alreadyThere) {
                    theirNames += myScoreboard.get(i).getName() + " ";
                    names.add(myScoreboard.get(i).getName());
                }
            }
        }



        return theirNames;
    }

    /**
     * Print the top 5 highest scores of the current quiz taker, along with the highest score ever and anyone who has achieved that.
     *
     * @param currentPlayerName
     *            - the name of the quiz taker you want to print the scores of
     */
    public void printScores(String currentPlayerName) {
        System.out.println("SCORE BOARD:");
        System.out.print("--------------------");

        System.out.println("\nTOP 5 SCORES OF CURRENT QUIZ TAKER");

        // prints out the current quiz taker's name and top 5 highest scores in
        // descending order
        for (int i = 0; i < myScoreboard.size() && myScoreboard.size() > 0; i++) {
            if (myScoreboard.get(i).getName().equals(currentPlayerName)) {
                System.out.println(myScoreboard.get(i).toString());
                break;
            }
        }

        System.out.println("\nHIGHEST SCORE EVER (" + findHighestScore() + ") WAS ACHIEVED BY");
        System.out.println(findHighestScorers());

    }

}
