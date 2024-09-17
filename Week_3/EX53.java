package Week_3;

import java.util.Scanner;

public class EX53 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a word: ");
        String word = reader.nextLine();
        System.out.print("Length of the first part: ");
        int number = Integer.parseInt(reader.nextLine());
        String result = word.substring(0, number);
        System.out.println("Result: " + result);
    }
}
