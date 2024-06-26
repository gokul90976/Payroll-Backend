package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "gpfReportnew")
@Data
public class GpfReportNew {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gpfId;

    private String employeeId;

    private String employeeName;

    private String basicPay;

    private BigDecimal personalPay;

    private String officeCode;

    private String designation;

    private BigDecimal specialPay;

    private BigDecimal da;

    private BigDecimal gpfSub;

    private BigDecimal gpfLoan;

    private BigDecimal gpfArrear;

    private BigDecimal vpf;

    private BigDecimal totalAmount;

    private String Date;
    private String paymentType;

}