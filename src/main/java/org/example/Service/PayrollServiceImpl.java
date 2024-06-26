package org.example.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.example.DTO.MonthlysalaryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.Entity.*;


import org.example.Model.EmployeeIdFilter;
import org.example.Repo.*;

import org.example.dataDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayrollServiceImpl implements PayrollService {

    private static final Logger log = LoggerFactory.getLogger(PayrollServiceImpl.class);
    @Autowired
    EmployeeSalaryHierarchyRepo employeeSalaryHierarchyRepo;
    private EmployeePayRollRepo employeePayRollRepo;
    private RecoveryDataRepo recoveryDataRepo;
    private RecoveryDataAddRepo recoveryDataAddRepo;
    private ProfessionalTaxRepo professionalTaxRepo;
    private IncomeTaxRepo incomeTaxRepo;
    private DaTaxRepo daTaxRepo;
    private MonthlySalaryRepo monthlySalaryRepo;
    private PercentageRepo percentageRepo;
    private MonthlySalaryNewRepo monthlySalaryNewRepo;
    private HraRepo hraRepo;
    private CcaRepo ccaRepo;
    private PayArrearRepo payArrearRepo;
    private DaArrearRepo daArrearRepo;
    private PersonalDataRepo personalDataRepo;
    private TemporaryEmployeeRepo temporaryEmployeeRepo;
    private ConcentionalRepo concentionalRepo;
    private MiscDeductionRepo miscDeductionRepo;
    private PayAdvanceRepo payAdvanceRepo;
    private EducationAdvanceRepo educationAdvanceRepo;
    private MarriageAdvanceRepo marriageAdvanceRepo;
    private ConvenyanceAdvanceRepo convenyanceAdvanceRepo;
    private FestivalAdvanceRepo festivalAdvanceRepo;
    private NhisRepo nhisRepo;
    private ProfessionalTaxReportRepo professionalTaxReportRepo;
    private IncomeTaxReportRepo incomeTaxReportRepo;
    private OneDayRecoveryRepo oneDayRecoveryRepo;
    private CpsRepo cpsRepo;
    private RentRepo rentRepo;
    private FbfRepo fbfRepo;
    private SpecialPfRepo specialPfRepo;
    private GpfRepo gpfRepo;
    private HbaRepo hbaRepo;
    private MiseDeduction2Repo miseDeduction2Repo;

    @Autowired
    public void PayrollService(EmployeePayRollRepo employeePayRollRepo,
                               RecoveryDataRepo recoveryDataRepo,
                               RecoveryDataAddRepo recoveryDataAddRepo,
                               ProfessionalTaxRepo professionalTaxRepo,
                               IncomeTaxRepo incomeTaxRepo,
                               DaTaxRepo daTaxRepo,
                               MonthlySalaryRepo monthlySalaryRepo,
                               PercentageRepo percentageRepo, MonthlySalaryNewRepo monthlySalaryNewRepo, HraRepo hraRepo, CcaRepo ccaRepo,
                               PayArrearRepo payArrearRepo, DaArrearRepo daArrearRepo, PersonalDataRepo personalDataRepo, TemporaryEmployeeRepo temporaryEmployeeRepo,
                               ConcentionalRepo concentionalRepo, MiscDeductionRepo miscDeductionRepo,
                               PayAdvanceRepo payAdvanceRepo, EducationAdvanceRepo educationAdvanceRepo, MarriageAdvanceRepo marriageAdvanceRepo,
                               ConvenyanceAdvanceRepo convenyanceAdvanceRepo, FestivalAdvanceRepo festivalAdvanceRepo, NhisRepo nhisRepo,
                               ProfessionalTaxReportRepo professionalTaxReportRepo, RentRepo rentRepo, FbfRepo fbfRepo, IncomeTaxReportRepo incomeTaxReportRepo,
                               CpsRepo cpsRepo, HbaRepo hbaRepo, SpecialPfRepo specialPfRepo, GpfRepo gpfRepo, OneDayRecoveryRepo oneDayRecoveryRepo,
                               MiseDeduction2Repo miseDeduction2Repo) {
        this.employeePayRollRepo = employeePayRollRepo;
        this.recoveryDataRepo = recoveryDataRepo;
        this.recoveryDataAddRepo = recoveryDataAddRepo;
        this.professionalTaxRepo = professionalTaxRepo;
        this.incomeTaxRepo = incomeTaxRepo;
        this.daTaxRepo = daTaxRepo;
        this.monthlySalaryRepo = monthlySalaryRepo;
        this.percentageRepo = percentageRepo;
        this.monthlySalaryNewRepo = monthlySalaryNewRepo;
        this.hraRepo = hraRepo;
        this.ccaRepo = ccaRepo;
        this.payArrearRepo = payArrearRepo;
        this.daArrearRepo = daArrearRepo;
        this.personalDataRepo = personalDataRepo;
        this.temporaryEmployeeRepo = temporaryEmployeeRepo;
        this.concentionalRepo = concentionalRepo;
        this.miscDeductionRepo = miscDeductionRepo;
        this.payAdvanceRepo = payAdvanceRepo;
        this.educationAdvanceRepo = educationAdvanceRepo;
        this.marriageAdvanceRepo = marriageAdvanceRepo;
        this.convenyanceAdvanceRepo = convenyanceAdvanceRepo;
        this.festivalAdvanceRepo = festivalAdvanceRepo;
        this.nhisRepo = nhisRepo;
        this.professionalTaxReportRepo = professionalTaxReportRepo;
        this.rentRepo = rentRepo;
        this.fbfRepo = fbfRepo;
        this.incomeTaxReportRepo = incomeTaxReportRepo;
        this.cpsRepo = cpsRepo;
        this.hbaRepo = hbaRepo;
        this.specialPfRepo = specialPfRepo;
        this.gpfRepo = gpfRepo;
        this.oneDayRecoveryRepo = oneDayRecoveryRepo;
        this.miseDeduction2Repo = miseDeduction2Repo;


    }

    @Override
    @Transactional
    public EmployeePayRoll saveEmployeePayRoll(EmployeePayRoll employeePayRoll) {

        EmployeePayRoll savedData = employeePayRollRepo.save(employeePayRoll);
        return savedData;
    }

    @Override
    public EmployeePayRoll getEmployeePayRollByEmployeeId(String empId) {
        EmployeePayRoll responseData = employeePayRollRepo.findByEmployeeId(empId);
        return responseData;
    }

    @Override
    public EmployeePayRoll getEmployeePayRollBynId(Long nId) {
        return employeePayRollRepo.findById(nId).get();
    }

    @Override
    public List<EmployeePayRoll> getAllEmployeePayRoll() {

        List<EmployeePayRoll> responseData = employeePayRollRepo.findAll();
        return responseData;
    }

    @Override
    @Transactional
    public EmployeePayRoll deleteEmployeePayRoll(Long id) {
        employeePayRollRepo.deleteById(id);
        return null;
    }


    @Override
    public RecoveryData getRecoveryDataById(Long id) {
        // TODO Auto-generated method stub
        RecoveryData recoveryData = recoveryDataRepo.findById(id).get();

        return recoveryData;
    }


    @Override
    public List<RecoveryData> getAllRecoverysData() {
        // TODO Auto-generated method stub
        return recoveryDataRepo.findAll();
    }


    @Override
    public void deleteRecoveryDataAndAddById(Long id) {
        // TODO Auto-generated method stub

        recoveryDataRepo.deleteById(id);
    }


    @Override
    public void deleteRecoveryDataAddById(Long id) {
        // TODO Auto-generated method stub
        recoveryDataAddRepo.deleteById(id);

    }


    //professionalTax---------------

    @Override
    public ProfessionalTax saveProfessionalTax(ProfessionalTax taxCalculation) {
        return professionalTaxRepo.save(taxCalculation);
    }

    @Override
    public List<ProfessionalTax> getAllProfessionalTax() {
        return professionalTaxRepo.findAll();
    }

    @Override
    public ProfessionalTax updateProfessionalTaxById(ProfessionalTax tax) {


        if (tax.getId() != null) {
            return professionalTaxRepo.save(tax);

        } else {

        }
        return null;
    }


    @Override
    public void deleteProfessionalTaxById(Long id) {
        professionalTaxRepo.deleteById(id);
    }

    @Override
    public ProfessionalTax getByIdProfessionalTax(Long id) {
        Optional<ProfessionalTax> findById = professionalTaxRepo.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            return null;
        }

    }


    // IncomeTax ---------------------
    @Override
    public IncomeTax saveIncomeTax(IncomeTax taxCalculation) {
        return incomeTaxRepo.save(taxCalculation);
    }

    @Override
    public List<IncomeTax> getAllIncomeTax() {
        return incomeTaxRepo.findAll();
    }

    @Override
    public IncomeTax updatedIncomeTaxById(IncomeTax tax) {

        if (tax.getId() != null) {
            return incomeTaxRepo.save(tax);
        } else {

        }
        return null;
    }

    @Override
    public void deleteIncomeTaxById(Long id) {
        incomeTaxRepo.deleteById(id);
    }


    // DaTax ---------------------
    @Override
    public DaTax saveDaTax(DaTax taxCalculation) {
        return daTaxRepo.save(taxCalculation);
    }

    @Override
    public List<DaTax> getAllDaTax() {
        return daTaxRepo.findAll();
    }

    @Override
    public DaTax updateDaTax(DaTax tax) {
        if (tax.getId() != null) {
            return daTaxRepo.save(tax);
        } else {

        }
        return null;

    }

    @Override
    public void deleteDaTaxById(Long id) {
        daTaxRepo.deleteById(id);
    }


//TODO BY GOKUL


