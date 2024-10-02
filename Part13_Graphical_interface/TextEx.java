package Part13_Graphical_interface;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TextEx extends Application {

    @Override
    public void start(Stage window) {
        BorderPane root = new BorderPane();

        TextArea textField = new TextArea();
        int letter = 0;
        Label letters = new Label("Letters: " + letter);

        Label words = new Label("Words: ");

        Label longest = new Label("The longest word is: ");

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(letters, words, longest);

        root.setBottom(hbox);
        root.setCenter(textField);




        textField.textProperty().addListener((change, oldValue, newValue) -> {

            int letterCount = newValue.length();
            letters.setText("Letters: " + letterCount);



            String[] wordArray = newValue.trim().split("\\s+");
            List<String> wordList = Arrays.asList(wordArray);


            long wordCount = wordList.stream()
                    .filter(word -> !word.isEmpty())
                    .count();
            words.setText("Words: " + wordCount);


            if (wordCount > 0) {
                String longestWord = wordList.stream()
                        .max(Comparator.comparingInt(String::length))
                        .orElse("");
                longest.setText("The longest word is: " + longestWord);
            } else {
                longest.setText("The longest word is: ");
            }
        });



        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextEx.class);
    }
}