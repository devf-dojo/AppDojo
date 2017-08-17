package dojo.f.dev.com.appdojo.Data.Api.client;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;

import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.Data.Api.models.Token;
import dojo.f.dev.com.appdojo.Data.Api.retrofit.ApiCreateService;
import dojo.f.dev.com.appdojo.Data.Api.retrofit.ApiDojo;
import dojo.f.dev.com.appdojo.utils.LiveUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrador on 09/08/17.
 */

public class AppDojoClient implements AppDojoService {

    interface onGetTokenListener {
        void onGetToken(@Nullable String idToken, boolean is_success_full);
    }

    private void getToken(final onGetTokenListener callback) {

        FirebaseUser user = LiveUser.mAuth.getCurrentUser();
        if (user == null) {
            callback.onGetToken(null, false);
            return;
        }
        user.getToken(false)
                .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                                           public void onComplete(@NonNull Task<GetTokenResult> task) {
                                               callback.onGetToken(task.getResult().getToken(), task.isSuccessful());
                                           }
                                       }
                );
    }


    @Override
    public void getCv(final String uid, final onGetCvListener callback) {
        getToken(new onGetTokenListener() {
            @Override
            public void onGetToken(@Nullable String idToken, boolean is_success_full) {
                if (is_success_full) {

                    ApiDojo api = ApiCreateService.createService();
                    api.getCv(uid, "Bearer " + idToken).enqueue(new Callback<Cv>() {
                        @Override
                        public void onResponse(Call<Cv> call, Response<Cv> response) {
                            Cv cv = response.body();
                            callback.onGetCvListener(cv, response.code() == 200);
                        }

                        @Override
                        public void onFailure(Call<Cv> call, Throwable t) {
                            callback.onGetCvListener(null, false);
                        }
                    });
                } else {
                    // TODO: Handle error -> task.getException();
                    callback.onGetCvListener(null, false);
                }
            }
        });
    }

    @Override
    public void createCv(final String uid, final Cv cv) {
        getToken(new onGetTokenListener() {
            @Override
            public void onGetToken(@Nullable String idToken, boolean is_success_full) {
                if (is_success_full) {

                    ApiDojo api = ApiCreateService.createService();
                    api.createCv(uid, "Bearer " + idToken, cv).enqueue(new Callback<Cv>() {
                        @Override
                        public void onResponse(Call<Cv> call, Response<Cv> response) {
                            Cv cv = response.body();
                            //String email = cv.getEmail();
                        }

                        @Override
                        public void onFailure(Call<Cv> call, Throwable t) {

                        }
                    });
                } else {
                    // TODO: Handle error -> task.getException();
                }
            }
        });
    }


    @Override
    public void updateCv(final String uid, final Cv cv) {
        getToken(new onGetTokenListener() {
            @Override
            public void onGetToken(@Nullable String idToken, boolean is_success_full) {
                if (is_success_full) {

                    ApiDojo api = ApiCreateService.createService();
                    api.updateCv(uid, "Bearer " + idToken, cv).enqueue(new Callback<Cv>() {
                        @Override
                        public void onResponse(Call<Cv> call, Response<Cv> response) {
                            Cv cv = response.body();
                            //String email = cv.getEmail();
                        }

                        @Override
                        public void onFailure(Call<Cv> call, Throwable t) {

                        }
                    });
                } else {
                    // TODO: Handle error -> task.getException();
                }
            }
        });
    }

    @Override
    public void login(@NonNull String code, final OnCompleteListener<AuthResult> callback) {
        if (code.length() == 0) {
            return;
        }

        ApiDojo api = ApiCreateService.createService();
        api.login_github(code).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.code() != 200) {
                    // return error
                    return;
                }
                //System.out.println("SUCCESS! " + response.body().access_token);
                AuthCredential credential = GithubAuthProvider.getCredential(response.body().access_token);
                LiveUser.mAuth.signInWithCredential(credential).addOnCompleteListener(callback);
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });
    }
}