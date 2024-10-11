package Part14;
// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;

public class LineGraphAnim extends Application {
    @Override
    public void start(Stage stage) {
        // The class Random is used to randomize the dice rolls
        Random random = new Random();

        NumberAxis xAxis = new NumberAxis();
        // y-axes represents the average of the rolls. The average is always between [1-6]
        NumberAxis yAxis = new NumberAxis(1, 6, 1);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        // removing elements of the chart, e.g. circles on points
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(false);

        // we create a variable representing the data and add it to the chart
        XYChart.Series average = new XYChart.Series();
        lineChart.getData().add(average);

        new AnimationTimer() {
            private long previous;
            private long sum;
            private long count;

            @Override
            public void handle(long current) {
                if (current - previous < 100_000_000L) {
                    return;
                }

                previous = current;

                // roll the dice
                int number = random.nextInt(6) + 1;

                // we grow the sum and increment the count
                sum += number;
                count++;

                // we add a new data point to the chart
                average.getData().add(new XYChart.Data(count, 1.0 * sum / count));
            }
        }.start();

        Scene scene = new Scene(lineChart, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
