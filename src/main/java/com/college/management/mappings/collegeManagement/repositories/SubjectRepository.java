package com.college.management.mappings.collegeManagement.repositories;

import com.college.management.mappings.collegeManagement.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
