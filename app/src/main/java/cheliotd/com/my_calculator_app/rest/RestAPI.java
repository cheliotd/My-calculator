package cheliotd.com.my_calculator_app.rest;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET("/latest")
    Call<RatesResponse> fetchCurrencyRates();
}
