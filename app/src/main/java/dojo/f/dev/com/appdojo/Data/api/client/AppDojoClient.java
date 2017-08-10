package dojo.f.dev.com.appdojo.Data.Api.client;

import android.provider.SyncStateContract;

import dojo.f.dev.com.appdojo.Data.Api.models.Cv;
import dojo.f.dev.com.appdojo.Data.Api.retrofit.ApiCreateService;
import dojo.f.dev.com.appdojo.Data.Api.retrofit.ApiDojo;
import dojo.f.dev.com.appdojo.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrador on 09/08/17.
 */

public class AppDojoClient implements AppDojoService{




    @Override
    public void getCv() {
        ApiDojo api = ApiCreateService.createService();

        api.createCv("caTdznCemngTmnFxMDCZeUUXRNk1", Constants.JSON_WEB_TOKEN).enqueue(new Callback<Cv>() {
            @Override
            public void onResponse(Call<Cv> call, Response<Cv> response) {
                Cv cv = response.body();
                String email = cv.getEmail();
            }

            @Override
            public void onFailure(Call<Cv> call, Throwable t) {

            }
        });
    }
}
