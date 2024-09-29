package com.college.management.mappings.collegeManagement.controllers;

import com.college.management.mappings.collegeManagement.entities.StudentEntity;
import com.college.management.mappings.collegeManagement.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/subject/{subjectId}")
    public StudentEntity assignSubjectToStudent(@PathVariable Long studentId,@PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId,subjectId);
    }
}
