package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.projection.PatientProjection;
import com.example.medical_backend.repositories.ConsultationRepo;
import com.example.medical_backend.repositories.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepo consultationRepo;
    private final PatientRepo patientRepo;
    @Autowired
    public ConsultationServiceImpl(ConsultationRepo consultationRepo, PatientRepo patientRepo) {
        this.consultationRepo = consultationRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public Consultation addConsultationToPatient(Consultation consultation,Long idPatient) throws NotFoundException {
        Optional<Patient> patient = patientRepo.findById(idPatient);
        if (patient.isPresent()) {
            consultation.setPatient(patient.get());
            consultation.setIdPatient(patient.get().getIdPatient());
            consultation.setDate(LocalDateTime.now());
            if(consultation.getVitalConstant().getHeight() != 0){
                consultation.getVitalConstant().setImc(consultation.getVitalConstant().getWeight()/Math.pow(consultation.getVitalConstant().getHeight(),2));
            }

            return consultationRepo.save(consultation);
        } else {
            throw new NotFoundException("Patient not found with id : " + idPatient);
        }
    }

    @Override
    public Collection<Consultation> getConsultationsByIdPatient(Long idPatient) throws NotFoundException{
        Optional<Patient> patient = patientRepo.findById(idPatient);
        if (patient.isPresent()) {
           return patient.get().getConsultations();
        } else {
            throw new NotFoundException("Patient not found with id : " + idPatient);
        }
    }

    @Override
    public Consultation getConsultationByIdPatient(Long idPatient, Long idConsultation) throws NotFoundException {
        Optional<Patient> patient = patientRepo.findById(idPatient);
        Optional<Consultation>   consultation = consultationRepo.findById(idConsultation);
        if (patient.isPresent()) {
            if(consultation.isPresent()){
                 consultation.get().setPatient(patient.get());
                 return consultation.get();
            }else{
                throw new NotFoundException("Consultation not found with id : " + idConsultation);
            }
        } else {
            throw new NotFoundException("Patient not found with id : " + idPatient);
        }
    }

    @Override
    public Collection<PatientProjection> getConsultations()  {
        return consultationRepo.consultations();
    }

    @Override
    public Consultation editConsultation(Consultation Consultation, Long idConsultation, Long idPatient) {
        return null;
    }

}
