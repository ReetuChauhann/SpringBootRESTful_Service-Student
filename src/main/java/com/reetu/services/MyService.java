package com.reetu.services;

import java.util.List;

import com.reetu.beans.Student;

public interface MyService {
	public String addStudent(Student s); // to add student
	public String deleteStudent(String name); // to delete Student
	public List<Student> togetallStudents(); // to view all the students
	public List<String> togetAllname();     // to get all the name of the student
	public List<Integer> getallIds();     // to get all the ids
	public List<Student> getnamelike(String name); // to get name like
	public Student viewbyname(String name); // view by name
	public String update(Student s); //update by ids
	

}
