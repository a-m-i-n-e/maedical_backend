package com.example.medical_backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HygienoDietitic  implements Serializable {
      @NotNull
     @NotBlank(message = "please enter this field")
    private  String label ;
    private  String descritpion ;
}
