package org.example.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
@Table(name = "monthly_salary")
public class MonthlySalary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nId_seq")
    @SequenceGenerator(name = "nId_seq", sequenceName = "nId_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_VOUCHER_NO", length = 250)
    private Long voucherNo;

    @Column(name = "N_TOTAL_EARNING", length = 50)
    private Long totalEarning;

    @Column(name = "N_TOTAL_DEDUCTIONS", length = 20)
    private Long totalDeductions;

    @Column(name = "N_NET_PAY", length = 20)
    private Long netPay;

    @Column(name = "FINACIONAL_YEAR_DATE", length = 20)
    private String finacionalYearDate;

    @Column(name = "REMARKS_FOR_DA", length = 250)
    private String remarksforDA;

    @Column(name = "REMARKS_FOR_AO", length = 250)
    private String remarksforAO;

    @Column(name = "REMARKS_FOR_DCAO", length = 250)
    private String remarksforDCAO;

    @Column(name = "REMARKS_FOR_FA", length = 250)
    private String remarksforFA;


    @Column(name = "SIGNATURE", length = 250)
    private String signature;

    @Column(name = "SIGNATURE_FOR_AO", length = 250)
    private String signatureForAO;

    @Column(name = "SIGNATURE_FOR_DCAO", length = 250)
    private String signatureForDCAO;

    @Column(name = "SIGNATURE_FOR_FA", length = 250)
    private String signatureForFA;


    @Column(name = "DATE", length = 250)
    private String date;

    @Column(name = "DATE_AO", length = 250)
    private String dateOfAO;

    @Column(name = "DATE_DCAO", length = 250)
    private String dateOfDCAO;

    @Column(name = "DATE_FA", length = 250)
    private String dateOfFA;


    @Column(name = "STATUS_DA", length = 20)
    private String statusDA;

    @Column(name = "STATUS_AO", length = 20)
    private String statusAO;

    @Column(name = "STATUS_DCAO", length = 20)
    private String statusDCAO;

    @Column(name = "STATUS_FA", length = 20)
    private String statusFA;

    @Column(name = "DAY", length = 20)
    private String day;

    @Column(name = "MONTH", length = 20)
    private String month;

    @Column(name = "YEAR", length = 20)
    private String year;

    private String paymentType;

    @Column(name = "fromDate")
    private LocalDate from;

    @Column(name = "toDate")
    private LocalDate to;

    @Column(name = "daDiff", length = 250)
    private String daDiff;


    @JsonManagedReference
    @OneToMany(mappedBy = "monthlySalary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MonthlySalaryNewData> employeeTableData;


}