package Week_4;

public class Counter {
    public int value;   // object variable that remembers the value of the counter
    private boolean state;

    public Counter(int startingValue, boolean check) {
        this.value = startingValue;
        if (check) {
            this.state = check;
            System.out.println("Starting Value and positive check");
        }else {
            System.out.println("Starting Value and negative check");
        }
    }
    public Counter(int startingValue) {
        this.value = startingValue;
        this.state = false;
        System.out.println("Starting Value and no check");
    }
    public Counter(boolean check) {
        this.value= 0;
        if (check) {
            this.state = check;
            System.out.println("Starting Value and positive check");
        }else {
            System.out.println("Starting Value and negative check");
        }
    }
    public Counter() {
        this.value = 0;
        this.state = false;
        System.out.println("No parameters");
    }

    public int balance() {
        return value;
    }

    public void increase() {
        this.increase(1);
    }
    public void increase(double amount) {
        if(amount > 0) {
            value += amount;
        }
    }

    public void decrease() {
        this.decrease(1);
    }
    public void decrease(double amount) {
        if (amount >= 0) {
            double decresedValue = (value - amount);
            System.out.println("Decreasing value: " + decresedValue);
            if (state) {
                if (this.value > 0) {
                    if (decresedValue <= 0) {
                        System.out.println("Decreasing value will be below 0");
                        value -= amount + decresedValue;
                    } else {
                        value -= amount;
                    }
                }
            } else {
                value -= amount;
            }
        }
    }
}
