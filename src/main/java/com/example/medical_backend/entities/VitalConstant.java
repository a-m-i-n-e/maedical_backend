package com.example.medical_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.io.Serializable;

@Embeddable
@Data
public class VitalConstant implements Serializable {
    private double height ;
    private double weight ;
    private double imc;
    private double temperature;
    private double cardiacFrequency;
    private double arterialPressure;
    private String observation;

}

