package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "specialPfReport")
@Data
public class SpecialPfReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private BigDecimal specialPfAmount;
    private String Date;
}