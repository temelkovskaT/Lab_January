package com.example.lab_january;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LabJanuaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabJanuaryApplication.class, args);
    }

}
