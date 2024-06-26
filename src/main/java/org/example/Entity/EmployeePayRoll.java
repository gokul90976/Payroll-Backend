package org.example.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.apache.xpath.objects.XString;


@Entity
@Data
@Table(name = "employee_payroll")
public class EmployeePayRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_EMPLOYEE_ID", length = 25)
    private String employeeId;
    @Column(name = "V_EMPLOYEE_NAME", length = 100)
    private String employeeName;


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

    @Column(name = "RENT_OPTION")
    private String rentOptions;

    @Column(name = "v_PF_CPS")
    private String pfcps;


    //  EARNINGS

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


    //  DEDUCTIONS

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

    private String type;

    private String paymentStatus;

    private String numberOfWorkingDays;

    private Long vpfInp;

    private String paymentType;
    private String Date;

}