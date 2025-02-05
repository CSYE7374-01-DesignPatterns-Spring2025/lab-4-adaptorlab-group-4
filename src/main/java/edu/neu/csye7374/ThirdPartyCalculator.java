package edu.neu.csye7374;

public class ThirdPartyCalculator implements CalculatableAPI {
    @Override
    public double operation(OPERATION op, double a, double b) {
        switch (op) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MULT:
                return a * b;
            case DIV:
                return (b != 0) ? a / b : 0;
            default:
                throw new IllegalArgumentException("Invalid Operation");
        }
    }
}
