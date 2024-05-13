package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.homerepository.HomeRepository;
import com.cjc.model.Student;
import com.cjc.servicei.ServiceI;
@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	HomeRepository hr;
	
	@Override
	public Student saveData(Student st) {
		return hr.save(st);
	}
	@Override
	public List<Student> displayData() {
		return (List<Student>) hr.findAll();
	}
	@Override
	public Student updateByRollno(int rollno) {
		return hr.findByRollno(rollno);
	}
	@Override
	public List<Student> deleteByRollno(int rollno) {
		 hr.deleteByRollno(rollno);
		  return (List<Student>) hr.findAll();
	}
	

}
