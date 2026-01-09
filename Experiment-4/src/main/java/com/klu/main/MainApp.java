package com.klu.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.student.StudentDetails;

import org.springframework.context.ApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		StudentDetails sd=(StudentDetails)context.getBean("StdReg");
		sd.display();

	}

}
