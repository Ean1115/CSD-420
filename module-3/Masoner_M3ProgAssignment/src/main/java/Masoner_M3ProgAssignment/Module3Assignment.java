package Masoner_M3ProgAssignment;
// Ean Masoner Module 3 Programming Assignment CSD-420
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Module3Assignment {

    public static void main(String[] args) {
        // Step 1: Create the original ArrayList and fill it with 50 random values (1 to 20)
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Step 2: Print the original list
        System.out.println("Original ArrayList: " + originalList);

        // Step 3: Remove duplicates and get a new ArrayList
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Step 4: Print the new list without duplicates
        System.out.println("ArrayList without duplicates: " + uniqueList);
    }

   
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
      
        HashSet<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
