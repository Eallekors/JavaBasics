package Part13_Graphical_interface;
//VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Multiple_views extends Application {

    @Override
    public void start(Stage window) {

        Button firstView = new Button("To the first view");
        Button secView = new Button("To the second view");
        Button thirdView = new Button("To the third View");

        Label FirstViewLabel = new Label("First View");
        Label SecondViewLabel = new Label("Second View");
        Label ThirdViewLabel = new Label("Third View");

        BorderPane firLayout = new BorderPane();
        firLayout.setTop(FirstViewLabel);
        firLayout.setCenter(secView);

        VBox secLayout = new VBox();
        secLayout.getChildren().add(thirdView);
        secLayout.getChildren().add(SecondViewLabel);

        GridPane thirdLayout = new GridPane();
        thirdLayout.add(ThirdViewLabel, 0, 0);
        thirdLayout.add(firstView, 0, 1);

        Scene first = new Scene(firLayout);
        Scene second = new Scene(secLayout);
        Scene third = new Scene(thirdLayout);

        secView.setOnAction((event) -> {
            window.setScene(second);
        });

        thirdView.setOnAction((event) -> {
            window.setScene(third);
        });

        firstView.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(Multiple_views.class);
    }
}