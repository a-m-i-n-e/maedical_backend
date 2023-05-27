package com.example.medical_backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.*;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surgery implements Serializable {
      @NotNull
      @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
    @NotNull
    @NotBlank(message = "please enter this field")
    private String observation;

    private LocalDate date;
}
