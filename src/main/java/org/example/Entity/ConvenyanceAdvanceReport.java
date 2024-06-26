package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "convenyanceAdvanceReport")
@Data
public class ConvenyanceAdvanceReport {

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
}