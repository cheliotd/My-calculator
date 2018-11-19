package cheliotd.com.my_calculator_app.Calculator;

import java.text.DecimalFormat;

public class CalculatorInteractor {

    private double firstNumber;
    private double secondNumber;

    public CalculatorInteractor(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addition(){
        DecimalFormat dFormat = new DecimalFormat("#.#####");
        return Double.valueOf(dFormat.format(firstNumber + secondNumber));
    }

    public double substraction(){
        DecimalFormat dFormat = new DecimalFormat("#.#####");
        return Double.valueOf(dFormat.format(firstNumber  - secondNumber));
    }

    public double multiply(){
        DecimalFormat dFormat = new DecimalFormat("#.#####");
        return Double.valueOf(dFormat.format(firstNumber * secondNumber));
    }

    public double division(){
        DecimalFormat dFormat = new DecimalFormat("#.#####");
        return Double.valueOf(dFormat.format(firstNumber / secondNumber));
    }

    public double sqrt(){
        DecimalFormat dFromat = new DecimalFormat("#.#####");
        return Double.valueOf(dFromat.format(Math.sqrt(firstNumber)));
    }
}
