package cheliotd.com.my_calculator_app.Converter.domain;

public interface ConverterInteractor {

    void getCurrencyRates(OnRatesFinishListener listener);

    interface OnRatesFinishListener{

        void onSuccess(currencyRates rates);

        void onError();
    }


}
