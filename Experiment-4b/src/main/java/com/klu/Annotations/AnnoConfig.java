package com.klu.Annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.klu.StudentDetails")
public class AnnoConfig {

}
