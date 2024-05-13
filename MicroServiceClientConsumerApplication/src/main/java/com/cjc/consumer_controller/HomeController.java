package com.cjc.consumer_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.model.Student;

@RestController
public class HomeController {
	@Autowired
	RestTemplate rt;
	
	@PostMapping("/postdatacon")
	public String postToProducer(@RequestBody Student s) {
//		String url = "http://localhost:8082/postdatapro";
		String url = "http://zuul/pro/postdatapro";
		return rt.postForObject(url,s,String.class);
	}
	
	@GetMapping("/getstudentlist")
	public List<Student> getStudentList() {
//		String url = "http://localhost:8082/getdata"; 
		String url = "http://zuul/pro/getdata";
		List<Student> list = rt.getForObject(url, List.class);
		return list;
	}
	
	@PutMapping("/updatestudent/{rollno}")
	public String updateStudent(@PathVariable int rollno, @RequestBody Student s) {
		String url = "http://zuul/pro/updatebyrollno/"+rollno;
		rt.put(url, s, Student.class);
		return "Data updated successfully";
	}
	
	@DeleteMapping("/deletestudent/{rollno}")
	public String deleteStudent(@PathVariable int rollno){
		String url = "http://zuul/pro/deletebyrollno/"+rollno;
		rt.delete(url);
		return "Student having "+ rollno + " deleted successfully";
	}
	
	
}
