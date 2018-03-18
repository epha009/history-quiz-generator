
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Edward Phan
 */
/**
 * class Scoreboard - creates a score board to hold and print scores of quiz takers
 */
public class Scoreboard {

    //ArrayList of QuizTakers for the Scoreboard
    private ArrayList<QuizTaker> allQuizTakers = new ArrayList<QuizTaker>();

    /**
     * Constructor Scoreboard - Fills the allQuizTakers ArrayList with QuizTakers from
     * the file "scores.txt"
     */
    public Scoreboard() {
        try {

            Scanner reader = new Scanner(new File("data/scores.txt"));

            while (reader.hasNext()) {
                String name = reader.next();
                int score = reader.nextInt();

                QuizTaker taker = new QuizTaker(name, score);
                allQuizTakers.add(taker); //Add this new QuizTaker to the Scoreboard *NOTE1

                //If the QuizTaker already exists in the Scoreboard, then his/her new score is added to that QuizTaker
                for (int i = 0; i < allQuizTakers.size() - 1; i++) {
                    if (allQuizTakers.get(i).getName().equals(taker.getName())) { //If name has already been found
                        allQuizTakers.get(i).addScore(score);
                        Sorter.quickSort(allQuizTakers.get(i).getMyScores(), 0,
                                allQuizTakers.get(i).getMyScores().size() - 1);
                        allQuizTakers.remove(allQuizTakers.size() - 1); //Remove the new QuizTaker object at NOTE1 to prevent duplicates
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
        for (int i = 0; i < allQuizTakers.size(); i++) {

            if (allQuizTakers.get(i).getScore(0).compareTo(highest) > 0) {
                highest = (int) allQuizTakers.get(i).getScore(0);
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
        for (int i = 0; i < allQuizTakers.size(); i++) {

            if (allQuizTakers.get(i).getScore(0).compareTo(highest) == 0) {
                //note that each quiz taker's arraylist of scores is already sorted in descending order post-constructor
                boolean alreadyThere = false;
                for(String name: names) {
                    if(name.equals(allQuizTakers.get(i).getName())) {
                        alreadyThere = true;
                    }
                }
                if (!alreadyThere) {
                    theirNames += allQuizTakers.get(i).getName() + " ";
                    names.add(allQuizTakers.get(i).getName());
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
        for (int i = 0; i < allQuizTakers.size() && allQuizTakers.size() > 0; i++) {
            if (allQuizTakers.get(i).getName().equals(currentPlayerName)) {
                System.out.println(allQuizTakers.get(i).toString());
                break;
            }
        }

        System.out.println("\nHIGHEST SCORE EVER (" + findHighestScore() + ") WAS ACHIEVED BY");
        System.out.println(findHighestScorers());

    }

}
