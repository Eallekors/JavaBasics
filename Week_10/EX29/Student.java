package Week_10.EX29;

public class Student extends Person {
    int cred;
    public Student(String name, String address) {
        super(name, address);
    }

    public int credits() {
        return cred;
    }

    public int study() {
        cred++;
        return 0;
    }

    @Override
    public String toString() {
        return name + " \n  " + aadress + " \n  credits " + cred;
    }
}
