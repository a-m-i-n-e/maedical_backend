package com.example.medical_backend.entities;

import com.example.medical_backend.models.Traitement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ordonance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdonance;
    private String title;
    @ElementCollection
    @CollectionTable(
            name="traitements",
            joinColumns=@JoinColumn(name="traitements_id")
    )
    private List<Traitement> traitements;
   @OneToOne
   @JsonIgnore
   private Consultation consultation;
   private  Long idConsultation;
}
