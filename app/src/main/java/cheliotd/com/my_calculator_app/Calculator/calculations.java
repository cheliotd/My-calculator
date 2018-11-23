package cheliotd.com.my_calculator_app.Calculator;

import java.text.DecimalFormat;

public class calculations {

    private double firstNumber;
    private double secondNumber;

    public calculations(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addition(){
        DecimalFormat dFormat = new DecimalFormat("#.#######");
        return Double.valueOf(dFormat.format(firstNumber + secondNumber));
    }

    public double substraction(){
        DecimalFormat dFormat = new DecimalFormat("#.#######");
        return Double.valueOf(dFormat.format(firstNumber  - secondNumber));
    }

    public double multiply(){
        DecimalFormat dFormat = new DecimalFormat("#.#######");
        return Double.valueOf(dFormat.format(firstNumber * secondNumber));
    }

    public double division(){
        DecimalFormat dFormat = new DecimalFormat("#.#######");
        return Double.valueOf(dFormat.format(firstNumber / secondNumber));
    }

}
