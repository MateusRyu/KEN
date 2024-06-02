package br.dev.ryu.ken.presenter;

import br.dev.ryu.ken.model.Book;
import br.dev.ryu.ken.model.ListOfBooks;
import br.dev.ryu.ken.service.IApiConsumer;
import br.dev.ryu.ken.view.UserView;

import java.util.List;
import java.util.Scanner;

public class UserPresenter {
    private final UserView VIEW;
    private final IApiConsumer API;
    private final Scanner SCANNER = new Scanner(System.in);

    public UserPresenter(UserView view, IApiConsumer api) {
        VIEW = view;
        API = api;
    }

    public String mainMenu() {
        return VIEW.displayStartMenu();
    }

    public void getAllBookByTitle() {
        System.out.println("What's the book's title?");
        String title = SCANNER.nextLine();
        System.out.println("Searching..");
        ListOfBooks listOfBooks = API.getBooksByTitle(title);
        System.out.println("Books found: " + listOfBooks.count());
        System.out.println("Processing data..");

        if (listOfBooks.count() > 0) {
            List<Book> books = API.getBooksFromListOfBooks(listOfBooks);
            books.forEach(System.out::println);
        }
    }

    private void registerBook(boolean confirm, Book book) {
        if (confirm) {
            // TODO implement to save book
            System.out.println("Registering " + book + "...");
        }
    }

    public void registerBookByTitle() {
        System.out.println("What's the book's title?");
        String title = SCANNER.nextLine();
        System.out.println("Searching..");
        ListOfBooks listOfBooks = API.getBooksByTitle(title);
        System.out.println("Books found: " + listOfBooks.count());
        Book book = new Book(listOfBooks.books().getFirst());
        System.out.println("Most popular book with this title: " + book);
        boolean confirm = VIEW.confirm("Want to register " + book + "?");
        registerBook(confirm, book);
    }

    public void registerBookById() {
        System.out.println("What's the book's ID?");
        String title = SCANNER.nextLine();
        System.out.println("Searching..");
        Book book = new Book(API.getBooksById(title));
        boolean confirm = VIEW.confirm("Want to register " + book + "?");
        registerBook(confirm, book);
    }
}
