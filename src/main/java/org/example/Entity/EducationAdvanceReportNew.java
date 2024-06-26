package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "educationAdvanceReportnew")
@Data
public class EducationAdvanceReportNew {

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

    private String paymentType;
}