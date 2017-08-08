package dojo.f.dev.com.appdojo.Login;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.GithubAuthProvider;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.live_data.LiveUser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RedirectUriReceiverActivity extends AppCompatActivity {
  private static final String TAG = RedirectUriReceiverActivity.class.getName();

  OkHttpClient client = new OkHttpClient();

  void run(String token) {
    RequestBody formBody = new FormBody.Builder()
      .add("client_id", "<CLIENT_ID>")
      .add("client_secret", "<CLIENT_SECRET>")
      .add("code", token)
      .add("accept", "json")
      .build();

    Request request = new Request.Builder()
      .url("https://github.com/login/oauth/access_token")
      .addHeader("Accept", "application/json")
      .post(formBody)
      .build();

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        // TODO: what I should do when the request failed
        e.printStackTrace();
        //RedirectUriReceiverActivity.this.finish();
      }

      @Override
      public void onResponse(Call call, Response response) {

        try {
          if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
          }

          JSONObject json = new JSONObject(response.body().string());
          String code = json.getString("access_token");

          AuthCredential credential = GithubAuthProvider.getCredential(code);
          LiveUser.mAuth.signInWithCredential(credential)
            .addOnCompleteListener(RedirectUriReceiverActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                  Log.w(TAG, "signInWithCredential", task.getException());
                  Toast.makeText(RedirectUriReceiverActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
                }
                // TODO: What I should do when the user was login

                //RedirectUriReceiverActivity.this.finish();

              }
            });
        } catch (JSONException | IOException e) {
          // TODO: what I should do when the request response not match with the expected
          e.printStackTrace();
          //RedirectUriReceiverActivity.this.finish();
        }
      }


    });
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    Intent intent = getIntent();
    // To get the action of the intent use
    String action = intent.getAction();
    if (!action.equals(Intent.ACTION_VIEW)) {
      throw new RuntimeException("Should not happen");
    }
    // To get the data use
    Uri data = intent.getData();
    try {
      UrlQuerySanitizer url = new UrlQuerySanitizer();
      url.setAllowUnregisteredParamaters(true);
      url.parseUrl(data.toString());
      String code = url.getValue("code"); // name now contains "Joe_User"
      run(code);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}