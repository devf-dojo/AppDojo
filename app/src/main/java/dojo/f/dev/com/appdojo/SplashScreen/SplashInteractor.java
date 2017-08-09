package dojo.f.dev.com.appdojo.SplashScreen;

import dojo.f.dev.com.appdojo.Data.Preferences.PreferencesManager;

/**
 * Created by Administrador on 08/08/17.
 */

public interface SplashInteractor {


    public interface onNavigation{

        void onSaveLogin();
        void onLogin();

    }

    void navigationTo(PreferencesManager preferences, onNavigation navigation);


}
