package com.college.management.mappings.collegeManagement.repositories;

import com.college.management.mappings.collegeManagement.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
