package Week_10.EX29;

public class Person {
    String name;
    String aadress;
    public Person(String name, String address) {
        this.name = name;
        this.aadress = address;
    }

    public String toString() {
        return name + " \n  " + aadress;
    }
}
