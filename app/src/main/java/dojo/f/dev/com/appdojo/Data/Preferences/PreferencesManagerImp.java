package dojo.f.dev.com.appdojo.Data.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.provider.SyncStateContract;
import android.renderscript.Script;

import dojo.f.dev.com.appdojo.utils.Constants;

/**
 * Created by Administrador on 08/08/17.
 */

public class PreferencesManagerImp implements PreferencesManager {


    private final SharedPreferences preferencesDevf;

    public PreferencesManagerImp(Context context){
        preferencesDevf = context.getSharedPreferences(Constants.PREFERENCES_DEVF,Context.MODE_PRIVATE);

    }


    @Override
    public void savePreferencesUser(String value) {
        preferencesDevf.edit()
                .putString(Constants.PREFERENCES_DEFF_KEY_USER,value)
                .apply();
    }

    @Override
    public void savePreferencesPass(String value) {

        preferencesDevf.edit()
                .putString(Constants.PREFERENCES_DEVF_KEY_PASS,value)
                .apply();

    }

    @Override
    public void savePreferencesToken(String value) {
        preferencesDevf
                .edit()
                .putString(Constants.PREFERENCES_DEVF_KEY_TOKEN, value)
                .apply();

    }

    @Override
    public void deletePreferencesUser() {

        preferencesDevf.edit()
                .remove(Constants.PREFERENCES_DEFF_KEY_USER)
                .apply();

    }

    @Override
    public void deletePreferencePass() {

        preferencesDevf.edit()
                .remove(Constants.PREFERENCES_DEVF_KEY_PASS)
                .apply();
    }

    @Override
    public void deletePreferencesToken() {

        preferencesDevf.edit()
                .remove(Constants.PREFERENCES_DEVF_KEY_TOKEN)
                .apply();

    }

    @Override
    public String getPreferencesUser() {

        return preferencesDevf.getString(Constants.PREFERENCES_DEFF_KEY_USER,"");
    }

    @Override
    public String getPreferencesPass() {

        return  preferencesDevf.getString(Constants.PREFERENCES_DEVF_KEY_PASS,"");
    }

    @Override
    public String getPreferencesToken() {

        return preferencesDevf.getString(Constants.PREFERENCES_DEVF_KEY_TOKEN,"");
    }

}
