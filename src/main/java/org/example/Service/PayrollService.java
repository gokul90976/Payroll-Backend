package org.example.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.example.DTO.MonthlysalaryData;
import org.example.Entity.*;
import org.example.Model.EmployeeIdFilter;
import org.example.dataDto.DaEmployeeDto;
import org.example.dataDto.EmployeeDataDto;
import org.example.dataDto.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PayrollService {
    EmployeePayRoll saveEmployeePayRoll(EmployeePayRoll employeePayRoll);

    EmployeePayRoll getEmployeePayRollByEmployeeId(String empId);

    EmployeePayRoll getEmployeePayRollBynId(Long nId);

    List<EmployeePayRoll> getAllEmployeePayRoll();

    EmployeePayRoll deleteEmployeePayRoll(Long id);

//    List<Map<String, Object>> getEmployeeDetails(String empId);


//   String checkRecoveryDataByEmployeeId(String employeeId);


    RecoveryData getRecoveryDataById(Long id);

    List<RecoveryData> getAllRecoverysData();

//    RecoveryData updateRecoveryDataAndAdd(RecoveryData recovery) throws NotFoundException;

    void deleteRecoveryDataAndAddById(Long id);

    void deleteRecoveryDataAddById(Long id);


//    void deleteRecoveryDataAndAddById(Long id);
//
//    void deleteRecoveryIndData(Long id);


    ProfessionalTax saveProfessionalTax(ProfessionalTax taxCalculation);

    List<ProfessionalTax> getAllProfessionalTax();

    ProfessionalTax updateProfessionalTaxById(ProfessionalTax tax);

    void deleteProfessionalTaxById(Long id);

    ProfessionalTax getByIdProfessionalTax(Long id);

    IncomeTax saveIncomeTax(IncomeTax taxCalculation);

    List<IncomeTax> getAllIncomeTax();

    IncomeTax updatedIncomeTaxById(IncomeTax tax);

    void deleteIncomeTaxById(Long id);


    DaTax saveDaTax(DaTax taxCalculation);

    List<DaTax> getAllDaTax();

    DaTax updateDaTax(DaTax tax);

    void deleteDaTaxById(Long id);

//    CommonFields saveCommon(CommonFields common);


    MonthlySalary saveMonthlySalary(MonthlySalary monthlySalary);

    //  List<MonthlySalary> getAllMonthlySalary(String loggedInBy);

    MonthlySalary getMonthlySalaryById(Long id);

    MonthlySalary deleteMonthlySalaryById(Long id);


    // Employee salary hierarchy get by role
    //  EmployeeSalaryHierarechy getAllEmployeeSalaryByRole(String role);

    // save salary details hieraechy
    // EmployeeSalaryHierarechy saveSalaryDetailsHierarechy(EmployeeSalaryHierarechy savEmployeeSalaryHierarechy);


    //Percentage % -------------------------------------------------------------------------
    Percentage savePercentage(Percentage percentage);

    Percentage getPercentageById(Long id);

    Percentage updatePercentage(Percentage existingPercentage);

    DaTax getDaById(Long id);

    IncomeTax getIncomeTaxById(Long id);

    RecoveryData saveOrUpdateRecoveryDataAndAdd(RecoveryData recovery);

    EmployeeIdFilter[] getAllEmpId();

    List<MonthlySalary> getAllMonthlySalary();

    MonthlySalary updateMonthlySalary(MonthlySalary monthlySalary);

    List<MonthlySalaryNewData> saveMonthlySalaryNewData(List<MonthlySalaryNewData> monthlySalaryNewData);

    List<MonthlySalary> getMonthlySalaryNewDataById(Long voucherNo);

    List<MonthlySalary> getMonthlySalaryVoucherNo(Long voucher);


    Hra saveHra(Hra hra);

    Page<Hra> getAllHra(Pageable pageable);

    Hra getHraById(Long Hraid);

    Hra updateHra(Hra existingHra);

    void deleteHraById(Long id);

    List<Hra> getAllHraData();

    Long findGradeValue(Long range, String officeCode);

    Cca saveCca(Cca cca);

    Cca getCcaById(Long ccaid);

    List<Cca> getAllCcaData();

    void deleteCcaById(Long id);

    Long findCCAValue(Long range, String officeCode);

    Long findDaPercentage(LocalDate currentDateParsed);

    MonthlySalaryNewData getMonthlySalaryNewById(Long id);

    Map<String, Long> getRecoveryTypesByEmployeeId(String employeeId);

    List<PayArrear> savePayArrears(PayArrear[] payArrear);

    List<PayArrear> getPayArrearData(List<String> employeeIds, Long voucherNo);

    List<PayArrear> getAllPayArrearData();

    void deletePayArrearById(Long id);

    List<EmployeeDataDto> getEmployeeData(List<String> employeeIds);

    Long findDaPercentageInRange(LocalDate fromDateParsed, LocalDate toDateParsed);

    List<DaArrear> saveDaArrears(DaArrear[] daArrear);

    List<DaArrear> getDaArrearData(List<String> employeeIds, Long voucherNo);

    List<DaArrear> getAllDaArrearData();

    void deleteDaArrearById(Long id);

    List<DaEmployeeDto> getDaEmployeeData(List<String> employeeIds);

    List<PersonalData> savePersonalData(PersonalData[] personalData);

    // PersonalData getPersonalData(String employeeId);

    List<PersonalData> getAllPersonalData();

    PersonalData getPersonalByEmployeeId(String empId);

    void deleteAllPersonalData();

    TemporaryEmployeePayroll saveTemporaryEmployeePayRoll(TemporaryEmployeePayroll temporaryEmployeePayroll);

    TemporaryEmployeePayroll getTemporaryEmployeePayRollById(Long nId);

    List<TemporaryEmployeePayroll> getAllTemporaryEmployeePayRoll();

// Concentional saveConcentional(Concentional concentional);

    Concessional getConcentionalById(Long concentionalId);

    List<Concessional> getAllConcessData();

    void deleteConcessById(Long concessionalId);

    Concessional saveConcessional(Concessional concessional);

    Double getConcessionValue(Double range, String officeCode);

    Long getProfessionalTaxAmount(LocalDate date);

    List<EmployeeDetails> getDamonthdata(LocalDate from, LocalDate to);

    List<MonthlySalary> getMonthlySalaryList();

    List<MonthlySalaryNewData> getMonthlySalaryNewDataList();

    List<Map<String, Object>> filterAndGroupEmployeeDetails(List<MonthlySalaryNewData> monthlySalaryNewDataList, List<MonthlySalary> monthlySalaryList, LocalDate from, LocalDate to, DateTimeFormatter formatter, Long daDiff);

    List<TemporaryEmployeePayroll> getEmployeePayRollsByStatus(String status);


    List<MonthlySalaryNewData> saveMonthlySalaryId(MonthlysalaryData monthlysalaryData);


// EmployeeData saveEmployeeData(EmployeeData employeeData);
//
// EmployeeDataDTOS processEmployeeData(EmployeeDataDTOS employeeDataDTO);


//    ResponseEntity<Object> updateRecoveryDataAdd(RecoveryDataAdd recoveryDataAdd);
}

