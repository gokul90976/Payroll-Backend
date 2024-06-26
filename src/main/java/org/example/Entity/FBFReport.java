package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fbfReport")
@Data
public class FBFReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fbfId;

    private String employeeId;

    private String employeeName;

    private BigDecimal fbfAmount;

    private String officeCode;

    private String designation;
    private String Date;


}