package jm_program.github.io.beans;

import jm_program.github.io.constants.Constants;
import jm_program.github.io.enums.NumberSystem;



public final class Instance {

    private final String expression;   // the expression you entered
    private double result;   // result of calculation
    private NumberSystem numberSystem;   // number system


    public Instance(String expression) {
        this.expression = expression.toUpperCase();
    }


    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

    public NumberSystem getNumberSystem() {
        return numberSystem;
    }
    public void setNumberSystem(NumberSystem numberSystem) {
        this.numberSystem = numberSystem;
    }

    @Override
    public String toString() {
        return  expression   + Constants.OUT_DELIMITER +
                result       + Constants.OUT_DELIMITER +
                numberSystem;
    }

}
