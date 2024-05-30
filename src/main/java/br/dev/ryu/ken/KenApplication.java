package br.dev.ryu.ken;

import br.dev.ryu.ken.presenter.PresenterRouter;
import br.dev.ryu.ken.presenter.UserPresenter;
import br.dev.ryu.ken.service.GutendexConsumer;
import br.dev.ryu.ken.service.IApiConsumer;
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
		IApiConsumer api = new GutendexConsumer();
		UserPresenter apiPresenter = new UserPresenter(userView, api);
		PresenterRouter presenterRouter = new PresenterRouter(apiPresenter, userView);

		presenterRouter.run();
	}
}
