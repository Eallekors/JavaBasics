package Week_7;

import java.util.HashMap;
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    // Constructor
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    // Method to start the user interface
    public void start() {
        System.out.print("Statements: \n add - adds a word pair to the dictionary \n translate - asks a word and prints its translation \n quit - quit the text user interface\n\n ");

        while (true) {

            System.out.print("\nStatement: ");
            String input = reader.nextLine();

            if (input.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }else if (input.equals("add")) {

                System.out.print("In Finnish: ");
                String fin = reader.nextLine();
                System.out.print("Translation: ");
                String trans = reader.nextLine();
                dictionary.add(fin, trans);

            }else if (input.equals("translate")) {

                System.out.print("Give a word: ");
                String trans = reader.nextLine();
                String transl = dictionary.translate(trans);
                System.out.println(transl);
            }else {
                System.out.println("Unknown statement");
            }
        }
    }
}
