package com.example.demo.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.servicei.StudentI;

@Service
@Transactional
public class ServiceImpl implements StudentI{
	
	@Autowired
	StudentRepository sr;

	@Override
	public Student saveData(Student s) {
		// TODO Auto-generated method stub
		return sr.save(s);
	}

	@Override
	public Iterable<Student> displayAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public void deleteStudent(int rn) {
		 sr.deleteByRollno(rn);
		 
		
	}

	@Override
	public Student editData(int rn) {
		// TODO Auto-generated method stub
		return sr.findByRollno(rn);
	}

	
}
