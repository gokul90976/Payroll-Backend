package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PersonalData")
@Data
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long PersonalId;

    @Column(name = "V_EMPLOYEE_ID")
    private String employeeId;
    @Column(name = "V_EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "V_OFFICE_CODE")
    private String officeCode;
    @Column(name = "V_OFFICE_NAME")
    private String officeName;

    @Column(name = "V_DESIGNATION_CODE")
    private String designationCode;
    @Column(name = "V_DESIGNATION_NAME")
    private String designationName;

    @Column(name = "V_PAN_NO")
    private String panNo;
    @Column(name = "V_AADHAR_NO")
    private String aadharNo;

    @Column(name = "N_MOBILE_NO")
    private String mobileNo;

    @Column(name = "v_email_id")
    private String emailId;

    @Column(name = "V_DIFFERENTLY_ABLED")
    private String differentlyAbled;

    @Column(name = "V_Date_Of_Birth")
//    @Temporal(TemporalType.DATE)
    private String dateOfBirth;
    @Column(name = "V_DATE_OF_JOINING_SERVICE")
    private String dateOfJoiningService;

    @Column(name = "V_LEVEL_AS_PER_PAY_MATRIX")
    private String levelAsPerPayMatrix;
    @Column(name = "N_BASIC_PAY")
    private String basicPay;

    @Column(name = "V_LEVEL_AS_PER_CELL_MATRIX")
    private String levelAsPerCellMatrix;
    @Column(name = "V_SCALE_OF_PAY")
    private String scaleOfPay;

    @Column(name = "V_INCREMENT_DUE_DATE")
    private String incrementDueDate;

    @Column(name = "V_DATE_OF_RETIREMENT")
    private String dateOfRetirement;

    @Column(name = "V_TRANSFER_OFFICE_CODE")
    private String transferOfficeCode;

    @Column(name = "V_TRANSFER_OFFICE_NAME")
    private String transferOfficeName;

    @Column(name = "V_DATE_OF_JOINING_TRANSFER")
    private String dateOfJoiningTransfer;

    @Column(name = "N_CONVEYANCE_ALLOWANCE")
    private String conveyanceAllowance;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "TOTAL_WORKING_DAYS")
    private String totalWorkingDays;
//
//    @Column(name = "N_RENT")
//    private String rent;
////    @Column(name = "V_CONCESSIONAL_VALUE")
////    private String concessionalValue;
////    @Column(name = "V_NOTIONAL_VALUE")
////    private String notionalValue;
//
//    @Column(name = "V_BANK_NAME", length = 100)
//    private String bankName;
//    @Column(name = "V_BANK_BRANCH_NAME", length = 100)
//    private String bankBranchName;
//    @Column(name = "V_BANK_AC_NO", length = 50)
//    private Long bankAcNo;
//    @Column(name = "V_BANK_IFSC", length = 50)
//    private String bankIFSC;
//
//    @Column(name = "V_PAY_STATUS")
//    private String payStatus;
//    @Column(name = "v_PF_CPS")
//    private String pfcps;

//    @Column(name = "N_HRA_GRADE", length = 20)
//    private Long hraGrade;
//    @Column(name = "N_CCA_GRADE", length = 20)
//    private Long ccaGrade;
//    @Column(name = "N_PF_PERCENTAGE", length = 20)
//    private Long pfPercentage;
//    @Column(name = "N_CPS_PERCENTAGE", length = 20)
//    private Long cpsPercentage;

    //  EARNINGS
