package Week_6;

public class EX97 {
    public static void printElegantly(int[] integerArray) {

        System.out.println("the cells of the array are: ");
        for( int i = 0; i < integerArray.length; i++ ) {

                if(i == integerArray.length - 1) {
                    System.out.print(integerArray[i] + " ");
                }else{
                    System.out.print(integerArray[i] + "," + " ");

                }
            }

        System.out.println("");
    }

    public static void  main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};
        printElegantly(array);
    }
}

