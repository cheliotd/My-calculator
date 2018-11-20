package cheliotd.com.my_calculator_app.rest;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import cheliotd.com.my_calculator_app.Converter.Currency;


public class RatesResponse {

    private String base;
    private String date;

    private ArrayList<Currency> rates = new ArrayList<Currency>();

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Currency> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Currency> rates) {
        this.rates = rates;
    }
}
