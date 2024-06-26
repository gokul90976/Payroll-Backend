package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "educationAdvanceReport")
@Data
public class EducationAdvanceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EducationId;

    private String employeeId;

    private String employeeName;

    private BigDecimal educationAdvanceAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;

    private String Date;
}