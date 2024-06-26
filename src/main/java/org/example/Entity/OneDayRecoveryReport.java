package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "oneDayRecoveryReport")
@Data
public class OneDayRecoveryReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oneId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private String basicPay;

    private BigDecimal gross;

    private BigDecimal deductionAmount;
    private String Date;


}