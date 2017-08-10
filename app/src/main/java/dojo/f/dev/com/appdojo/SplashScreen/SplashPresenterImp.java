package dojo.f.dev.com.appdojo.SplashScreen;

import dojo.f.dev.com.appdojo.Data.Preferences.PreferencesManager;

public class SplashPresenterImp implements SplashPresenter, SplashInteractor.onNavigation {

    private final SplashView splashView;
    private final SplashInteractor splashInteractor;
    private final PreferencesManager preferencesDevf;

    public SplashPresenterImp(SplashView view, PreferencesManager preferences){
        splashView = view;
        preferencesDevf = preferences;
        splashInteractor = new SplashInteractorImp();

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void navigation() {

        splashInteractor.navigationTo(preferencesDevf,this);

    }



    //si hay un login guardado ir al menu principal
    @Override
    public void onSaveLogin() {

        splashView.goToMain();

    }

    //si no hay login guardado ir al login
    @Override
    public void onLogin() {
        splashView.gotoLogin();
    }
}
