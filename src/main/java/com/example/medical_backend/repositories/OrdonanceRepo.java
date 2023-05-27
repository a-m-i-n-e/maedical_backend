package com.example.medical_backend.repositories;

import com.example.medical_backend.entities.Antecedent;
import com.example.medical_backend.entities.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdonanceRepo extends JpaRepository<Ordonance,Long> {
}