package cheliotd.com.my_calculator_app.Converter;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public interface ConverterInteractor {

    void getCurrencyRates(OnRatesFinishListener listener);

    interface OnRatesFinishListener{

        void onSuccess(HashMap<String, BigDecimal> currencies);

        void onError();
    }


}
