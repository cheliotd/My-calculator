package cheliotd.com.my_calculator_app.Converter.presentation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cheliotd.com.my_calculator_app.Converter.domain.ConverterPresenter;
import cheliotd.com.my_calculator_app.Converter.domain.ConverterView;
import cheliotd.com.my_calculator_app.Converter.domain.currencyRates;
import cheliotd.com.my_calculator_app.R;
import cheliotd.com.my_calculator_app.base.MainView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConverterFragment extends Fragment implements ConverterView {


    @BindView(R.id.amount_edit_text)
    EditText mAmountEditText;

    @BindView(R.id.target_currency_spinner)
    Spinner mTargetCurrencySpinner;

    @BindView(R.id.target_currency_amount)
    TextView convertedResult;

    String targetCurrency;
    Double targetRate;
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

        presenter = new ConverterPresenterImpl(this);
        presenter.getRates();

        return view;
    }


    @Override
    public void loadSpinnerData(final currencyRates rates) {

        final ArrayList<String> currencies = new ArrayList(rates.getCurrencyRates().keySet());

        getActivity().runOnUiThread(new Runnable() {

            ArrayAdapter<String> adapter = new ArrayAdapter(
                    getContext(),
                    android.R.layout.simple_spinner_item,
                    currencies
            );

            @Override
            public void run() {
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                mTargetCurrencySpinner.setAdapter(adapter);
            }
        });

        mTargetCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                targetCurrency = String.valueOf(parent.getItemAtPosition(position));

                targetRate = rates.getCurrencyRates().get(targetCurrency);
                String amount= mAmountEditText.getText().toString();
                calculateResult(amount, targetRate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void calculateResult(String amount, double targetRate) {

        DecimalFormat df = new DecimalFormat("#.#####");
        double result = Double.valueOf(df.format(Double.parseDouble(amount) / targetRate));

        convertedResult.setText(String.valueOf(result));
    }


    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), R.string.on_network_error, Toast.LENGTH_LONG).show();
    }


}