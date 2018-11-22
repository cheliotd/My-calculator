package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;
import java.util.HashMap;

public class ConverterPresenterImpl implements ConverterPresenter, ConverterInteractor.OnRatesFinishListener {

    private ConverterInteractor interactor;
    private ConverterView view;

    public ConverterPresenterImpl(ConverterInteractor interactor, ConverterView view) {
        this.interactor = interactor;
        this.view = view;
    }

    @Override
    public void getRates(String fromCurrency) {
        interactor.getCurrencyRates(this, fromCurrency);
    }

    @Override
    public void onSuccess(HashMap<String, String> rates) {
        view.loadSpinnerData(rates);
    }

    @Override
    public void onError() {

    }


}
