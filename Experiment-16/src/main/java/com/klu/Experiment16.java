package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // ✅ This automatically scans com.klu.* packages
public class Experiment16 {
    public static void main(String[] args) {
        SpringApplication.run(Experiment16.class, args);
    }
}
