package Part14;

// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Shenghai extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("University of Helsinki Shanghai Ranking");


        NumberAxis xAxis = createXNumberAxis("Year", 2006, 2018);
        NumberAxis yAxis = createNumberAxis("Ranking", 0, 100);


        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki Shanghai Ranking");


        XYChart.Series<Number, Number> rankingData = createRankingData();
        lineChart.getData().add(rankingData);


        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }


    private NumberAxis createXNumberAxis(String label, double lowerBound, double upperBound) {
        NumberAxis axis = new NumberAxis();
        axis.setLabel(label);
        axis.setAutoRanging(false);
        axis.setLowerBound(lowerBound);
        axis.setUpperBound(upperBound);


        axis.setTickUnit(2);
        axis.setTickLabelFormatter(new javafx.scene.chart.NumberAxis.DefaultFormatter(axis) {
            @Override
            public String toString(Number value) {
                return String.valueOf(value.intValue());
            }
        });

        return axis;
    }


    private NumberAxis createNumberAxis(String label, double lowerBound, double upperBound) {
        NumberAxis axis = new NumberAxis();
        axis.setLabel(label);
        axis.setAutoRanging(false);
        axis.setLowerBound(lowerBound);
        axis.setUpperBound(upperBound);
        return axis;
    }


    private XYChart.Series<Number, Number> createRankingData() {
        XYChart.Series<Number, Number> rankingData = new XYChart.Series<>();
        rankingData.setName("Ranking");


        rankingData.getData().add(new XYChart.Data<>(2007, 73));
        rankingData.getData().add(new XYChart.Data<>(2008, 68));
        rankingData.getData().add(new XYChart.Data<>(2009, 72));
        rankingData.getData().add(new XYChart.Data<>(2010, 72));
        rankingData.getData().add(new XYChart.Data<>(2011, 74));
        rankingData.getData().add(new XYChart.Data<>(2012, 73));
        rankingData.getData().add(new XYChart.Data<>(2013, 76));
        rankingData.getData().add(new XYChart.Data<>(2014, 73));
        rankingData.getData().add(new XYChart.Data<>(2015, 67));
        rankingData.getData().add(new XYChart.Data<>(2016, 56));
        rankingData.getData().add(new XYChart.Data<>(2017, 56));

        return rankingData;
    }

    public static void main(String[] args) {
        launch(Shenghai.class);
    }
}
