package cheliotd.com.my_calculator_app.Converter;

import java.math.BigDecimal;
import java.util.HashMap;

public class Currency {

    private String currency;
    private BigDecimal rate;

    public Currency(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
