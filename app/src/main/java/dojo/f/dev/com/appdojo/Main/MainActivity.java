package dojo.f.dev.com.appdojo.Main;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.auth.FirebaseUser;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;
import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.utils.LiveUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FirebaseUser user = LiveUser.mAuth.getCurrentUser();
        if (user != null) {
            final AppDojoClient api = new AppDojoClient();
            api.getCv(user.getUid(), new AppDojoService.onGetCvListener() {
                @Override
                public void onGetCvListener(@Nullable Cv cv, boolean is_success_full) {
                    if (cv == null) {
                        cv = new Cv();
                        cv.setName("Yo");
                        api.createCv(user.getUid(), cv);
                        return;
                    }

                    TextView name = findViewById(R.id.name_cv);
                    TextView email = findViewById(R.id.email_cv);
                    SimpleDraweeView photo = findViewById(R.id.photo_cv);
                    TextView phone = findViewById(R.id.phone_cv);
                    TextView biography = findViewById(R.id.biography_cv);
                    TextView website = findViewById(R.id.website_cv);
                    TextView github = findViewById(R.id.github_cv);
                    TextView facebook = findViewById(R.id.facebook_cv);
                    TextView twitter = findViewById(R.id.twitter_cv);
                    TextView linkedin = findViewById(R.id.linkedin_cv);

                    name.setText(cv.getName());
                    email.setText(cv.getEmail());
                    photo.setImageURI(cv.getPhoto());
                    phone.setText(cv.getPhone());
                    biography.setText(cv.getBiography());
                    website.setText(cv.getWebsite());
                    github.setText(cv.getGithub());
                    facebook.setText(cv.getFacebook());
                    twitter.setText(cv.getTwitter());
                    linkedin.setText(cv.getLinkedin());
                }
            });
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