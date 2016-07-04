package com.goit;


public class CalculatorAddSubMultDiv implements Calculator {

    final static String ADD = "+";
    final static String SUB = "-";
    final static String MULT = "*";
    final static String DIV = "/";

    @Override
    public double operate(double a, double b, String operation) {
        if (operation.equals(ADD)) return a + b;
        if (operation.equals(SUB)) return a - b;
        if (operation.equals(MULT)) return a * b;
        if (operation.equals(DIV)) return a / b;
        else throw new IllegalArgumentException("No such operation: "+operation);
    }


}
