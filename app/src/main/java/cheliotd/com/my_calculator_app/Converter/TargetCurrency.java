package cheliotd.com.my_calculator_app.Converter;

public enum TargetCurrency {

    GBP("GBP","UK Pounds"), EUR("EUR","EU Euro"), JPY("JPY","Japan Yen"), BRL("BRL","Brazil Reais");


    public final String currencyCode;

    public final String currencyDescription;

    TargetCurrency(String currencyCode, String currencyDescription) {
        this.currencyCode = currencyCode;
        this.currencyDescription = currencyDescription;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyDescription() {
        return currencyDescription;
    }
}
