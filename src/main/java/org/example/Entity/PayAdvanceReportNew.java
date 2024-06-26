package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payAdvanceReportnew")
@Data
public class PayAdvanceReportNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;

    private String employeeId;

    private String employeeName;

    private BigDecimal payAdvanceAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;
    private String Date;
    private String paymentType;

}