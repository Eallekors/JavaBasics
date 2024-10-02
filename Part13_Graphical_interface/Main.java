package Part13_Graphical_interface;

import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Title: ");
        String title = reader.nextLine();

        Application.launch(Input_title.class,
                "--title=" + title);
    }
}