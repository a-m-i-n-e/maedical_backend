package com.example.medical_backend.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Urogenetic implements Serializable {
     @NotNull
     @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
     @NotNull
     @NotBlank(message = "please enter this field")
    private String remark ;
    private LocalDate date ;
}

