package Part14;
// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

// Import necessary JavaFX and I/O classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartiesApplication extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Relative Support of Major Finnish Parties (1968-2008)");

        // Create the x and y axes
        NumberAxis xAxis = createXNumberAxis("Year", 1968, 2008);
        NumberAxis yAxis = createNumberAxis("Relative Support (%)", 0, 30); // Adjust upper bound as necessary

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of Finnish Parties");

        // Read the data and populate the chart
        readDataAndPopulateChart(lineChart);

        // Set up the scene and stage
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    // Method to create a specific NumberAxis for the x-axis
    private NumberAxis createXNumberAxis(String label, double lowerBound, double upperBound) {
        NumberAxis axis = new NumberAxis();
        axis.setLabel(label);
        axis.setAutoRanging(false);
        axis.setLowerBound(lowerBound);
        axis.setUpperBound(upperBound);
        axis.setTickUnit(1);
        return axis;
    }

    // Method to create a general NumberAxis for the y-axis
    private NumberAxis createNumberAxis(String label, double lowerBound, double upperBound) {
        NumberAxis axis = new NumberAxis();
        axis.setLabel(label);
        axis.setAutoRanging(false);
        axis.setLowerBound(lowerBound);
        axis.setUpperBound(upperBound);
        return axis;
    }

    // Method to read data from the TSV file and populate the chart
    private void readDataAndPopulateChart(LineChart<Number, Number> lineChart) {
        String filePath = "C:\\Users\\Erki\\IdeaProjects\\JavaBasics\\Part14\\partiesdata.tsv"; // Path to your TSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Skip header line if present

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header if needed
                    continue;
                }

                String[] pieces = line.split("\t"); // Split the line into parts
                String partyName = pieces[0]; // First column is the party name

                // Create a new series for each party
                XYChart.Series<Number, Number> partyData = new XYChart.Series<>();
                partyData.setName(partyName); // Set the series name to the party name

                // Loop through the years and add data points
                for (int i = 1; i < pieces.length; i++) {
                    int year = 1968 + (i - 1); // Calculate the year based on index
                    double support = Double.valueOf(pieces[i]); // Convert string to double
                    partyData.getData().add(new XYChart.Data<>(year, support)); // Add data point
                }

                // Add the party data series to the chart
                lineChart.getData().add(partyData);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any I/O exceptions
        }
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
