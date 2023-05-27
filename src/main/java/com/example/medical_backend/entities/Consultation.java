package com.example.medical_backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="consultations")
public class Consultation implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long idConsultation;
   private String reason;
   private String medicalDiagnostic;
   private String resultClinicalExam;
   private LocalDateTime date;
  @Embedded
   private VitalConstant vitalConstant;
   @ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   private Patient patient;
   @Transient
   private Long idPatient ;
    @OneToOne
    @JsonIgnore
    private Ordonance ordonance;
}
