package Part14;
// VM options --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml

// SavingsCalculatorUI.java
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculatorUI {
    private LineChart<Number, Number> lineChart;
    private Slider monthlySavingsSlider;
    private Slider interestRateSlider;
    private Label monthlySavingsLabel;
    private Label interestRateLabel;

    public SavingsCalculatorUI() {
        monthlySavingsSlider = createSlider(25, 250, 50);
        interestRateSlider = createSlider(0, 10, 5);

        monthlySavingsLabel = new Label("Monthly savings: " + monthlySavingsSlider.getValue());
        interestRateLabel = new Label("Yearly interest rate: " + interestRateSlider.getValue() + "%");

        monthlySavingsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            monthlySavingsLabel.setText("Monthly savings: " + newValue.intValue());
            updateChart();
        });

        interestRateSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            interestRateLabel.setText("Yearly interest rate: " + newValue.intValue() + "%");
            updateChart();
        });

        lineChart = createLineChart();
        getLayout();
        updateChart(); // Initial chart update
    }

    private Slider createSlider(double min, double max, double initial) {
        Slider slider = new Slider(min, max, initial);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        return slider;
    }

    private LineChart<Number, Number> createLineChart() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount (€)");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Savings Over Time");
        return chart;
    }

    public BorderPane getLayout() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15));

        // First BorderPane for monthly savings
        BorderPane savingsPane = new BorderPane();
        savingsPane.setLeft(new Label("Monthly savings"));
        savingsPane.setCenter(monthlySavingsSlider);
        savingsPane.setRight(monthlySavingsLabel);

        // Second BorderPane for yearly interest rate
        BorderPane interestPane = new BorderPane();
        interestPane.setLeft(new Label("Yearly interest rate"));
        interestPane.setCenter(interestRateSlider);
        interestPane.setRight(interestRateLabel);

        vBox.getChildren().addAll(savingsPane, interestPane);
        borderPane.setTop(vBox);
        borderPane.setCenter(lineChart);

        return borderPane;
    }

    private void updateChart() {
        double monthlySavings = monthlySavingsSlider.getValue();
        double yearlyInterestRate = interestRateSlider.getValue() / 100;
        lineChart.getData().clear();

        XYChart.Series<Number, Number> savingsSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> interestSeries = new XYChart.Series<>();

        for (int year = 0; year <= 30; year++) {
            double totalSavings = monthlySavings * 12 * year;
            double totalWithInterest = 0;
            for (int month = 1; month <= year * 12; month++) {
                totalWithInterest += monthlySavings;
                totalWithInterest *= (1 + yearlyInterestRate / 12);
            }
            savingsSeries.getData().add(new XYChart.Data<>(year, totalSavings));
            interestSeries.getData().add(new XYChart.Data<>(year, totalWithInterest));
        }

        lineChart.getData().addAll(savingsSeries, interestSeries);
    }
}
