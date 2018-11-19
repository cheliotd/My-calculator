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
import android.widget.Toast;

import java.util.ArrayList;

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
    TextView mTargetCurrencyAmount;

    ConverterPresenter presenter;


    public static ConverterFragment newInstance(MainView mainView) {

        Bundle args = new Bundle();
        ConverterFragment mfragment = new ConverterFragment();
        args.putSerializable("main_view", mainView);
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

        //TODO setText amount from calculator
        //TODO presenter.getData
        return view;
    }


    @Override
    public void displaySpinnerDate(ArrayList<Currency> currencies) {

    }

    @OnItemSelected(R.id.target_currency_spinner)
    public void targetSpinnerItemSelected(int position){
        mTargetCurrencySpinner.setSelection(position);  //TODO check variable on setSelection
    }


    @Override
    public void displayResult(String result) {
        mTargetCurrencyAmount.setText(result);
    }

    @Override
    public void onNetworkError() {
    }

    @Override
    public void onInputError() {
    }
}