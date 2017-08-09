package dojo.f.dev.com.appdojo.Data.Api.retrofit;


import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.Data.Api.models.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDojo {

    /*@Headers({
            "Accept: application/json",
            "User-Agent: Devf-Dojo/1.0"
    })*/
    @GET("/api/v1/dojo/users/{uid}/cv")
    Call<Cv> getCv(@Path("uid") String uid,
                   @Header("Authorization") String authorization);

    @POST("/api/v1/dojo/users/{uid}/cv")
    Call<Cv> createCv(@Path("uid") String uid,
                      @Header("Authorization") String authorization,
                      @Body Cv cv);

    @PUT("/api/v1/dojo/users/{uid}/cv")
    Call<Cv> updateCv(@Path("uid") String uid,
                      @Header("Authorization") String authorization,
                      @Body Cv cv);

    @Headers({
            "Accept: application/json",
            "User-Agent: Devf-Dojo/1.0"
    })
    @GET("/api/v1/dojo/auth/github/login")
    Call<Token> login_github(@Query("code") String code);
}