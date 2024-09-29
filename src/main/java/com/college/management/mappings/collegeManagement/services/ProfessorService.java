package com.college.management.mappings.collegeManagement.services;

import com.college.management.mappings.collegeManagement.entities.ProfessorEntity;
import com.college.management.mappings.collegeManagement.entities.StudentEntity;
import com.college.management.mappings.collegeManagement.entities.SubjectEntity;
import com.college.management.mappings.collegeManagement.repositories.ProfessorRepository;
import com.college.management.mappings.collegeManagement.repositories.StudentRepository;
import com.college.management.mappings.collegeManagement.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }

    public ProfessorEntity getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public ProfessorEntity createProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                    subjectEntity.map(subject -> {
                        subject.setProfessor(professor);
                        professor.getSubjects().add(subject);
                        return professorRepository.save(professor);
                    })
                ).orElse(null);
    }

    public ProfessorEntity assignStudentsToProfessor(Long professorId, List<Long> studentId) {
        Optional<ProfessorEntity> professor = professorRepository.findById(professorId);
        List<StudentEntity> studentsList = studentRepository.findAllById(studentId);

        if(professor.isPresent()){
            ProfessorEntity professorEntity = professor.get();

            for(StudentEntity studentEntity: studentsList){
                studentEntity.getProfessors().add(professorEntity);
                professorEntity.getStudents().add(studentEntity);
            }
            return professorRepository.save(professorEntity);
        }
        return null;
    }
}
