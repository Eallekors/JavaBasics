package Week_7;

import java.util.ArrayList;

public class Container {
    ArrayList<Suitcase> cases = new ArrayList<Suitcase>();
    private int curweight;
    private int maxweight;

    public Container(int weight) {
        this.maxweight = weight;
    }

    public void addSuitcase(Suitcase suitcase) {
        cases.add(suitcase);
        curweight += suitcase.totalWeight();
    }

    public String toString(){
        return cases.size() + " suitcases (" + curweight + " kg)";
    }
}
