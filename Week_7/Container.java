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

    public void printThings(){
        for (Suitcase suitcase : cases) {
            for (Thing thing : suitcase.things) {
                System.out.println(thing);
            }
        }
    }

    public int totalWeight() {
        return curweight;
    }

    public int getMaxWeight() {
        return maxweight;
    }
}
