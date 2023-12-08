package com.ali;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ali.controller.StudentDetails;
import com.ali.model.Student;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Application.class, args);
		
		StudentDetails controller	=ctx.getBean("controller",StudentDetails.class);
		
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter rno1");
		 String rno1=sc.next().toUpperCase();
		 System.out.println("enter rno2");
		 String rno2=sc.next().toUpperCase();
		 
		 try {
			 List<Student> liststu=controller.showStudentDetailsByRno(rno1, rno2);
				/* for(Employee e:listEmps) {   // Enhanced for loop 
					 System.out.println(e);  
				 }//for
				*/
				/*listEmps.forEach(emp->{      //Java8 forEach syntax1
				   System.out.println(emp);
				});*/
			 
				/* listEmps.forEach(emp->           //Java8 forEach syntax2
					   System.out.println(emp)
					   );*/
			 
			 liststu.forEach(System.out::println);  // java8   forEach with method reference concept
			   
		 
		 }//try
		 catch(SQLException se) {
			 se.printStackTrace();
			 System.out.println("Internal DB Problem  ");
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Internal unknown Problem  ");
		 }
		 
		 //close container 
		 ((ConfigurableApplicationContext) ctx).close();

	}

}
