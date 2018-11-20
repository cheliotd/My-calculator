package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;

public interface ConverterInteractor {

    void getCurrencyRates(OnRatesFinishListener listener);

    String convertCurrency(double amount, Currency targetCurrency);

    interface OnRatesFinishListener{
        void onSuccess(ArrayList<Currency> rates);

        void onError();
    }


}
