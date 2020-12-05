package api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST(".")
    Call<ResponseBody> addWifi(@Body WifiData data);
}
