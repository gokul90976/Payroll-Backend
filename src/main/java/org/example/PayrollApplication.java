package org.example;

import org.example.Entity.Percentage;
import org.example.Service.PayrollService;
import org.example.Service.PayrollServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }

    @Bean
    public Percentage percentage() {
        return new Percentage();
    }

    @Bean
    public PayrollService payrollService() {
        return new PayrollServiceImpl();
    }

}