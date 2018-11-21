package cheliotd.com.my_calculator_app.Converter;

import java.util.ArrayList;

public interface ConverterPresenter {

    void getRates();

    void onItemClick(double quantity, Currency targetCurrency);

}
