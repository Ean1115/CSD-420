//Ean Masoner CSD-420 M2 Programming Assignment//
package Masoner_M2ProgAssignment;

import java.io.*;
import java.util.Random;

public class WriteToFile {
    public static void main(String[] args) {
        String filename = "datafile.dat"; // Replace [yourname] with your name, e.g., "John_datafile.dat"
        Random random = new Random();

        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        // Generate random integers and doubles
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = random.nextInt(100); // Random integer between 0 and 99
            randomDoubles[i] = random.nextDouble() * 100; // Random double between 0.0 and 99.99
        }

        // Write data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Random Integers:");
            for (int num : randomIntegers) {
                writer.write(" " + num);
            }
            writer.newLine();

            writer.write("Random Doubles:");
            for (double num : randomDoubles) {
                writer.write(" " + num);
            }
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
        System.out.println("Data written to file successfully!");
    }
}
