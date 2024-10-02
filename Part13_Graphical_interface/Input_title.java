package Part13_Graphical_interface;
//VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Input_title extends Application {

    @Override
    public void start(Stage window) {

        Parameters params = getParameters();
        String title = params.getNamed().get("title");


        window.setTitle(title);
        window.show();
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Title: ");
        String title = reader.nextLine();

        launch(Input_title.class,
                "--title=" + title);
    }
}