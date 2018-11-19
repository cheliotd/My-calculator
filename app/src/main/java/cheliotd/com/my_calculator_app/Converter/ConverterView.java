package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;

public interface ConverterView {

    void displaySpinnerDate(ArrayList<Currency> currencies);

    void displayResult(String result);

    void onNetworkError();

    void onInputError();



}
