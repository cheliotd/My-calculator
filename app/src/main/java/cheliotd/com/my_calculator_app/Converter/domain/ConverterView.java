package cheliotd.com.my_calculator_app.Converter.domain;

public interface ConverterView {

    void loadSpinnerData(currencyRates rates);

    void calculateResult(String amount, double targetRate);

    void showErrorMessage();



}
