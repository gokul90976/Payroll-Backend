package org.example.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_SALARY_HIERARECHY")
public class EmployeeSalaryHierarechy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_REMARKS", length = 250)
    private String remarks;

    @Column(name = "V_SIGNATURE", length = 250)
    private String signature;

    @Column(name = "V_DATE")
    private String date;

    // it should be null if role is other than Assistant
    @Column(name = "V_SUBMITTED_BY_ASSISTANT", length = 250)
    private String submittedByAssistant;

    // only for DCAO Tab -   // these ALL should be null if role is other than DCAo


    @Column(name = "V_DCAO_REMARKS", length = 250)
    private String dcaoRemarks;

    @Column(name = "V_DCAO_BANK_CODE", length = 250)
    private String dcaoBankCode;

    @Column(name = "V_DCAO_SIGNATURE", length = 250)
    private String dcaoSignature;

    @Column(name = "D_DCAO_DATE")
    private LocalDate dcaoDate;

    // APPROVED BY AND REJECTED BY COMMON FOR ALL EXCEPT ASSISTANT TAB

    @Column(name = "V_APPROVED_BY", length = 250)
    private String approvedBy;

    @Column(name = "V_REJECTED_BY", length = 250)
    private String rejectedBy;


    // ONLY FOR FINAL DCAO BUTTON
    @Column(name = "V_JVL", length = 250)
    private String jvlButton;


    // COMMON FOR ALL

    @Column(name = "V_ROLE", length = 250)
    private String role;

    //  @Transient
    // List<MonthlySalary> monthlySalaryTable;

    // Voucher No
    @Column(name = "V_VOUCHER_NO", length = 250)
    private String voucherNo;

    @Column(name = "V_VOUCHER_UPATED_DATE", length = 250)
    private String voucherUpdatedDate;

    @Column(name = "v_logged_in_by")
    private String loggedInBy;

    private String Date;
}
