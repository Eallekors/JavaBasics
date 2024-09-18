package Week_9.EX20.application;

import java.util.Random;

public class Thermometer implements Sensor {
    private boolean isOn;
    private Random random;

    public Thermometer() {
        this.isOn = true;  // Thermometer starts off
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (!this.isOn) {
            throw new IllegalStateException("Thermometer is off. Cannot measure temperature.");
        }
        // Return a random number between -30 and 30
        return random.nextInt(61) - 30;  // Random number between -30 and 30 (inclusive)
    }
}

