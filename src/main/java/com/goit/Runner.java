package com.goit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

import static com.goit.CalculatorAddSubMultDiv.*;


public class Runner {
    CalculatorAddSubMultDiv calculatorAddSubMultDiv;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Runner runner = applicationContext.getBean("runner", Runner.class);
        runner.run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean isValidOperation;
        String operation = "";
        while (true) {
            isValidOperation = false;
            System.out.print("Type an operation: ");
            String input = in.next();
            System.out.print("\r");
            for (int i = 1; i <= input.length() - 2; i++) {
                char c = input.charAt(i);
                if (Character.toString(c).equals(ADD)) {
                    isValidOperation = true;
                    operation = ADD;
                    break;
                }
                if (Character.toString(c).equals(SUB)) {
                    isValidOperation = true;
                    operation = SUB;
                    break;
                }
                if (Character.toString(c).equals(MULT)) {
                    isValidOperation = true;
                    operation = MULT;
                    break;
                }
                if (Character.toString(c).equals(DIV)) {
                    isValidOperation = true;
                    operation = DIV;
                    break;
                }
            }

            if (!isValidOperation){
                System.err.println("Enter valid type of operation +/-");
                continue;
            }

            String[] operands = input.split("\\"+operation);
            if (operands.length != 2){
                System.err.println("Enter 2 operands, instead of "+operands.length);
                continue;
            }

            System.out.println("="+ calculatorAddSubMultDiv.operate(Double.valueOf(operands[0]), Double.valueOf(operands[1]), operation));
        }
    }

    public void setCalculatorAddSubMultDiv(CalculatorAddSubMultDiv calculatorAddSubMultDiv) {
        this.calculatorAddSubMultDiv = calculatorAddSubMultDiv;
    }
}
