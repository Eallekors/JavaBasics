package Week_10.EX29;

public class Teacher extends Person {
    int salary;
    public Teacher(String name, String address, int salary) {
        super(name, address );
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " \n  " + aadress + " \n  salary " + salary + " euros/month";
    }
}
