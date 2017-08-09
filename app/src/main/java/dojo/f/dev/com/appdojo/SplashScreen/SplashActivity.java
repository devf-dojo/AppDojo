package dojo.f.dev.com.appdojo.SplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dojo.f.dev.com.appdojo.Data.Preferences.PreferencesManager;
import dojo.f.dev.com.appdojo.Data.Preferences.PreferencesManagerImp;
import dojo.f.dev.com.appdojo.Main.MainActivity;
import dojo.f.dev.com.appdojo.login.LoginActivity;

/**
 * Created by Administrador on 08/08/17.
 */

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter;
    private PreferencesManager preferencesDevf;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferencesDevf = new PreferencesManagerImp(this);
        splashPresenter = new SplashPresenterImp(this, preferencesDevf);

        splashPresenter.navigation();
    }


    @Override
    public void goToMain() {

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    @Override
    public void gotoLogin() {

        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }


}