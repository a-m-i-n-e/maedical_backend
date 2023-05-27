package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Consultation;
import com.example.medical_backend.entities.Ordonance;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import com.example.medical_backend.repositories.ConsultationRepo;
import com.example.medical_backend.repositories.OrdonanceRepo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class OrdonanceServiceImpl implements OrdonanceService{
    @Autowired
    private final OrdonanceRepo ordonanceRepo;
    @Autowired
    private final ConsultationRepo consultationRepo;

    public OrdonanceServiceImpl(OrdonanceRepo ordonanceRepo,ConsultationRepo consultationRepo) {
        this.ordonanceRepo = ordonanceRepo;
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Collection<Ordonance> getOrdonances() {
        return ordonanceRepo.findAll();
    }

    @Override
    public Ordonance addOrdonanceToPatient(Ordonance ordonance, Long idConsultation) throws NotFoundException {
          Optional<Consultation> consultation = consultationRepo.findById(idConsultation);
        if (consultation.isPresent()) {
            ordonance.setConsultation(consultation.get());
            ordonance.setIdConsultation(consultation.get().getIdConsultation());
            consultation.get().setOrdonance(ordonance);
            return ordonanceRepo.save(ordonance);
        } else {
            throw new NotFoundException("Consultation not found with id : " + idConsultation);
        }
    }

    @Override
    public Ordonance getOrdonnace(Long idConsultation) throws NotFoundException{
        Optional<Consultation> consultation = consultationRepo.findById(idConsultation);
        if (consultation.isPresent()) {

            return consultation.get().getOrdonance();
        } else {
            throw new NotFoundException("Consultation not found with id : " + idConsultation);
        }
    }

}
