package cheliotd.com.my_calculator_app.Converter;

public class Currency {

    private boolean success;
    private String baseCurrency;
    private String date;
    private String rates;

    public Currency(boolean success, String baseCurrency, String date, String rates) {
        this.success = success;
        this.baseCurrency = baseCurrency;
        this.date = date;
        this.rates = rates;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }
}