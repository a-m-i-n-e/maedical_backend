package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Antecedent;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.repositories.AntecedentRepo;
import com.example.medical_backend.repositories.ConsultationRepo;
import com.example.medical_backend.repositories.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AntecedentServiceImpl implements AntecedentService{
    private final AntecedentRepo antecedentRepo;
    private final PatientRepo patientRepo;
    @Autowired
    public AntecedentServiceImpl(AntecedentRepo antecedentRepo, PatientRepo patientRepo) {
        this.antecedentRepo = antecedentRepo;
        this.patientRepo = patientRepo;
    }
    @Override
    public Antecedent addAntecedentToPatient(Antecedent antecedent, Long idPatient) throws NotFoundException {
       Optional<Patient> patient = patientRepo.findById(idPatient);
       if(patient.isPresent()) {
           antecedent.setPatient(patient.get());
           antecedent.setIdPatient(patient.get().getIdPatient());
           return antecedentRepo.save(antecedent) ;
       }
       else {
           throw new NotFoundException("patient not found");
       }
    }

    @Override
    public List<Antecedent> getAntecedents()  {
        return antecedentRepo.findAll();
    }

}
