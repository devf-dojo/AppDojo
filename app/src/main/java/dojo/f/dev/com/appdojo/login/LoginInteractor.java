package dojo.f.dev.com.appdojo.login;

/**
 * Created by Administrador on 08/08/17.
 */

public interface LoginInteractor {


    interface onLoginListener{

        void onLoginSucess();
        void onLoginError();
    }


    void login();


}
