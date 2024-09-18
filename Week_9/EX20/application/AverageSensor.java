package Week_9.EX20.application;



import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!this.isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor is off or has no sensors");
        }

        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.measure();
        }

        int average = sum / sensors.size();
        readings.add(average);  // Store the average reading
        return average;
    }

    // Exercise 20.4: Return all readings
    public List<Integer> readings() {
        return new ArrayList<>(this.readings);
    }
}
