package dojo.f.dev.com.appdojo.SplashScreen;

import dojo.f.dev.com.appdojo.Data.Preferences.PreferencesManager;

/**
 * Created by Administrador on 08/08/17.
 */

public class SplashInteractorImp implements SplashInteractor{



    @Override
    public void navigationTo(PreferencesManager preferences, onNavigation navigation) {

        if(preferences.getPreferencesUser().isEmpty()&&preferences.getPreferencesPass().isEmpty()){


            navigation.onLogin();
        }else {

            navigation.onSaveLogin();

        }

    }
}
