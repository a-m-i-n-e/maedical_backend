package com.example.medical_backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class Medicament implements Serializable {
    private String  medicamentName;
    private int dosage;
}
