package com.example.medical_backend.entities;

import com.example.medical_backend.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Antecedent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAntecedent;
    @ElementCollection
    @CollectionTable(
            name="Pathologie",
            joinColumns=@JoinColumn(name="Pathologie_id")
    )
    private List<Pathology> pathologies;
    @ElementCollection
    @CollectionTable(
            name="Surgery",
            joinColumns=@JoinColumn(name="Surgery_id")
    )
    private  List<Surgery> surgeries;
    @ElementCollection
    @CollectionTable(
            name="DrugAllergy",
            joinColumns=@JoinColumn(name="DrugAllergy_id")
    )
    private  List<DrugAllergy> drugAllergies;
    @ElementCollection
    @CollectionTable(
            name="GynecoObstertr",
            joinColumns=@JoinColumn(name="GynecoObstertr_id")
    )
    private List<GynecoObstertr> gynecoObstertrs;

    @ElementCollection
    @CollectionTable(
            name="Family",
            joinColumns=@JoinColumn(name="Family_id")
    )

    private  List<Family> families;

    @ElementCollection
    @CollectionTable(
            name="Urogenetic",
            joinColumns=@JoinColumn(name="Urogenetic_id")
    )
    private  List<Urogenetic> urogenetics ;

    @ElementCollection
    @CollectionTable(
            name="ParaClinical",
            joinColumns=@JoinColumn(name="ParaClinical_id")
    )
    private  List<ParaClinical> paraclinicals;

    @ElementCollection
    @CollectionTable(
            name="SexualActivity",
            joinColumns=@JoinColumn(name="SexualActivity_id")
    )
    private  List<SexualActivity> sexualActivities;
    @ElementCollection
    @CollectionTable(
            name="HygienoDietitics",
            joinColumns=@JoinColumn(name="HygienoDietitics_id")
    )
    private List<HygienoDietitic> hygienoDietitics;
    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Patient patient;
    private Long idPatient;
}
