package com.example.medical_backend.entities;

import com.example.medical_backend.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import javax.validation.constraints.*;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient")
public class Patient implements Serializable {
    @Id
    private  Long idPatient ;
    @NotNull
    private String firstNamePatient ;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String lastNamePatient ;
    @Past
    private LocalDate birthdate;
    @Embedded
    private  BirthPlace birthPlace ;
    private int age;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Pattern(regexp = "^\\d{10}$",message = "number phone not valid")
    private String numberPhone ;
    @Enumerated(EnumType.STRING)
    private CivilityState civilityState;
    private String bloodGroup;
    private  String job;
    private String trustedPersonName;
    private String PersonnelImage;
    @Pattern(regexp = "^\\d{10}$",message = "number phone not valid")
    private String trustedPersonPhoneNumber;
    private String otherNotes;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private Collection<Consultation> consultations;
    @ToString.Exclude
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Antecedent antecedent;
    }
