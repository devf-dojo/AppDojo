package dojo.f.dev.com.appdojo.login;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;

/**
 * Created by Administrador on 08/08/17.
 */

public class LoginInteractorImp implements LoginInteractor{

    @Override
    public void login(AppDojoService apiDojo, onLoginListener listener) {


        if(listener.onLoginSucess()){

            apiDojo.getCv();

        }

    }
}
