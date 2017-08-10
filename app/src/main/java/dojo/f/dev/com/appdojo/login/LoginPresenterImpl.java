package dojo.f.dev.com.appdojo.login;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;

/**
 * Created by Administrador on 08/08/17.
 */

public class LoginPresenterImpl implements LoginPresenter {

    LoginInteractor interactor;
    final LoginView view;


    LoginPresenterImpl(LoginView view) {

        this.view = view;
        interactor = new LoginInteractorImp();
    }

    @Override
    public void login() {

        view.goToMain();

    }






}
