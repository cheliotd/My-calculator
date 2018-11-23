package cheliotd.com.my_calculator_app.rest;

import cheliotd.com.my_calculator_app.Converter.domain.currencyRates;

public class RatesResponse {


    private currencyRates rates;

    public RatesResponse(currencyRates rates) {
        this.rates = rates;
    }

    public currencyRates getRates() {
        return rates;
    }

    public void setRates(currencyRates rates) {
        this.rates = rates;
    }
}