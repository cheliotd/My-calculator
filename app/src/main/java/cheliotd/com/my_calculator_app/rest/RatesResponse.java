package cheliotd.com.my_calculator_app.rest;

import java.util.ArrayList;

import cheliotd.com.my_calculator_app.Converter.Currency;


public class RatesResponse {

    private RestAPI restAPI;

    public RatesResponse(RestAPI restAPI) {
        this.restAPI = restAPI;
    }

    public ArrayList<Currency> getCurrencyRates(){
        return restAPI.fetchCurrencyRates();
    }
}
