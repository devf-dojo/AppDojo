package dojo.f.dev.com.appdojo.Main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.auth.FirebaseUser;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;
import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.login.LoginActivity;
import dojo.f.dev.com.appdojo.utils.LiveUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
        {
            TextView name = findViewById(R.id.name_cv);
            name.setText(user.getDisplayName());

            TextView email = findViewById(R.id.email_cv);
            email.setText(user.getEmail());

            SimpleDraweeView photo = findViewById(R.id.photo_cv);
            photo.setImageURI(user.getPhotoUrl());
        }
        {
            View header = navigationView.getHeaderView(0);
            ;

            TextView email = (TextView) header.findViewById(R.id.nav_email);
            email.setText(user.getEmail());

            TextView name = (TextView) header.findViewById(R.id.nav_name);
            name.setText(user.getDisplayName());

            SimpleDraweeView photo = (SimpleDraweeView) header.findViewById(R.id.nav_photo);
            photo.setImageURI(user.getPhotoUrl());
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_logout) {
            // Handle the camera action

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
