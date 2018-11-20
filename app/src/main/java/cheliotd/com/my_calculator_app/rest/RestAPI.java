package cheliotd.com.my_calculator_app.rest;

import java.util.ArrayList;

import cheliotd.com.my_calculator_app.Converter.Currency;
import cheliotd.com.my_calculator_app.base.Constants;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET(Constants.API_BASE)
    Call<RatesResponse> fetchCurrencyRates();
}
