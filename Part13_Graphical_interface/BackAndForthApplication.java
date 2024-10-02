package Part13_Graphical_interface;
//VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BackAndForthApplication extends Application {

    @Override
    public void start(Stage window) {

        Button back = new Button("Back ..");
        Button forth = new Button(".. forth.");

        Scene first = new Scene(back);
        Scene second = new Scene(forth);

        back.setOnAction((event) -> {
            window.setScene(second);
        });

        forth.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(Multiple_views.class);
    }
}