package com.example.demo.servicei;

import com.example.demo.model.Student;

public interface StudentI {
	
	public Student saveData(Student s);

	public Iterable<Student> displayAll();
	
	public void deleteStudent(int rn);

	public Student editData(int rn);

//	public void saveInfo(Student stu);
	
	

}
