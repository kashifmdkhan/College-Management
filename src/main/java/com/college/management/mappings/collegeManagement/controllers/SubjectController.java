package com.college.management.mappings.collegeManagement.controllers;

import com.college.management.mappings.collegeManagement.entities.SubjectEntity;
import com.college.management.mappings.collegeManagement.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectEntity> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
       return subjectService.createNewSubject(subjectEntity);
    }
}
