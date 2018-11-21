package cheliotd.com.my_calculator_app.Converter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import cheliotd.com.my_calculator_app.R;
import cheliotd.com.my_calculator_app.base.MainView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConverterFragment extends Fragment implements ConverterView {


    @BindView(R.id.amount_edit_text)
    EditText mAmountEditText;

    @BindView(R.id.from_currency_spinner)
    Spinner mFromCurrencySpinner;

    @BindView(R.id.target_currency_spinner)
    Spinner mTargetCurrencySpinner;

    @BindView(R.id.target_currency_amount)
    TextView convertedResult;

    ConverterPresenter presenter;


    public static ConverterFragment newInstance(MainView mainView, String amount) {

        Bundle args = new Bundle();
        ConverterFragment mfragment = new ConverterFragment();
        args.putSerializable("main_view", mainView);
        args.putString("amount", amount);
        mfragment.setArguments(args);
        return mfragment;
    }

    public ConverterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        ButterKnife.bind(this, view);
        mAmountEditText.setText(getArguments().getString("amount"));

        return view;
    }


    @Override
    public void loadSpinnerData(HashMap<String, String> currencies) {

        ArrayAdapter<Currency> rates = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                currencies.get()
        );
    }

    @Override
    public void displayResult(String result) {
        convertedResult.setText(result);
    }


}