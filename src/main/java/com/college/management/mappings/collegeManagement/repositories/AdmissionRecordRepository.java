package com.college.management.mappings.collegeManagement.repositories;

import com.college.management.mappings.collegeManagement.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {

}
