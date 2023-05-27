package com.example.medical_backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class Traitement implements Serializable {
     @Embedded
     Medicament medicamentTitle;
     @Embedded
     Posologie posologie;
     int unitsNumber;
     double qsp ;
}
