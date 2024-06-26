package org.example.dataDto;

import java.time.LocalDate;

public class EmployeeMonthlySalaryDto {
    private String employeeId;
    private Long netPay;


    private Long monthlySalaryId;
    private Long voucherNo;
    private Long totalEarnings;
    private Long totalDeductions;


    private String alreadyBasicPay;
    private Long cps;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Long cpsArrear;
    private Long gpfSub;
    private Long gpfArrear;
    private Long alreadyPersonalPay;
    private Long alreadyHraArrear;
    private Long alreadyCcaArrear;
    private Long alreadySpecialPay;
    private Long alreadyMisc1;
    private Long alreadyDaArrear;
    private String dateOfFA;
    public EmployeeMonthlySalaryDto(String employeeId, Long netPay, Long monthlySalaryId, Long voucherNo,
                                    Long totalEarnings, Long totalDeductions, String dateOfFA, Long cps, Long cpsArrear,
                                    Long gpfSub, Long gpfArrear, Long alreadyPersonalPay, Long alreadyHraArrear, Long alreadyCcaArrear,
                                    Long alreadySpecialPay, Long alreadyMisc1, Long alreadyDaArrear, String alreadyBasicPay, LocalDate fromDate, LocalDate toDate) {
        this.employeeId = employeeId;
        this.netPay = netPay;
        this.monthlySalaryId = monthlySalaryId;
        this.voucherNo = voucherNo;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.cps = cps;
        this.cpsArrear = cpsArrear;
        this.gpfSub = gpfSub;
        this.gpfArrear = gpfArrear;
        this.alreadyPersonalPay = alreadyPersonalPay;
        this.alreadyHraArrear = alreadyHraArrear;
        this.alreadyCcaArrear = alreadyCcaArrear;
        this.alreadySpecialPay = alreadySpecialPay;
        this.alreadyMisc1 = alreadyMisc1;
        this.alreadyDaArrear = alreadyDaArrear;
        this.dateOfFA = dateOfFA;
        this.alreadyBasicPay = alreadyBasicPay;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getAlreadyDaArrear() {
        return alreadyDaArrear;
    }

    public void setAlreadyDaArrear(Long alreadyDaArrear) {
        this.alreadyDaArrear = alreadyDaArrear;
    }

    public Long getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(Long totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getNetPay() {
        return netPay;
    }

    public void setNetPay(Long netPay) {
        this.netPay = netPay;
    }

    public Long getMonthlySalaryId() {
        return monthlySalaryId;
    }

    public void setMonthlySalaryId(Long monthlySalaryId) {
        this.monthlySalaryId = monthlySalaryId;
    }

    public Long getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Long voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Long getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(Long totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public Long getCps() {
        return cps;
    }

    public void setCps(Long cps) {
        this.cps = cps;
    }

    public Long getCpsArrear() {
        return cpsArrear;
    }

    public void setCpsArrear(Long cpsArrear) {
        this.cpsArrear = cpsArrear;
    }

    public Long getGpfSub() {
        return gpfSub;
    }

    public void setGpfSub(Long gpfSub) {
        this.gpfSub = gpfSub;
    }

    public Long getGpfArrear() {
        return gpfArrear;
    }

    public void setGpfArrear(Long gpfArrear) {
        this.gpfArrear = gpfArrear;
    }

    public Long getAlreadyPersonalPay() {
        return alreadyPersonalPay;
    }

    public void setAlreadyPersonalPay(Long alreadyPersonalPay) {
        this.alreadyPersonalPay = alreadyPersonalPay;
    }

    public Long getAlreadyHraArrear() {
        return alreadyHraArrear;
    }

    public void setAlreadyHraArrear(Long alreadyHraArrear) {
        this.alreadyHraArrear = alreadyHraArrear;
    }

    public Long getAlreadyCcaArrear() {
        return alreadyCcaArrear;
    }

    public void setAlreadyCcaArrear(Long alreadyCcaArrear) {
        this.alreadyCcaArrear = alreadyCcaArrear;
    }

    public Long getAlreadySpecialPay() {
        return alreadySpecialPay;
    }

    public void setAlreadySpecialPay(Long alreadySpecialPay) {
        this.alreadySpecialPay = alreadySpecialPay;
    }

    public Long getAlreadyMisc1() {
        return alreadyMisc1;
    }

    public void setAlreadyMisc1(Long alreadyMisc1) {
        this.alreadyMisc1 = alreadyMisc1;
    }

    public String getDateOfFA() {
        return dateOfFA;
    }

    public void setDateOfFA(String dateOfFA) {
        this.dateOfFA = dateOfFA;
    }

    public String getAlreadyBasicPay() {
        return alreadyBasicPay;
    }

    public void setAlreadyBasicPay(String alreadyBasicPay) {
        this.alreadyBasicPay = alreadyBasicPay;
    }

   }
