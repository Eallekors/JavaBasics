package Week_5;

public class Apartment {
    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter){
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public boolean larger(Apartment otherApartment ){
        if (this.squareMeters > otherApartment.squareMeters){
            return true;
        }else {
            return false;
        }
    }

    public int priceDifference(Apartment otherApartment) {
        int origApart = this.squareMeters * this.pricePerSquareMeter;
        int otherApart = otherApartment.squareMeters * otherApartment.pricePerSquareMeter;
        int dif = otherApart - origApart;
        if (dif < 0 ){
            return (dif * -1);
        }else {
            return dif;
        }
    }

    public boolean moreExpensiveThan(Apartment otherApartment) {
        int origApart = this.squareMeters * this.pricePerSquareMeter;
        int otherApart = otherApartment.squareMeters * otherApartment.pricePerSquareMeter;
        if(origApart > otherApart){
            return true;
        }
        else if(origApart < otherApart) {
            return false;
        }

         return false;

    }

}