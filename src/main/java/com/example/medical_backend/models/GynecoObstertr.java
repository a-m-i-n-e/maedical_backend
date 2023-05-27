package com.example.medical_backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.*;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GynecoObstertr  implements Serializable {
     @NotNull
     @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
    @NotNull
     @NotBlank(message = "please enter this field")
    private LocalDate date;
     @NotNull
     @NotBlank(message = "please enter this field")
    private String remark;
}
