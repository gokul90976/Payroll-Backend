package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "specialPfReportnew")
@Data
public class SpecialPfReportNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private BigDecimal specialPfAmount;
    private String Date;
    private String paymentType;
}