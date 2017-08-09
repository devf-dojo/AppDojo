package dojo.f.dev.com.appdojo.login;

/**
 * Created by Administrador on 08/08/17.
 */

public interface LoginView {

    void showLoginError();
    void showLoginSucess();
    void savePreferencesUser();
    void goToMain();
}
