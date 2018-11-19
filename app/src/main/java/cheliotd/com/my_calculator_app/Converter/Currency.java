package cheliotd.com.my_calculator_app.Converter;

public class Currency {

    private String currencyId;
    private int currencyRate;

    public Currency(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public int getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(int currencyRate) {
        this.currencyRate = currencyRate;
    }
}
