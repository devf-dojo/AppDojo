package dojo.f.dev.com.appdojo.Data.Api.client;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import dojo.f.dev.com.appdojo.Data.Api.models.Cv;

/**
 * Created by Administrador on 09/08/17.
 */

public interface AppDojoService {

    interface onGetCvListener {
        void onGetCvListener(@Nullable Cv cv, boolean is_success_full);
    }

    void getCv(String uid, onGetCvListener callback);
    void createCv(String uid, Cv cv);
    void updateCv(String uid, Cv cv);


    void login(@NonNull String code, OnCompleteListener<AuthResult> callback);

}
