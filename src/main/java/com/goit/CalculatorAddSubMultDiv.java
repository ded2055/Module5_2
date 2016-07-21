package com.goit;


public class CalculatorAddSubMultDiv implements Calculator {

//    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    final static String ADD = "+";
    final static String SUB = "-";
    final static String MULT = "*";
    final static String DIV = "/";

    @Override
    public double calculate(double a, double b, String operation) {
//        LOGGER.info("calculate called "+a+" "+operation+" "+b);
        if (operation.equals(ADD)) return a + b;
        if (operation.equals(SUB)) return a - b;
        if (operation.equals(MULT)) return a * b;
        if (operation.equals(DIV)) return a / b;
        else throw new IllegalArgumentException("No such operation: "+operation);
    }


}
