package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daArrear")
@Data
public class DaArrear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "darrear_id")
    private Long darrearId;

    @Column(name = "fromDate")
    private LocalDate fromDate;

    @Column(name = "toDate")
    private LocalDate toDate;

    @Column(name = "daArrearBasicPay")
    private Long daArrearBasicPay;

    @Column(name = "daArrearPersonalPay")
    private Long daArrearPersonalPay;

    @Column(name = "daDifference")
    private Long daDifference;

    @Column(name = "daArrearValue")
    private Long daArrearValue;

    @Column(name = "totalEarning")
    private double totalEarning;

    @Column(name = "netPay")
    private double netPay;

    @Column(name = "totalDeductions")
    private double totalDeductions;

    @Column(name = "V_EMPLOYEE_ID", length = 25)
    private String employeeId;

    @Column(name = "V_EMPLOYEE_NAME", length = 100)
    private String employeeName;

    @Column(name = "V_OFFICE_NAME", length = 100)
    private String officeName;

    @Column(name = "V_DESIGNATION_CODE", length = 25)
    private String designationCode;

    @Column(name = "V_VOUCHER_NO", length = 250)
    private Long voucherNo;

    private String Date;

}


