package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rentReport")
@Data
public class RentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;

    private String employeeId;

    private String employeeName;

    private BigDecimal rentAmount;

    private BigDecimal waterCharge;

    private String officeCode;

    private String designation;

    private BigDecimal totalAmount;

    private String Date;

}