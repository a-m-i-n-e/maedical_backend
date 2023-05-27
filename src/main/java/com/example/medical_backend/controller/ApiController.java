package com.example.medical_backend.controller;


import com.example.medical_backend.Service.AntecedentService;
import com.example.medical_backend.Service.ConsultationService;
import com.example.medical_backend.Service.OrdonanceService;
import com.example.medical_backend.Service.PatientService;
import com.example.medical_backend.entities.Antecedent;
import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Ordonance;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.projection.PatientProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class ApiController {
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final ConsultationService consultationService;

    @Autowired
    private final AntecedentService antecedentService;

    @Autowired
    private final OrdonanceService ordonanceService;
    @PostMapping("patients/addPatient")
    public ResponseEntity<Patient> addPatient( @RequestBody  @Valid Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }
    @PutMapping("patients/editPatient/{id}")
    public ResponseEntity<Patient> editPatient(@RequestBody @Valid Patient patient,@PathVariable Long id) throws NotFoundException {
        return  ResponseEntity.ok(patientService.editPatient(patient,id));
    }
    @GetMapping("patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }
    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(patientService.getPatient(id));
    }
    @PostMapping("consultations/addConsultation/{idPatient}")
    public ResponseEntity<Consultation> addConsultation(@RequestBody  @Valid Consultation consultation,@PathVariable Long idPatient) throws NotFoundException {
        return new ResponseEntity<>(consultationService.addConsultationToPatient(consultation,idPatient), HttpStatus.CREATED);
    }

    @GetMapping("patients/{idPatient}/consultations/{idConsultation}")
     public ResponseEntity<Consultation> getConsultationByIdPatient(@PathVariable Long idPatient,@PathVariable Long idConsultation) throws NotFoundException {
        return ResponseEntity.ok(consultationService.getConsultationByIdPatient(idPatient,idConsultation));
        }
    @GetMapping("consultations/patients/{idPatient}")
    public ResponseEntity<Collection<Consultation>> getConsultationsByIdPatient(@PathVariable Long idPatient) throws NotFoundException {
        return ResponseEntity.ok(consultationService.getConsultationsByIdPatient(idPatient));
    }

    @GetMapping("consultations")
    public ResponseEntity<Collection<PatientProjection>> getConsultationsByIdPatient() {
        return ResponseEntity.ok(consultationService.getConsultations());
    }


    @PostMapping("patients/{idPatient}/addAntecedent")
    public ResponseEntity<Antecedent> getConsultationsByIdPatient(@RequestBody Antecedent antecedent, @PathVariable Long idPatient) throws NotFoundException {
        return ResponseEntity.ok(antecedentService.addAntecedentToPatient(antecedent,idPatient));
    }

    @GetMapping("antecedents")
    public ResponseEntity<Collection<Antecedent>> getAntecedents() {
        return ResponseEntity.ok(antecedentService.getAntecedents());
    }

    @GetMapping("ordonances")
    public ResponseEntity<Collection<Ordonance>> getOrdonances() {
        return ResponseEntity.ok(ordonanceService.getOrdonances());
    }

    @PostMapping("ordonances/addOrdonance/{idConsultation}")
    public ResponseEntity<Ordonance> addOrdonnace(@RequestBody  Ordonance ordonance ,@PathVariable Long idConsultation) throws NotFoundException{
        return ResponseEntity.ok(ordonanceService.addOrdonanceToPatient(ordonance,idConsultation));
    }

    @GetMapping("consultations/{idConsultation}/ordonance")
    public ResponseEntity<Ordonance> getOrdonance(@PathVariable  Long idConsultation) throws NotFoundException{
        return ResponseEntity.ok(ordonanceService.getOrdonnace(idConsultation));
    }
}



