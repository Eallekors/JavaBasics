package Part14;

// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Support Chart");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        // Set bounds for axes
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1968);
        xAxis.setUpperBound(2008);

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(10); // Adjust according to your data range

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");

        XYChart.Series<Number, Number> rkpData = new XYChart.Series<>();
        rkpData.setName("RKP");
        rkpData.getData().add(new XYChart.Data<>(1968, 5.6));
        rkpData.getData().add(new XYChart.Data<>(1972, 5.2));
        rkpData.getData().add(new XYChart.Data<>(1976, 4.7));
        rkpData.getData().add(new XYChart.Data<>(1980, 4.7));
        rkpData.getData().add(new XYChart.Data<>(1984, 5.1));
        rkpData.getData().add(new XYChart.Data<>(1988, 5.3));
        rkpData.getData().add(new XYChart.Data<>(1992, 5.0));
        rkpData.getData().add(new XYChart.Data<>(1996, 5.4));
        rkpData.getData().add(new XYChart.Data<>(2000, 5.1));
        rkpData.getData().add(new XYChart.Data<>(2004, 5.2));
        rkpData.getData().add(new XYChart.Data<>(2008, 4.7));

        lineChart.getData().add(rkpData);

        XYChart.Series<Number, Number> vihrData = new XYChart.Series<>();
        vihrData.setName("VIHR");
        vihrData.getData().add(new XYChart.Data<>(1984, 2.8));
        vihrData.getData().add(new XYChart.Data<>(1988, 2.3));
        vihrData.getData().add(new XYChart.Data<>(1992, 6.9));
        vihrData.getData().add(new XYChart.Data<>(1996, 6.3));
        vihrData.getData().add(new XYChart.Data<>(2000, 7.7));
        vihrData.getData().add(new XYChart.Data<>(2004, 7.4));
        vihrData.getData().add(new XYChart.Data<>(2008, 8.9));

        lineChart.getData().add(vihrData);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(Chart.class);
    }
}
