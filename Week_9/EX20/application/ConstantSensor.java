package Week_9.EX20.application;

public class ConstantSensor implements Sensor{

    private int temp;

    public ConstantSensor(int measure) {
        this.temp = measure;
    }
    @Override
    public boolean isOn() {
        return true;
    }
    public void on(){

    }

    public void off(){

    }

    public int measure(){

        return temp;
    }
}
