package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.annoconfig.AppConfig;
import com.klu.model.Student;
 

public class MainApp {

	public static void main(String[] args) {
		 System.out.println("\n\n\nIt's from Annotations : ");
		 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		  Student s=context.getBean(Student.class);
		  s.display();
		  System.out.println("\n\n\nIt's from xml : ");
		  ApplicationContext context1= new ClassPathXmlApplicationContext("appconfig.xml");
		  Student s1=context.getBean(Student.class);
		  s1.display();
	}

}
