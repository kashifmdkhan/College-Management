package com.college.management.mappings.collegeManagement.services;

import com.college.management.mappings.collegeManagement.entities.StudentEntity;
import com.college.management.mappings.collegeManagement.entities.SubjectEntity;
import com.college.management.mappings.collegeManagement.repositories.StudentRepository;
import com.college.management.mappings.collegeManagement.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<StudentEntity> student =  studentRepository.findById(studentId);
        Optional<SubjectEntity> subject = subjectRepository.findById(subjectId);

       return student.flatMap(studentEntity ->
                    subject.map(subjectEntity -> {
                        studentEntity.getSubjects().add(subjectEntity);
                        return studentRepository.save(studentEntity);
                    })
                ).orElse(null);
    }
}
