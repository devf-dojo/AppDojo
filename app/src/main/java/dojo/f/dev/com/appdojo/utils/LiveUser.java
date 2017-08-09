package dojo.f.dev.com.appdojo.utils;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LiveUser extends LiveData<FirebaseUser> {
    private static final String TAG = LiveUser.class.getSimpleName();

    private static LiveUser sInstance;

    @NonNull
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private FirebaseAuth.AuthStateListener mConnection = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Log.d(TAG, "onAuthStateChanged: signed_in");
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged: signed_out");
            }
            setValue(user);
        }
    };

    @MainThread
    public static LiveUser get() {
        if (sInstance == null) {
            sInstance = new LiveUser();
        }
        return sInstance;
    }

    @Override
    protected void onActive() {
        mAuth.addAuthStateListener(mConnection);
    }

    @Override
    protected void onInactive() {
        mAuth.removeAuthStateListener(mConnection);
    }

}