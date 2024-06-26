package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "monthly_salary_new_data")
@ToString()
public class MonthlySalaryNewData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long id;

    @Column(name = "V_EMPLOYEE_ID", length = 25)
    private String employeeId;

    @Column(name = "V_EMPLOYEE_NAME", length = 100)
    private String employeeName;

    @Column(name = "V_OFFICE_CODE", length = 25)
    private String officeCode;

    @Column(name = "V_OFFICE_NAME", length = 100)
    private String officeName;

    @Column(name = "V_DESIGNATION_CODE", length = 25)
    private String designationCode;

    @Column(name = "V_DESIGNATION_NAME", length = 100)
    private String designationName;

    @Column(name = "N_TOTAL_EARNING", length = 50)
    private Long totalEarning;

    @Column(name = "N_TOTAL_DEDUCTIONS", length = 20)
    private Long totalDeductions;

    @Column(name = "N_NET_PAY", length = 20)
    private Long netPay;

    @Column(name = "V_PAN_NO", length = 25)
    private String panNo;

    @Column(name = "V_AADHAR_NO", length = 12)
    private String aadharNo;

    @Column(name = "N_MOBILE_NO", length = 10)
    private String mobileNo;

    @Column(name = "V_EMAIL_ID", length = 100)
    private String emailId;

    @Column(name = "V_DIFFERENTLY_ABLED")
    private String differentlyAbled;

    @Column(name = "V_DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "V_DATE_OF_JOINING_SERVICE")
    private String dateOfJoiningService;

    @Column(name = "V_LEVEL_AS_PER_PAY_MATRIX", length = 25)
    private String levelAsPerPayMatrix;

    @Column(name = "N_BASIC_PAY", length = 20)
    private String basicPay;

    @Column(name = "V_LEVEL_AS_PER_CELL_MATRIX", length = 25)
    private String levelAsPerCellMatrix;

    @Column(name = "V_SCALE_OF_PAY", length = 20)
    private String scaleOfPay;

    @Column(name = "V_INCREMENT_DUE_DATE")
    private String incrementDueDate;

    @Column(name = "V_DATE_OF_RETIREMENT")
    private String dateOfRetirement;

    @Column(name = "V_TRANSFER_OFFICE_CODE", length = 25)
    private String transferOfficeCode;

    @Column(name = "V_TRANSFER_OFFICE_NAME", length = 100)
    private String transferOfficeName;

    @Column(name = "V_DATE_OF_JOINING_TRANSFER")
    private String dateOfJoiningTransfer;

    @Column(name = "N_RENT")
    private String rent;

    @Column(name = "V_BANK_NAME", length = 100)
    private String bankName;

    @Column(name = "V_BANK_BRANCH_NAME", length = 100)
    private String bankBranchName;

    @Column(name = "V_BANK_AC_NO", length = 50)
    private Long bankAcNo;

    @Column(name = "V_BANK_IFSC", length = 50)
    private String bankIFSC;

    @Column(name = "V_PAY_STATUS")
    private String payStatus;

    @Column(name = "V_PF_CPS")
    private String pfcps;

    @Column(name = "N_BASIC_PAY_EARNING", length = 20)
    private Long basicPayEarning;

    @Column(name = "N_PERSONAL_PAY", length = 20)
    private Long personalPay;

    @Column(name = "N_SPECIAL_PAY", length = 20)
    private Long specialPay;

    @Column(name = "N_DA", length = 20)
    private Long da;

    @Column(name = "N_HRA", length = 20)
    private Long hra;

    @Column(name = "N_HRR", length = 20)
    private Long hrr;

    @Column(name = "N_CCA", length = 20)
    private Long cca;

    @Column(name = "N_MEDICAL_ALLOWANCE", length = 20)
    private Long medicalAllowance;

    @Column(name = "N_FTA", length = 20)
    private Long fta;

    @Column(name = "N_HILL_ALLOWANCE", length = 20)
    private Long hillAllowance;

    @Column(name = "N_WINTER_ALLOWANCE", length = 20)
    private Long winterAllowance;

    @Column(name = "N_WASHING_ALLOWANCE", length = 20)
    private Long washingAllowance;

    @Column(name = "N_CONVEYANCE_ALLOWANCE_EARNINGS", length = 20)
    private Long conveyanceAllowanceEarnings;

    @Column(name = "N_CASH_ALLOWANCE", length = 20)
    private Long cashAllowance;

    @Column(name = "N_INTERIM_RELIEF", length = 20)
    private Long interimRelief;

    @Column(name = "N_MISC_1", length = 20)
    private Long misc1;

    @Column(name = "N_GPF_SUB", length = 20)
    private Long gpfSub;

    @Column(name = "N_VPF", length = 20)
    private Long vpf;

    @Column(name = "N_CPS", length = 20)
    private Long cps;

    @Column(name = "N_FBF", length = 20)
    private Long fbf;

    @Column(name = "N_NHIS", length = 20)
    private Long nhis;

    @Column(name = "N_SPECIAL_PF", length = 20)
    private Long specialPf;

    @Column(name = "N_HBA", length = 20)
    private Long hba;

    @Column(name = "N_HBF", length = 20)
    private Long hbf;

    @Column(name = "N_RENT_DEDUCTIONS", length = 20)
    private Long rentDeductions;

    @Column(name = "N_WATER_CHARGES", length = 20)
    private Long waterCharges;

    @Column(name = "N_PROFESSIONAL_TAX", length = 20)
    private Long professionalTax;

    @Column(name = "N_ONE_DAY_RECOVERY", length = 20)
    private Long oneDayRecovery;

    @Column(name = "N_INCOME_TAX", length = 20)
    private Long incomeTax;

    @Column(name = "N_INCOME_TAX_CESS", length = 20)
    private Long incomeTaxCess;

    @Column(name = "N_EOE", length = 20)
    private Long eoe;

    @Column(name = "N_GPF_LOAN", length = 20)
    private Long gpfLoan;

    @Column(name = "N_GPF_ARREAR", length = 20)
    private Long gpfArrear;

    @Column(name = "N_CPS_ARREAR", length = 20)
    private Long cpsArrear;

    @Column(name = "N_FESTIVAL_ADVANCE", length = 20)
    private Long festivalAdvance;

    @Column(name = "N_CONVEYANCE_ADVANCE", length = 20)
    private Long conveyanceAdvance;

    @Column(name = "N_EDUCATION_ADVANCE", length = 20)
    private Long educationAdvance;

    @Column(name = "N_MARRIAGE_ADVANCE", length = 20)
    private Long marriageAdvance;

    @Column(name = "N_PAY_ADVANCE", length = 20)
    private Long payAdvance;

    @Column(name = "N_MISC_DEDUCTION_1", length = 20)
    private Long miscDeduction1;

    @Column(name = "N_MISC_DEDUCTION_2", length = 20)
    private Long miscDeduction2;

    @Column(name = "V_VOUCHER_NO", length = 250)
    private Long voucherNo;

    @Column(name = "GROSS_TOTAL", length = 250)
    private Long grossTotal;

    @Column(name = "EL_MONTH", length = 250)
    private String elMonth;

    @Column(name = "NO_OF_DAYS", length = 250)
    private String noOfDays;

    @Column(name = "ORIGINAL_BASICPAY", length = 250)
    private Long originalBasicPay;

    @Column(name = "ORGINAL_CCA", length = 250)
    private Long originalCca;

    @Column(name = "ORGINAL_DA", length = 250)
    private Long originalDa;

    @Column(name = "ORGINAL_HRA", length = 250)
    private Long originalHra;

    @Column(name = "ORGINAL_SPECIALPAY", length = 250)
    private Long originalSpecialPay;

    @Column(name = "EL_BASICPAY", length = 250)
    private Double elBasicPay;

    @Column(name = "EL_SPECIALPAY", length = 250)
    private Double elSpecialPay;

    @Column(name = "EL_DA", length = 250)
    private Double elDa;

    @Column(name = "EL_HRA", length = 250)
    private Double elHra;

    @Column(name = "EL_CCA", length = 250)
    private Double elCca;

    @Column(name = "JANUARY", length = 250)
    private String january;

    @Column(name = "FEBRUARY", length = 250)
    private String february;

    @Column(name = "MARCH", length = 250)
    private String march;

    @Column(name = "APRIL", length = 250)
    private String april;

    @Column(name = "MAY", length = 250)
    private String may;

    @Column(name = "JUNE", length = 250)
    private String june;

    @Column(name = "JULY", length = 250)
    private String july;

    @Column(name = "AUGUST", length = 250)
    private String august;

    @Column(name = "SEPTEMBER", length = 250)
    private String september;

    @Column(name = "OCTOBER", length = 250)
    private String october;

    @Column(name = "NOVEMBER", length = 250)
    private String november;

    @Column(name = "DECEMBER", length = 250)
    private String december;

    @Column(name = "JANUARY_DIFF", length = 250)
    private String januaryDiff;

    @Column(name = "FEBRUARY_DIFF", length = 250)
    private String februaryDiff;

    @Column(name = "MARCH_DIFF", length = 250)
    private String marchDiff;

    @Column(name = "APRIL_DIFF", length = 250)
    private String aprilDiff;

    @Column(name = "MAY_DIFF", length = 250)
    private String mayDiff;

    @Column(name = "JUNE_DIFF", length = 250)
    private String juneDiff;

    @Column(name = "JULY_DIFF", length = 250)
    private String julyDiff;

    @Column(name = "AUGUST_DIFF", length = 250)
    private String augustDiff;

    @Column(name = "SEPTEMBER_DIFF", length = 250)
    private String septemberDiff;

    @Column(name = "OCTOBER_DIFF", length = 250)
    private String octoberDiff;

    @Column(name = "NOVEMBER_DIFF", length = 250)
    private String novemberDiff;

    @Column(name = "DECEMBER_DIFF", length = 250)
    private String decemberDiff;

    @Column(name = "netTotal", length = 250)
    private Long netTotal;

    @Column(name = "misc1Total", length = 250)
    private Long misc1Total;
    @Column(name = "misc2Total", length = 250)
    private Long misc2Total;
    @Column(name = "payTotal", length = 250)
    private Long payTotal;
    @Column(name = "educationTotal", length = 250)
    private Long educationTotal;
    @Column(name = "marraigeTotal", length = 250)
    private Long marraigeTotal;
    @Column(name = "conveyanceTotal", length = 250)
    private Long conveyanceTotal;
    @Column(name = "festivalTotal", length = 250)
    private Long festivalTotal;
    @Column(name = "rentTotal", length = 250)
    private Long rentTotal;
    @Column(name = "incomeTaxTotal", length = 250)
    private Long incomeTaxTotal;
    @Column(name = "cpsTotal", length = 250)
    private Long cpsTotal;
    @Column(name = "hbaTotal", length = 250)
    private Long hbaTotal;
    @Column(name = "gpfTotal", length = 250)
    private Long gpfTotal;
    @Column(name = "oneDayRecoveryTotal", length = 250)
    private Long oneDayRecoveryTotal;
    @Column(name = "V_LASTMONTH_BALANCEAMOUNT", length = 25)
    private String LastmonthBalanceAmount;
    private String date;
    @Column(name = "NUMBER_OF_WORKINGDAYS", length = 250)
    private Long numberOfWorkingDays;

    @Column(name = "misc1Recovered", length = 250)
    private BigDecimal misc1Recovered;
    @Column(name = "misc2Recovered", length = 250)
    private BigDecimal misc2Recovered;
    @Column(name = "payRecovered", length = 250)
    private BigDecimal payRecovered;
    @Column(name = "educationRecovered", length = 250)
    private BigDecimal educationRecovered;
    @Column(name = "marraigeRecoverd", length = 250)
    private BigDecimal marraigeRecoverd;
    @Column(name = "conveyanceRecovered", length = 250)
    private BigDecimal conveyanceRecovered;
    @Column(name = "festivalRecovered", length = 250)
    private BigDecimal festivalRecovered;

    @Column(name = "daArrear")
    private Long daArrear;

    @Column(name = "hraArrear")
    private Long hraArrear;

    @Column(name = "ccaArrear")
    private Long ccaArrear;

    private Long toBemisc1;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_salary_id")
    private MonthlySalary monthlySalary;



}