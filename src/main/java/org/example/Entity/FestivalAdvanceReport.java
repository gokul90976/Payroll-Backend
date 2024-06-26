package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "festivalAdvanceReport")
@Data
public class FestivalAdvanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long festivalId;

    private String employeeId;

    private String employeeName;

    private BigDecimal festivalAdvanceAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;

    private String Date;
}