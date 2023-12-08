package com.ali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.dao.IStudentDAO;
import com.ali.model.Student;

@Service("studService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	@Autowired
	private IStudentDAO dao;

	@Override
	public List<Student> fetchStudDetailsByRno(String rno1, String rno2) throws Exception {

		List<Student> listStud = dao.getStudByNo(rno1, rno2);
		return listStud;
	}

}
