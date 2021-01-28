package com.lucas.learn_junit;

public class Calculator {

    private boolean enabled = false;

    public void enableCalculator() { enabled = true; }

    public void disableCalculator() { enabled = false; }

    public int add(int num1, int num2) { 
        testIfTheCalculatorIsEnabled();
        return num1 + num2; 
    }

    public int square(int num) { 
        testIfTheCalculatorIsEnabled();
        return num * num; 
    }

    private void testIfTheCalculatorIsEnabled() {
        if(!enabled) throw new RuntimeException("The calculator is not enabled");
    }
}
