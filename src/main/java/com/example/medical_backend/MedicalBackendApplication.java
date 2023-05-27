package com.example.medical_backend;
import com.example.medical_backend.Service.PatientService;
import com.example.medical_backend.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
@SpringBootApplication
public class MedicalBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalBackendApplication.class, args);
    }
}