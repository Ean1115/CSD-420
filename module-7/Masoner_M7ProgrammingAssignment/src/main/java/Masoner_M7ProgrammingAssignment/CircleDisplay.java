// Ean Masoner Module 7 Programming Assignment CSD-420//

package Masoner_M7ProgrammingAssignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleDisplay extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Create four circles
        Circle circle1 = new Circle(50, 50, 40);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(150, 50, 40);
        circle2.setId("redcircle");

        Circle circle3 = new Circle(50, 150, 40);
        circle3.setId("greencircle");

        Circle circle4 = new Circle(150, 150, 40);
        circle4.getStyleClass().add("plaincircle");
        circle4.getStyleClass().add("circleborder");

        // Add circles to pane
        pane.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Apply CSS
        Scene scene = new Scene(pane, 300, 300);
     scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

