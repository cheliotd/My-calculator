package cheliotd.com.my_calculator_app.Converter;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cheliotd.com.my_calculator_app.rest.RatesResponse;

public class ConverterInteractorImpl implements ConverterInteractor {

    private RatesResponse response;

    public ConverterInteractorImpl(RatesResponse response) {
        this.response = response;
    }

    @Override
    public ArrayList<Currency> getCurrencyRates() {
        return response.getCurrencyRates();
    }

    @Override
    public String convertCurrency(double amount, Currency targetCurrency) {
        double result = 0.00;

        result = amount / targetCurrency.getCurrencyRate();

        DecimalFormat df = new DecimalFormat("#0.00");

        String resultF = Double.toString(result);

        return resultF;
    }
}
