package com.reetu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reetu.beans.Student;
import com.reetu.dao.StudentRepo;

@Service
public class Service1 implements MyService{
	                     @Autowired
	                     StudentRepo sr;
	                     
	                 //to add 
	                @Override
	                public String addStudent(Student s) {
	                
	                return sr.addstudent(s);
	                }

					@Override
					public String deleteStudent(String name) {
						
						return sr.delete(name);
					}

					@Override
					public List<Student> togetallStudents() {
						
						return sr.viewallstudent();
					}

					@Override
					public List<String> togetAllname() {
						
						return sr.onlyallname();
					}

					@Override
					public List<Integer> getallIds() {
						
						return sr.onlyallids();
					}

					@Override
					public List<Student> getnamelike(String name) {
						
						return sr.viewnameLike(name);
					}

					@Override
					public Student viewbyname(String name) {
						
						return sr.viewbyname(name);
					}

					@Override
					public String update(Student s) {
						
						return sr.update(s);
					}

}
