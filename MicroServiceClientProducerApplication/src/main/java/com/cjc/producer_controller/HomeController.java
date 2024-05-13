package com.cjc.producer_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Student;
import com.cjc.servicei.ServiceI;

@RestController
public class HomeController {
	@Autowired
	ServiceI si;
	
	@PostMapping("/postdatapro")
	public Student postData(@RequestBody Student st) {
		Student student = si.saveData(st); 
		System.out.println("Data posted successfully");
		return student;
	}
	
	@GetMapping("/getdata")
	public List<Student> getData(){
		List<Student> list = si.displayData();
		return list;
	}
	
	@PutMapping("/updatebyrollno/{rollno}")
	public Student updateStudent(@PathVariable int rollno, @RequestBody Student s) {
		Student student = si.updateByRollno(rollno);
		
		student.setRollno(s.getRollno());
		student.setFirstname(s.getFirstname());
		student.setLastname(s.getLastname());
		
		Student updatedStudent = si.saveData(student);
		return updatedStudent;
	}
	
	@DeleteMapping("/deletebyrollno/{rollno}")
	public List<Student> deleteStudent(@PathVariable int rollno) {
		List<Student> list = si.deleteByRollno(rollno);
		return list;
	}
}
