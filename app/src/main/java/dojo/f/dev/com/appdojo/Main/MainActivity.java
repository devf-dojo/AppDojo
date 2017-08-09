package dojo.f.dev.com.appdojo.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.auth.FirebaseUser;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.utils.LiveUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseUser user = LiveUser.mAuth.getCurrentUser();
        if (user != null) {
            new AppDojoClient().getCv(user.getUid());
        } else {
            return;
        }

        TextView name = findViewById(R.id.name_cv);
        name.setText(user.getDisplayName());

        TextView email = findViewById(R.id.email_cv);
        email.setText(user.getEmail());

        SimpleDraweeView photo = findViewById(R.id.photo_cv);
        photo.setImageURI(user.getPhotoUrl());


    }


}