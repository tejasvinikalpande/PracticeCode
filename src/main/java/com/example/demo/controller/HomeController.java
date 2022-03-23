package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.servicei.StudentI;

@RestController
public class HomeController {
	
	@Autowired
	StudentI si;

	@RequestMapping("/")
	public String prelog()
	{
		return "welcome";
	}
//	@RequestMapping(value="/dataget", method=RequestMethod.GET)
//	public String dataget()
//	{
//		Iterable<Student> list = si.displayAll();
//		
//		Iterator< Student > itr = list.iterator();
//		
//		while(itr.hasNext())
//		{
//			Student stu = itr.next();
//			System.out.println(stu.getRollno());
//			System.out.println(stu.getName());
//			System.out.println(stu.getAddr());
//			System.out.println(stu.getMbno());
//		}
//		return "Get Data";
//}
	
	@RequestMapping(value="/datapost", method = RequestMethod.POST)
	public String dataPost(@RequestBody Student s)
	{
		Student stu = si.saveData(s);
		
		System.out.println("Rollno"+stu.getRollno());
		System.out.println("Name "+stu.getName());
		System.out.println("Address"+stu.getAddr());
		System.out.println("Mobile"+stu.getMbno());
		return "Data Saved";
	}
	@RequestMapping(value="/deleteData/{rollno}", method=RequestMethod.DELETE)
	public String deleteData(@PathVariable ("rollno") int rn)
	{
		si.deleteStudent(rn);
		return "deleted Successfully!!";
		
	}
	
	@RequestMapping(value="/datapatch/{rollno}", method = RequestMethod.PATCH)
	public String dataPatch(@PathVariable("rollno") int rn, @RequestBody Student s)
	{
		Student stu = si.editData(rn);
		try {
		if(stu.getRollno()==rn)
		{
		si.saveData(s);
		System.out.println("Roll No" +rn);
		return "Data Update";
		}
		else
		{
			return "Roll Number Not Found";
		}
		}
		catch (Exception e) {
			
			return "Roll Number Not Found";
		}
	}
	@RequestMapping(value="/dataget", method=RequestMethod.GET)
	public List<Student> getStudent(){
		
		return (List<Student>) si.displayAll();
	}
	
}