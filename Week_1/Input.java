package Week_1;
import java.util.Scanner;
    public class Input {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);

            System.out.print("Who is greeted: ");
            String name = reader.nextLine(); // Reads a line of input from the user and assigns it
            //     to the variable called name

            System.out.print("Hi " + name);
        }
    }
