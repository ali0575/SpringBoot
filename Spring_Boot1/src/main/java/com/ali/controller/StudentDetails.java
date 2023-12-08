package com.ali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ali.model.Student;
import com.ali.service.IStudentMgmtService;

@Controller("controller")
public class StudentDetails {
	
	@Autowired
	private IStudentMgmtService service;
	
	public List<Student> showStudentDetailsByRno(String rno1, String rno2) throws Exception{
		List <Student> listStudd = service.fetchStudDetailsByRno(rno1, rno2);
		return  listStudd;
	}
}
