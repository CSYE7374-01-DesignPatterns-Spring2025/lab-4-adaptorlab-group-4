package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;

public class CalculatorAdapterClass extends ThirdPartyCalculator implements AccumulatableAPI {
    private double sum;

    public CalculatorAdapterClass() {
        this.sum = 0;
    }

    @Override
    public double accumulation(List<Double> itemPrices) {
        sum = 0;
        for (double itemPrice : itemPrices) {
            sum = this.operation(OPERATION.ADD, sum, itemPrice);
        }
        return sum;
    }

    @Override
    public double payment(double cash) {
        return this.operation(OPERATION.SUB, cash, sum);
    }

    // Static play() method to test Class Adapter functionality
    public static void play() {
        AccumulatableAPI adapter = new CalculatorAdapterClass();
        List<Double> prices = Arrays.asList(15.0, 25.5, 35.75);

        System.out.println("[Class Adapter] Total: " + adapter.accumulation(prices));
        System.out.println("[Class Adapter] Remaining after payment: " + adapter.payment(120));
    }
}

