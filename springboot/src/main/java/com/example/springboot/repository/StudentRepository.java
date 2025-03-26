package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
	public Student findByEmail(String email);
	@Query("select MAX(s.SNO) from Student s")
	public String findMaxSNO();
}
