package Masoner_M4ProgAssignment;

// Ean Masoner Module 4 Programming Assignment CSD-420
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Testing with 50,000 integers
        System.out.println("Testing with 50,000 integers:");
        testPerformance(50000);

        // Testing with 500,000 integers
        System.out.println("Testing with 500,000 integers:");
        testPerformance(500000);
    }

    private static void testPerformance(int size) {
        
        List<Integer> linkedList = new LinkedList<>();

        
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

      
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Time taken using Iterator: " + iteratorTime + " nanoseconds");

      
        startTime = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        long getIndexTime = endTime - startTime;
        System.out.println("Time taken using get(index): " + getIndexTime + " nanoseconds");

        // Compare results
        System.out.println("Difference: " + Math.abs(getIndexTime - iteratorTime) + " nanoseconds\n");
    }
}
