package cheliotd.com.my_calculator_app.rest;

import java.math.BigDecimal;
import java.util.HashMap;

public class RatesResponse {


    private HashMap<String, BigDecimal> Result;


    public RatesResponse(HashMap<String, BigDecimal> result) {
        Result = result;
    }

    public HashMap<String, BigDecimal> getResult() {
        return Result;
    }

    public void setResult(HashMap<String, BigDecimal> result) {
        Result = result;
    }
}