package cheliotd.com.my_calculator_app.Converter.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import cheliotd.com.my_calculator_app.Converter.domain.ConverterInteractor;
import cheliotd.com.my_calculator_app.rest.RatesResponse;
import cheliotd.com.my_calculator_app.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  ConverterInteractorImpl implements ConverterInteractor {

    @Override
    public void getCurrencyRates(final OnRatesFinishListener listener) {

        Call<RatesResponse> call = RestClient.call().fetchCurrencyRates(getDate());

        call.enqueue(new Callback<RatesResponse>() {
            @Override
            public void onResponse(Call<RatesResponse> call, Response<RatesResponse> response) {

                listener.onSuccess(response.body().getRates());
                // listener.onSuccess(insertMockData());

            }

            @Override
            public void onFailure(Call<RatesResponse> call, Throwable t) {

                listener.onError();
            }
        });

    }


    /* public HashMap<String, Double> insertMockData(){

        HashMap<String, Double> currencies = new HashMap<>();

        currencies.put("USD", 1.13481);
        currencies.put("AED", 4.168326);
        currencies.put("AMD", 551.387039);
        currencies.put("BIF", 2026.259497);
        currencies.put("CHF", 1.131893);
        currencies.put("CAD", 1.501918);
        currencies.put("CZK",25.978747);
        currencies.put("TWD",35.1065);

        return currencies;

    }
    */

    private String getDate(){
        return new SimpleDateFormat("YYYY-MM-DD").format(new Date());
    }
}
