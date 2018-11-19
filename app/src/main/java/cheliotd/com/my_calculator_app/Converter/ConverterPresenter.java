package cheliotd.com.my_calculator_app.Converter;

public interface ConverterPresenter {

    void getRates();

    void onItemClick(double quantity, Currency targetCurrency);

    void onInputError();
}
