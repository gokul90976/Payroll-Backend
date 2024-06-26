package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "professionalTaxReport")
@Data
public class ProfessionalTaxReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionalId;

    private String employeeId;

    private String employeeName;

    private BigDecimal professionalTaxAmount;

    private String officeCode;

    private String designation;

    private String Date;
}