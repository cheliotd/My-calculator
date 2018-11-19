package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;

public interface ConverterInteractor {

    ArrayList<Currency> getCurrencyRates();

    String convertCurrency(double amount, Currency targetCurrency);


}
