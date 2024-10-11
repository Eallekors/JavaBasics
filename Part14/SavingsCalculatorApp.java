package Part14;
// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Savings Calculator");

        // Create the axes for the line chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Savings Value");

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Over Time");

        // Create the VBox to hold the sliders
        VBox vbox = new VBox();

        // Create the first BorderPane for Monthly Savings
        BorderPane monthlySavingsPane = createSliderPane("Monthly Savings", 25, 250, "Monthly Savings: $");
        vbox.getChildren().add(monthlySavingsPane);

        // Create the second BorderPane for Yearly Interest Rate
        BorderPane yearlyInterestPane = createSliderPane("Yearly Interest Rate", 0, 10, "Yearly Interest Rate: %");
        vbox.getChildren().add(yearlyInterestPane);

        // Set the vbox to the top of the BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vbox);
        borderPane.setCenter(lineChart);

        // Create the scene and add it to the stage
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BorderPane createSliderPane(String labelText, double min, double max, String sliderDescription) {
        BorderPane pane = new BorderPane();

        // Label on the left
        Label label = new Label(labelText);
        pane.setLeft(label);

        // Slider in the middle
        Slider slider = new Slider(min, max, (min + max) / 2);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);

        // Slider description on the right
        Label sliderValueLabel = new Label(sliderDescription + slider.getValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sliderValueLabel.setText(sliderDescription + String.format("%.2f", newValue));
        });

        pane.setCenter(slider);
        pane.setRight(sliderValueLabel);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