//    @Override
//    @Transactional
//    public MonthlySalary saveMonthlySalary(MonthlySalary monthlySalary) {
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String formattedDate = currentDate.format(formatter);
//
//        monthlySalary.setDateOfAO(formattedDate);
//        monthlySalary.setDateOfDCAO(formattedDate);
//        monthlySalary.setDateOfFA(formattedDate);
//
//        if ("Approved".equals(monthlySalary.getStatusFA())) {
//            // Initialize lazy association
//            int a = monthlySalary.getEmployeeTableData().size();
//            System.out.println("count:" + a);
//
//
//            for (MonthlySalaryNewData monthlySalaryNewData : monthlySalary.getEmployeeTableData()) {
//                String employeeId = monthlySalaryNewData.getEmployeeId();
//                List<RecoveryData> recoveryDataList = recoveryDataRepo.findByEmployeeId(employeeId);
//
//                for (RecoveryData recoveryData : recoveryDataList) {
//                    for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
//
//
//                        BigDecimal recovered = recoveryDataAdd.getRecoverd();
//                        Long perMonthDemand = recoveryDataAdd.getPerMonthDemand();
//                        Long regularMonth = recoveryDataAdd.getRegularMonthDemand();
//                        Long lastMonth = recoveryDataAdd.getLastMonthDemand();
//                        LocalDate date = recoveryDataAdd.getDate();
//                        Long TotalMonth = recoveryDataAdd.getNoOfMonths();
//                        if (date==LocalDate.now()) {
//                            recovered = recovered.add(BigDecimal.valueOf(perMonthDemand));
//                        } else if(date!=LocalDate.now()&& TotalMonth ==1) {
//                            recovered = recovered.add(BigDecimal.valueOf(lastMonth));
//                        } else {
//                            recovered = recovered.add(BigDecimal.valueOf(regularMonth));
//
//                        }
//                        BigDecimal totalDemand = BigDecimal.valueOf(recoveryDataAdd.getTotalDemand());
//                        BigDecimal remainingBalance = totalDemand.subtract(recovered);
//                        recoveryDataAdd.setRecoverd(recovered);
//                        Long noOfMonth = recoveryDataAdd.getNoOfMonths()-1;
//                        recoveryDataAdd.setNoOfMonths(noOfMonth);
//
//
//                        recoveryDataAdd.setBalanceAmount(remainingBalance);
//                        if (remainingBalance.compareTo(BigDecimal.ZERO) == 0) {
//                            recoveryDataAdd.setPerMonthDemand(0L);
//                            recoveryDataAdd.setLastMonthDemand(0L);
//                            recoveryDataAdd.setRegularMonthDemand(0L);
//                        }
//                    }
//                    recoveryDataRepo.save(recoveryData);
//                }
//                BigDecimal NhisValue = BigDecimal.ZERO;
//                BigDecimal miscDeductionAmount = BigDecimal.ZERO;
//                BigDecimal miscDeductionBalance = BigDecimal.ZERO;
//                BigDecimal payAdvanceAmount = BigDecimal.ZERO;
//                BigDecimal payAdvanceBalance = BigDecimal.ZERO;
//                BigDecimal educationAdvanceAmount = BigDecimal.ZERO;
//                BigDecimal educationAdvanceBalance = BigDecimal.ZERO;
//                BigDecimal marriageAdvanceAmount = BigDecimal.ZERO;
//                BigDecimal marriageAdvanceBalance = BigDecimal.ZERO;
//                BigDecimal convenyanceAdvanceAmount = BigDecimal.ZERO;
//                BigDecimal convenyanceAdvanceBalance = BigDecimal.ZERO;
//                BigDecimal festivalAdvanceAmount = BigDecimal.ZERO;
//                BigDecimal festivalAdvanceBalance = BigDecimal.ZERO;
//                BigDecimal professionalTaxAmount = BigDecimal.ZERO;
//                BigDecimal rentAmount = BigDecimal.ZERO;
//                BigDecimal waterCharge = BigDecimal.ZERO;
//                BigDecimal fbfAmount = BigDecimal.ZERO;
//                BigDecimal incomeAmount = BigDecimal.ZERO;
//                BigDecimal incomeCess = BigDecimal.ZERO;
//                BigDecimal totalAmount = BigDecimal.ZERO;
//                BigDecimal cpsAmount = BigDecimal.ZERO;
//                BigDecimal CpsArrearAmount = BigDecimal.ZERO;
//                BigDecimal cpsTotalAmount = BigDecimal.ZERO;
//                BigDecimal hbaAmount = BigDecimal.ZERO;
//                BigDecimal hbfAmount = BigDecimal.ZERO;
//                BigDecimal eoeAoumnt = BigDecimal.ZERO;
//                BigDecimal hbaTotalAmount = BigDecimal.ZERO;
//                BigDecimal specialPfAmount = BigDecimal.ZERO;
//                BigDecimal gpfSubAmount = BigDecimal.ZERO;
//                BigDecimal vpfAmount = BigDecimal.ZERO;
//                BigDecimal gpfLoanAmount = BigDecimal.ZERO;
//                BigDecimal gpfArrearAmount = BigDecimal.ZERO;
//                BigDecimal gpfTotalAmount = BigDecimal.ZERO;
//                BigDecimal deductionAmount = BigDecimal.ZERO;
//
//
//                //// EmployeePayRoll employeePayRoll = employeePayRollRepo.findByEmployeeId(employeeId);
//                if (monthlySalaryNewData.getOneDayRecovery() != null) {
//                    deductionAmount = deductionAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getOneDayRecovery()));
//                }
//                if (monthlySalaryNewData.getGpfSub() != null) {
//                    gpfSubAmount = gpfSubAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfSub()));
//                }
//                if (monthlySalaryNewData.getVpf() != null) {
//                    vpfAmount = vpfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getVpf()));
//                }
//                if (monthlySalaryNewData.getGpfLoan() != null) {
//                    gpfLoanAmount = gpfLoanAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfLoan()));
//                }
//                if (monthlySalaryNewData.getGpfArrear() != null) {
//                    gpfArrearAmount = gpfArrearAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfArrear()));
//                }
//
//                BigDecimal gpfAdd = gpfSubAmount.add(vpfAmount);
//                BigDecimal gpfplus = gpfLoanAmount.add(gpfArrearAmount);
//                gpfTotalAmount = gpfAdd.add(gpfplus);
//                if (monthlySalaryNewData.getSpecialPf() != null) {
//                    specialPfAmount = specialPfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPf()));
//                }
//                if (monthlySalaryNewData.getHba() != null) {
//                    hbaAmount = hbaAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getHba()));
//                }
//                if (monthlySalaryNewData.getHbf() != null) {
//                    hbfAmount = hbfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getHbf()));
//                }
//                if (monthlySalaryNewData.getEoe() != null) {
//                    eoeAoumnt = eoeAoumnt.add(BigDecimal.valueOf(monthlySalaryNewData.getEoe()));
//                }
//                BigDecimal hbaAdd = hbaAmount.add(hbfAmount);
//                hbaTotalAmount = eoeAoumnt.add(hbaAdd);
//                if (monthlySalaryNewData.getCps() != null) {
//                    cpsAmount = cpsAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getCps()));
//                }
//                if (monthlySalaryNewData.getCpsArrear() != null) {
//                    CpsArrearAmount = CpsArrearAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getCpsArrear()));
//                }
//                cpsTotalAmount = cpsAmount.add(CpsArrearAmount);
//                if (monthlySalaryNewData.getIncomeTaxCess() != null) {
//                    incomeCess = incomeCess.add(BigDecimal.valueOf(monthlySalaryNewData.getIncomeTaxCess()));
//                }
//                if (monthlySalaryNewData.getIncomeTax() != null) {
//                    incomeAmount = incomeAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getIncomeTax()));
//                }
//                totalAmount = incomeAmount.add(incomeCess);
//                if (monthlySalaryNewData.getFbf() != null) {
//                    fbfAmount = fbfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getFbf()));
//                }
//                if (monthlySalaryNewData.getNhis() != null) {
//                    NhisValue = NhisValue.add(BigDecimal.valueOf(monthlySalaryNewData.getNhis()));
//                }
//                if (monthlySalaryNewData.getProfessionalTax() != null) {
//                    professionalTaxAmount = professionalTaxAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getProfessionalTax()));
//                }
//                if (monthlySalaryNewData.getRentDeductions() != null) {
//                    rentAmount = rentAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getRentDeductions()));
//                }
//                if (monthlySalaryNewData.getWaterCharges() != null) {
//                    waterCharge = waterCharge.add(BigDecimal.valueOf(monthlySalaryNewData.getWaterCharges()));
//                }
//                if (NhisValue.compareTo(BigDecimal.ZERO) > 0) {
//                    NhisReport nhisReport = new NhisReport();
//                    nhisReport.setEmployeeId(employeeId);
//                    nhisReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    nhisReport.setNhisAmount(NhisValue);
//                    nhisReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    nhisReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    nhisRepo.save(nhisReport);
//                }
//                if (professionalTaxAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    ProfessionalTaxReport professionalTaxReport = new ProfessionalTaxReport();
//                    professionalTaxReport.setEmployeeId(employeeId);
//                    professionalTaxReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    professionalTaxReport.setProfessionalTaxAmount(professionalTaxAmount);
//                    professionalTaxReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    professionalTaxReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    professionalTaxReportRepo.save(professionalTaxReport);
//                }
//                if (rentAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    RentReport rentReport = new RentReport();
//                    rentReport.setEmployeeId(employeeId);
//                    rentReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    rentReport.setRentAmount(rentAmount);
//                    rentReport.setWaterCharge(waterCharge);
//                    rentReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    rentReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    rentRepo.save(rentReport);
//                }
//                if (fbfAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    FBFReport fbfReport = new FBFReport();
//                    fbfReport.setEmployeeId(employeeId);
//                    fbfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    fbfReport.setFbfAmount(fbfAmount);
//                    fbfReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    fbfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    fbfRepo.save(fbfReport);
//                }
//                if (incomeAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    IncomeTaxReport incomeTaxReport = new IncomeTaxReport();
//                    incomeTaxReport.setEmployeeId(employeeId);
//                    incomeTaxReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    incomeTaxReport.setBasicPay(monthlySalaryNewData.getBasicPay());
//                    incomeTaxReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    incomeTaxReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    incomeTaxReport.setPanNo(monthlySalaryNewData.getPanNo());
//                    incomeTaxReport.setGross(monthlySalaryNewData.getTotalEarning());
//                    incomeTaxReport.setIncomeTax(incomeAmount);
//                    incomeTaxReport.setIncomeTaxCess(incomeCess);
//                    incomeTaxReport.setTotalAmount(totalAmount);
//                    incomeTaxReportRepo.save(incomeTaxReport);
//                }
//                if (cpsAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    CpsReport cpsReport = new CpsReport();
//                    cpsReport.setEmployeeId(employeeId);
//                    cpsReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    cpsReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    cpsReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    cpsReport.setBasicPay(monthlySalaryNewData.getBasicPay());
//                    if (monthlySalaryNewData.getPersonalPay() != null) {
//                        cpsReport.setPersonalPay(BigDecimal.valueOf(monthlySalaryNewData.getPersonalPay()));
//                    }
//                    if (monthlySalaryNewData.getSpecialPay() != null) {
//                        cpsReport.setSpecialPay(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPay()));
//                    }
//                    if (monthlySalaryNewData.getDa() != null) {
//                        cpsReport.setDa(BigDecimal.valueOf(monthlySalaryNewData.getDa()));
//                    }
//                    cpsReport.setCpsAmount(cpsAmount);
//                    cpsReport.setCpsArrear(CpsArrearAmount);
//                    cpsReport.setTotalAmount(cpsTotalAmount);
//                    cpsRepo.save(cpsReport);
//                }
//                if (hbaAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    HbaReport hbaReport = new HbaReport();
//                    hbaReport.setEmployeeId(employeeId);
//                    hbaReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    hbaReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    hbaReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    hbaReport.setHba(hbaAmount);
//                    hbaReport.setHbf(hbfAmount);
//                    hbaReport.setEoe(eoeAoumnt);
//                    hbaReport.setTotalAmount(hbaTotalAmount);
//                    hbaRepo.save(hbaReport);
//                }
//                if (specialPfAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    SpecialPfReport specialPfReport = new SpecialPfReport();
//                    specialPfReport.setEmployeeId(employeeId);
//                    specialPfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    specialPfReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    specialPfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    specialPfReport.setSpecialPfAmount(specialPfAmount);
//                    specialPfRepo.save(specialPfReport);
//                }
//                if (gpfSubAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    GpfReport gpfReport = new GpfReport();
//                    gpfReport.setEmployeeId(employeeId);
//                    gpfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    gpfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    gpfReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    gpfReport.setDa(BigDecimal.valueOf(monthlySalaryNewData.getDa()));
//                    gpfReport.setBasicPay(monthlySalaryNewData.getBasicPay());
//                    gpfReport.setPersonalPay(BigDecimal.valueOf(monthlySalaryNewData.getPersonalPay()));
//                    gpfReport.setSpecialPay(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPay()));
//                    gpfReport.setGpfSub(gpfSubAmount);
//                    gpfReport.setGpfArrear(gpfArrearAmount);
//                    gpfReport.setGpfLoan(gpfLoanAmount);
//                    gpfReport.setVpf(vpfAmount);
//                    gpfReport.setTotalAmount(gpfTotalAmount);
//                    gpfRepo.save(gpfReport);
//                }
//                if (deductionAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    OneDayRecoveryReport oneDayRecoveryReport = new OneDayRecoveryReport();
//                    oneDayRecoveryReport.setEmployeeId(employeeId);
//                    oneDayRecoveryReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    oneDayRecoveryReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    oneDayRecoveryReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    oneDayRecoveryReport.setBasicPay(monthlySalaryNewData.getBasicPay());
//                    oneDayRecoveryReport.setGross(BigDecimal.valueOf(monthlySalaryNewData.getTotalEarning()));
//                    oneDayRecoveryReport.setDeductionAmount(deductionAmount);
//                    oneDayRecoveryRepo.save(oneDayRecoveryReport);
//                }
//
//
//                for (RecoveryData recoveryData : recoveryDataList) {
//                    for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
//                        String recoveryType = recoveryDataAdd.getRecovery();
//                        LocalDate date = recoveryDataAdd.getDate();
//                        Long TotalMonth =recoveryDataAdd.getNoOfMonths();
//                        if ("miscDeduction1".equals(recoveryType)) {
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()) {
//                                    // Calculate recovery and balance amounts for miscDeduction
//                                    miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else {
//                                    miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }
//                            }
//                        } else if ("payAdvance".equals(recoveryType)) {
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()) {
//                                    // Calculate recovery and balance amounts for payAdvance
//                                    payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }else{
//                                    payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }
//
//                            }
//                        } else if ("educationAdvance".equals(recoveryType)) {
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()) {
//                                    // Calculate recovery and balance amounts for payAdvance
//                                    educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }else{
//                                    educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }
//
//                            }
//                        } else if ("marriageAdvance".equals(recoveryType)) {
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()) {
//                                    // Calculate recovery and balance amounts for payAdvance
//                                    marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }else{
//                                    marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }
//
//                            }
//                        } else if ("conveyanceAdvance".equals(recoveryType)) {
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()){
//                                    // Calculate recovery and balance amounts for payAdvance
//                                    convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }else{
//                                    convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                }
//
//                            }
//                        } else if ("festivalAdvance".equals(recoveryType)) {
//                            // Calculate recovery and balance amounts for payAdvance
//                            if (recoveryDataAdd.getPerMonthDemand() != null) {
//                                if (date == LocalDate.now()) {
//                                    festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
//                                    festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//                                } else if (date != LocalDate.now() && TotalMonth == 1) {
//                                    festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
//                                    festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//
//                                } else {
//                                    festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
//                                    festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
//
//                                }
//                            }
//
//
//                        }
//                    }
//                }
//
//// Save MiscDeductionReport if applicable
//                if (miscDeductionAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    MiscDeductionReport miscDeduction = new MiscDeductionReport();
//                    miscDeduction.setEmployeeId(employeeId);
//                    miscDeduction.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    miscDeduction.setRecoveryAmount(miscDeductionAmount);
//                    miscDeduction.setBalanceAmount(miscDeductionBalance);
//                    miscDeduction.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    miscDeduction.setDesignation(monthlySalaryNewData.getDesignationName());
//                    miscDeduction.setDate(monthlySalary.getDateOfFA());
//                    miscDeductionRepo.save(miscDeduction);
//                }
//
//// Save PayAdvanceReport if applicable
//                if (payAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    PayAdvanceReport payAdvanceReport = new PayAdvanceReport();
//                    payAdvanceReport.setEmployeeId(employeeId);
//                    payAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    payAdvanceReport.setPayAdvanceAmount(payAdvanceAmount);
//                    payAdvanceReport.setBalanceAmount(payAdvanceBalance);
//                    payAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    payAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    payAdvanceRepo.save(payAdvanceReport);
//                }
//                if (educationAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    EducationAdvanceReport educationAdvanceReport = new EducationAdvanceReport();
//                    educationAdvanceReport.setEmployeeId(employeeId);
//                    educationAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    educationAdvanceReport.setEducationAdvanceAmount(educationAdvanceAmount);
//                    educationAdvanceReport.setBalanceAmount(educationAdvanceBalance);
//                    educationAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    educationAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    educationAdvanceRepo.save(educationAdvanceReport);
//                }
//                if (marriageAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    MarriageAdvanceReport marriageAdvanceReport = new MarriageAdvanceReport();
//                    marriageAdvanceReport.setEmployeeId(employeeId);
//                    marriageAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    marriageAdvanceReport.setMarriageAdvanceAmount(marriageAdvanceAmount);
//                    marriageAdvanceReport.setBalanceAmount(marriageAdvanceBalance);
//                    marriageAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    marriageAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    marriageAdvanceRepo.save(marriageAdvanceReport);
//                }
//                if (convenyanceAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    ConvenyanceAdvanceReport convenyanceAdvanceReport = new ConvenyanceAdvanceReport();
//                    convenyanceAdvanceReport.setEmployeeId(employeeId);
//                    convenyanceAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    convenyanceAdvanceReport.setConvenyanceAdvanceAmount(convenyanceAdvanceAmount);
//                    convenyanceAdvanceReport.setBalanceAmount(convenyanceAdvanceBalance);
//                    convenyanceAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    convenyanceAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    convenyanceAdvanceRepo.save(convenyanceAdvanceReport);
//                }
//                if (festivalAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
//                    FestivalAdvanceReport festivalAdvanceReport = new FestivalAdvanceReport();
//                    festivalAdvanceReport.setEmployeeId(employeeId);
//                    festivalAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
//                    festivalAdvanceReport.setFestivalAdvanceAmount(festivalAdvanceAmount);
//                    festivalAdvanceReport.setBalanceAmount(festivalAdvanceBalance);
//                    festivalAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
//                    festivalAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
//                    festivalAdvanceRepo.save(festivalAdvanceReport);
//                }
//
//            }
//        }
//        return monthlySalaryRepo.save(monthlySalary);
//    }

    @Override
    @Transactional
    public MonthlySalary saveMonthlySalary(MonthlySalary monthlySalary) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);

        monthlySalary.setDateOfAO(formattedDate);
        monthlySalary.setDateOfDCAO(formattedDate);
        monthlySalary.setDateOfFA(formattedDate);

        if ("Approved".equals(monthlySalary.getStatusFA())) {
            // Initialize lazy association
            int a = monthlySalary.getEmployeeTableData().size();
            System.out.println("count:" + a);


            for (MonthlySalaryNewData monthlySalaryNewData : monthlySalary.getEmployeeTableData()) {
                if("DA Arrear".equals(monthlySalary.getPaymentType())){
                    monthlySalaryNewData.setDa(monthlySalaryNewData.getGrossTotal());
                }
                if ("EL Surrender".equals(monthlySalary.getPaymentType())) {
                    monthlySalaryNewData.setPersonalPay(0L);

                }
                if("Pay Arrear".equals(monthlySalary.getPaymentType())){
                    monthlySalaryNewData.setDa(monthlySalaryNewData.getDaArrear());
                    monthlySalaryNewData.setHra(monthlySalaryNewData.getHraArrear());
                    monthlySalaryNewData.setCca(monthlySalaryNewData.getCcaArrear());
                    monthlySalaryNewData.setMisc1(monthlySalaryNewData.getToBemisc1());
                }
                String employeeId = monthlySalaryNewData.getEmployeeId();
                List<RecoveryData> recoveryDataList = recoveryDataRepo.findByEmployeeId(employeeId);

                for (RecoveryData recoveryData : recoveryDataList) {
                    for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
                        String recoveryType = recoveryDataAdd.getRecovery();

                        BigDecimal recovered = recoveryDataAdd.getRecoverd();
                        Long perMonthDemand = recoveryDataAdd.getPerMonthDemand();
                        Long regularMonth = recoveryDataAdd.getRegularMonthDemand();
                        Long lastMonth = recoveryDataAdd.getLastMonthDemand();
                        LocalDate date = recoveryDataAdd.getDate();
                        Long TotalMonth = recoveryDataAdd.getNoOfMonths();

                        log.info("Received recoveryType: {}", recoveryType);


                        Long waterCharges = monthlySalaryNewData.getWaterCharges();
                        Long rentDeductions = monthlySalaryNewData.getRentDeductions();

                        if (waterCharges == null) {
                            waterCharges = 0L;
                        }

                        if (rentDeductions == null) {
                            rentDeductions = 0L;
                        }

                        monthlySalaryNewData.setRentTotal(waterCharges + rentDeductions);
                        Long incomeTax = monthlySalaryNewData.getIncomeTax();
                        Long incomeTaxCess = monthlySalaryNewData.getIncomeTaxCess();

                        if (incomeTax == null) {
                            incomeTax = 0L;
                        }

                        if (incomeTaxCess == null) {
                            incomeTaxCess = 0L;
                        }

                        monthlySalaryNewData.setIncomeTaxTotal(incomeTax + incomeTaxCess);
                        Long cps = monthlySalaryNewData.getCps();
                        Long cpsArrear = monthlySalaryNewData.getCpsArrear();

                        if (cps == null) {
                            cps = 0L;
                        }

                        if (cpsArrear == null) {
                            cpsArrear = 0L;
                        }

                        monthlySalaryNewData.setCpsTotal(cps + cpsArrear);
                        Long hba = monthlySalaryNewData.getHba();
                        Long hbf = monthlySalaryNewData.getHbf();
                        Long eoe = monthlySalaryNewData.getEoe();

                        if (hba == null) {
                            hba = 0L;
                        }

                        if (hbf == null) {
                            hbf = 0L;
                        }

                        if (eoe == null) {
                            eoe = 0L;
                        }

                        monthlySalaryNewData.setHbaTotal(hba + hbf + eoe);
                        Long gpfSub = monthlySalaryNewData.getGpfSub();
                        Long vpf = monthlySalaryNewData.getVpf();

                        if (gpfSub == null) {
                            gpfSub = 0L;
                        }

                        if (vpf == null) {
                            vpf = 0L;
                        }

                        monthlySalaryNewData.setGpfTotal(gpfSub + vpf);
                        Long oneDayRecovery = monthlySalaryNewData.getOneDayRecovery();

                        if (oneDayRecovery == null) {
                            oneDayRecovery = 0L;
                        }

                        monthlySalaryNewData.setOneDayRecoveryTotal(oneDayRecovery);
//                       LocalDate currentDate = LocalDate.now();
                        int currentMonth = currentDate.getMonthValue();
                        int currentYear = currentDate.getYear();
                        if (!(monthlySalary.getPaymentType().equals("Pay Arrear") ||
                                monthlySalary.getPaymentType().equals("DA Arrear") ||
                                monthlySalary.getPaymentType().equals("EL Surrender"))) {
                            // Your logic here

                            if (date != null) {
                                if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                    recovered = recovered.add(BigDecimal.valueOf(perMonthDemand));
                                } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                    recovered = recovered.add(BigDecimal.valueOf(lastMonth));
                                } else {
                                    recovered = recovered.add(BigDecimal.valueOf(regularMonth));
                                }
                            }
                        }

                        BigDecimal totalDemand = BigDecimal.valueOf(recoveryDataAdd.getTotalDemand());
                        BigDecimal remainingBalance = totalDemand.subtract(recovered);
                        recoveryDataAdd.setRecoverd(recovered);


                        recoveryDataAdd.setBalanceAmount(remainingBalance);
//                        saveConvenyanceAdvanceReport(recoveryDataAdd);


                        if (remainingBalance.compareTo(BigDecimal.ZERO) == 0) {
                            recoveryDataAdd.setPerMonthDemand(0L);
                            //recoveryDataAdd.setLastMonthDemand(0L);
                            recoveryDataAdd.setRegularMonthDemand(0L);
                            recoveryDataAdd.setNoOfMonths(0L);
                        }
                    }
                    recoveryDataRepo.save(recoveryData);

                }



                BigDecimal NhisValue = BigDecimal.ZERO;
                BigDecimal miscDeductionAmount = BigDecimal.ZERO;
                BigDecimal miscDeductionBalance = BigDecimal.ZERO;
                BigDecimal payAdvanceAmount = BigDecimal.ZERO;
                BigDecimal payAdvanceBalance = BigDecimal.ZERO;
                BigDecimal educationAdvanceAmount = BigDecimal.ZERO;
                BigDecimal educationAdvanceBalance = BigDecimal.ZERO;
                BigDecimal marriageAdvanceAmount = BigDecimal.ZERO;
                BigDecimal marriageAdvanceBalance = BigDecimal.ZERO;
                BigDecimal convenyanceAdvanceAmount = BigDecimal.ZERO;
                BigDecimal convenyanceAdvanceBalance = BigDecimal.ZERO;
                BigDecimal festivalAdvanceAmount = BigDecimal.ZERO;
                BigDecimal festivalAdvanceBalance = BigDecimal.ZERO;
                BigDecimal professionalTaxAmount = BigDecimal.ZERO;
                BigDecimal rentAmount = BigDecimal.ZERO;
                BigDecimal waterCharge = BigDecimal.ZERO;
                BigDecimal fbfAmount = BigDecimal.ZERO;
                BigDecimal incomeAmount = BigDecimal.ZERO;
                BigDecimal incomeCess = BigDecimal.ZERO;
                BigDecimal totalAmount = BigDecimal.ZERO;
                BigDecimal cpsAmount = BigDecimal.ZERO;
                BigDecimal CpsArrearAmount = BigDecimal.ZERO;
                BigDecimal cpsTotalAmount = BigDecimal.ZERO;
                BigDecimal hbaAmount = BigDecimal.ZERO;
                BigDecimal hbfAmount = BigDecimal.ZERO;
                BigDecimal eoeAoumnt = BigDecimal.ZERO;
                BigDecimal hbaTotalAmount = BigDecimal.ZERO;
                BigDecimal specialPfAmount = BigDecimal.ZERO;
                BigDecimal gpfSubAmount = BigDecimal.ZERO;
                BigDecimal vpfAmount = BigDecimal.ZERO;
                BigDecimal gpfLoanAmount = BigDecimal.ZERO;
                BigDecimal gpfArrearAmount = BigDecimal.ZERO;
                BigDecimal gpfTotalAmount = BigDecimal.ZERO;
                BigDecimal deductionAmount = BigDecimal.ZERO;


                //// EmployeePayRoll employeePayRoll = employeePayRollRepo.findByEmployeeId(employeeId);
                if (monthlySalaryNewData.getOneDayRecovery() != null) {
                    deductionAmount = deductionAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getOneDayRecovery()));
                }
                if (monthlySalaryNewData.getGpfSub() != null) {
                    gpfSubAmount = gpfSubAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfSub()));
                }
                if (monthlySalaryNewData.getVpf() != null) {
                    vpfAmount = vpfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getVpf()));
                }
                if (monthlySalaryNewData.getGpfLoan() != null) {
                    gpfLoanAmount = gpfLoanAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfLoan()));
                }
                if (monthlySalaryNewData.getGpfArrear() != null) {
                    gpfArrearAmount = gpfArrearAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getGpfArrear()));
                }

                BigDecimal gpfAdd = gpfSubAmount.add(vpfAmount);
                BigDecimal gpfplus = gpfLoanAmount.add(gpfArrearAmount);
                gpfTotalAmount = gpfAdd.add(gpfplus);
                if (monthlySalaryNewData.getSpecialPf() != null) {
                    specialPfAmount = specialPfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPf()));
                }
                if (monthlySalaryNewData.getHba() != null) {
                    hbaAmount = hbaAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getHba()));
                }
                if (monthlySalaryNewData.getHbf() != null) {
                    hbfAmount = hbfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getHbf()));
                }
                if (monthlySalaryNewData.getEoe() != null) {
                    eoeAoumnt = eoeAoumnt.add(BigDecimal.valueOf(monthlySalaryNewData.getEoe()));
                }
                BigDecimal hbaAdd = hbaAmount.add(hbfAmount);
                hbaTotalAmount = eoeAoumnt.add(hbaAdd);
                if (monthlySalaryNewData.getCps() != null) {
                    cpsAmount = cpsAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getCps()));
                }
                if (monthlySalaryNewData.getCpsArrear() != null) {
                    CpsArrearAmount = CpsArrearAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getCpsArrear()));
                }
                cpsTotalAmount = cpsAmount.add(CpsArrearAmount);
                if (monthlySalaryNewData.getIncomeTaxCess() != null) {
                    incomeCess = incomeCess.add(BigDecimal.valueOf(monthlySalaryNewData.getIncomeTaxCess()));
                }
                if (monthlySalaryNewData.getIncomeTax() != null) {
                    incomeAmount = incomeAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getIncomeTax()));
                }
                totalAmount = incomeAmount.add(incomeCess);
                if (monthlySalaryNewData.getFbf() != null) {
                    fbfAmount = fbfAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getFbf()));
                }
                if (monthlySalaryNewData.getNhis() != null) {
                    NhisValue = NhisValue.add(BigDecimal.valueOf(monthlySalaryNewData.getNhis()));
                }
                if (monthlySalaryNewData.getProfessionalTax() != null) {
                    professionalTaxAmount = professionalTaxAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getProfessionalTax()));
                }
                if (monthlySalaryNewData.getRentDeductions() != null) {
                    rentAmount = rentAmount.add(BigDecimal.valueOf(monthlySalaryNewData.getRentDeductions()));
                }
                if (monthlySalaryNewData.getWaterCharges() != null) {
                    waterCharge = waterCharge.add(BigDecimal.valueOf(monthlySalaryNewData.getWaterCharges()));
                }
                if (NhisValue.compareTo(BigDecimal.ZERO) > 0) {
                    NhisReport nhisReport = new NhisReport();
                    nhisReport.setEmployeeId(employeeId);
                    nhisReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    nhisReport.setNhisAmount(NhisValue);
                    nhisReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    nhisReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    nhisRepo.save(nhisReport);
                }
                if (professionalTaxAmount.compareTo(BigDecimal.ZERO) > 0) {
                    ProfessionalTaxReport professionalTaxReport = new ProfessionalTaxReport();
                    professionalTaxReport.setEmployeeId(employeeId);
                    professionalTaxReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    professionalTaxReport.setProfessionalTaxAmount(professionalTaxAmount);
                    professionalTaxReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    professionalTaxReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    professionalTaxReportRepo.save(professionalTaxReport);
                }
                if (rentAmount.compareTo(BigDecimal.ZERO) > 0) {
                    RentReport rentReport = new RentReport();
                    rentReport.setEmployeeId(employeeId);
                    rentReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    rentReport.setRentAmount(rentAmount);
                    rentReport.setWaterCharge(waterCharge);
                    rentReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    rentReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    rentRepo.save(rentReport);
                }
                if (fbfAmount.compareTo(BigDecimal.ZERO) > 0) {
                    FBFReport fbfReport = new FBFReport();
                    fbfReport.setEmployeeId(employeeId);
                    fbfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    fbfReport.setFbfAmount(fbfAmount);
                    fbfReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    fbfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    fbfRepo.save(fbfReport);
                }
                if (incomeAmount.compareTo(BigDecimal.ZERO) > 0) {
                    IncomeTaxReport incomeTaxReport = new IncomeTaxReport();
                    incomeTaxReport.setEmployeeId(employeeId);
                    incomeTaxReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    incomeTaxReport.setBasicPay(monthlySalaryNewData.getBasicPay());
                    incomeTaxReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    incomeTaxReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    incomeTaxReport.setPanNo(monthlySalaryNewData.getPanNo());
                    incomeTaxReport.setGross(monthlySalaryNewData.getTotalEarning());
                    incomeTaxReport.setIncomeTax(incomeAmount);
                    incomeTaxReport.setIncomeTaxCess(incomeCess);
                    incomeTaxReport.setTotalAmount(totalAmount);
                    incomeTaxReportRepo.save(incomeTaxReport);
                }
                if (cpsAmount.compareTo(BigDecimal.ZERO) > 0) {
                    CpsReport cpsReport = new CpsReport();
                    cpsReport.setEmployeeId(employeeId);
                    cpsReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    cpsReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    cpsReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    cpsReport.setBasicPay(monthlySalaryNewData.getBasicPay());
                    if (monthlySalaryNewData.getPersonalPay() != null) {
                        cpsReport.setPersonalPay(BigDecimal.valueOf(monthlySalaryNewData.getPersonalPay()));
                    }
                    if (monthlySalaryNewData.getSpecialPay() != null) {
                        cpsReport.setSpecialPay(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPay()));
                    }
                    if (monthlySalaryNewData.getDa() != null) {
                        cpsReport.setDa(BigDecimal.valueOf(monthlySalaryNewData.getDa()));
                    }
                    cpsReport.setCpsAmount(cpsAmount);
                    cpsReport.setCpsArrear(CpsArrearAmount);
                    cpsReport.setTotalAmount(cpsTotalAmount);
                    cpsRepo.save(cpsReport);
                }
                if (hbaAmount.compareTo(BigDecimal.ZERO) > 0) {
                    HbaReport hbaReport = new HbaReport();
                    hbaReport.setEmployeeId(employeeId);
                    hbaReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    hbaReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    hbaReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    hbaReport.setHba(hbaAmount);
                    hbaReport.setHbf(hbfAmount);
                    hbaReport.setEoe(eoeAoumnt);
                    hbaReport.setTotalAmount(hbaTotalAmount);
                    hbaRepo.save(hbaReport);
                }
                if (specialPfAmount.compareTo(BigDecimal.ZERO) > 0) {
                    SpecialPfReport specialPfReport = new SpecialPfReport();
                    specialPfReport.setEmployeeId(employeeId);
                    specialPfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    specialPfReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    specialPfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    specialPfReport.setSpecialPfAmount(specialPfAmount);
                    specialPfRepo.save(specialPfReport);
                }
                if (gpfSubAmount.compareTo(BigDecimal.ZERO) > 0) {
                    GpfReport gpfReport = new GpfReport();
                    gpfReport.setEmployeeId(employeeId);
                    gpfReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    gpfReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    gpfReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    gpfReport.setDa(BigDecimal.valueOf(monthlySalaryNewData.getDa()));
                    gpfReport.setBasicPay(monthlySalaryNewData.getBasicPay());
                    gpfReport.setPersonalPay(BigDecimal.valueOf(monthlySalaryNewData.getPersonalPay()));
                    gpfReport.setSpecialPay(BigDecimal.valueOf(monthlySalaryNewData.getSpecialPay()));
                    gpfReport.setGpfSub(gpfSubAmount);
                    gpfReport.setGpfArrear(gpfArrearAmount);
                    gpfReport.setGpfLoan(gpfLoanAmount);
                    gpfReport.setVpf(vpfAmount);
                    gpfReport.setTotalAmount(gpfTotalAmount);
                    gpfRepo.save(gpfReport);
                }
                if (deductionAmount.compareTo(BigDecimal.ZERO) > 0) {
                    OneDayRecoveryReport oneDayRecoveryReport = new OneDayRecoveryReport();
                    oneDayRecoveryReport.setEmployeeId(employeeId);
                    oneDayRecoveryReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    oneDayRecoveryReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    oneDayRecoveryReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    oneDayRecoveryReport.setBasicPay(monthlySalaryNewData.getBasicPay());
                    oneDayRecoveryReport.setGross(BigDecimal.valueOf(monthlySalaryNewData.getTotalEarning()));
                    oneDayRecoveryReport.setDeductionAmount(deductionAmount);
                    oneDayRecoveryRepo.save(oneDayRecoveryReport);
                }


                for (RecoveryData recoveryData : recoveryDataList) {
                    if (!(monthlySalary.getPaymentType().equals("Pay Arrear") ||
                            monthlySalary.getPaymentType().equals("DA Arrear") ||
                            monthlySalary.getPaymentType().equals("EL Surrender"))) {

                        for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
                            String recoveryType = recoveryDataAdd.getRecovery();
                            LocalDate date = recoveryDataAdd.getDate();
                            //  LocalDate currentDate = LocalDate.now();
                            int currentMonth = currentDate.getMonthValue();
                            int currentYear = currentDate.getYear();
                            Long TotalMonth = recoveryDataAdd.getNoOfMonths() - 1;
                            recoveryDataAdd.setNoOfMonths(TotalMonth);
                            if (recoveryDataAdd.getBalanceAmount().compareTo(BigDecimal.ZERO) == 0) {
                                recoveryDataAdd.setPerMonthDemand(0L);
                               // recoveryDataAdd.setLastMonthDemand(0L);
                                recoveryDataAdd.setRegularMonthDemand(0L);
                                recoveryDataAdd.setNoOfMonths(0L);
                            }

                            if ("miscDeduction1".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for miscDeduction
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc1Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc1Recovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc1Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc1Recovered(recoveryDataAdd.getRecoverd());
                                    } else {
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc1Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc1Recovered(recoveryDataAdd.getRecoverd());
                                    }
                                }
                            } else if ("miscDeduction2".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for miscDeduction
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc2Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc2Recovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc2Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc2Recovered(recoveryDataAdd.getRecoverd());
                                    } else {
                                        miscDeductionAmount = miscDeductionAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        miscDeductionBalance = miscDeductionBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMisc2Total(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMisc2Recovered(recoveryDataAdd.getRecoverd());
                                    }
                                }
                            } else if ("payAdvance".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for payAdvance
                                        payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setPayTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setPayRecovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setPayTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setPayRecovered(recoveryDataAdd.getRecoverd());
                                    } else {
                                        payAdvanceAmount = payAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        payAdvanceBalance = payAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setPayTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setPayRecovered(recoveryDataAdd.getRecoverd());
                                    }

                                }
                            } else if ("educationAdvance".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for payAdvance
                                        educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setEducationTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setEducationRecovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setEducationTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setEducationRecovered(recoveryDataAdd.getRecoverd());
                                    } else {
                                        educationAdvanceAmount = educationAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        educationAdvanceBalance = educationAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setEducationTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setEducationRecovered(recoveryDataAdd.getRecoverd());
                                    }

                                }
                            } else if ("marriageAdvance".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for payAdvance
                                        marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMarraigeTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMarraigeRecoverd(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMarraigeTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMarraigeRecoverd(recoveryDataAdd.getRecoverd());
                                    } else {
                                        marriageAdvanceAmount = marriageAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        marriageAdvanceBalance = marriageAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setMarraigeTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setMarraigeRecoverd(recoveryDataAdd.getRecoverd());
                                    }

                                }
                            } else if ("conveyanceAdvance".equals(recoveryType)) {
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        // Calculate recovery and balance amounts for payAdvance
                                        convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setConveyanceTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setConveyanceRecovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setConveyanceTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setConveyanceRecovered(recoveryDataAdd.getRecoverd());
                                    } else {
                                        convenyanceAdvanceAmount = convenyanceAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        convenyanceAdvanceBalance = convenyanceAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setConveyanceTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setConveyanceRecovered(recoveryDataAdd.getRecoverd());
                                    }

                                }
                            } else if ("festivalAdvance".equals(recoveryType)) {
                                // Calculate recovery and balance amounts for payAdvance
                                if (recoveryDataAdd.getPerMonthDemand() != null) {
                                    if (currentMonth == date.getMonthValue() && currentYear == date.getYear()) {
                                        festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
                                        festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setFestivalTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setFestivalRecovered(recoveryDataAdd.getRecoverd());
                                    } else if (currentMonth != date.getMonthValue() && TotalMonth == 1) {
                                        festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getLastMonthDemand()));
                                        festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setFestivalTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setFestivalRecovered(recoveryDataAdd.getRecoverd());

                                    } else {
                                        festivalAdvanceAmount = festivalAdvanceAmount.add(BigDecimal.valueOf(recoveryDataAdd.getRegularMonthDemand()));
                                        festivalAdvanceBalance = festivalAdvanceBalance.add(recoveryDataAdd.getBalanceAmount());
                                        monthlySalaryNewData.setFestivalTotal(recoveryDataAdd.getTotalDemand());
                                        monthlySalaryNewData.setFestivalRecovered(recoveryDataAdd.getRecoverd());

                                    }
                                }



                            }
                        }
                    }
                }

