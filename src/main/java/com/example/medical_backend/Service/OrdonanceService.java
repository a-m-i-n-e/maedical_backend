package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Ordonance;
import com.example.medical_backend.exception.NotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;

public interface OrdonanceService  {
    Collection<Ordonance> getOrdonances();
    Ordonance addOrdonanceToPatient(Ordonance ordonance,Long idConsultation) throws NotFoundException;

    Ordonance getOrdonnace(Long idConsultation) throws  NotFoundException;
}
