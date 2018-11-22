package cheliotd.com.my_calculator_app.Converter;

import java.math.BigDecimal;
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
    public void getRates() {
        interactor.getCurrencyRates(this);
    }

    @Override
    public void onSuccess(HashMap<String, BigDecimal> rates) {

        ArrayList<String> currencies = new ArrayList<>(rates.keySet());

        view.loadSpinnerData(currencies);
    }

    @Override
    public void onError() {

    }


}