// Save MiscDeductionReport if applicable
                if (miscDeductionAmount.compareTo(BigDecimal.ZERO) > 0) {
                    MiscDeductionReport miscDeduction = new MiscDeductionReport();
                    miscDeduction.setEmployeeId(employeeId);
                    miscDeduction.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    miscDeduction.setRecoveryAmount(miscDeductionAmount);
                    miscDeduction.setBalanceAmount(miscDeductionBalance);
                    miscDeduction.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    miscDeduction.setDesignation(monthlySalaryNewData.getDesignationName());
                    miscDeduction.setDate(monthlySalary.getDateOfFA());
                    miscDeductionRepo.save(miscDeduction);
                }
                if (miscDeductionAmount.compareTo(BigDecimal.ZERO) > 0) {
                    MiscDeductionReport2 miscDeduction = new MiscDeductionReport2();
                    miscDeduction.setEmployeeId(employeeId);
                    miscDeduction.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    miscDeduction.setRecoveryAmount(miscDeductionAmount);
                    miscDeduction.setBalanceAmount(miscDeductionBalance);
                    miscDeduction.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    miscDeduction.setDesignation(monthlySalaryNewData.getDesignationName());
                    miscDeduction.setDate(monthlySalary.getDateOfFA());
                    miseDeduction2Repo.save(miscDeduction);
                }

