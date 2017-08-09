package dojo.f.dev.com.appdojo.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dojo.f.dev.com.appdojo.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void showLoginError() {

    }

    @Override
    public void showLoginSucess() {

    }

    @Override
    public void savePreferencesUser() {

    }

    @Override
    public void goToMain() {

    }
}
