package cheliotd.com.my_calculator_app.rest;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("?access_key=947e11747b19e774d48e75ab606ab6c0")
    Call<RatesResponse> fetchCurrencyRates(@Query("date") String date);
}


