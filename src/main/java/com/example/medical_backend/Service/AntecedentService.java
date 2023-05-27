package com.example.medical_backend.Service;

import com.example.medical_backend.entities.Antecedent;
import com.example.medical_backend.entities.Patient;
import com.example.medical_backend.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


public interface AntecedentService {

    Antecedent addAntecedentToPatient(Antecedent antecedent,Long idPatient) throws NotFoundException;
    Collection<Antecedent> getAntecedents() ;


}