// Save PayAdvanceReport if applicable
                if (payAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
                    PayAdvanceReport payAdvanceReport = new PayAdvanceReport();
                    payAdvanceReport.setEmployeeId(employeeId);
                    payAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    payAdvanceReport.setPayAdvanceAmount(payAdvanceAmount);
                    payAdvanceReport.setBalanceAmount(payAdvanceBalance);
                    payAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    payAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    payAdvanceRepo.save(payAdvanceReport);
                }
                if (educationAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
                    EducationAdvanceReport educationAdvanceReport = new EducationAdvanceReport();
                    educationAdvanceReport.setEmployeeId(employeeId);
                    educationAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    educationAdvanceReport.setEducationAdvanceAmount(educationAdvanceAmount);
                    educationAdvanceReport.setBalanceAmount(educationAdvanceBalance);
                    educationAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    educationAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    educationAdvanceRepo.save(educationAdvanceReport);
                }
                if (marriageAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
                    MarriageAdvanceReport marriageAdvanceReport = new MarriageAdvanceReport();
                    marriageAdvanceReport.setEmployeeId(employeeId);
                    marriageAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    marriageAdvanceReport.setMarriageAdvanceAmount(marriageAdvanceAmount);
                    marriageAdvanceReport.setBalanceAmount(marriageAdvanceBalance);
                    marriageAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    marriageAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    marriageAdvanceRepo.save(marriageAdvanceReport);
                }
                if (convenyanceAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
                    ConvenyanceAdvanceReport convenyanceAdvanceReport = new ConvenyanceAdvanceReport();
                    convenyanceAdvanceReport.setEmployeeId(employeeId);
                    convenyanceAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    convenyanceAdvanceReport.setConvenyanceAdvanceAmount(convenyanceAdvanceAmount);
                    convenyanceAdvanceReport.setBalanceAmount(convenyanceAdvanceBalance);
                    convenyanceAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    convenyanceAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    convenyanceAdvanceRepo.save(convenyanceAdvanceReport);

                }
                if (festivalAdvanceAmount.compareTo(BigDecimal.ZERO) > 0) {
                    FestivalAdvanceReport festivalAdvanceReport = new FestivalAdvanceReport();
                    festivalAdvanceReport.setEmployeeId(employeeId);
                    festivalAdvanceReport.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                    festivalAdvanceReport.setFestivalAdvanceAmount(festivalAdvanceAmount);
                    festivalAdvanceReport.setBalanceAmount(festivalAdvanceBalance);
                    festivalAdvanceReport.setDesignation(monthlySalaryNewData.getDesignationName());
                    festivalAdvanceReport.setOfficeCode(monthlySalaryNewData.getOfficeCode());
                    festivalAdvanceRepo.save(festivalAdvanceReport);
                }

            }

        }

        return monthlySalaryRepo.save(monthlySalary);


    }



    @Override
    public MonthlySalary getMonthlySalaryById(Long id) {
        MonthlySalary salaryData = monthlySalaryRepo.findById(id).get();

        return salaryData;
    }

    // delete monthly salary by id
    @Override
    public MonthlySalary deleteMonthlySalaryById(Long id) {

        MonthlySalary salaryData = monthlySalaryRepo.findById(id).get();
//        if (salaryData != null) {
//
//            employeeSalaryCustomFieldsRepo.deleteByEmployeeId(salaryData.getEmployeeId());
//        }
        monthlySalaryRepo.deleteById(id);
        return null;
    }


    // Percentage % -----------------------------------------------------------------------------------
    public Percentage savePercentage(Percentage percentage) {

        return percentageRepo.save(percentage);
    }

    public Percentage getPercentageById(Long id) {
        return percentageRepo.findById(id).orElse(null);
    }

    public Percentage updatePercentage(Percentage existingPercentage) {

        return percentageRepo.save(existingPercentage);
    }

    @Override
    public DaTax getDaById(Long id) {
        return daTaxRepo.findById(id).orElse(null);
    }

    @Override
    public IncomeTax getIncomeTaxById(Long id) {
        return incomeTaxRepo.findById(id).orElse(null);
    }

    @Override
    public RecoveryData saveOrUpdateRecoveryDataAndAdd(RecoveryData recoveryData) {

        if (recoveryData.getRecoveryId() != null) {

            Optional<RecoveryData> existingRecoveryDataOptional = recoveryDataRepo.findById(recoveryData.getRecoveryId());
            if (existingRecoveryDataOptional.isPresent()) {
                RecoveryData existingRecoveryData = existingRecoveryDataOptional.get();

                // Update the existing recoveryData object with the new data
                existingRecoveryData.setEmployeeId(recoveryData.getEmployeeId());
                existingRecoveryData.setEmployeeName(recoveryData.getEmployeeName());


                // Save the updated recoveryData object
                RecoveryData savedRecoveryData = recoveryDataRepo.save(existingRecoveryData);

                // Update or add RecoveryDataAdd entities
                for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
                    if (recoveryDataAdd.getRecoverydataId() != null) {
                        // If the RecoveryDataAdd object has an ID, it means it's an existing entry
                        RecoveryDataAdd existingRecoveryDataAdd = recoveryDataAddRepo.findById(recoveryDataAdd.getRecoverydataId())
                                .orElseThrow(() -> new RuntimeException("RecoveryDataAdd not found with ID: " + recoveryDataAdd.getRecoverydataId()));
                        // Update the existing RecoveryDataAdd object with the new data
                        existingRecoveryDataAdd.setRecovery(recoveryDataAdd.getRecovery());
                        existingRecoveryDataAdd.setRecoverd(recoveryDataAdd.getRecoverd());
                        // existingRecoveryDataAdd.setRecoverdTotal(recoveryDataAdd.getRecoverd());
                        existingRecoveryDataAdd.setTotalDemand(recoveryDataAdd.getTotalDemand());
                        existingRecoveryDataAdd.setPerMonthDemand(recoveryDataAdd.getPerMonthDemand());
                        existingRecoveryDataAdd.setRegularMonthDemand(recoveryDataAdd.getRegularMonthDemand());
                        existingRecoveryDataAdd.setLastMonthDemand(recoveryDataAdd.getLastMonthDemand());
                        existingRecoveryDataAdd.setDate(recoveryDataAdd.getDate());
                        existingRecoveryDataAdd.setNoOfMonths(recoveryDataAdd.getNoOfMonths());
                        existingRecoveryDataAdd.setBalanceAmount(recoveryDataAdd.getBalanceAmount());


                        // Set the updated RecoveryData object for this RecoveryDataAdd entity

                        // Save the updated RecoveryDataAdd object
                        recoveryDataAddRepo.save(existingRecoveryDataAdd);
                    } else {
                        // If the RecoveryDataAdd object doesn't have an ID, it means it's a new entry
                        // Set the RecoveryData object for this new RecoveryDataAdd entity
                        recoveryDataAdd.setRecoveryData(savedRecoveryData);

                        // Save the new RecoveryDataAdd entity
                        recoveryDataAddRepo.save(recoveryDataAdd);
                    }
                }
                return recoveryData; // Return the updated RecoveryData
            } else {
                // If no existing recoveryData found with the provided ID, throw an exception or handle it accordingly
                throw new RuntimeException("RecoveryData not found with ID: " + recoveryData.getRecoveryId());
            }
        } else {
            // If the provided recoveryData object doesn't have an ID, it means it's a new entry
            RecoveryData savedRecoveryData = recoveryDataRepo.save(recoveryData);
            for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
                // Set the RecoveryData object for this new RecoveryDataAdd entity
                recoveryDataAdd.setRecoveryData(savedRecoveryData);

                // Save the new RecoveryDataAdd entity
                recoveryDataAddRepo.save(recoveryDataAdd);

            }
            EmployeePayRoll employeeData = employeePayRollRepo.findByEmployeeId(recoveryData.getEmployeeId());
            if (employeeData != null) {
                for (RecoveryDataAdd r : recoveryData.getRecoveryDataAdd()) {
                    String recoveryType = r.getRecovery();
                    Long perMonthDemand = r.getPerMonthDemand();
                    Long regularMonthDemand = r.getRegularMonthDemand();
                    Long lastMonthDemand = r.getLastMonthDemand();
                    LocalDate recoveryDate = r.getDate();

                    // Get the current date and month
                    LocalDate currentDate = LocalDate.now();
                    int currentMonth = currentDate.getMonthValue();
                    int currentYear = currentDate.getYear();
                    Long noOfMonth = r.getNoOfMonths();
                    Long count = r.getCount();

                    if (recoveryDate != null) {
                        if (currentMonth == recoveryDate.getMonthValue() && currentYear == recoveryDate.getYear()) {
                            // If recovery date is in current month and year, set perMonthDemand
                            assignPerMonthDemand(employeeData, recoveryType, perMonthDemand);
                        } else if (noOfMonth != null && noOfMonth == 1) {
                            System.out.println("nooooo" + noOfMonth);
                            // If noOfMonth equals 1, set lastMonthDemand
                            assignLastMonthDemand(employeeData, recoveryType, lastMonthDemand);

                            //r.setNoOfMonths(noOfMonth);
                        } else if (currentMonth != recoveryDate.getMonthValue() && noOfMonth > 1) {
                            //if (currentMonth != recoveryDate.getMonthValue() && noOfMonth > 1) {
                            // If recovery date is in a different month, set regularMonthDemand
                            assignRegularMonthDemand(employeeData, recoveryType, regularMonthDemand);
                        }
//                        
                    }
                }

                // Save the updated EmployeePayRoll object
                employeeData = employeePayRollRepo.save(employeeData);
                System.out.println("Updated Employee Data: " + employeeData);
            }

            return savedRecoveryData;
        }
    }

    private void assignLastMonthDemand(EmployeePayRoll employeeData, String recoveryType, Long lastMonthDemand) {
        switch (recoveryType) {
            case "gpfLoan":
                employeeData.setGpfLoan(lastMonthDemand);
                break;
            case "gpfArrear":
                employeeData.setGpfArrear(lastMonthDemand);
                break;
            case "cpsArrear":
                employeeData.setCpsArrear(lastMonthDemand);
                break;
            case "festivalAdvance":
                employeeData.setFestivalAdvance(lastMonthDemand);
                break;
            case "conveyanceAdvance":
                employeeData.setConveyanceAdvance(lastMonthDemand);
                break;
            case "educationAdvance":
                employeeData.setEducationAdvance(lastMonthDemand);
                break;
            case "marriageAdvance":
                employeeData.setMarriageAdvance(lastMonthDemand);
                break;
            case "payAdvance":
                employeeData.setPayAdvance(lastMonthDemand);
                break;
            case "miscDeduction1":
                employeeData.setMiscDeduction1(lastMonthDemand);
                break;
            case "miscDeduction2":
                employeeData.setMiscDeduction2(lastMonthDemand);
                break;
            default:
                // Handle unknown recovery type
                break;
        }
    }


    private void assignRegularMonthDemand(EmployeePayRoll employeeData, String recoveryType, Long regularMonthDemand) {
        switch (recoveryType) {
            case "gpfLoan":
                employeeData.setGpfLoan(regularMonthDemand);
                break;
            case "gpfArrear":
                employeeData.setGpfArrear(regularMonthDemand);
                break;
            case "cpsArrear":
                employeeData.setCpsArrear(regularMonthDemand);
                break;
            case "festivalAdvance":
                employeeData.setFestivalAdvance(regularMonthDemand);
                break;
            case "conveyanceAdvance":
                employeeData.setConveyanceAdvance(regularMonthDemand);
                break;
            case "educationAdvance":
                employeeData.setEducationAdvance(regularMonthDemand);
                break;
            case "marriageAdvance":
                employeeData.setMarriageAdvance(regularMonthDemand);
                break;
            case "payAdvance":
                employeeData.setPayAdvance(regularMonthDemand);
                break;
            case "miscDeduction1":
                employeeData.setMiscDeduction1(regularMonthDemand);
                break;
            case "miscDeduction2":
                employeeData.setMiscDeduction2(regularMonthDemand);
                break;
            default:
                // Handle unknown recovery type
                break;
        }
    }

    private void assignPerMonthDemand(EmployeePayRoll employeeData, String recoveryType, Long perMonthDemand) {
        switch (recoveryType) {
            case "gpfLoan":
                employeeData.setGpfLoan(perMonthDemand);
                break;
            case "gpfArrear":
                employeeData.setGpfArrear(perMonthDemand);
                break;
            case "cpsArrear":
                employeeData.setCpsArrear(perMonthDemand);
                break;
            case "festivalAdvance":
                employeeData.setFestivalAdvance(perMonthDemand);
                break;
            case "conveyanceAdvance":
                employeeData.setConveyanceAdvance(perMonthDemand);
                break;
            case "educationAdvance":
                employeeData.setEducationAdvance(perMonthDemand);
                break;
            case "marriageAdvance":
                employeeData.setMarriageAdvance(perMonthDemand);
                break;
            case "payAdvance":
                employeeData.setPayAdvance(perMonthDemand);
                break;
            case "miscDeduction1":
                employeeData.setMiscDeduction1(perMonthDemand);
                break;
            case "miscDeduction2":
                employeeData.setMiscDeduction2(perMonthDemand);
                break;
            default:
                // Handle unknown recovery type
                break;
        }

    }

    @Override
    public EmployeeIdFilter[] getAllEmpId() {
        List<EmployeePayRoll> payRolls = employeePayRollRepo.findAll();
        EmployeeIdFilter[] filter = new EmployeeIdFilter[payRolls.size()];
        int index = 0;

        for (EmployeePayRoll employeePayRoll : payRolls) {
            EmployeeIdFilter employeeIdFilter = new EmployeeIdFilter();
            employeeIdFilter.setEmployeeId(employeePayRoll.getEmployeeId());
            employeeIdFilter.setId(employeePayRoll.getNId());
            filter[index++] = employeeIdFilter;
        }

        return filter;
    }

    @Override
    public List<MonthlySalary> getAllMonthlySalary() {
        List<MonthlySalary> mass = monthlySalaryRepo.findAll();
        for (MonthlySalary massed : mass) {
            massed.getDateOfAO();
            massed.getDateOfDCAO();
            massed.getDateOfFA();
        }
        return mass;
    }

    @Override
    public MonthlySalary updateMonthlySalary(MonthlySalary monthlySalary) {
        if (monthlySalary.getNId() != null) {
            return monthlySalaryRepo.save(monthlySalary);
        } else {

        }
        return null;

    }

    @Override
    public List<MonthlySalaryNewData> saveMonthlySalaryNewData(List<MonthlySalaryNewData> monthlySalaryNewData) {
        return monthlySalaryNewRepo.saveAll(monthlySalaryNewData);
    }

    @Override
    public List<MonthlySalary> getMonthlySalaryNewDataById(Long voucherNo) {
        return monthlySalaryRepo.findAllByVoucherNo(voucherNo);
    }

    @Override
    public List<MonthlySalary> getMonthlySalaryVoucherNo(Long voucher) {
        List<MonthlySalary> mass = monthlySalaryRepo.findByVoucherNo(voucher);
        for (MonthlySalary massd : mass) {
            massd.getDateOfFA();
            massd.getDateOfDCAO();
            massd.getDateOfAO();
        }
        return mass;
    }

    @Override
    public Hra saveHra(Hra hra) {
        return hraRepo.save(hra);
    }

    @Override
    public Page<Hra> getAllHra(Pageable pageable) {
        return hraRepo.findAll(pageable);
    }


    @Override
    public Hra getHraById(Long Hraid) {
        return hraRepo.findById(Hraid).orElse(null);
    }

    @Override
    public Hra updateHra(Hra existingHra) {
        return hraRepo.save(existingHra);
    }

    @Override
    public void deleteHraById(Long id) {

        hraRepo.deleteById(id);
    }

    @Override
    public List<Hra> getAllHraData() {
        return hraRepo.findAll();
    }

    @Override
    public Long findGradeValue(Long range, String officeCode) {
        List<Hra> payRanges = hraRepo.findAll();
        for (Hra payRange : payRanges) {
            if (range >= payRange.getPayRangeFrom() && range <= payRange.getPayRangeTo()) {
                if (officeCode.equals("01") || officeCode.equals("02") || officeCode.equals("03") || officeCode.equals("04") || officeCode.equals("05") || officeCode.equals("06") || officeCode.equals("07") || officeCode.equals("08") || officeCode.equals("09") || officeCode.equals("11") || officeCode.equals("12") || officeCode.equals("13") || officeCode.equals("15") || officeCode.equals("16") || officeCode.equals("17") || officeCode.equals("19") || officeCode.equals("20") || officeCode.equals("21") || officeCode.equals("22") || officeCode.equals("23") || officeCode.equals("25")) {
                    return payRange.getGrade01();
                } else if (officeCode.equals("26") || officeCode.equals("27") || officeCode.equals("29") || officeCode.equals("30") || officeCode.equals("31") || officeCode.equals("35")) {
                    return payRange.getGrade02();
                } else if (officeCode.equals("32") || officeCode.equals("33") || officeCode.equals("36") || officeCode.equals("37") || officeCode.equals("39") || officeCode.equals("40")) {
                    return payRange.getGrade03();
                } else if (officeCode.equals("77") || officeCode.equals("78") || officeCode.equals("79") || officeCode.equals("80") || officeCode.equals("81") || officeCode.equals("82") || officeCode.equals("83") || officeCode.equals("84") || officeCode.equals("85") || officeCode.equals("86") || officeCode.equals("87") || officeCode.equals("88") || officeCode.equals("89") || officeCode.equals("90") || officeCode.equals("91") || officeCode.equals("92") || officeCode.equals("93") || officeCode.equals("94") || officeCode.equals("95") || officeCode.equals("96") || officeCode.equals("97") || officeCode.equals("98") || officeCode.equals("99") || officeCode.equals("100")) {
                    return payRange.getGrade04();
                } else {
                    return payRange.getGrade05();
                }

            }
        }
        return 0L;
    }

    @Override
    public Cca saveCca(Cca cca) {
        return ccaRepo.save(cca);
    }

    @Override
    public Cca getCcaById(Long ccaid) {
        return ccaRepo.findById(ccaid).orElse(null);
    }

    @Override
    public List<Cca> getAllCcaData() {
        return ccaRepo.findAll();
    }

    @Override
    public void deleteCcaById(Long id) {
        ccaRepo.deleteById(id);

    }

    @Override
    public Long findCCAValue(Long range, String officeCode) {

        List<Cca> valueRange = ccaRepo.findAll();

        for (Cca CCARange : valueRange) {
            if (range >= CCARange.getCcaFromPay() && range <= CCARange.getCcaToPay()) {
                if (officeCode.equals("01") || officeCode.equals("02") || officeCode.equals("03") || officeCode.equals("04") || officeCode.equals("05") || officeCode.equals("06") || officeCode.equals("07") || officeCode.equals("08") || officeCode.equals("09") || officeCode.equals("11") || officeCode.equals("12") || officeCode.equals("13") || officeCode.equals("15") || officeCode.equals("16") || officeCode.equals("17") || officeCode.equals("19") || officeCode.equals("20") || officeCode.equals("21") || officeCode.equals("22") || officeCode.equals("23") || officeCode.equals("25")) {
                    return CCARange.getCcaFirstValue();
                } else if (officeCode.equals("26") || officeCode.equals("27") || officeCode.equals("29") || officeCode.equals("30") || officeCode.equals("31") || officeCode.equals("35") || officeCode.equals("36") || officeCode.equals("38")) {
                    return CCARange.getCcaSecondValue();
                } else {
                    return 0L;
                }
            }
        }

        return 0L;
    }

    @Override
    public Long findDaPercentage(LocalDate currentDate) {
        List<DaTax> daTaxList = daTaxRepo.findAll();

        for (DaTax daTax : daTaxList) {
            if (currentDate.isAfter(daTax.getFrom()) && (daTax.getTo() == null || currentDate.isBefore(daTax.getTo()))) {
                return daTax.getDaPercentage();
            }
        }
        return null;
    }

    @Override
    public MonthlySalaryNewData getMonthlySalaryNewById(Long id) {
        return monthlySalaryNewRepo.findById(id).orElse(null);
    }

    @Override
    public Map<String, Long> getRecoveryTypesByEmployeeId(String employeeId) {
        Map<String, Long> recoveryTypesWithPerMonthDemand = new HashMap<>();

        List<RecoveryData> recoveryDataList = recoveryDataRepo.findByEmployeeId(employeeId);

        if (recoveryDataList != null) {
            for (RecoveryData recoveryData : recoveryDataList) {
                for (RecoveryDataAdd recoveryDataAdd : recoveryData.getRecoveryDataAdd()) {
                    String recoveryType = recoveryDataAdd.getRecovery();
                    Long perMonthDemand = recoveryDataAdd.getPerMonthDemand();
                    Long regularMonthDemand = recoveryDataAdd.getRegularMonthDemand();
                    Long lastMonthDemand = recoveryDataAdd.getLastMonthDemand();
                    LocalDate recoveryDate = recoveryDataAdd.getDate();
                    Long noOfMonth = recoveryDataAdd.getNoOfMonths();

                    // Get the current date and month
                    LocalDate currentDate = LocalDate.now();
                    int currentMonth = currentDate.getMonthValue();
                    int currentYear = currentDate.getYear();

                    if (recoveryDate != null && recoveryDate.getMonthValue() == currentMonth && recoveryDate.getYear() == currentYear) {
                        // If the recovery date is in the current month and year, set perMonthDemand
                        updateRecoveryTypeDemand(recoveryTypesWithPerMonthDemand, recoveryType, perMonthDemand);
                    } else if (noOfMonth != null && noOfMonth == 1) {
                        // If the recovery date is in the future month, set regularMonthDemand
                        updateRecoveryTypeDemand(recoveryTypesWithPerMonthDemand, recoveryType, lastMonthDemand);
                    } else {
                        // If the recovery date is in the past month, set lastMonthDemand
                        updateRecoveryTypeDemand(recoveryTypesWithPerMonthDemand, recoveryType, regularMonthDemand);
                    }
                }
            }
        }
        List<String> allRecoveryTypes = getAllRecoveryTypes();
        for (String recovrytype : allRecoveryTypes) {
            if (!recoveryTypesWithPerMonthDemand.containsKey(recovrytype)) {
                recoveryTypesWithPerMonthDemand.put(recovrytype, 0L);
            }
        }

        return recoveryTypesWithPerMonthDemand;
    }

    private void updateRecoveryTypeDemand(Map<String, Long> recoveryTypesWithPerMonthDemand, String recoveryType, Long demand) {
        if (recoveryTypesWithPerMonthDemand.containsKey(recoveryType)) {
            // Add the demand to the existing value
            demand += recoveryTypesWithPerMonthDemand.get(recoveryType);
        }
        recoveryTypesWithPerMonthDemand.put(recoveryType, demand);
    }


    @Override
    public List<PayArrear> savePayArrears(PayArrear[] payArrears) {
        // Save each PayArrear individually
        List<PayArrear> savedArrears = new ArrayList<>();
        for (PayArrear arrear : payArrears) {
            savedArrears.add(payArrearRepo.save(arrear));
        }

        // Aggregated response data
        Map<String, PayArrear> aggregatedReports = new HashMap<>();

        for (PayArrear report : savedArrears) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                PayArrear existingReport = aggregatedReports.get(employeeId);
                existingReport.setBasicPay(existingReport.getBasicPay() + report.getBasicPay());
                existingReport.setPersonalPay(existingReport.getPersonalPay() + report.getPersonalPay());
                existingReport.setSpecialPay(existingReport.getSpecialPay() + report.getSpecialPay());
                existingReport.setDaArrear(existingReport.getDaArrear() + report.getDaArrear());
                existingReport.setHraArrear(existingReport.getHraArrear() + report.getHraArrear());
                existingReport.setCcaArrear(existingReport.getCcaArrear() + report.getCcaArrear());
                existingReport.setToBemisc1(existingReport.getToBemisc1() + report.getToBemisc1());
                existingReport.setTotalEarning(existingReport.getTotalEarning() + report.getTotalEarning());

                existingReport.setAlreadyBasicPay(existingReport.getAlreadyBasicPay() + report.getAlreadyBasicPay());
                existingReport.setAlreadyPersonalPay(existingReport.getAlreadyPersonalPay() + report.getAlreadyPersonalPay());
                existingReport.setAlreadySpecialPay(existingReport.getAlreadySpecialPay() + report.getAlreadySpecialPay());
                existingReport.setAlreadyDaArrear(existingReport.getAlreadyDaArrear() + report.getAlreadyDaArrear());
                existingReport.setAlreadyHraArrear(existingReport.getAlreadyHraArrear() + report.getAlreadyHraArrear());
                existingReport.setAlreadyCcaArrear(existingReport.getAlreadyCcaArrear() + report.getAlreadyCcaArrear());
                existingReport.setTotalDeductions(existingReport.getTotalDeductions() + report.getTotalDeductions());
                existingReport.setAlreadyMisc1(existingReport.getAlreadyMisc1() + report.getAlreadyMisc1());
                existingReport.setNetPay(existingReport.getNetPay() + report.getNetPay());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        // Convert aggregated reports to a list for response
        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<PayArrear> getPayArrearData(List<String> employeeIds, Long voucherNo) {
        return payArrearRepo.findAllByEmployeeIdInAndVoucherNo(employeeIds, voucherNo);
    }

    @Override
    public List<PayArrear> getAllPayArrearData() {
        return payArrearRepo.findAll();
    }

    @Override
    public void deletePayArrearById(Long id) {
        payArrearRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDataDto> getEmployeeData(List<String> employeeIds) {
        List<EmployeeDataDto> employeeDataList = new ArrayList<>();

        for (String employeeId : employeeIds) {
            EmployeePayRoll employee = employeePayRollRepo.findByEmployeeId(employeeId);
            if (employee != null) {
                List<PayArrear> payArrears = payArrearRepo.findByEmployeeId(employeeId);
                double alreadyDrawn = 0.0;

                double totalEarningsArrear = 0.0;
                double alreadyTotalEarningsArrear = 0.0;
                EmployeeDataDto employeeData = new EmployeeDataDto();
                employeeData.setEmployeeId(employee.getEmployeeId());
                employeeData.setEmployeeName(employee.getEmployeeName());
                employeeData.setNetPay(alreadyTotalEarningsArrear);
                employeeData.setTotalDifferenceOfArrear(alreadyTotalEarningsArrear);
                employeeData.setTotalEarning(totalEarningsArrear);
                employeeData.setTotalDeductions(alreadyDrawn);

                employeeDataList.add(employeeData);
            } else {
                // Handle case where employee is not found
            }
        }

        return employeeDataList;
    }

    @Override
    public Long findDaPercentageInRange(LocalDate fromDateParsed, LocalDate toDateParsed) {
        List<DaTax> daTaxList = daTaxRepo.findAll();

        for (DaTax daTax : daTaxList) {
            LocalDate fromDateTax = daTax.getFrom();
            LocalDate toDateTax = daTax.getTo(); // If 'to' date is null, consider current date
            if ((fromDateTax.isBefore(toDateParsed) || fromDateTax.isEqual(toDateParsed))
                    && (toDateTax.isAfter(fromDateParsed) || toDateTax.isEqual(fromDateParsed))) {
                return daTax.getDaPercentage();
            }
        }

        return null; // No DA percentage found in the given range
    }

    @Override
    public List<DaArrear> saveDaArrears(DaArrear[] daArrear) {

        List<DaArrear> savedArrears = new ArrayList<>();
        for (DaArrear arrear : daArrear) {
            savedArrears.add(daArrearRepo.save(arrear));
        }
        return savedArrears;
    }

    @Override
    public List<DaArrear> getDaArrearData(List<String> employeeIds, Long voucherNo) {
        return daArrearRepo.findAllByEmployeeIdInAndVoucherNo(employeeIds, voucherNo);
    }

    @Override
    public List<DaArrear> getAllDaArrearData() {
        return daArrearRepo.findAll();
    }

    @Override
    public void deleteDaArrearById(Long id) {
        daArrearRepo.deleteById(id);
    }

    @Override
    public List<DaEmployeeDto> getDaEmployeeData(List<String> employeeIds) {
        List<DaEmployeeDto> employeeDataList = new ArrayList<>();

        for (String employeeId : employeeIds) {
            EmployeePayRoll employee = employeePayRollRepo.findByEmployeeId(employeeId);
            if (employee != null) {
                List<DaArrear> daArrears = daArrearRepo.findByEmployeeId(employeeId);
                double alreadyDrawn = 0.0;
                double totalDifference = 0.0;
                double totalEarningsArrear = 0.0;
                DaEmployeeDto employeeData = new DaEmployeeDto();
                employeeData.setEmployeeId(employee.getEmployeeId());
                employeeData.setEmployeeName(employee.getEmployeeName());
                employeeData.setPfcps(employee.getPfcps());
                employeeData.setTotalDeductions(alreadyDrawn);
                employeeData.setNetPay(totalDifference);
                employeeData.setTotalEarning(totalEarningsArrear);

                employeeDataList.add(employeeData);
            } else {
                // Handle case where employee is not found
            }
        }

        return employeeDataList;
    }

    @Override
    public List<PersonalData> savePersonalData(PersonalData[] personalData) {
        List<PersonalData> savedData = personalDataRepo.saveAll(List.of(personalData));
        return savedData;
    }

//    @Override
//    public PersonalData getPersonalData(String employeeId) {
//        return personalDataRepo.findByEmployeeId(employeeId);
//    }

    @Override
    public List<PersonalData> getAllPersonalData() {
        return personalDataRepo.findAll();
    }

    @Override
    public PersonalData getPersonalByEmployeeId(String empId) {
        PersonalData responseData = personalDataRepo.findByEmployeeId(empId);
        return responseData;

    }

    @Override
    public void deleteAllPersonalData() {
        personalDataRepo.deleteAll();
    }

    @Override
    public TemporaryEmployeePayroll saveTemporaryEmployeePayRoll(TemporaryEmployeePayroll temporaryEmployeePayroll) {
        return temporaryEmployeeRepo.save(temporaryEmployeePayroll);
    }

    @Override
    public TemporaryEmployeePayroll getTemporaryEmployeePayRollById(Long nId) {
        return temporaryEmployeeRepo.findById(nId).orElse(null);
    }

    @Override
    public List<TemporaryEmployeePayroll> getAllTemporaryEmployeePayRoll() {
        return temporaryEmployeeRepo.findAll();
    }


    @Override
    public Concessional getConcentionalById(Long concentionalId) {
        return concentionalRepo.findById(concentionalId).orElse(null);
    }

    @Override
    public List<Concessional> getAllConcessData() {
        return concentionalRepo.findAll();
    }

    @Override
    public void deleteConcessById(Long concessionalId) {
        concentionalRepo.deleteById(concessionalId);
    }

    @Override
    public Concessional saveConcessional(Concessional concessional) {
        return concentionalRepo.save(concessional);
    }

    @Override
    public Double getConcessionValue(Double range, String officeCode) {
        List<Concessional> valueRange = concentionalRepo.findAll();

        for (Concessional CCARange : valueRange) {
            if (range >= CCARange.getPayRangeFrom() && range <= CCARange.getPayRangeTo()) {
                if (officeCode.equals("01") || officeCode.equals("02") || officeCode.equals("03") || officeCode.equals("04") || officeCode.equals("05") || officeCode.equals("06") || officeCode.equals("07") || officeCode.equals("08") || officeCode.equals("09") || officeCode.equals("11") || officeCode.equals("12") || officeCode.equals("13") || officeCode.equals("15") || officeCode.equals("16") || officeCode.equals("17") || officeCode.equals("19") || officeCode.equals("20") || officeCode.equals("21") || officeCode.equals("22") || officeCode.equals("23") || officeCode.equals("25") || officeCode.equals("26") || officeCode.equals("27") || officeCode.equals("29") || officeCode.equals("30") || officeCode.equals("31") || officeCode.equals("35") || officeCode.equals("38")) {
                    return CCARange.getGrade01();
                } else if (officeCode.equals("32") || officeCode.equals("33") || officeCode.equals("36") || officeCode.equals("37") || officeCode.equals("39") || officeCode.equals("40")) {
                    return CCARange.getGrade02();
                } else {
                    return (double) 0L;
                }
            }
        }

        return (double) 0L;
    }

    @Override
    public Long getProfessionalTaxAmount(LocalDate date) {
        List<ProfessionalTax> professionalTaxes = professionalTaxRepo.findAll();
        for (ProfessionalTax proValue : professionalTaxes) {
            if (date.getMonthValue() == 1 || date.getMonthValue() == 8) {
                return proValue.getValues();
            } else {
                return 0L;
            }
        }
        return null;
    }

    @Override
    public List<EmployeeDetails> getDamonthdata(LocalDate from, LocalDate to) {
        List<MonthlySalaryNewData> monthlySalaryNewDataList = monthlySalaryNewRepo.findAll();
        List<MonthlySalary> monthlySalaryList = monthlySalaryRepo.findAll();

        List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (MonthlySalaryNewData monthlySalaryNewData : monthlySalaryNewDataList) {
            for (MonthlySalary monthlySalary : monthlySalaryList) {
                if (monthlySalaryNewData.getMonthlySalary().getNId().equals(monthlySalary.getNId())) {
                    // Check if finacionalYearDate falls within the specified range
                    if (monthlySalary.getDateOfFA() != null && monthlySalary.getStatusFA().equals("Approved")) {
                        LocalDate financialYearDate = LocalDate.parse(monthlySalary.getFinacionalYearDate(), formatter);
                        if (!financialYearDate.isBefore(from) && !financialYearDate.isAfter(to)) {
                            EmployeeDetails employeeDetails = new EmployeeDetails();

                            Long basicAndPersonal = monthlySalaryNewData.getPersonalPay() + monthlySalaryNewData.getBasicPayEarning();
                            employeeDetails.setEmployeeId(monthlySalaryNewData.getEmployeeId());
                            employeeDetails.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                            //employeeDetails.setBasicPay(monthlySalaryNewData.getBasicPay());
                            //employeeDetails.setPersonalPay(monthlySalaryNewData.getPersonalPay());
                            //employeeDetails.setBasicAndPersonalPay(basicAndPersonal);
                            //employeeDetails.setDateOfFA(monthlySalary.getDateOfFA());
                            employeeDetailsList.add(employeeDetails);
                        }
                    }
                }
            }
        }
        return employeeDetailsList;
    }

    @Override
    public List<MonthlySalary> getMonthlySalaryList() {
        return monthlySalaryRepo.findAll();
    }

    @Override
    public List<MonthlySalaryNewData> getMonthlySalaryNewDataList() {
        return monthlySalaryNewRepo.findAll();
    }

    @Override
    public List<Map<String, Object>> filterAndGroupEmployeeDetails(
            List<MonthlySalaryNewData> monthlySalaryNewDataList,
            List<MonthlySalary> monthlySalaryList,
            LocalDate from,
            LocalDate to,
            DateTimeFormatter formatter,
            Long daDiff) {

        Map<String, EmployeeDetails> employeeDetailsMap = new HashMap<>();

        for (MonthlySalaryNewData monthlySalaryNewData : monthlySalaryNewDataList) {
            for (MonthlySalary monthlySalary : monthlySalaryList) {
                if (monthlySalaryNewData.getMonthlySalary().getNId().equals(monthlySalary.getNId())) {
                    if (monthlySalary.getDateOfFA() != null && "Approved".equals(monthlySalary.getStatusFA())) {
                        LocalDate financialYearDate = LocalDate.parse(monthlySalary.getDateOfFA(), formatter);

                        if (!financialYearDate.isBefore(from) && !financialYearDate.isAfter(to)) {
                            String employeeId = monthlySalaryNewData.getEmployeeId();
                            EmployeeDetails details = employeeDetailsMap.getOrDefault(employeeId, new EmployeeDetails());
                            if (monthlySalaryNewData.getPersonalPay() != null && monthlySalaryNewData.getBasicPayEarning() != null) {
                                Long basicAndPersonal = monthlySalaryNewData.getPersonalPay() + monthlySalaryNewData.getBasicPayEarning();
                                Long diffAmount = basicAndPersonal * daDiff / 100;


                                details.setEmployeeId(employeeId);
                                details.setEmployeeName(monthlySalaryNewData.getEmployeeName());
                                details.setPfcps(monthlySalaryNewData.getPfcps());
                                details.setDesignationCode(monthlySalaryNewData.getDesignationCode());
                                details.setDesignationName(monthlySalaryNewData.getDesignationName());
                                String month = financialYearDate.getMonth().toString().toLowerCase();
                                details.setMonthWiseSalary(month, basicAndPersonal);
                                details.setMonthWiseDiff(month, diffAmount);

                                employeeDetailsMap.put(employeeId, details);
                            }
                        }
                    }
                }
            }
        }

        List<Map<String, Object>> responseList = new ArrayList<>();
        Set<String> allMonths = new HashSet<>();

        for (EmployeeDetails details : employeeDetailsMap.values()) {
            allMonths.addAll(details.getMonthWiseSalary().keySet());
        }

        List<String> columnDefinitions = new ArrayList<>(Arrays.asList("Sno", "employeeId", "employeeName"));
        for (String month : allMonths) {
            columnDefinitions.add(month);
            columnDefinitions.add(month + "Diff");
        }

        for (EmployeeDetails details : employeeDetailsMap.values()) {
            Map<String, Object> response = new HashMap<>();
            response.put("Sno", responseList.size() + 1);
            response.put("employeeId", details.getEmployeeId());
            response.put("employeeName", details.getEmployeeName());
            response.put("designationName", details.getDesignationName());
            response.put("designationCode", details.getDesignationCode());
            response.put("pfCps", details.getPfcps());
            response.putAll(details.getMonthWiseSalary());
            response.putAll(details.getMonthWiseDiff());

            responseList.add(response);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("columnDefinitions", columnDefinitions);
        dataMap.put("data", responseList);

        List<Map<String, Object>> finalResponseList = new ArrayList<>();
        finalResponseList.add(dataMap);

        return finalResponseList;
    }

    @Override
    public List<TemporaryEmployeePayroll> getEmployeePayRollsByStatus(String status) {
        List<TemporaryEmployeePayroll> data = temporaryEmployeeRepo.findAll();

        List<TemporaryEmployeePayroll> filteredData;
        if ("Yes".equals(status)) {
            filteredData = data.stream()
                    .filter(employeePayRoll -> "Yes".equals(employeePayRoll.getPaymentStatus()))
                    .collect(Collectors.toList());
        } else if ("No".equals(status)) {
            filteredData = data.stream()
                    .filter(employeePayRoll -> "No".equals(employeePayRoll.getPaymentStatus()))
                    .collect(Collectors.toList());
        } else {
            filteredData = null;
        }

        return filteredData;
    }


    private double calculateDaAlreadyDrawn(List<DaArrear> daArrears) {
        double alreadyDrawn = 0;
        for (DaArrear arrear : daArrears) {
            alreadyDrawn += arrear.getTotalDeductions();
        }
        return alreadyDrawn;
    }

    private double calculateDaTotalDifference(EmployeePayRoll employee, List<DaArrear> daArrears) {
//        double totalDifferenceArrear = employee.getTotalEarning();
        double totalAlreadyDrawn = calculateDaAlreadyDrawn(daArrears);
        double totalDifference = 0;
        for (DaArrear arrear : daArrears) {
            totalDifference += arrear.getNetPay();

        }
        System.out.println(totalDifference);
        return totalDifference;
    }

    private double calculateDaTotalEarningArreare(List<DaArrear> daArrears) {
        double totalEarningsArrear = 0;
        for (DaArrear arrear : daArrears) {
            totalEarningsArrear += arrear.getTotalEarning();
        }
        return totalEarningsArrear;
    }


    private double calculateAlreadyDrawn(List<PayArrear> payArrears) {
        long alreadyDrawn = 0;
        for (PayArrear arrear : payArrears) {
            Double totalEarningsArrear = arrear.getTotalDeductions();
            if (totalEarningsArrear != null) {
                alreadyDrawn += totalEarningsArrear;
            }
        }
        return alreadyDrawn;
    }

    private double calculateTotalEarningArreare(List<PayArrear> payArrears) {
        double totalEarningsArrear = 0;
        for (PayArrear arrear : payArrears) {
            Double totalEarning = arrear.getTotalEarning();
            if (totalEarning != null) {
                totalEarningsArrear += totalEarning;
            }
        }
        return totalEarningsArrear;
    }

    private double calculateAlreadyTotalEarningsArrear(List<PayArrear> payArrears) {
        double totalAlreadyEarningsArrear = 0;
        for (PayArrear payArrear : payArrears) {
            Double alreadyTotalEarningsArrear = payArrear.getTotalDeductions();
            Double totalEarningsArrear = payArrear.getTotalEarning();

            if (alreadyTotalEarningsArrear != null && totalEarningsArrear != null) {
                double differenceOfArrear = totalEarningsArrear - alreadyTotalEarningsArrear;
                totalAlreadyEarningsArrear += differenceOfArrear;
            }
        }
        return totalAlreadyEarningsArrear;
    }


    private List<String> getAllRecoveryTypes() {
        List<String> recoveryModel = new ArrayList<>();
        recoveryModel.add("hba");
        recoveryModel.add("cpsArrear");
        recoveryModel.add("gpfArrear");
        recoveryModel.add("gpfLoan");
        recoveryModel.add("festivalAdvance");
        recoveryModel.add("conveyanceAdvance");
        recoveryModel.add("educationAdvance");
        recoveryModel.add("marriageAdvance");
        recoveryModel.add("payAdvance");
        recoveryModel.add("miscDeduction1");
        recoveryModel.add("miscDeduction2");

        // Add more recovery types as needed

        return recoveryModel;

    }

    private void saveConvenyanceAdvanceReport(RecoveryDataAdd recoveryDataAdd) {
        ConvenyanceAdvanceReport convenyanceAdvanceReport = new ConvenyanceAdvanceReport();
        convenyanceAdvanceReport.setConvenyanceId(30L); // Example value, adjust as per your logic
        convenyanceAdvanceReport.setEmployeeId(recoveryDataAdd.getRecoveryData().getEmployeeId());
        convenyanceAdvanceReport.setEmployeeName(recoveryDataAdd.getRecoveryData().getEmployeeName());
        convenyanceAdvanceReport.setConvenyanceAdvanceAmount(BigDecimal.valueOf(recoveryDataAdd.getPerMonthDemand()));
        convenyanceAdvanceReport.setBalanceAmount(recoveryDataAdd.getBalanceAmount());


        convenyanceAdvanceRepo.save(convenyanceAdvanceReport);
        System.out.println(convenyanceAdvanceReport);
    }

    @Override
    public List<MonthlySalaryNewData> saveMonthlySalaryId(MonthlysalaryData monthlysalaryData) {
        List<MonthlySalaryNewData> monthlySalaryNewData = monthlySalaryNewRepo.findAllById(monthlysalaryData.getId());

        for (MonthlySalaryNewData monthlySalaryNew : monthlySalaryNewData) {
            monthlySalaryNew.setMisc1(0L);
        }
        monthlySalaryNewRepo.saveAll(monthlySalaryNewData);


        return monthlySalaryNewData;
    }
}




