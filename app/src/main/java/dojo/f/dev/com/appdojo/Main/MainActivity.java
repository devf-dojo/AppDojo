package dojo.f.dev.com.appdojo.Main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoClient;
import dojo.f.dev.com.appdojo.Data.Api.client.AppDojoService;
import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.R;
import dojo.f.dev.com.appdojo.login.LoginActivity;
import dojo.f.dev.com.appdojo.utils.LiveUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    AppDojoClient api = new AppDojoClient();

    boolean has_mod = false;

    TextView name;
    TextView email;

    SimpleDraweeView photo;

    TextView phone;
    TextView biography;
    TextView skills;
    TextView languages;
    TextView website;
    TextView github;
    TextView facebook;
    TextView twitter;
    TextView linkedin;
    TextView hobbies;

    void saveCv() {
        FirebaseUser user = LiveUser.mAuth.getCurrentUser();
        if (user == null) {
            return;
        }
        Cv cv = new Cv();
        // TODO validate the info of user

        cv.setName(name.getText().toString().trim());
        String my_email = email.getText().toString().trim();
        if (my_email.length() != 0) {
            cv.setEmail(my_email);
        }
        /*if (photo. != null) {
            cv.setPhoto()
            photo.setImageURI();
        }*/
        cv.setPhone(phone.getText().toString().trim());

        cv.setBiography(biography.getText().toString().trim());

        String[] skills_array = skills.getText().toString().split(",");
        List<String> skills_list = new ArrayList<String>();
        for (int i = 0; i < skills_array.length; i++) {
            String str = skills_array[i].trim();
            if (str.length() != 0) {
                skills_list.add(str);
            }
        }
        if (skills_list.size() != 0) {
            cv.setSkills(skills_list);
        }

        String[] languages_array = languages.getText().toString().split(",");
        List<String> languages_list = new ArrayList<String>();
        for (int i = 0; i < languages_array.length; i++) {
            String str = languages_array[i].trim();
            if (str.length() != 0) {
                languages_list.add(str);
            }
        }
        if (languages_list.size() != 0) {
            cv.setLanguages(languages_list);
        }

        String my_website = website.getText().toString().trim();
        if (my_website.length() != 0) {
            cv.setWebsite(my_website);
        }
        String my_github = github.getText().toString().trim();
        if (my_github.length() != 0) {
            cv.setGithub(my_github);
        }
        String my_facebook = facebook.getText().toString().trim();
        if (my_github.length() != 0) {
            cv.setFacebook(my_facebook);
        }
        String my_twitter = twitter.getText().toString().trim();
        if (my_twitter.length() != 0) {
            cv.setTwitter(my_twitter);
        }
        String my_linkedin = linkedin.getText().toString().trim();
        if (my_linkedin.length() != 0) {
            cv.setLinkedin(my_linkedin);
        }

        String[] hobbies_array = hobbies.getText().toString().split(",");
        List<String> hobbies_list = new ArrayList<String>();
        for (int i = 0; i < hobbies_array.length; i++) {
            String str = hobbies_array[i].trim();
            if (str.length() != 0) {
                hobbies_list.add(str);
            }
        }
        if (hobbies_list.size() != 0) {
            cv.setHobbies(hobbies_list);
        }

        api.updateCv(user.getUid(), cv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_edit_cv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (has_mod) {
                saveCv();

                Snackbar.make(view, "Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                has_mod = false;
                //}
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        name = findViewById(R.id.name_cv);
        email = findViewById(R.id.email_cv);
        photo = findViewById(R.id.photo_cv);
        phone = findViewById(R.id.phone_cv);
        biography = findViewById(R.id.biography_cv);
        skills = findViewById(R.id.skills_cv);
        languages = findViewById(R.id.languages_cv);
        website = findViewById(R.id.website_cv);
        github = findViewById(R.id.github_cv);
        facebook = findViewById(R.id.facebook_cv);
        twitter = findViewById(R.id.twitter_cv);
        linkedin = findViewById(R.id.linkedin_cv);
        hobbies = findViewById(R.id.hobbies_cv);

        final FirebaseUser user = LiveUser.mAuth.getCurrentUser();
        if (user != null) {
            api.getCv(user.getUid(), new AppDojoService.onGetCvListener() {
                @Override
                public void onGetCvListener(@Nullable Cv cv, boolean is_success_full) {
                    if (cv == null) {
                        return;
                    }

                    name.setText(cv.getName());
                    email.setText(cv.getEmail());
                    if (cv.getPhoto() != null) {
                        photo.setImageURI(cv.getPhoto());
                    }
                    phone.setText(cv.getPhone());

                    biography.setText(cv.getBiography());

                    String skills_list = "";
                    if (cv.getSkills() != null) {
                        for (String skill : cv.getSkills()) {
                            skills_list += skill + ", ";
                        }
                    }
                    skills.setText(skills_list);

                    String language_list = "";
                    if (cv.getLanguages() != null) {
                        for (String language : cv.getLanguages()) {
                            language_list += language + ", ";
                        }
                    }
                    languages.setText(language_list);

                    website.setText(cv.getWebsite());
                    github.setText(cv.getGithub());
                    facebook.setText(cv.getFacebook());
                    twitter.setText(cv.getTwitter());
                    linkedin.setText(cv.getLinkedin());

                    String hobbies_list = "";
                    if (cv.getHobbies() != null) {
                        for (String hobbies : cv.getHobbies()) {
                            hobbies_list += hobbies + ", ";
                        }
                    }
                    hobbies.setText(hobbies_list);
                }
            });
        } else {
            return;
        }
        {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            photo.setImageURI(user.getPhotoUrl());
        }
        {
            View header = navigationView.getHeaderView(0);

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
            LiveUser.mAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}