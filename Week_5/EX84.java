package Week_5;
import Week_4.Counter;

public class EX84 {
    private double balance;

    public EX84(double balance) {
        this.balance = balance;

    }




    @Override
    public String toString() {
        return  " balance: " ;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increase(-10);
        System.out.println(counter.balance());
        counter.decrease(-10);
        System.out.println(counter.balance());
        counter.decrease();
        System.out.println(counter.balance());


    }
}
