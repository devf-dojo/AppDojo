package dojo.f.dev.com.appdojo.app;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by Administrador on 08/08/17.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);

    }
}
