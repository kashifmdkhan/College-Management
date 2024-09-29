package com.college.management.mappings.collegeManagement.services;

import com.college.management.mappings.collegeManagement.entities.AdmissionRecordEntity;
import com.college.management.mappings.collegeManagement.entities.StudentEntity;
import com.college.management.mappings.collegeManagement.repositories.AdmissionRecordRepository;
import com.college.management.mappings.collegeManagement.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {

    private AdmissionRecordRepository admissionRecordRepository;
    private StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }

    public AdmissionRecordEntity getAdmissionRecordEntityById(Long admissionId) {
        return admissionRecordRepository.findById(admissionId).orElse(null);
    }

    public List<AdmissionRecordEntity> getAllAdmissionRecord() {
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return  admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity addStudentToAdmissionRecord(Long admissionId, Long studentId) {
        Optional<AdmissionRecordEntity> admission = admissionRecordRepository.findById(admissionId);
        Optional<StudentEntity> student = studentRepository.findById(studentId);

        return admission.flatMap(admissionRecordEntity ->
                    student.map(studentEntity -> {
                        admissionRecordEntity.setStudent(studentEntity);
                        return admissionRecordRepository.save(admissionRecordEntity);
                    })
                ).orElse(null);
    }
}
