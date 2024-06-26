package org.example.Service;

import org.example.Entity.*;
import org.example.Repo.MiscDeductionRepo;
import org.example.dataDto.EmployeeDataDto;
import org.example.dataDto.EmployeeMonthlySalaryDto;
import org.example.dataDto.EmployeePaySlipDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.example.dataDto.MiscDeductionDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ReportService {


    List<MiscDeductionReport> getAllMiscData();

    List<PayAdvanceReport> getAllPayData();

    List<EducationAdvanceReport> getAllEducationData();

    List<MarriageAdvanceReport> getAllMarriageData();

    List<ConvenyanceAdvanceReport> getAllConveyanceData();

    List<FestivalAdvanceReport> getAllFestivalData();

    List<NhisReport> getAllNhisData();

    List<ProfessionalTaxReport> getAllPrpfessionalData();

    List<IncomeTaxReport> getAllIncomeTaxData();

    List<OneDayRecoveryReport> getAllOneDayRecoveryData();

    List<CpsReport> getAllCpsData();

    List<RentReport> getAllRentData();

    List<FBFReport> getAllFBFData();

    List<SpecialPfReport> getAllSpecialPfData();

    List<GpfReport> getAllGpfData();

    List<HbaReport> getAllHbaData();

    List<MiscDeductionReport2> getAllMisc2Data();


    List<MiscDeductionReport> getMiscDataByEmployeeId(String employeeId);

    List<PayAdvanceReport> getPayDataByEmployeeId(String employeeId);

    List<EducationAdvanceReport> getEducationDataByEmployeeId(String employeeId);

    List<MarriageAdvanceReport> getMarriageDataByEmployeeId(String employeeId);

    List<ConvenyanceAdvanceReport> getConveyanceDataByEmployeeId(String employeeId);

    List<FestivalAdvanceReport> getFestivalDataByEmployeeId(String employeeId);

    List<NhisReport> getNhisDataByEmployeeId(String employeeId);

    List<ProfessionalTaxReport> getPrpfessionalDataByEmployeeId(String employeeId);

    List<IncomeTaxReport> getIncomeTaxDataByEmployeeId(String employeeId);

    List<OneDayRecoveryReport> getOneDayRecoveryDataByEmployeeId(String employeeId);

    List<CpsReport> getCpsDataByEmployeeId(String employeeId);

    List<RentReport> getRentDataByEmployeeId(String employeeId);

    List<FBFReport> getFBFDataByEmployeeId(String employeeId);

    List<SpecialPfReport> getSpecialPfDataByEmployeeId(String employeeId);

    List<GpfReport> getGpfDataByEmployeeId(String employeeId);

    List<HbaReport> getHbaDataByEmployeeId(String employeeId);

    List<MiscDeductionReport2> getMisc2DataByEmployeeId(String employeeId);

    List<MiscDeductionReport> getAllMiscData(LocalDate fromDate, LocalDate toDate);

    List<PayAdvanceReport> getAllPayData(LocalDate fromDate, LocalDate toDate);

    List<EducationAdvanceReport> getAllEducationData(LocalDate fromDate, LocalDate toDate);

    List<MarriageAdvanceReport> getAllMarriageData(LocalDate fromDate, LocalDate toDate);

    List<ConvenyanceAdvanceReport> getAllConveyanceData(LocalDate fromDate, LocalDate toDate);

    List<FestivalAdvanceReport> getAllFestivalData(LocalDate fromDate, LocalDate toDate);

    List<NhisReport> getAllNhisData(LocalDate fromDate, LocalDate toDate);

    List<ProfessionalTaxReport> getAllProfessionalData(LocalDate fromDate, LocalDate toDate);

    List<IncomeTaxReport> getAllIncomeTaxData(LocalDate fromDate, LocalDate toDate);

    List<OneDayRecoveryReport> getAllOneDayRecoveryData(LocalDate fromDate, LocalDate toDate);

    List<CpsReport> getAllCpsData(LocalDate fromDate, LocalDate toDate);

    List<RentReport> getAllRentData(LocalDate fromDate, LocalDate toDate);

    List<FBFReport> getAllFBFData(LocalDate fromDate, LocalDate toDate);

    List<SpecialPfReport> getAllSpecialPfData(LocalDate fromDate, LocalDate toDate);

    List<GpfReport> getAllGpfData(LocalDate fromDate, LocalDate toDate);

    List<HbaReport> getAllHbaData(LocalDate fromDate, LocalDate toDate);

    List<MiscDeductionReport2> getAllMisc2Data(LocalDate fromDate, LocalDate toDate);

    List<EmployeeMonthlySalaryDto> getEmployeeIdAndMonthlySalary(String employeeId, LocalDate fromDate, LocalDate toDate);

    List<EmployeeMonthlySalaryDto> getEmployeeIdAndMonthlySalaryDashboard(LocalDate fromDate, LocalDate toDate);

    List<EmployeePaySlipDto> getPaySlip(String employeeId, int month, int year);


    List<MonthlySalaryNewData> getAggregatedMonthlySalaries();

    List<String> getEmployeeId();



    List<MonthlySalaryNewData> getAggregatedMonthlySalaries(LocalDate fromDate, LocalDate toDate);

    List<PayArrear> getPayArrearsWithDateOfFA(String employeeId, int month, int year);

//    Map<String, Object> getPayArrearsWithDateOfFA(List<String> employeeIds, LocalDate startDate, LocalDate endDate);


//    Page<MonthlySalaryNewData> getAggregatedMonthlySalaries(LocalDate fromDate, LocalDate toDate, Pageable pageable);
}