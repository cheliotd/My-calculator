package cheliotd.com.my_calculator_app.Converter;

import java.util.HashMap;

public class ConverterPresenterImpl implements ConverterPresenter, ConverterInteractor.OnRatesFinishListener {

    private ConverterInteractor interactor;
    private ConverterView view;

    public ConverterPresenterImpl(ConverterView view) {
        interactor = new ConverterInteractorImpl();
        this.view = view;
    }

    @Override
    public void getRates() {
        interactor.getCurrencyRates(this);
    }

    @Override
    public double calculateAmount(String amount, String targetCurrency) {
        return interactor.getConvertedResult(amount, targetCurrency);
    }


    @Override
    public void onSuccess(HashMap<String, Double> currencies) {
        view.loadSpinnerData(currencies);
    }

    @Override
    public void onError() {
        view.showErrorMessage();
    }


}
