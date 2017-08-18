package dojo.f.dev.com.appdojo.login;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.List;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.Main.MainActivity;
import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.utils.Constants;
import dojo.f.dev.com.appdojo.utils.LiveUser;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter;


    void checkCode(Intent intent){

        String action = intent.getAction();
        /*if (!action.equals(Intent.ACTION_VIEW)) {
            throw new RuntimeException("Should not happen");
        }*/
        // To get the data use
        Uri data = intent.getData();
        if (data != null) {
            try {
                UrlQuerySanitizer url = new UrlQuerySanitizer();
                url.setAllowUnregisteredParamaters(true);
                url.parseUrl(data.toString());
                String code = url.getValue("code");

                AppDojoClient api = new AppDojoClient();
                api.login(code, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        onLoginChange(task.isSuccessful(), true);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        onLoginChange(LiveUser.mAuth.getCurrentUser() != null, false);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        checkCode(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //LiveUser.mAuth.signOut();

        Button boton_login = findViewById(R.id.btn_login_whith_github);
        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_LOGIN_GITHUB));

                //browserIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
                //startActivity(browserIntent);

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.enableUrlBarHiding();
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

                String PACKAGE_NAME = "com.android.chrome";

                customTabsIntent.intent.setData(Uri.parse(Constants.URL_LOGIN_GITHUB));

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(customTabsIntent.intent, PackageManager.MATCH_DEFAULT_ONLY);

                for (ResolveInfo resolveInfo : resolveInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    if (TextUtils.equals(packageName, PACKAGE_NAME))
                        customTabsIntent.intent.setPackage(PACKAGE_NAME);
                }
                customTabsIntent.launchUrl(LoginActivity.this, Uri.parse(Constants.URL_LOGIN_GITHUB));
            }
        });
        checkCode(getIntent());
    }

    void onLoginChange(boolean isSuccessFull, boolean showError) {
        if (isSuccessFull) {
            showLoginSucess();
            goToMain();
        } else if (showError) {
            showLoginError();
        }
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSucess() {
        Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void savePreferencesUser() {

    }

    @Override
    public void goToMain() {

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}