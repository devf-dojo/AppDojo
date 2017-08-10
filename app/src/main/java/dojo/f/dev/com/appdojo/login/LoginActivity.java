package dojo.f.dev.com.appdojo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import dojo.f.dev.com.appdojo.Main.MainActivity;
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
        Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSucess() {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void savePreferencesUser() {

    }

    @Override
    public void goToMain() {

        startActivity(new Intent(this,MainActivity.class));
    }
}
