package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "MiscDeductionReport2")
@Data
public class MiscDeductionReport2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long miscId;

    private String employeeId;

    private String employeeName;

    private BigDecimal recoveryAmount;

    private BigDecimal balanceAmount;

    private String officeCode;

    private String designation;

    private String Date;


}