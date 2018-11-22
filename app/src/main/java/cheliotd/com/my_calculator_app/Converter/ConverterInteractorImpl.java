package cheliotd.com.my_calculator_app.Converter;

import java.math.BigDecimal;
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
    public void getCurrencyRates(final OnRatesFinishListener listener) {

        Call<RatesResponse> call = RestClient.call().fetchCurrencyRates();

        call.enqueue(new Callback<RatesResponse>() {
            @Override
            public void onResponse(Call<RatesResponse> call, Response<RatesResponse> response) {
                HashMap<String, BigDecimal> rates = response.body().getResult();
                listener.onSuccess(rates);
            }

            @Override
            public void onFailure(Call<RatesResponse> call, Throwable t) {

            }
        });
    }
}
