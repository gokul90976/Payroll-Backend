package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "convenyanceAdvanceReportnew")
@Data
public class ConvenyanceAdvanceReportNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long convenyanceId;

    private String employeeId;

    private String employeeName;

    private BigDecimal convenyanceAdvanceAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;

    private String Date;

    private String paymentType;
}