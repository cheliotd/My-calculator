package cheliotd.com.my_calculator_app.Converter;


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

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
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

    private int targetCurrency;

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
    public void loadSpinnerData(final HashMap<String, Double> currencies) {

        final ArrayList<String> countries = new ArrayList<>(currencies.keySet());

        getActivity().runOnUiThread(new Runnable() {

            ArrayAdapter<String> adapter = new ArrayAdapter(
                    getContext(),
                    android.R.layout.simple_spinner_item,
                    countries
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
                String targetCurrency = String.valueOf(parent.getItemAtPosition(position));
                String amount= mAmountEditText.getText().toString();
                calculateResult(amount, targetCurrency);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void calculateResult(String amount, String targetCurrency) {

        double finalAmount = presenter.calculateAmount(amount, targetCurrency);
        convertedResult.setText(String.valueOf(finalAmount));
    }


    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), R.string.on_network_error, Toast.LENGTH_LONG).show();
    }


}