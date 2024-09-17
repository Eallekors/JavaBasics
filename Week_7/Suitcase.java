package Week_7;

import java.util.ArrayList;

public class Suitcase {
    ArrayList<Thing> things = new ArrayList<Thing>();
    private int curweight;
    private int maxweight;
    public Suitcase(int weight) {
        this.maxweight = weight;
    }

    public void addThing(Thing thing){
        int currentweight = thing.getWeight();

        if(curweight + thing.getWeight() < maxweight) {
            things.add(thing);
            curweight += thing.getWeight();
        }
    }

    public String toString(){
        if (things.size() == 0){
            return "empty (0 kg)";
        }else if(things.size() == 1){
            return things.size() + " thing ( " + curweight + " kg)";
        }else {
            return things.size() + " things ( " + curweight + " kg)";
        }

    }
}
