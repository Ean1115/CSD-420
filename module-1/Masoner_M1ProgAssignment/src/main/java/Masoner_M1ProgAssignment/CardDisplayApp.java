//Ean Masoner CSD-420 M1ProgAssignment//

package Masoner_M1ProgAssignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplayApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final int NUM_DISPLAY_CARDS = 4;
    private List<ImageView> cardViews;

    public CardDisplayApp() {
        this.cardViews = new ArrayList<>();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        HBox cardBox = new HBox(10);
        Button refreshButton = new Button("Refresh");

        // Initialize ImageViews for cards
        for (int i = 0; i < NUM_DISPLAY_CARDS; i++) {
            ImageView cardView = new ImageView();
            cardView.setFitWidth(100);
            cardView.setFitHeight(150);
            cardViews.add(cardView);
            cardBox.getChildren().add(cardView);
        }

        // Set up refresh button action
        refreshButton.setOnAction(e -> displayRandomCards());

        root.getChildren().addAll(cardBox, refreshButton);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Card Display App");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Display initial set of random cards
        displayRandomCards();
    }

    private void displayRandomCards() {
    List<Integer> cardIndices = new ArrayList<>();
    for (int i = 1; i <= NUM_CARDS; i++) {
        cardIndices.add(i);
    }
    Collections.shuffle(cardIndices);

    for (int i = 0; i < NUM_DISPLAY_CARDS; i++) {
        int cardIndex = cardIndices.get(i);
       String imagePath = "file:/C:/Users/MASONERE/CSD-420/CSD-420/module-1/Masoner_M1ProgAssignment/AssignmentCards/" + cardIndex + ".png";
        File imageFile = new File(imagePath.replace("file:", ""));
        System.out.println("Checking file: " + imageFile.getAbsolutePath() + " - Exists: " + imageFile.exists());
        Image cardImage = new Image(imageFile.toURI().toString());
        cardViews.get(i).setImage(cardImage);
        System.out.println("Loaded image: " + imagePath + " - Success: " + !cardImage.isError());
        if (cardImage.isError()) {
            System.out.println("Error loading image: " + imagePath);
        }
    }
}

    public static void main(String[] args) {
        launch(args);
    }
}