package com.college.management.mappings.collegeManagement.services;

import com.college.management.mappings.collegeManagement.entities.SubjectEntity;
import com.college.management.mappings.collegeManagement.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return  subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}
