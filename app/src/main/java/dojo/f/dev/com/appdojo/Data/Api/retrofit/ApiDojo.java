package dojo.f.dev.com.appdojo.Data.Api.retrofit;


import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiDojo {


    @FormUrlEncoded
    @POST(" api/v1/dojo/users/{uid}/cv")
    Call<Cv> createCv(@Field("name") String name,
                      @Field("email") String email,
                      @Field("photo") String photo,
                      @Field("cintas") String[] cintas);

}
