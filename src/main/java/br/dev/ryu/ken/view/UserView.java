package br.dev.ryu.ken.view;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println("Welcome to Kodama Encyclopedia Network, a.k.a. KEN!");
    }

    public String displayStartMenu() {
        System.out.println("""
            Enter the number corresponding to the desired option and then press the [ENTER] button:
        
            (1) - Book search by title;
            (2) - List of all books;
            (3) - List of authors;
            (4) - List living authors in a given year;
            (5) - Display the number of books in a given language;
            (6) - List of living authors in a given year;

            (0) - Exit
        """);
        return scanner.nextLine();
    }
}
