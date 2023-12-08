package com.ali.dao;

import java.util.List;

import com.ali.model.Student;

public interface IStudentDAO {
	public List<Student> getStudByNo(String no1,String no2) throws Exception;

}
