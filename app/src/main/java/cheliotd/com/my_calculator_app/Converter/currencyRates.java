package cheliotd.com.my_calculator_app.Converter;

import java.math.BigDecimal;

public class currencyRates {

    private String currency;
    private Double rate;

    public currencyRates(String currency, Double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
