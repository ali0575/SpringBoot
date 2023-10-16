// service Impl class
package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired    //injects the dynamically generated proxy class object 
	private IMovieRepo  movieRepo;  //HAS-A proeprty
	

	@Override
	public String registerMovie(Movie movie) {
		System.out.println("InMemory Proxu class name::"+movieRepo.getClass()+"..........."+Arrays.toString(movieRepo.getClass().getInterfaces()));
		   //use repo
		 System.out.println("bfore saving::"+movie);
		    Movie movie1=movieRepo.save(movie);
		    System.out.println("after saving::"+movie1);
		    
		return " Move is registered with the Id Value::"+movie1.getMid();
	}


	
	
	
	
	
}
