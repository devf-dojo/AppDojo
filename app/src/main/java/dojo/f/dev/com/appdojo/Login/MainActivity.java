package dojo.f.dev.com.appdojo.Login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.live_data.LiveUser;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    if (LiveUser.mAuth.getCurrentUser() == null) {
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize?client_id=56f0c5f5e093d2a1c8cd"));
      startActivity(browserIntent);
    }
  }

}