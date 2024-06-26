package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hbaReport")
@Data
public class HbaReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hbaId;

    private String employeeId;

    private String employeeName;

    private String officeCode;

    private String designation;

    private BigDecimal hba;

    private BigDecimal hbf;

    private BigDecimal eoe;

    private BigDecimal totalAmount;

    private String Date;
}