package com.ali.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.model.Student;



@Repository("studDAO")
public class StudentDAOImpl implements IStudentDAO {
	private static final String GET_STUD_BY_RNO="SELECT RNO,NAME,CLAS,MOB FROM STUDENT60 WHERE RNO IN(?,?) ORDER BY RNO";
	@Autowired
	private DataSource ds;
	

	@Override
	public List<Student> getStudByNo(String no1,String no2) throws Exception {
		
		  List<Student> listStuds=null;
		  
	   
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_STUD_BY_RNO)){  // try with resource
			   //set qury param values
			   ps.setString(1, no1);
			   ps.setString(2, no2);
			 
			   
			   //execute the query
			   try(ResultSet rs=ps.executeQuery()){
				   
				   // copy  ResultSet object records to List collection as Employee class objects
				   listStuds=new ArrayList();
				      while(rs.next()) {
				    	  Student st=new Student();
				    	  st.setRno(rs.getInt(1));
				    	  st.setName(rs.getString(2));
				    	  st.setClas(rs.getString(3));
				    	  st.setMob(rs.getInt(4));
				    	  listStuds.add(st);
				      }//while
			   }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // exception re-throwing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; //exception re-throwing
		}
	
	return listStuds;
	}//method

}//class
