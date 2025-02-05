package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;

public class CalculatorAdapter implements AccumulatableAPI {
    private final CalculatableAPI calculator;
    private double sum;

    public CalculatorAdapter(CalculatableAPI calc) {
        this.calculator = calc;
        this.sum = 0;
    }

    @Override
    public double accumulation(List<Double> itemPrices) {
        sum = 0;
        for (double itemPrice : itemPrices) {
            sum = this.calculator.operation(CalculatableAPI.OPERATION.ADD, sum, itemPrice);
        }
        return sum;
    }

    @Override
    public double payment(double cash) {
        return this.calculator.operation(CalculatableAPI.OPERATION.SUB, cash, sum);
    }

    // Static play() method to test Adapter functionality
    public static void play() {
        ThirdPartyCalculator thirdPartyCalculator = new ThirdPartyCalculator();
        AccumulatableAPI adapter = new CalculatorAdapter(thirdPartyCalculator);

        List<Double> prices = Arrays.asList(10.0, 20.5, 30.75);
        System.out.println("[Object Adapter] Total: " + adapter.accumulation(prices));
        System.out.println("[Object Adapter] Remaining after payment: " + adapter.payment(100));
    }
}

 