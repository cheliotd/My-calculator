package cheliotd.com.my_calculator_app.Converter;

import java.util.HashMap;

public class Currency {

    private String baseCurrency;
    private String date;
    private HashMap<String, String> rates;

    public Currency(String baseCurrency, String date, HashMap<String, String> rates) {
        this.baseCurrency = baseCurrency;
        this.date = date;
        this.rates = rates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, String> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }
}