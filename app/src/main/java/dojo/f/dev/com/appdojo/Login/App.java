package dojo.f.dev.com.appdojo.Login;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }

}

