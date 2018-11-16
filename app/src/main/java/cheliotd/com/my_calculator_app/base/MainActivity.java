package cheliotd.com.my_calculator_app.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cheliotd.com.my_calculator_app.Calculator.CalculatorFragment;
import cheliotd.com.my_calculator_app.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.calculator_root, CalculatorFragment.newInstance(this))
                .commit();
    }

    @Override
    public void addCalculatorFragment() {


    }

    @Override
    public void addCurrencyFragment() {
    }
}
