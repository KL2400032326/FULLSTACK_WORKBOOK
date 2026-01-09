package com.klu.MainApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import com.klu.Annotations.*;
import com.klu.StudentDetails.*;
public class Main {

	public static void main(String[] args) {
		  ApplicationContext context = new AnnotationConfigApplicationContext(AnnoConfig.class);
		  Student s=context.getBean(Student.class);
		  s.display();
		  
	}

}
