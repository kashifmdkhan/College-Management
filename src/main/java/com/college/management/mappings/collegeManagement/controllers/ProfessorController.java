package com.college.management.mappings.collegeManagement.controllers;

import com.college.management.mappings.collegeManagement.entities.ProfessorEntity;
import com.college.management.mappings.collegeManagement.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<ProfessorEntity> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable("professorId") Long id){
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public ProfessorEntity createProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable Long professorId,@PathVariable Long subjectId){
        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ProfessorEntity assignStudentsToProfessor(@PathVariable Long professorId,@PathVariable List<Long> studentId){
       return professorService.assignStudentsToProfessor(professorId,studentId);
    }

}
