package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient getPatient(Long idPatient) throws NotFoundException;
    Patient editPatient(Patient patient , Long idPatient) throws NotFoundException;
    List<Patient> getPatients();
}
