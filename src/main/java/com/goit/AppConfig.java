package com.goit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public Runner runner(CalculatorAddSubMultDiv calculatorAddSubMultDiv) {
        Runner runner = new Runner();
        runner.setCalculatorAddSubMultDiv(calculatorAddSubMultDiv);
        return runner;
    }

    @Bean
    CalculatorAddSubMultDiv calculatorAdditionSubtraction(){
        return new CalculatorAddSubMultDiv();
    }
}
