package cheliotd.com.my_calculator_app.rest;

import cheliotd.com.my_calculator_app.Converter.currencyRates;

public class RatesResponse {


    private currencyRates Result;

    public RatesResponse(currencyRates result) {
        Result = result;
    }

    public currencyRates getResult() {
        return Result;
    }

    public void setResult(currencyRates result) {
        Result = result;
    }
}