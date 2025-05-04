package Masoner_M8ProgrammingAssignment;

// Ean Masoner Module 8 Programming Assignment
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class ThreeThreads extends Application {
    private static final int COUNT = 10000; // Minimum count for each thread

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        Thread lettersThread = new Thread(() -> generateCharacters(textArea, "abcdefghijklmnopqrstuvwxyz"));
        Thread numbersThread = new Thread(() -> generateCharacters(textArea, "0123456789"));
        Thread symbolsThread = new Thread(() -> generateCharacters(textArea, "!@#$%^&*"));

        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateCharacters(TextArea textArea, String characters) {
        Random random = new Random();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < COUNT; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            output.append(c);
        }

        // Update UI on JavaFX application thread
        javafx.application.Platform.runLater(() -> textArea.appendText(output.toString() + "\n"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
