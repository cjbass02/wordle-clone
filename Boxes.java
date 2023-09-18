import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Boxes {
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Label> labels = new ArrayList<>();
    private ArrayList<StackPane> stackPanes = new ArrayList<>();
    private int row = 0;
    private Pane pane;


    public Boxes(int length, Pane pane) {
        for (int i = 0; i < length * 5; i++) {
            stackPanes.add(new StackPane());
            stackPanes.get(i).getChildren().add(new Rectangle());
            stackPanes.get(i).getChildren().add(new Label());
        }
        this.pane = pane;
        pane.getChildren().addAll(stackPanes);
    }

    public void enterGuess(Guess guess, String answer) {
        String wrongPlace = guess.wrongSpot(answer);
        for (int i = row * 5; i < row * 5 + 5; i++) {
            //remove old rectangle from place
            stackPanes.get(i).getChildren().clear();

            Rectangle rectangle = new Rectangle();
            if (wrongPlace.charAt(i) != '*') {
                //add yellow rectangle
                rectangle.setFill(Color.YELLOW);

            } else {
                rectangle.setFill(Color.GRAY);
            }
            stackPanes.get(i).getChildren().add(rectangle);
            //add text
            Label label = new Label();
            label.setText((guess.getStringGuess().charAt(i) + "").toUpperCase());
            stackPanes.get(i).getChildren().add(label);

        }
        pane.getChildren().clear();
        pane.getChildren().addAll(stackPanes);
    }
}
