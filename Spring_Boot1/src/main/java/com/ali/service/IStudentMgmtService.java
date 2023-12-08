package com.ali.service;

import java.util.List;

import com.ali.model.Student;

public interface IStudentMgmtService {
	public List<Student> fetchStudDetailsByRno(String rno1,String rno2) throws Exception;

}
