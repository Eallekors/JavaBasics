package Week_5;

public class EX87 {
    public static void main(String[] args) {
        Apartment studioManhattan = new Apartment(1, 16, 5500); //88 000
        Apartment twoRoomsBrooklyn = new Apartment(2, 38, 4200); // 159 600
        Apartment fourAndKitchenBronx = new Apartment(3, 78, 2500);// 195 000

        System.out.println( studioManhattan.larger(twoRoomsBrooklyn) );       // false
        System.out.println( fourAndKitchenBronx.larger(twoRoomsBrooklyn) );   // true

        System.out.println( studioManhattan.priceDifference(twoRoomsBrooklyn) );        // 71600
        System.out.println( fourAndKitchenBronx.priceDifference(twoRoomsBrooklyn) );    // 35400

        System.out.println( studioManhattan.moreExpensiveThan(twoRoomsBrooklyn) );       // false
        System.out.println( fourAndKitchenBronx.moreExpensiveThan(twoRoomsBrooklyn) );   // true
        System.out.println( twoRoomsBrooklyn.moreExpensiveThan(studioManhattan) ); // true
    }
}
