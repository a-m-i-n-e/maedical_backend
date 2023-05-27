package com.example.medical_backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.*;
import java.io.Serializable;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugAllergy  implements Serializable {
    @NotNull
   @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
    @NotNull
   @NotBlank(message = "please enter this field")
    private String substance ;
   @NotNull
   @NotBlank(message = "please enter this field")
    private  String remark ;
}
