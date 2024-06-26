package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fbfReportnew")
@Data
public class FBFReportNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fbfId;

    private String employeeId;

    private String employeeName;

    private BigDecimal fbfAmount;

    private String officeCode;

    private String designation;
    private String Date;
    private String paymentType;


}