package dojo.f.dev.com.appdojo.Data.Api.retrofit;


import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiDojo {


    @FormUrlEncoded
    @POST(" api/v1/dojo/users/{uid}/cv")
    Call<Cv> createCv(@Path("uid") String uid,
                      @Header("Authorization") String authorization);


}
