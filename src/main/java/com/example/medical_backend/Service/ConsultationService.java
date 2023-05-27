package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.projection.PatientProjection;

import java.util.Collection;
import java.util.List;

public interface ConsultationService {
    Consultation addConsultationToPatient(Consultation consultation,Long idPatient) throws NotFoundException;
    Collection<Consultation> getConsultationsByIdPatient(Long idPatient) throws NotFoundException;
    Consultation getConsultationByIdPatient(Long idPatient , Long idConsultation) throws NotFoundException;

    Collection<PatientProjection> getConsultations() ;
    Consultation editConsultation(Consultation Consultation , Long idConsultation,Long idPatient) throws NotFoundException;


}
