package jm_program.github.io.enums;


public enum Operations {

    ADDITION("+") {
        @Override
        public double calculate(int a, int b) {
            return a + b;
        }
    },

    SUBTRACTION("-") {
        @Override
        public double calculate(int a, int b) {
            return a - b;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public double calculate(int a, int b) {
            return a * b;
        }
    },

    DIVISION("/") {
        @Override
        public double calculate(int a, int b) {
            return rounder((double)a / b);
        }
    };



    private String operation;


    Operations (String operation) {
        this.operation = operation;
    }


    public String getOperation() {
        return operation;
    }

    public abstract double calculate(int a, int b);

    // rounding up to 0.01 to the nearest
    protected double rounder (double roundedValue) {
        double resultRound = Math.round(roundedValue * 100);
        return resultRound / 100;
    }

}
