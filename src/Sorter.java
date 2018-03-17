import java.util.ArrayList;

/**
 * Tool class to sort
 * @author Tommy Vo Tran
 */
public class Sorter {

    /**
     * Organizes a list in descending order using recursive quick sort algorithm
     *
     * @param a
     *            reference to an array of Comparables to be sorted
     * @param first
     *            starting index of range of values to be sorted
     * @param last
     *            ending index of range of values to be sorted
     */
    public static void quickSort(ArrayList<Comparable> a, int first, int last) {
        // Add your code here
        int g = first, h = last;

        int medianIndex = (first + last) / 2;

        Comparable median = a.get(medianIndex);

        do {

            // find a value on the left side of median that doesn't belong there
            while (a.get(g).compareTo(median) > 0) {
                g++;
            }
            // find a value on the right side of median that doesn't belong there
            while (a.get(h).compareTo(median) < 0) {
                h--;
            }
            // swap those two values
            if (g <= h) {
                swap(a, g, h);
                g++; // advance units to continue checking
                h--;
            }

        } while (g < h);

        if (h > first) {
            quickSort(a, first, h); // recursively quickSort left and right sublists
        }

        if (g < last) {
            quickSort(a, g, last);
        }
    }
    /**
     * Interchanges two elements in an ArrayList
     *
     * @param list
     *            reference to an array of integers
     * @param a
     *            index of integer to be swapped
     * @param b
     *            index of integer to be swapped
     */
    private static void swap(ArrayList<Comparable> list, int a, int b) {

        Comparable temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
