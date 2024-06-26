package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payarrear")
@Data
public class PayArrear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arrear_id")
    private Long arrearId;

    @Column(name = "fromDate")
    private LocalDate fromDate;

    @Column(name = "toDate")
    private LocalDate toDate;

    @Column(name = "basicPay")
    private Long basicPay;

    @Column(name = "personalPay")
    private Long personalPay;

    @Column(name = "specialPay")
    private Long specialPay;

    @Column(name = "daArrear")
    private Long daArrear;

    @Column(name = "hraArrear")
    private Long hraArrear;

    @Column(name = "ccaArrear")
    private Long ccaArrear;

    @Column(name = "totalEarningsArrear")
    private double totalEarning;


    // Already drawn fields

    @Column(name = "alreadyBasicPay")
    private Long alreadyBasicPay;

    @Column(name = "alreadyPersonalPay")
    private Long alreadyPersonalPay;

    @Column(name = "alreadySpecialPay")
    private Long alreadySpecialPay;

    @Column(name = "alreadyDaArrear")
    private Long alreadyDaArrear;

    @Column(name = "alreadyHraArrear")
    private Long alreadyHraArrear;

    @Column(name = "alreadyCcaArrear")
    private Long alreadyCcaArrear;

    @Column(name = "totalDeductions")
    private double totalDeductions;

    @Column(name = "netPay ")
    private double netPay;

    @Column(name = "totalDifferenceArrear")
    private double totalDifferenceArrear;

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

    private String designationName;

    private String officeCode;

    private String dateOfJoiningService;
    private Long cpsPercent;
    private Long gpfPercent;
    private Long totalNetpay;

    private Long toBemisc1;

    private Long alreadyMisc1;

    private Long cca;
    private Long hra;
    private Long da;
    private Long personalPays;
    private Long basicPayEarning;
    private Long specialPays;
    private Long gpfsub;
    private Long misc1;
    private Long cps;


}
