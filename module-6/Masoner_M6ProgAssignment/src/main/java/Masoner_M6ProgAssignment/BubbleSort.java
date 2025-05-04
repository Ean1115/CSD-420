package Masoner_M6ProgAssignment;
// Ean Masoner Module 6 Programming Assignment CSD-420
import java.util.Comparator;

public class BubbleSort {

    // Method to sort using Comparable
    public static <T extends Comparable<T>> void bubbleSortComparable(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap elements
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to sort using Comparator
    public static <T> void bubbleSortComparator(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // Swap elements
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        bubbleSortComparable(numbers);

        System.out.println("Sorted using Comparable:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] words = {"apple", "orange", "banana", "grape"};
        bubbleSortComparator(words, String::compareTo);

        System.out.println("Sorted using Comparator:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
