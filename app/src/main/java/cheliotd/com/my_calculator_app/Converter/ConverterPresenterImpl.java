package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;

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
    public void onItemClick(double quantity, Currency targetCurrency) {
        String result = interactor.convertCurrency(quantity, targetCurrency);
        view.displayResult(result);
    }

    @Override
    public void onSuccess(ArrayList<Currency> rates) {

    }

    @Override
    public void onError() {

    }
}
