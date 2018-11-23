package cheliotd.com.my_calculator_app.Converter;

import java.util.HashMap;

public interface ConverterInteractor {

    void getCurrencyRates(OnRatesFinishListener listener);

    double getConvertedResult(String amount, String targetCurrency);

    interface OnRatesFinishListener{

        void onSuccess(HashMap<String, Double> currencies);

        void onError();
    }


}
