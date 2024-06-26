package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "marriageAdvanceReportnew")
@Data
public class MarriageAdvanceReportNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marriageId;

    private String employeeId;

    private String employeeName;

    private BigDecimal marriageAdvanceAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;

    private String Date;

    private String paymentType;

}