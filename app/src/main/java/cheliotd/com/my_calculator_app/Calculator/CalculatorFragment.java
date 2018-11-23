package cheliotd.com.my_calculator_app.Calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cheliotd.com.my_calculator_app.R;
import cheliotd.com.my_calculator_app.base.MainView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {


    @BindView(R.id.result_textview)
    TextView mResultTextView;

    String result = "0";
    String operator = "";

    double firstNumber = 0;
    double secondNumber = 0;
    double pendingNumber = 0;

    boolean userInput = true;
    boolean isFirstInput = true;


    MainView mainView;


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
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        ButterKnife.bind(this, view);

        mainView = (MainView) getArguments().getSerializable("main_view");
        return view;
    }


  private void attachResult(){
        pendingNumber = Double.parseDouble(result);
  }

  private void restore(){
        firstNumber = pendingNumber;
  }

  private void handleInput(){
        if (isFirstInput){
            firstNumber = Double.parseDouble(result);
        }
        else {
            secondNumber = Double.parseDouble(result);
        }
  }

  @OnClick({R.id.zero_button, R.id.one_button, R.id.two_button, R.id.three_button, R.id.four_button,
  R.id.five_button, R.id.six_button, R.id.seven_button, R.id.eight_button, R.id.nine_button, R.id.decimal})
     public void onNumberButtonClicked(Button button){
        if (result.length() <= 12){
            if (result.equals("0")){
               if(!button.getText().toString().equals(".")){
                   result = "";
               }
            }
            if (!(result.contains(".") && button.getText().toString().equals("."))){
                result += button.getText();
                userInput = true;
            }
        }else {
            Toast.makeText(getContext(), R.string.large_input, Toast.LENGTH_LONG).show();
        }
      handleInput();
      updateDisplay();

  }

  public void chooseOperation(){

        calculations interactor = new calculations(firstNumber, secondNumber);

      switch (operator){
          case "+":
              result = Double.toString(interactor.addition());
              updateDisplay();
              attachResult();
              clear();
              restore();
              break;
          case "-":
              result = Double.toString(interactor.substraction());
              updateDisplay();
              attachResult();
              clear();
              restore();
              break;
          case "*":
              result = Double.toString(interactor.multiply());
              updateDisplay();
              attachResult();
              clear();
              restore();
              break;
          case "/":
              if (secondNumber == 0){
                  result = "ERROR";
                  updateDisplay();
                  userInput = false;
              }
              else {
                  result = Double.toString(interactor.division());
                  updateDisplay();
                  attachResult();
                  clear();
                  restore();
              }
              break;
      }

  }


  @OnClick({R.id.addition_button, R.id.substraction_button, R.id.multiply_button, R.id.division_button})
    public void onOperationButtonClicked(Button button){

        if (secondNumber!= 0 && !operator.equals("")){
            chooseOperation();
            firstNumber = pendingNumber;
            operator = button.getText().toString();
            result = "Ans " + button.getText().toString();
            updateDisplay();
            result = "";
            isFirstInput = false;
      }
      else if (secondNumber == 0){
            if (operator.equals("")){
                operator = button.getText().toString();
                result = button.getText().toString();
                updateDisplay();
                result = "";
                isFirstInput = false;
            }
            else if (!operator.equals("")){
                operator = button.getText().toString();
                result = button.getText().toString();
                updateDisplay();
                result = "";
                isFirstInput = false;
            }
        }
  }

  @OnClick(R.id.square_root_button)
  public void onSquareRootButton(){
        if (firstNumber > 0 ) {
            DecimalFormat formatDouble = new DecimalFormat("#.###########");
            result = (formatDouble.format(Math.sqrt(firstNumber)));
            attachResult();
            updateDisplay();
            clear();
            restore();
            isFirstInput = true;
            userInput = false;
        }else
            Toast.makeText(getContext(),R.string.ERROR_callConverter, Toast.LENGTH_LONG).show();

  }

  @OnClick(R.id.positive_negative_button)
  public void onInputSignClicked(){
        if (userInput) {
            if (!result.equals("") && !result.equals("0")){
                if (result.startsWith("-")){
                    result = result.substring(1, result.length());
                    updateDisplay();
                    handleInput();
                }
                else {
                    result = "-" + result;
                    updateDisplay();
                    handleInput();
                }
            }
        }
  }

  @OnClick(R.id.equals)
    public void onEqualsClick(){
        if (!operator.equals("")){
            chooseOperation();
            isFirstInput = true;
            userInput = false;
        }
  }

  @OnClick(R.id.clear_button)
    public void onClearClicked(){
        clear();
        updateDisplay();
  }

  private void clear(){
        firstNumber = 0;
        secondNumber = 0;
        result = "0";
        operator = "";
        isFirstInput = true;
    }

    private void updateDisplay(){
        mResultTextView.setText(result);
    }


    @OnClick(R.id.currency_button)
     public void callCurrencyFragment() {
        if (result == "ERROR") {
            Toast.makeText(getContext(), R.string.ERROR_callConverter, Toast.LENGTH_LONG).show();
        } else {
            if (result == "0") {
                mainView.addCurrencyFragment(Double.toString(pendingNumber));
            } else {
                mainView.addCurrencyFragment(result);
            }

        }
       clear();
    }

}
