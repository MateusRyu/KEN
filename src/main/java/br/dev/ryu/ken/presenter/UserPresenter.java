package br.dev.ryu.ken.presenter;

import br.dev.ryu.ken.model.Book;
import br.dev.ryu.ken.service.IApiConsumer;
import br.dev.ryu.ken.view.UserView;

import java.util.Optional;
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

    public void getBookByTitle() {
        System.out.println("What's the book's title?");
        String title = SCANNER.nextLine();
        Optional<Book> book = API.getBookByTitle(title);
        System.out.println(book);
    }
}
