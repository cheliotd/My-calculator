package cheliotd.com.my_calculator_app.Converter;

public class ConverterPresenterImpl implements ConverterPresenter {

    private ConverterInteractor interactor;
    private ConverterView view;

    public ConverterPresenterImpl(ConverterInteractor interactor, ConverterView view) {
        this.interactor = interactor;
        this.view = view;
    }

    @Override
    public void getRates() {
        interactor.getCurrencyRates();
    }

    @Override
    public void onItemClick(double quantity, Currency targetCurrency) {
        String result = interactor.convertCurrency(quantity, targetCurrency);
        view.displayResult(result);
    }

    @Override
    public void onInputError() {
        view.onInputError();
    }
}
