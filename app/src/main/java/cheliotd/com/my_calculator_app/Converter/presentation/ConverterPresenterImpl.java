package cheliotd.com.my_calculator_app.Converter.presentation;

import cheliotd.com.my_calculator_app.Converter.data.ConverterInteractorImpl;
import cheliotd.com.my_calculator_app.Converter.domain.ConverterInteractor;
import cheliotd.com.my_calculator_app.Converter.domain.ConverterPresenter;
import cheliotd.com.my_calculator_app.Converter.domain.ConverterView;
import cheliotd.com.my_calculator_app.Converter.domain.currencyRates;

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
    public void onSuccess(currencyRates rates) {
        view.loadSpinnerData(rates);
    }

    @Override
    public void onError() {
        view.showErrorMessage();
    }


}
