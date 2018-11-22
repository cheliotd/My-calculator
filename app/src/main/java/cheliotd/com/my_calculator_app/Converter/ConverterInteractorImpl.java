package cheliotd.com.my_calculator_app.Converter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.OnClick;
import cheliotd.com.my_calculator_app.R;
import cheliotd.com.my_calculator_app.rest.RatesResponse;
import cheliotd.com.my_calculator_app.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConverterInteractorImpl implements ConverterInteractor {

    private RatesResponse response;

    public ConverterInteractorImpl(RatesResponse response) {
        this.response = response;
    }


    @Override
    public void getCurrencyRates(final OnRatesFinishListener listener, String fromCurrency) {

        Call<RatesResponse> call = RestClient.call().fetchCurrencyRates(fromCurrency);

        call.enqueue(new Callback<RatesResponse>() {
            @Override
            public void onResponse(Call<RatesResponse> call, Response<RatesResponse> response) {
                HashMap<String, String> rates = response.body().getResult();
                listener.onSuccess(rates);
            }

            @Override
            public void onFailure(Call<RatesResponse> call, Throwable t) {

            }
        });
    }
}
