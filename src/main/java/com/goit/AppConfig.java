package com.goit;

//@Configuration
//@EnableAspectJAutoProxy
public class AppConfig {

//    @Bean
    public Runner runner(CalculatorAddSubMultDiv calculatorAddSubMultDiv) {
        Runner runner = new Runner();
        runner.setCalculator(calculatorAddSubMultDiv);
        return runner;
    }

//    @Bean
    CalculatorAddSubMultDiv calculatorAdditionSubtraction(){
        return new CalculatorAddSubMultDiv();
    }
}
