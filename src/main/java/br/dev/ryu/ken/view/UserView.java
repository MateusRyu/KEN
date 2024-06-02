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
        
            (1) - Search book search by title;
            (2) - Register book by title;
            (3) - Register book by ID;
            (4) - List of all books registered;
            (5) - List of authors;
            (6) - List living authors in a given year;
            (7) - Display the number of books in a given language;
            (8) - List of living authors in a given year;

            (0) - Exit
        """);
        return scanner.nextLine();
    }

    public boolean confirm(String question) {
        System.out.println(question + "\n(Y) Yes\n(N) No");
        String confirm = scanner.nextLine();
        return confirm.equalsIgnoreCase("y");
    }
}
