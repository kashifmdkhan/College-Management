package com.college.management.mappings.collegeManagement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "admission_record")
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer fees;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity student;
}
