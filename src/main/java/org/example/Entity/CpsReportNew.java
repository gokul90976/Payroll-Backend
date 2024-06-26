package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cpsReportnew")
@Data
public class CpsReportNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cpsId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private String basicPay;

    private BigDecimal personalPay;

    private BigDecimal specialPay;

    private BigDecimal da;

    private BigDecimal cpsAmount;

    private BigDecimal cpsArrear;

    private BigDecimal totalAmount;

    private String Date;
    private String paymentType;
}