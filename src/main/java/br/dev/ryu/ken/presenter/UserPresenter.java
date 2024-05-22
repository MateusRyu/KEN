package br.dev.ryu.ken.presenter;

import br.dev.ryu.ken.view.UserView;

public class UserPresenter {
    private final UserView VIEW;

    public UserPresenter(UserView view) {
        VIEW = view;
    }

    public String mainMenu() {
        return VIEW.displayStartMenu();
    }
}
