package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "incomeTaxReort")
@Data
public class IncomeTaxReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private String panNo;

    private String basicPay;

    private Long gross;

    private BigDecimal incomeTax;

    private BigDecimal incomeTaxCess;

    private BigDecimal totalAmount;

    private String Date;
}