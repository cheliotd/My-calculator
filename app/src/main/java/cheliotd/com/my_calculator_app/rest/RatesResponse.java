package cheliotd.com.my_calculator_app.rest;

import java.util.HashMap;

public class RatesResponse {


    private HashMap<String, String> Result = new HashMap<>();


    public RatesResponse(HashMap<String, String> result) {
        Result = result;
    }

    public HashMap<String, String> getResult() {
        return Result;
    }

    public void setResult(HashMap<String, String> result) {
        Result = result;
    }
}