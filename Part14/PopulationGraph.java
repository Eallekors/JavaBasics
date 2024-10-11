package Part14;
// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static javafx.application.Application.launch;

public class PopulationGraph extends Application {

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Populations of the Nordic countries");
        barChart.setLegendVisible(false);

        // List of countries and populations
        List<CountryPopulation> countryPopulations = Arrays.asList(
                new CountryPopulation("Sweden", 10313447),
                new CountryPopulation("Denmark", 5809502),
                new CountryPopulation("Finland", 5537364),
                new CountryPopulation("Norway", 5372191),
                new CountryPopulation("Iceland", 343518)
        );

        // Sort by country name
        countryPopulations.sort(Comparator.comparing(CountryPopulation::getName));

        XYChart.Series<String, Number> populations = new XYChart.Series<>();

        // Add data to the series in sorted order
        for (CountryPopulation cp : countryPopulations) {
            populations.getData().add(new XYChart.Data<>(cp.getName(), cp.getPopulation()));
        }

        barChart.getData().add(populations);
        Scene view = new Scene(barChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Helper class to store country and population
    static class CountryPopulation {
        private final String name;
        private final int population;

        public CountryPopulation(String name, int population) {
            this.name = name;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }
    }
}
