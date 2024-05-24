package br.dev.ryu.ken.presenter;

import br.dev.ryu.ken.view.UserView;

public class PresenterRouter {
    private final UserPresenter API_PRESENTER;
    private final UserView USER_VIEW;

    public PresenterRouter(UserPresenter apiPresenter, UserView userView) {
        API_PRESENTER = apiPresenter;
        USER_VIEW = userView;
    }

    public void run() {
        String option = "-1";
        USER_VIEW.welcome();
        while (!option.equalsIgnoreCase("0")) {
            option = API_PRESENTER.mainMenu();
            switch (option) {
                case "0":
                    break;
                case "1":
                    API_PRESENTER.getBookByTitle();
                    break;
                case "2":
                    // TODO
                    System.out.println("List of all books");
                    break;
                case "3":
                    // TODO
                    System.out.println("List of authors");
                    break;
                case "4":
                    // TODO
                    System.out.println("List living authors in a given year");
                    break;
                case "5":
                    // TODO
                    System.out.println("Display the number of books in a given language");
                    break;
                case "6":
                    // TODO
                    System.out.println("List of living authors in a given year");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

    }
}
