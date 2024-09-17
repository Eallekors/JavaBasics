package Week_7;

public class Thing {
    String Inname;
    int Inweight;
    public Thing(String name, int weight) {
        Inname = name;
        Inweight = weight;
    }
    public String getName() {
        return Inname;
    }
    public int getWeight() {
        return Inweight;
    }
    public String toString() {
        return Inname + " (" + Inweight + " kg)";
    }
}
