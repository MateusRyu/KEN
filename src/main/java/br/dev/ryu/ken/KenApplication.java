package br.dev.ryu.ken;

import br.dev.ryu.ken.presenter.PresenterRouter;
import br.dev.ryu.ken.presenter.UserPresenter;
import br.dev.ryu.ken.view.UserView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KenApplication.class, args);
	}

	@Override
	public void run(String... args) {
		UserView userView = new UserView();
		UserPresenter apiPresenter = new UserPresenter(userView);
		PresenterRouter presenterRouter = new PresenterRouter(apiPresenter, userView);

		presenterRouter.run();
	}
}
