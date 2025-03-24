//Ean Masoner CSD-420 M2 Programming Assignment//

package Masoner_M2ProgAssignment;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) {
        String filename = "datafile.dat"; // Replace [yourname] with your name, e.g., "John_datafile.dat"

        // Read data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
