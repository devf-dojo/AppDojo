package dojo.f.dev.com.appdojo.login;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;
import dojo.f.dev.com.appdojo.Data.Api.retrofit.ApiDojo;

/**
 * Created by Administrador on 08/08/17.
 */

public interface LoginInteractor {


    interface onLoginListener{

        boolean onLoginSucess();
        boolean onLoginError();
    }


    void login(AppDojoService apiDojo, onLoginListener listener);


}