//
//    @Column(name = "N_BASIC_PAY_EARNING", length = 20)
//    private String basicPayEarning;
//
//    @Column(name = "N_PERSONAL_PAY", length = 20)
//    private Long personalPay;
//    @Column(name = "N_SPECIAL_PAY", length = 20)
//    private Long specialPay;
//    @Column(name = "N_DA", length = 20)
//    private Long da;
//    @Column(name = "N_HRA", length = 20)
//    private Long hra;
//    @Column(name = "N_HRR", length = 20)
//    private Long hrr;
//    @Column(name = "N_CCA", length = 20)
//    private Long cca;
//
//    @Column(name = "N_MEDICAL_ALLOWANCE", length = 20)
//    private Long medicalAllowance;
//    @Column(name = "N_FTA", length = 20)
//    private Long fta;
//
//    @Column(name = "N_HILL_ALLOWANCE", length = 20)
//    private Long hillAllowance;
//
//    @Column(name = "N_WINTER_ALLOWANCE", length = 20)
//    private Long winterAllowance;
//
//    @Column(name = "N_WASHING_ALLOWANCE", length = 20)
//    private Long washingAllowance;
//
//    @Column(name = "N_CONVEYANCE_ALLOWANCE_EARNINGS", length = 20)
//    private Long conveyanceAllowanceEarnings;
//    @Column(name = "N_CASH_ALLOWANCE", length = 20)
//    private Long cashAllowance;
//
//    @Column(name = "N_INTERIM_RELIEF", length = 20)
//    private Long interimRelief;
//
//    @Column(name = "N_MISC_1", length = 20)
//    private Long misc1;
//
//    @Column(name = "N_TOTAL_EARNING", length = 50)
//    private Long totalEarning;
//
//    //  DEDUCTIONS
//
//    @Column(name = "N_GPF_SUB", length = 20)
//    private Long gpfSub;
//    @Column(name = "N_VPF", length = 20)
//    private Long vpf;
//    @Column(name = "N_CPS", length = 20)
//    private Long cps;
//    @Column(name = "N_FBF", length = 20)
//    private Long fbf;
//    @Column(name = "N_NHIS", length = 20)
//    private Long nhis;
//    @Column(name = "N_SPECIAL_PF", length = 20)
//    private Long specialPf;
//    @Column(name = "N_HBA", length = 20)
//    private Long hba;
//    @Column(name = "N_HBF", length = 20)
//    private Long hbf;
//    //    @Column(name = "N_CADAP", length = 20)
////    private Long cadap;
//    @Column(name = "N_RENT_DEDUCTIONS", length = 20)
//    private Long rentDeductions;
//    @Column(name = "N_WATER_CHARGES", length = 20)
//    private Long waterCharges;
//    @Column(name = "N_PROFESSIONAL_TAX", length = 20)
//    private Long professionalTax;
//    @Column(name = "N_ONE_DAY_RECOVERY", length = 20)
//    private Long oneDayRecovery;
//    @Column(name = "N_INCOME_TAX", length = 20)
//    private Long incomeTax;
//    @Column(name = "N_INCOME_TAX_CESS", length = 20)
//    private Long incomeTaxCess;
//    @Column(name = "N_EOE", length = 20)
//    private Long eoe;
//    @Column(name = "N_GPF_LOAN", length = 20)
//    private Long gpfLoan;
//    @Column(name = "N_GPF_ARREAR", length = 20)
//    private Long gpfArrear;
//    @Column(name = "N_CPS_ARREAR", length = 20)
//    private Long cpsArrear;
//    @Column(name = "N_FESTIVAL_ADVANCE", length = 20)
//    private Long festivalAdvance;
//    @Column(name = "N_CONVEYANCE_ADVANCE", length = 20)
//    private Long conveyanceAdvance ;
//    @Column(name = "N_EDUCATION_ADVANCE", length = 20)
//    private Long educationAdvance;
//    @Column(name = "N_MARRIAGE_ADVANCE", length = 20)
//    private Long marriageAdvance;
//    @Column(name = "N_PAY_ADVANCE", length = 20)
//    private Long payAdvance;
//    @Column(name = "N_MISC_DEDUCTION_1", length = 20)
//    private Long miscDeduction1;
//    @Column(name = "N_MISC_DEDUCTION_2", length = 20)
//    private Long miscDeduction2;
//
//    @Column(name = "N_TOTAL_DEDUCTIONS", length = 20)
//    private Long totalDeductions;
//    @Column(name = "N_NET_PAY", length = 20)
//    private Long netPay;
//    private String type;


}