package com.example.medical_backend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.*;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pathology  {
    @NotNull
    @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
    @NotNull
   @NotBlank(message = "please enter this field")
    private  String pathology;
    @NotNull
    @NotBlank(message = "please enter this field")
    private String treatment;
    private LocalDate DateFrom;
    private LocalDate DateTo;
}
