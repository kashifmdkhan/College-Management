package com.college.management.mappings.collegeManagement.controllers;

import com.college.management.mappings.collegeManagement.entities.AdmissionRecordEntity;
import com.college.management.mappings.collegeManagement.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admission")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping
    public List<AdmissionRecordEntity> getAllAdmissionRecord(){
        return admissionRecordService.getAllAdmissionRecord();
}

    @GetMapping("/{admissionId}")
    public AdmissionRecordEntity getAdmissionRecordEntityById(@PathVariable Long admissionId){
        return admissionRecordService.getAdmissionRecordEntityById(admissionId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }

    @PutMapping(path = "/{admissionId}/student/{studentId}")
    public AdmissionRecordEntity addStudentToAdmissionRecord(@PathVariable Long admissionId,@PathVariable Long studentId){
        return admissionRecordService.addStudentToAdmissionRecord(admissionId,studentId);
    }

}
