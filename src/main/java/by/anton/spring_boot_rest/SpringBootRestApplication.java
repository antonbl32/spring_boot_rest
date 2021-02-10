package by.anton.spring_boot_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //можно указать (scanBasePackageClasses = "пакет")
public class SpringBootRestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRestApplication.class, args);
    }

}
