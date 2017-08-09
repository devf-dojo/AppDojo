package dojo.f.dev.com.appdojo.Data.Preferences;

import android.content.Context;

/**
 * Created by Administrador on 08/08/17.
 */

public interface PreferencesManager {

    void savePreferencesUser(String value);
    void savePreferencesPass(String value);
    void savePreferencesToken(String value);
    void deletePreferencesUser();
    void deletePreferencePass();
    void deletePreferencesToken();
    String getPreferencesUser();
    String getPreferencesPass();
    String getPreferencesToken();

}
