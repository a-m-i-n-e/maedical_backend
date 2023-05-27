package com.example.medical_backend.repositories;

import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PatientRepo extends JpaRepository<Patient,Long> {
    List<Patient>  findPatientsByFirstNamePatientContainingAndLastNamePatientContains(String lastName,String firstName);

}
