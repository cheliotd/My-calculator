package cheliotd.com.my_calculator_app.Calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cheliotd.com.my_calculator_app.R;
import cheliotd.com.my_calculator_app.base.MainView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    public static CalculatorFragment newInstance(MainView mainView) {

        Bundle args = new Bundle();
        CalculatorFragment mfragment = new CalculatorFragment();
        args.putSerializable("main_view", mainView);
        mfragment.setArguments(args);
        return mfragment;

    }


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

}
