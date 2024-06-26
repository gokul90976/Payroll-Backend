package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "nhisReport")
@Data
public class NhisReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nhisId;

    private String employeeId;

    private String employeeName;

    private BigDecimal nhisAmount;

    private String officeCode;

    private String designation;

    private String Date;
}