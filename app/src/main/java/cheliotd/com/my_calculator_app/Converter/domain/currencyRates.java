package cheliotd.com.my_calculator_app.Converter.domain;

import java.math.BigDecimal;
import java.util.HashMap;

public class currencyRates {



    private HashMap<String, Double> currencyRates;

    public currencyRates(HashMap<String, Double> currencyRates) {
        this.currencyRates = currencyRates;
    }

    public HashMap<String, Double> getCurrencyRates() {
        return currencyRates;
    }

    public void setCurrencyRates(HashMap<String, Double> currencyRates) {
        this.currencyRates = currencyRates;
    }
}
