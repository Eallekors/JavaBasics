package Part13_Graphical_interface;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

import java.util.Scanner;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) {

        Parameters params = getParameters();
        String title = params.getNamed().get("title");


        window.setTitle(title);
        window.show();
    }
}