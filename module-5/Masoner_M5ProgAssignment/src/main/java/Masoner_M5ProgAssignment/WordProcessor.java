package Masoner_M5ProgAssignment;
//Ean Masoner CSD-420 Module 5 Programming Assignment
import java.io.*;
import java.util.*;

public class WordProcessor {

    // Method to read words from the file
    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.split("\\s+");
                words.addAll(Arrays.asList(wordArray));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    // Method to filter non-duplicate words
    public static List<String> getNonDuplicateWords(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        List<String> uniqueWords = new ArrayList<>(wordSet);
        Collections.sort(uniqueWords);
        return uniqueWords;
    }

    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        List<String> words = readWordsFromFile(fileName);

        if (!words.isEmpty()) {
            List<String> uniqueWords = getNonDuplicateWords(words);

            System.out.println("Non-duplicate words in ascending order:");
            System.out.println(uniqueWords);

            System.out.println("\nNon-duplicate words in descending order:");
            Collections.reverse(uniqueWords);
            System.out.println(uniqueWords);
        } else {
            System.out.println("No words found in the file.");
        }
    }
}
