package Part14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SavingsCalculatorUI ui = new SavingsCalculatorUI();
        Scene scene = new Scene(ui.getLayout(), 800, 600);
        primaryStage.setTitle("Saastolaskuri");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}