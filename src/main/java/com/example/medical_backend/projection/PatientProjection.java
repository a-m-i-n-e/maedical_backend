package com.example.medical_backend.projection;

import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "patientProjection", types = Consultation.class)
public interface PatientProjection {
    @Value("#{target.idConsultation}")
    public Long getIdConsultation();

    @Value("#{target.date}")
    public LocalDateTime getDate();


    @Value("#{target.reason}")
    public String getReason();



    @Value("#{target.patient.lastNamePatient}")
    public String getLastNamePatient();

    @Value("#{target.patient.firstNamePatient}")
    public String getFirstNamePatient();

    @Value("#{target.patient.age}")
    public int getAge();








}