package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.repositories.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class PatientImpl implements PatientService {
    private final PatientRepo patientRepo;
    @Autowired
    public PatientImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    @Override
    public Patient addPatient(Patient patient) {
        Optional<Patient> patient1 = patientRepo.findById(patient.getIdPatient());

        if(patient1.isPresent()){
            throw new IllegalStateException("Patient is taken");
        }
        else {
            String generatedId =""+patient.getBirthdate().getYear()+""+ LocalDateTime.now().getMinute()+LocalDateTime.now().getSecond();
            patient.setIdPatient(Long.valueOf(generatedId));
            patient.setAge(Period.between(patient.getBirthdate(),LocalDate.now()).getYears());
            return patientRepo.save(patient);
        }
    }
    @Override
    public Patient getPatient(Long idPatient)  throws NotFoundException {
        Optional<Patient> patient = patientRepo.findById(idPatient);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new NotFoundException("Patient not found with id : " + idPatient);
        }
    }


    @Override
    public Patient editPatient(Patient patient, Long idPatient) throws NotFoundException {
        Optional<Patient> patient1 = patientRepo.findById(idPatient);
        if (patient1.isPresent()) {
            patient.setIdPatient(idPatient);
            return patientRepo.save(patient);
        } else {
            throw new NotFoundException("Patient not found with id : " + idPatient);
        }
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }



}