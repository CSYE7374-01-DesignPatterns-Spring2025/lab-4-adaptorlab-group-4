package edu.neu.csye7374;

public class Calculate {
  public static void demo() {
    System.out.println("=== Running Object Adapter ===");
    CalculatorAdapter.play();

    System.out.println("\n=== Running Class Adapter ===");
    CalculatorAdapterClass.play();
}
}
