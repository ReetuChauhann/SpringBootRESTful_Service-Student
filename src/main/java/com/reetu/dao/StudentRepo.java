package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reetu.beans.Student;

@Repository
public class StudentRepo {
	                       
	                         @Autowired 
	                         JdbcTemplate jdbcTemplate;
	                         
	                         //to add student
	                         
	                         public String addstudent(Student s) {
	                        	 String query = "insert into sdata values(?,?,?,?)";
	                        	  int x =jdbcTemplate.update(query, new Object[] {s.getSid(), s.getSname(), s.getSroll(), s.getScourse()});
	                        	  if(x!=0) {
	                        		  return "Success";
	                        	  }
	                        	  else {
	                        		  return "failed";
	                        	  }
	                        		  
	                         }
	                         
	                       //to view all student
	                         
	                         public List<Student> viewallstudent(){
	                        	 class StudentMapper implements RowMapper{

									@Override
									public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
										Student s = new Student();
										s.setSid(rs.getInt("sid"));
										s.setSname(rs.getString("sname"));
										s.setSroll(rs.getInt("sroll"));
										s.setScourse(rs.getString("scourse"));
										return s;
									}
	                        		 
	                        	 }
	                        	final String query = "select * from sdata";
	                        	List<Student> s = jdbcTemplate.query(query, new StudentMapper());
	                        	return s;
	                         }
	                         
	                       //to view namelike student
	                        public List<Student> viewnameLike(String name){
	                        	class StudentMapper implements RowMapper{

									@Override
									public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
										Student s = new Student();
										s.setSid(rs.getInt("sid"));
										s.setSname(rs.getString("sname"));
										s.setSroll(rs.getInt("sroll"));
										s.setScourse(rs.getString("scourse"));
										return s;
									}
	                        		
	                        	}
	                               try {
	                            	   final String query = "select * from sdata where sname like ?";
	        	                       List<Student> s= jdbcTemplate.query(query, new StudentMapper(), new Object[] {"%"+name+"%"});
	        	                       return s;
									
								} catch (Exception e) {
									e.printStackTrace();
									return null;
								}	
	                        
	                        }
	                        
	                        //to delete student
	                        public String delete(String name) {
	                        	String query = "delete from sdata where sname=?";
	                        	int x = jdbcTemplate.update(query, new Object[] {name});
	                        	if(x!=0) {
	                        		return "success";
	                        	}
	                        	else {
	                        		return "failed";
	                        	}
	                        }
	                        
	                        // to get allstudents name
	                        public List<String> onlyallname(){
	                        	class StudentMapper implements RowMapper{

									@Override
									public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
										
										return rs.getString("sname");
									}
	                        		
	                        	}
	                        final String query = "select * from sdata";
	                        List<String> s= jdbcTemplate.query(query, new StudentMapper());
	                        return s;
	                        }
	                        
	                        // to get allstudents ids
	                        public List<Integer> onlyallids(){
	                        	class StudentMapper implements RowMapper{

									@Override
									public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
										
										return rs.getInt("sid");
									}
	                        		
	                        	}
	                        final String query = "select * from sdata";
	                        List<Integer> s= jdbcTemplate.query(query, new StudentMapper());
	                        return s;
	                        }
	                        
	                        //to update
	                        public String update(Student s) {
	                        	try {
	                        		String query = "update sdata set sname=?, sroll=?, scourse=? where sid=?";
		                        	int x = jdbcTemplate.update(query, new Object[] {s.getSname(), s.getSroll(), s.getScourse(), s.getSid()}); // have to ask!
		                        	if(x!=0)
		                        		return "success";
		                        
		                        	else 
		                        		return "failed";
		                        	
									
								} catch (Exception e) {
									e.printStackTrace();
									return "failed";
								}
	                        }
                              //to view by name
	                        public Student viewbyname(String name){
	                        	 class  StudentMapper implements RowMapper{

									@Override
									public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
										Student s = new Student();
										s.setSid(rs.getInt("sid"));
										s.setSname(rs.getString("sname"));
									    s.setSroll(rs.getInt("sroll"));
									    s.setScourse(rs.getString("scourse"));
										return s;
									}
	                        		 
	                        	 }
	                        try {
	                        	final String query = "select * from sdata where sname=?";
		                        Student s = (Student) jdbcTemplate.queryForObject(query, new StudentMapper() ,new Object[] {name});
		                        return s;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                        
	                        }
}
