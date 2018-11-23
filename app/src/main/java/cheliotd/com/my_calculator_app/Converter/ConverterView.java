package cheliotd.com.my_calculator_app.Converter;

import java.util.HashMap;

public interface ConverterView {

    void loadSpinnerData(HashMap<String, Double> currencies);

    void calculateResult(String amount, String targetCurrency);

    void showErrorMessage();



}
