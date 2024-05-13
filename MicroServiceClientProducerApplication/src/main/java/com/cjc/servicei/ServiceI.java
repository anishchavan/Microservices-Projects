package com.cjc.servicei;

import java.util.List;

import com.cjc.model.Student;

public interface ServiceI {

	Student saveData(Student st);

	List<Student> displayData();

	Student updateByRollno(int rollno);

	List<Student> deleteByRollno(int rollno);

}
