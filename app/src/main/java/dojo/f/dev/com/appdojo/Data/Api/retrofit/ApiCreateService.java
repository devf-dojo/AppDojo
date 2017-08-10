package dojo.f.dev.com.appdojo.Data.Api.retrofit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dojo.f.dev.com.appdojo.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCreateService {

    private static Gson gson = new GsonBuilder().create();

    private static Retrofit retrofit;


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.URL_BASE_DOJO)
                    .addConverterFactory(GsonConverterFactory.create(gson));

    public static ApiDojo createService() {
        if (retrofit == null) {
            retrofit = builder.build();
        }
        return retrofit.create(ApiDojo.class);
    }
}
