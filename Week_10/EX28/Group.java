package Week_10.EX28;


import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{
    private List<Organism> organisms;
    int dx;
    int dy;
    public Group() {
        this.organisms = new ArrayList<>();
    }
    public void addToGroup(Organism organism){
        this.organisms.add(organism);
    }

    public String toString(){
        for(Organism organism : organisms){
            System.out.println(organism);
        }
        return "";
    }

    @Override
    public void move(int dx, int dy) {
        this.dx += dx;
        this.dy += dy;
    }
}
