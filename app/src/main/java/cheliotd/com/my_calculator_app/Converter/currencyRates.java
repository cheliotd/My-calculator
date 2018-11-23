package cheliotd.com.my_calculator_app.Converter;

import java.math.BigDecimal;
import java.util.HashMap;

public class Currency {

    private String country;
    private BigDecimal rate;

    public Currency(String country, BigDecimal rate) {
        this.country = country;
        this.rate = rate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
