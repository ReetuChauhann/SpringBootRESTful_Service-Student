package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reetu.beans.Student;
import com.reetu.services.MyService;

@RestController
public class MyController {
	                         @Autowired
	                         MyService service; 
	                         
	               @RequestMapping("/")
	               public String home() {
	            	   return "Hello there!";
	               }
	               
	               // to view all the students
	             @GetMapping(value="/students",produces={"application/json", "application/xml"}) //but by default it produces it into json
	            public List<Student> getallstudents() {
	            	 List<Student> s = service.togetallStudents();
	            	 return s;
	             }
	            // to view by name
	             @GetMapping(value="/student/{name}")
	             public Student viewbyName(@PathVariable("name") String name){
	            	 Student s = service.viewbyname(name);
	            	 return s;
	             }
	            // to viewLikename
	            @GetMapping(value="/students/{name}")
	            public List<Student> likename(@PathVariable("name") String name){
	            	List<Student> s = service.getnamelike(name);
	            	return s;
	            }
	           // to add student
	            @PostMapping(value="/addstudent", consumes= {"application/xml","application/json"}) // by defauly consumes in both json,xml
	            public String addStudent(@RequestBody Student s) {
	            	String r = service.addStudent(s);
	            	if(r.equalsIgnoreCase("success"))
	            		return "Success";
	            	else
	            		return "failed";
	            }
	           
	            //to get all name
	            @GetMapping(value = "/getallname")
	            public List<String> getallname(){
	            	List<String> s = service.togetAllname();
	            	return s;
	            	
	            }
	            
	          //to get all ids
	            @GetMapping(value = "/getallids")
	            public List<Integer> getallids(){
	            	List<Integer> s = service.getallIds();
	            	return s;
	            	
	            }
	            
	           //to delete
	            @RequestMapping(value="/delete/{name}")
	            	public String delete(@PathVariable("name") String name) {
	            		String s = service.deleteStudent(name);
	            		if(s.equalsIgnoreCase("success"))
	            			return "Success";
	            		else 
	            			 return "Failed";
	            	}
	            @PutMapping(value="/updateStudent")
	            public String updates(@RequestBody Student s) {
	            	String s1 = service.update(s);
	            	return s1;
	            }
	            

}
