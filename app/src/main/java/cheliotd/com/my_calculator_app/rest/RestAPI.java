package cheliotd.com.my_calculator_app.rest;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("/latest")
    Call<RatesResponse> fetchCurrencyRates(@Query("base") String fromCurrency);
}
