package org.example.Service;

import org.example.Entity.*;
import org.example.Repo.*;
//import org.example.dataDto.MiscDeductionDTO;
import org.example.dataDto.EmployeeMonthlySalaryDto;
import org.example.dataDto.EmployeePaySlipDto;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final PayArrearRepo payArrearRepo;

    private final MiscDeductionRepo miscDeductionRepo;

    private final PayAdvanceRepo payAdvanceRepo;

    private final MonthlySalaryNewRepo monthlysalarynewrepo;

    private final EducationAdvanceRepo educationAdvanceRepo;

    private final MarriageAdvanceRepo marriageAdvanceRepo;

    private final ConvenyanceAdvanceRepo convenyanceAdvanceRepo;

    private final FestivalAdvanceRepo festivalAdvanceRepo;

    private final NhisRepo nhisRepo;

    private final ProfessionalTaxReportRepo professionalTaxReportRepo;

    private final IncomeTaxReportRepo incomeTaxReportRepo;

    private final OneDayRecoveryRepo oneDayRecoveryRepo;

    private final CpsRepo cpsRepo;

    private final RentRepo rentRepo;

    private final FbfRepo fbfRepo;

    private final SpecialPfRepo specialPfRepo;

    private final GpfRepo gpfRepo;

    private final HbaRepo hbaRepo;

    private final MiseDeduction2Repo miseDeduction2Repo;

    private final MonthlySalaryRepo monthlysalaryrepo;


    public ReportServiceImpl(PayArrearRepo payArrearRepo, MiscDeductionRepo miscDeductionRepo,
                             PayAdvanceRepo payAdvanceRepo,
                             EducationAdvanceRepo educationAdvanceRepo,
                             MarriageAdvanceRepo marriageAdvanceRepo,
                             ConvenyanceAdvanceRepo convenyanceAdvanceRepo,
                             FestivalAdvanceRepo festivalAdvanceRepo, NhisRepo nhisRepo,
                             ProfessionalTaxReportRepo professionalTaxReportRepo, IncomeTaxReportRepo incomeTaxReportRepo, OneDayRecoveryRepo oneDayRecoveryRepo, CpsRepo cpsRepo, RentRepo rentRepo, FbfRepo fbfRepo, SpecialPfRepo specialPfRepo, GpfRepo gpfRepo, HbaRepo hbaRepo, MiseDeduction2Repo miseDeduction2Repo, MonthlySalaryNewRepo monthlysalarynewrepo, MonthlySalaryRepo monthlysalaryrepo) {
        this.payArrearRepo = payArrearRepo;
        this.miscDeductionRepo = miscDeductionRepo;
        this.payAdvanceRepo = payAdvanceRepo;
        this.educationAdvanceRepo = educationAdvanceRepo;
        this.marriageAdvanceRepo = marriageAdvanceRepo;
        this.convenyanceAdvanceRepo = convenyanceAdvanceRepo;
        this.festivalAdvanceRepo = festivalAdvanceRepo;
        this.nhisRepo = nhisRepo;
        this.professionalTaxReportRepo = professionalTaxReportRepo;
        this.incomeTaxReportRepo = incomeTaxReportRepo;
        this.oneDayRecoveryRepo = oneDayRecoveryRepo;
        this.cpsRepo = cpsRepo;
        this.rentRepo = rentRepo;
        this.fbfRepo = fbfRepo;
        this.specialPfRepo = specialPfRepo;
        this.gpfRepo = gpfRepo;
        this.hbaRepo = hbaRepo;
        this.miseDeduction2Repo = miseDeduction2Repo;
        this.monthlysalarynewrepo = monthlysalarynewrepo;
        this.monthlysalaryrepo = monthlysalaryrepo;
    }


//    @Override
//    public List<MiscDeductionReport> getAllMiscData() {
//        return miscDeductionRepo.findAll();
//    }


    @Override
    public List<MiscDeductionReport> getAllMiscData() {
        List<MiscDeductionReport> allReports = miscDeductionRepo.findAll();

        Map<String, MiscDeductionReport> aggregatedReports = new HashMap<>();

        for (MiscDeductionReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MiscDeductionReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setRecoveryAmount(existingReport.getRecoveryAmount().add(report.getRecoveryAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


//    @Override
//    public List<PayAdvanceReport> getAllPayData() {
//        return payAdvanceRepo.findAll();
//    }

    @Override
    public List<PayAdvanceReport> getAllPayData() {
        List<PayAdvanceReport> allReports = payAdvanceRepo.findAll();

        Map<String, PayAdvanceReport> aggregatedReports = new HashMap<>();

        for (PayAdvanceReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                PayAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setPayAdvanceAmount(existingReport.getPayAdvanceAmount().add(report.getPayAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

//    @Override
//    public List<EducationAdvanceReport> getAllEducationData() {
//        return educationAdvanceRepo.findAll();
//    }

    @Override
    public List<EducationAdvanceReport> getAllEducationData() {
        List<EducationAdvanceReport> allReports = educationAdvanceRepo.findAll();

        Map<String, EducationAdvanceReport> aggregatedReports = new HashMap<>();

        for (EducationAdvanceReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                EducationAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setEducationAdvanceAmount(existingReport.getEducationAdvanceAmount().add(report.getEducationAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


    //    @Override
//    public List<MarriageAdvanceReport> getAllMarriageData() {
//        return marriageAdvanceRepo.findAll();
//    }
    @Override
    public List<MarriageAdvanceReport> getAllMarriageData() {
        List<MarriageAdvanceReport> allReports = marriageAdvanceRepo.findAll();

        Map<String, MarriageAdvanceReport> aggregatedReports = new HashMap<>();

        for (MarriageAdvanceReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MarriageAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setMarriageAdvanceAmount(existingReport.getMarriageAdvanceAmount().add(report.getMarriageAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }
//    @Override
//    public List<ConvenyanceAdvanceReport> getAllConveyanceData() {
//        return convenyanceAdvanceRepo.findAll();
//    }

    @Override
    public List<ConvenyanceAdvanceReport> getAllConveyanceData() {
        List<ConvenyanceAdvanceReport> allReports = convenyanceAdvanceRepo.findAll();

        Map<String, ConvenyanceAdvanceReport> aggregatedReports = new HashMap<>();

        for (ConvenyanceAdvanceReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                ConvenyanceAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setConvenyanceAdvanceAmount(existingReport.getConvenyanceAdvanceAmount().add(report.getConvenyanceAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


//    @Override
//    public List<FestivalAdvanceReport> getAllFestivalData() {
//        return festivalAdvanceRepo.findAll();
//    }


    @Override
    public List<FestivalAdvanceReport> getAllFestivalData() {
        List<FestivalAdvanceReport> allReports = festivalAdvanceRepo.findAll();

        Map<String, FestivalAdvanceReport> aggregatedReports = new HashMap<>();

        for (FestivalAdvanceReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                FestivalAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setFestivalAdvanceAmount(existingReport.getFestivalAdvanceAmount().add(report.getFestivalAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }
//    @Override
//    public List<NhisReport> getAllNhisData() {
//        return nhisRepo.findAll();
//    }

    @Override
    public List<NhisReport> getAllNhisData() {
        List<NhisReport> allReports = nhisRepo.findAll();

        Map<String, NhisReport> aggregatedReports = new HashMap<>();

        for (NhisReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                NhisReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setNhisAmount(existingReport.getNhisAmount().add(report.getNhisAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<ProfessionalTaxReport> getAllPrpfessionalData() {
        List<ProfessionalTaxReport> allReports = professionalTaxReportRepo.findAll();

        Map<String, ProfessionalTaxReport> aggregatedReports = new HashMap<>();

        for (ProfessionalTaxReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                ProfessionalTaxReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setProfessionalTaxAmount(existingReport.getProfessionalTaxAmount().add(report.getProfessionalTaxAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<IncomeTaxReport> getAllIncomeTaxData() {
        List<IncomeTaxReport> allReports = incomeTaxReportRepo.findAll();

        Map<String, IncomeTaxReport> aggregatedReports = new HashMap<>();

        for (IncomeTaxReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                IncomeTaxReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the income tax and income tax cess
                existingReport.setIncomeTax(existingReport.getIncomeTax().add(report.getIncomeTax()));
                existingReport.setIncomeTaxCess(existingReport.getIncomeTaxCess().add(report.getIncomeTaxCess()));
                // Calculating total amount
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

//    @Override
//    public List<OneDayRecoveryReport> getAllOneDayRecoveryData() {
//        return oneDayRecoveryRepo.findAll();
//    }

    @Override
    public List<OneDayRecoveryReport> getAllOneDayRecoveryData() {
        List<OneDayRecoveryReport> allReports = oneDayRecoveryRepo.findAll();

        Map<String, OneDayRecoveryReport> aggregatedReports = new HashMap<>();

        for (OneDayRecoveryReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                OneDayRecoveryReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setDeductionAmount(existingReport.getDeductionAmount().add(report.getDeductionAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<CpsReport> getAllCpsData() {
        List<CpsReport> allReports = cpsRepo.findAll();

        Map<String, CpsReport> aggregatedReports = new HashMap<>();

        for (CpsReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                CpsReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the required fields
                existingReport.setCpsAmount(existingReport.getCpsAmount().add(report.getCpsAmount()));
                existingReport.setCpsArrear(existingReport.getCpsArrear().add(report.getCpsArrear()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

//    @Override
//    public List<RentReport> getAllRentData() {
//        return rentRepo.findAll();
//    }


    @Override
    public List<RentReport> getAllRentData() {
        List<RentReport> allReports = rentRepo.findAll();

        Map<String, RentReport> aggregatedReports = new HashMap<>();

        for (RentReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                RentReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the required fields
                existingReport.setRentAmount(existingReport.getRentAmount().add(report.getRentAmount()));
                existingReport.setWaterCharge(existingReport.getWaterCharge().add(report.getWaterCharge()));

                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


//    @Override
//    public List<FBFReport> getAllFBFData() {
//        return fbfRepo.findAll();
//    }


    @Override
    public List<FBFReport> getAllFBFData() {
        List<FBFReport> allReports = fbfRepo.findAll();

        Map<String, FBFReport> aggregatedReports = new HashMap<>();

        for (FBFReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                FBFReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the fbfAmount
                existingReport.setFbfAmount(existingReport.getFbfAmount().add(report.getFbfAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    //    @Override
//    public List<SpecialPfReport> getAllSpecialPfData() {
//        return specialPfRepo.findAll();
//    }
    @Override
    public List<SpecialPfReport> getAllSpecialPfData() {
        List<SpecialPfReport> allReports = specialPfRepo.findAll();

        Map<String, SpecialPfReport> aggregatedReports = new HashMap<>();

        for (SpecialPfReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                SpecialPfReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the specialPfAmount
                existingReport.setSpecialPfAmount(existingReport.getSpecialPfAmount().add(report.getSpecialPfAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }
//    @Override
//    public List<GpfReport> getAllGpfData() {
//        return gpfRepo.findAll();
//    }

    @Override
    public List<GpfReport> getAllGpfData() {
        List<GpfReport> allReports = gpfRepo.findAll();

        Map<String, GpfReport> aggregatedReports = new HashMap<>();

        for (GpfReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                GpfReport existingReport = aggregatedReports.get(employeeId);
                // Summing up the required fields
                existingReport.setGpfSub(existingReport.getGpfSub().add(report.getGpfSub()));
                existingReport.setGpfLoan(existingReport.getGpfLoan().add(report.getGpfLoan()));
                existingReport.setGpfArrear(existingReport.getGpfArrear().add(report.getGpfArrear()));
                existingReport.setVpf(existingReport.getVpf().add(report.getVpf()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

//    @Override
//    public List<HbaReport> getAllHbaData() {
//        return hbaRepo.findAll();
//    }

    @Override
    public List<HbaReport> getAllHbaData() {
        List<HbaReport> allReports = hbaRepo.findAll();

        Map<String, HbaReport> aggregatedReports = new HashMap<>();

        for (HbaReport report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                HbaReport existingReport = aggregatedReports.get(employeeId);

                existingReport.setHba(existingReport.getHba().add(report.getHba()));
                existingReport.setHbf(existingReport.getHbf().add(report.getHbf()));
                existingReport.setEoe(existingReport.getEoe().add(report.getEoe()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    //    @Override
//    public List<MiscDeductionReport2> getAllMisc2Data() {
//        return miseDeduction2Repo.findAll();
//    }
    @Override
    public List<MiscDeductionReport2> getAllMisc2Data() {
        List<MiscDeductionReport2> allReports = miseDeduction2Repo.findAll();

        Map<String, MiscDeductionReport2> aggregatedReports = new HashMap<>();

        for (MiscDeductionReport2 report : allReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MiscDeductionReport2 existingReport = aggregatedReports.get(employeeId);

                existingReport.setRecoveryAmount(existingReport.getRecoveryAmount().add(report.getRecoveryAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<MiscDeductionReport> getMiscDataByEmployeeId(String employeeId) {
        return miscDeductionRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<PayAdvanceReport> getPayDataByEmployeeId(String employeeId) {
        return payAdvanceRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<EducationAdvanceReport> getEducationDataByEmployeeId(String employeeId) {
        return educationAdvanceRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<MarriageAdvanceReport> getMarriageDataByEmployeeId(String employeeId) {
        return marriageAdvanceRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<ConvenyanceAdvanceReport> getConveyanceDataByEmployeeId(String employeeId) {
        return convenyanceAdvanceRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<FestivalAdvanceReport> getFestivalDataByEmployeeId(String employeeId) {
        return festivalAdvanceRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<NhisReport> getNhisDataByEmployeeId(String employeeId) {
        return nhisRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<ProfessionalTaxReport> getPrpfessionalDataByEmployeeId(String employeeId) {
        return professionalTaxReportRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<IncomeTaxReport> getIncomeTaxDataByEmployeeId(String employeeId) {
        return incomeTaxReportRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<OneDayRecoveryReport> getOneDayRecoveryDataByEmployeeId(String employeeId) {
        return oneDayRecoveryRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<CpsReport> getCpsDataByEmployeeId(String employeeId) {
        return cpsRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<RentReport> getRentDataByEmployeeId(String employeeId) {
        return rentRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<FBFReport> getFBFDataByEmployeeId(String employeeId) {
        return fbfRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<SpecialPfReport> getSpecialPfDataByEmployeeId(String employeeId) {
        return specialPfRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<GpfReport> getGpfDataByEmployeeId(String employeeId) {
        return gpfRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<HbaReport> getHbaDataByEmployeeId(String employeeId) {
        return hbaRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<MiscDeductionReport2> getMisc2DataByEmployeeId(String employeeId) {
        return miseDeduction2Repo.findByEmployeeId(employeeId);
    }

    @Override
    public List<MiscDeductionReport> getAllMiscData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<MiscDeductionReport> allReports = miscDeductionRepo.findAll();


        List<MiscDeductionReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, MiscDeductionReport> aggregatedReports = new HashMap<>();

        for (MiscDeductionReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MiscDeductionReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setRecoveryAmount(existingReport.getRecoveryAmount().add(report.getRecoveryAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<PayAdvanceReport> getAllPayData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<PayAdvanceReport> allReports = payAdvanceRepo.findAll();

        List<PayAdvanceReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, PayAdvanceReport> aggregatedReports = new HashMap<>();

        for (PayAdvanceReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                PayAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setPayAdvanceAmount(existingReport.getPayAdvanceAmount().add(report.getPayAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


    @Override
    public List<EducationAdvanceReport> getAllEducationData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<EducationAdvanceReport> allReports = educationAdvanceRepo.findAll();

        List<EducationAdvanceReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, EducationAdvanceReport> aggregatedReports = new HashMap<>();

        for (EducationAdvanceReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                EducationAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setEducationAdvanceAmount(existingReport.getEducationAdvanceAmount().add(report.getEducationAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<MarriageAdvanceReport> getAllMarriageData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<MarriageAdvanceReport> allReports = marriageAdvanceRepo.findAll();

        List<MarriageAdvanceReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, MarriageAdvanceReport> aggregatedReports = new HashMap<>();

        for (MarriageAdvanceReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MarriageAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setMarriageAdvanceAmount(existingReport.getMarriageAdvanceAmount().add(report.getMarriageAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<ConvenyanceAdvanceReport> getAllConveyanceData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<ConvenyanceAdvanceReport> allReports = convenyanceAdvanceRepo.findAll();

        List<ConvenyanceAdvanceReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, ConvenyanceAdvanceReport> aggregatedReports = new HashMap<>();

        for (ConvenyanceAdvanceReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                ConvenyanceAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setConvenyanceAdvanceAmount(existingReport.getConvenyanceAdvanceAmount().add(report.getConvenyanceAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<FestivalAdvanceReport> getAllFestivalData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<FestivalAdvanceReport> allReports = festivalAdvanceRepo.findAll();

        List<FestivalAdvanceReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, FestivalAdvanceReport> aggregatedReports = new HashMap<>();

        for (FestivalAdvanceReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                FestivalAdvanceReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setFestivalAdvanceAmount(existingReport.getFestivalAdvanceAmount().add(report.getFestivalAdvanceAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<NhisReport> getAllNhisData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<NhisReport> allReports = nhisRepo.findAll();

        List<NhisReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, NhisReport> aggregatedReports = new HashMap<>();

        for (NhisReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                NhisReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setNhisAmount(existingReport.getNhisAmount().add(report.getNhisAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<ProfessionalTaxReport> getAllProfessionalData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<ProfessionalTaxReport> allReports = professionalTaxReportRepo.findAll();

        List<ProfessionalTaxReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, ProfessionalTaxReport> aggregatedReports = new HashMap<>();

        for (ProfessionalTaxReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                ProfessionalTaxReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setProfessionalTaxAmount(existingReport.getProfessionalTaxAmount().add(report.getProfessionalTaxAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<IncomeTaxReport> getAllIncomeTaxData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<IncomeTaxReport> allReports = incomeTaxReportRepo.findAll();

        List<IncomeTaxReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, IncomeTaxReport> aggregatedReports = new HashMap<>();

        for (IncomeTaxReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                IncomeTaxReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setIncomeTax(existingReport.getIncomeTax().add(report.getIncomeTax()));
                existingReport.setIncomeTaxCess(existingReport.getIncomeTaxCess().add(report.getIncomeTaxCess()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<OneDayRecoveryReport> getAllOneDayRecoveryData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<OneDayRecoveryReport> allReports = oneDayRecoveryRepo.findAll();

        List<OneDayRecoveryReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, OneDayRecoveryReport> aggregatedReports = new HashMap<>();

        for (OneDayRecoveryReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                OneDayRecoveryReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setDeductionAmount(existingReport.getDeductionAmount().add(report.getDeductionAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<CpsReport> getAllCpsData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<CpsReport> allReports = cpsRepo.findAll();

        List<CpsReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, CpsReport> aggregatedReports = new HashMap<>();

        for (CpsReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                CpsReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setCpsAmount(existingReport.getCpsAmount().add(report.getCpsAmount()));
                existingReport.setCpsArrear(existingReport.getCpsArrear().add(report.getCpsArrear()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<RentReport> getAllRentData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<RentReport> allReports = rentRepo.findAll();

        List<RentReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, RentReport> aggregatedReports = new HashMap<>();

        for (RentReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                RentReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setRentAmount(existingReport.getRentAmount().add(report.getRentAmount()));
                existingReport.setWaterCharge(existingReport.getWaterCharge().add(report.getWaterCharge()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<FBFReport> getAllFBFData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<FBFReport> allReports = fbfRepo.findAll();

        List<FBFReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, FBFReport> aggregatedReports = new HashMap<>();

        for (FBFReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                FBFReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setFbfAmount(existingReport.getFbfAmount().add(report.getFbfAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<SpecialPfReport> getAllSpecialPfData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<SpecialPfReport> allReports = specialPfRepo.findAll();

        List<SpecialPfReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, SpecialPfReport> aggregatedReports = new HashMap<>();

        for (SpecialPfReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                SpecialPfReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setSpecialPfAmount(existingReport.getSpecialPfAmount().add(report.getSpecialPfAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<GpfReport> getAllGpfData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<GpfReport> allReports = gpfRepo.findAll();

        List<GpfReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, GpfReport> aggregatedReports = new HashMap<>();

        for (GpfReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                GpfReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setGpfSub(existingReport.getGpfSub().add(report.getGpfSub()));
                existingReport.setGpfLoan(existingReport.getGpfLoan().add(report.getGpfLoan()));
                existingReport.setGpfArrear(existingReport.getGpfArrear().add(report.getGpfArrear()));
                existingReport.setVpf(existingReport.getVpf().add(report.getVpf()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<HbaReport> getAllHbaData(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<HbaReport> allReports = hbaRepo.findAll();

        List<HbaReport> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, HbaReport> aggregatedReports = new HashMap<>();

        for (HbaReport report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                HbaReport existingReport = aggregatedReports.get(employeeId);
                existingReport.setHba(existingReport.getHba().add(report.getHba()));
                existingReport.setHbf(existingReport.getHbf().add(report.getHbf()));
                existingReport.setEoe(existingReport.getEoe().add(report.getEoe()));
                existingReport.setTotalAmount(existingReport.getTotalAmount().add(report.getTotalAmount()));
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }

    @Override
    public List<MiscDeductionReport2> getAllMisc2Data(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<MiscDeductionReport2> allReports = miseDeduction2Repo.findAll();

        List<MiscDeductionReport2> filteredReports = allReports.stream()
                .filter(report -> {
                    LocalDate reportDate = LocalDate.parse(report.getDate(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        Map<String, MiscDeductionReport2> aggregatedReports = new HashMap<>();

        for (MiscDeductionReport2 report : filteredReports) {
            String employeeId = report.getEmployeeId();

            if (aggregatedReports.containsKey(employeeId)) {
                MiscDeductionReport2 existingReport = aggregatedReports.get(employeeId);
                existingReport.setRecoveryAmount(existingReport.getRecoveryAmount().add(report.getRecoveryAmount()));
                existingReport.setBalanceAmount(report.getBalanceAmount());
            } else {
                aggregatedReports.put(employeeId, report);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }


    @Override
    public List<EmployeeMonthlySalaryDto> getEmployeeIdAndMonthlySalary(String employeeId, LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        List<MonthlySalaryNewData> results = monthlysalarynewrepo.findByEmployeeId(employeeId);

        // Ensure lazy-loaded properties are initialized
        results.forEach(result -> Hibernate.initialize(result.getMonthlySalary()));

        // Filter reports within the specified date range
        List<MonthlySalaryNewData> filteredResults = results.stream()
                .filter(result -> {
                    LocalDate reportDate = LocalDate.parse(result.getMonthlySalary().getDateOfFA(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        // Aggregate reports by employee
        Map<String, EmployeeMonthlySalaryDto> aggregatedReports = new HashMap<>();

        for (MonthlySalaryNewData result : filteredResults) {
            String empId = result.getEmployeeId();

            long cps = result.getCps() != null ? result.getCps() : 0L;
            long cpsArrear = result.getCpsArrear() != null ? result.getCpsArrear() : 0L;
            long gpfSub = result.getGpfSub() != null ? result.getGpfSub() : 0L;
            long gpfArrear = result.getGpfArrear() != null ? result.getGpfArrear() : 0L;
            long personalPay = result.getPersonalPay() != null ? result.getPersonalPay() : 0L;
            long hra = result.getHra() != null ? result.getHra() : 0L;
            long cca = result.getCca() != null ? result.getCca() : 0L;
            long specialPay = result.getSpecialPay() != null ? result.getSpecialPay() : 0L;
            long misc1 = result.getMisc1() != null ? result.getMisc1() : 0L;
            long da = result.getDa() != null ? result.getDa() : 0L;
            String basicPay = result.getBasicPay() != null ? result.getBasicPay() : "0";

            if (aggregatedReports.containsKey(empId)) {
                EmployeeMonthlySalaryDto existingDto = aggregatedReports.get(empId);

                existingDto.setCps(existingDto.getCps() + cps);
                existingDto.setCpsArrear(existingDto.getCpsArrear() + cpsArrear);
                existingDto.setGpfSub(existingDto.getGpfSub() + gpfSub);
                existingDto.setGpfArrear(existingDto.getGpfArrear() + gpfArrear);
                existingDto.setAlreadyPersonalPay(existingDto.getAlreadyPersonalPay() + personalPay);
                existingDto.setAlreadyHraArrear(existingDto.getAlreadyHraArrear() + hra);
                existingDto.setAlreadyCcaArrear(existingDto.getAlreadyCcaArrear() + cca);
                existingDto.setAlreadySpecialPay(existingDto.getAlreadySpecialPay() + specialPay);
                existingDto.setAlreadyMisc1(existingDto.getAlreadyMisc1() + misc1);
                existingDto.setAlreadyDaArrear(existingDto.getAlreadyDaArrear() + da);
                existingDto.setAlreadyBasicPay(Integer.toString(
                        Integer.parseInt(existingDto.getAlreadyBasicPay()) + Integer.parseInt(basicPay)
                ));
            } else {
                EmployeeMonthlySalaryDto newDto = new EmployeeMonthlySalaryDto(
                        result.getEmployeeId(),
                        result.getMonthlySalary().getNetPay(),
                        result.getMonthlySalary().getNId(),
                        result.getMonthlySalary().getVoucherNo(),
                        result.getMonthlySalary().getTotalEarning(),
                        result.getMonthlySalary().getTotalDeductions(),
                        result.getMonthlySalary().getDateOfFA(),
                        cps,
                        cpsArrear,
                        gpfSub,
                        gpfArrear,
                        personalPay,
                        hra,
                        cca,
                        specialPay,
                        misc1,
                        da,
                        basicPay,
                        fromDate,
                        toDate
                );
                aggregatedReports.put(empId, newDto);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }



    @Override
    public List<EmployeeMonthlySalaryDto> getEmployeeIdAndMonthlySalaryDashboard(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        List<MonthlySalaryNewData> allResults = monthlysalarynewrepo.findAll();

        // Ensure lazy-loaded properties are initialized
        allResults.forEach(result -> Hibernate.initialize(result.getMonthlySalary()));

        // Filter reports within the specified date range
        List<MonthlySalaryNewData> filteredResults = allResults.stream()
                .filter(result -> {
                    LocalDate reportDate = LocalDate.parse(result.getMonthlySalary().getDateOfFA(), formatter);
                    return (reportDate.isEqual(fromDate) || reportDate.isAfter(fromDate)) &&
                            (reportDate.isEqual(toDate) || reportDate.isBefore(toDate));
                })
                .collect(Collectors.toList());

        // Aggregate reports by employee
        Map<String, EmployeeMonthlySalaryDto> aggregatedReports = new HashMap<>();

        for (MonthlySalaryNewData result : filteredResults) {
            String empId = result.getEmployeeId();

            long cps = result.getCps() != null ? result.getCps() : 0L;
            long cpsArrear = result.getCpsArrear() != null ? result.getCpsArrear() : 0L;
            long gpfSub = result.getGpfSub() != null ? result.getGpfSub() : 0L;
            long gpfArrear = result.getGpfArrear() != null ? result.getGpfArrear() : 0L;
            long personalPay = result.getPersonalPay() != null ? result.getPersonalPay() : 0L;
            long hra = result.getHra() != null ? result.getHra() : 0L;
            long cca = result.getCca() != null ? result.getCca() : 0L;
            long specialPay = result.getSpecialPay() != null ? result.getSpecialPay() : 0L;
            long misc1 = result.getMisc1() != null ? result.getMisc1() : 0L;
            long da = result.getDa() != null ? result.getDa() : 0L;
            String basicPay = result.getBasicPay() != null ? result.getBasicPay() : "0";

            if (aggregatedReports.containsKey(empId)) {
                EmployeeMonthlySalaryDto existingDto = aggregatedReports.get(empId);

                existingDto.setCps(existingDto.getCps() + cps);
                existingDto.setCpsArrear(existingDto.getCpsArrear() + cpsArrear);
                existingDto.setGpfSub(existingDto.getGpfSub() + gpfSub);
                existingDto.setGpfArrear(existingDto.getGpfArrear() + gpfArrear);
                existingDto.setAlreadyPersonalPay(existingDto.getAlreadyPersonalPay() + personalPay);
                existingDto.setAlreadyHraArrear(existingDto.getAlreadyHraArrear() + hra);
                existingDto.setAlreadyCcaArrear(existingDto.getAlreadyCcaArrear() + cca);
                existingDto.setAlreadySpecialPay(existingDto.getAlreadySpecialPay() + specialPay);
                existingDto.setAlreadyMisc1(existingDto.getAlreadyMisc1() + misc1);
                existingDto.setAlreadyDaArrear(existingDto.getAlreadyDaArrear() + da);
                existingDto.setAlreadyBasicPay(Integer.toString(
                        Integer.parseInt(existingDto.getAlreadyBasicPay()) + Integer.parseInt(basicPay)
                ));
            } else {
                EmployeeMonthlySalaryDto newDto = new EmployeeMonthlySalaryDto(
                        result.getEmployeeId(),
                        result.getMonthlySalary().getNetPay(),
                        result.getMonthlySalary().getNId(),
                        result.getMonthlySalary().getVoucherNo(),
                        result.getMonthlySalary().getTotalEarning(),
                        result.getMonthlySalary().getTotalDeductions(),
                        result.getMonthlySalary().getDateOfFA(),
                        cps,
                        cpsArrear,
                        gpfSub,
                        gpfArrear,
                        personalPay,
                        hra,
                        cca,
                        specialPay,
                        misc1,
                        da,
                        basicPay,
                        fromDate,
                        toDate
                );
                aggregatedReports.put(empId, newDto);
            }
        }

        return new ArrayList<>(aggregatedReports.values());
    }














    @Override
    public List<EmployeePaySlipDto> getPaySlip(String employeeId, int month, int year) {
        List<EmployeePaySlipDto> paySlips = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


        List<MonthlySalaryNewData> results = monthlysalarynewrepo.findByEmployeeId(employeeId);


        List<MonthlySalaryNewData> filteredResults = results.stream()
                .filter(result -> {
                    String dateOfFAString = result.getMonthlySalary().getDateOfFA();
                    if (dateOfFAString != null) {
                        LocalDate dateOfFA = LocalDate.parse(dateOfFAString, formatter);
                        return dateOfFA.getMonthValue() == month && dateOfFA.getYear() == year;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        for (MonthlySalaryNewData data : filteredResults) {

            Long numberOfWorkingDays = Optional.ofNullable(data.getNumberOfWorkingDays()).orElse(0L);

            System.out.println(numberOfWorkingDays);


            long lossOfPay = daysInMonth - numberOfWorkingDays;
            long difference = daysInMonth - numberOfWorkingDays;

            System.out.println(difference);

            // Check if there's existing EmployeePaySlipDto for the same employeeId
            EmployeePaySlipDto existingPaySlip = paySlips.stream()
                    .filter(paySlip -> paySlip.getEmployeeId().equals(employeeId))
                    .findFirst()
                    .orElse(null);

            if (existingPaySlip != null) {
                existingPaySlip.setTotalEarning((existingPaySlip.getTotalEarning() != null ? existingPaySlip.getTotalEarning() : 0L) + (data.getTotalEarning() != null ? data.getTotalEarning() : 0L));
                existingPaySlip.setTotalDeductions((existingPaySlip.getTotalDeductions() != null ? existingPaySlip.getTotalDeductions() : 0L) + (data.getTotalDeductions() != null ? data.getTotalDeductions() : 0L));
                existingPaySlip.setNetPay((existingPaySlip.getNetPay() != null ? existingPaySlip.getNetPay() : 0L) + (data.getNetPay() != null ? data.getNetPay() : 0L));
                existingPaySlip.setBasicPayEarning((existingPaySlip.getBasicPayEarning() != null ? existingPaySlip.getBasicPayEarning() : 0L) + (data.getBasicPayEarning() != null ? data.getBasicPayEarning() : 0L));
                existingPaySlip.setDa((existingPaySlip.getDa() != null ? existingPaySlip.getDa() : 0L) + (data.getDa() != null ? data.getDa() : 0L));
                existingPaySlip.setCca((existingPaySlip.getCca() != null ? existingPaySlip.getCca() : 0L) + (data.getCca() != null ? data.getCca() : 0L));
                existingPaySlip.setHba((existingPaySlip.getHba() != null ? existingPaySlip.getHba() : 0L) + (data.getHba() != null ? data.getHba() : 0L));
                existingPaySlip.setHbf((existingPaySlip.getHbf() != null ? existingPaySlip.getHbf() : 0L) + (data.getHbf() != null ? data.getHbf() : 0L));
                existingPaySlip.setRentDeductions((existingPaySlip.getRentDeductions() != null ? existingPaySlip.getRentDeductions() : 0L) + (data.getRentDeductions() != null ? data.getRentDeductions() : 0L));
                existingPaySlip.setWaterCharges((existingPaySlip.getWaterCharges() != null ? existingPaySlip.getWaterCharges() : 0L) + (data.getWaterCharges() != null ? data.getWaterCharges() : 0L));
                existingPaySlip.setGpfSub((existingPaySlip.getGpfSub() != null ? existingPaySlip.getGpfSub() : 0L) + (data.getGpfSub() != null ? data.getGpfSub() : 0L));
                existingPaySlip.setGpfArrear((existingPaySlip.getGpfArrear() != null ? existingPaySlip.getGpfArrear() : 0L) + (data.getGpfArrear() != null ? data.getGpfArrear() : 0L));
                existingPaySlip.setCps((existingPaySlip.getCps() != null ? existingPaySlip.getCps() : 0L) + (data.getCps() != null ? data.getCps() : 0L));
                existingPaySlip.setProfessionalTax((existingPaySlip.getProfessionalTax() != null ? existingPaySlip.getProfessionalTax() : 0L) + (data.getProfessionalTax() != null ? data.getProfessionalTax() : 0L));
                existingPaySlip.setOneDayRecovery((existingPaySlip.getOneDayRecovery() != null ? existingPaySlip.getOneDayRecovery() : 0L) + (data.getOneDayRecovery() != null ? data.getOneDayRecovery() : 0L));
                existingPaySlip.setIncomeTax((existingPaySlip.getIncomeTax() != null ? existingPaySlip.getIncomeTax() : 0L) + (data.getIncomeTax() != null ? data.getIncomeTax() : 0L));
                existingPaySlip.setCpsArrear((existingPaySlip.getCpsArrear() != null ? existingPaySlip.getCpsArrear() : 0L) + (data.getCpsArrear() != null ? data.getCpsArrear() : 0L));
                existingPaySlip.setIncomeTaxCess((existingPaySlip.getIncomeTaxCess() != null ? existingPaySlip.getIncomeTaxCess() : 0L) + (data.getIncomeTaxCess() != null ? data.getIncomeTaxCess() : 0L));
                existingPaySlip.setEoe((existingPaySlip.getEoe() != null ? existingPaySlip.getEoe() : 0L) + (data.getEoe() != null ? data.getEoe() : 0L));
                existingPaySlip.setFestivalAdvance((existingPaySlip.getFestivalAdvance() != null ? existingPaySlip.getFestivalAdvance() : 0L) + (data.getFestivalAdvance() != null ? data.getFestivalAdvance() : 0L));
                existingPaySlip.setConveyanceAdvance((existingPaySlip.getConveyanceAdvance() != null ? existingPaySlip.getConveyanceAdvance() : 0L) + (data.getConveyanceAdvance() != null ? data.getConveyanceAdvance() : 0L));
                existingPaySlip.setEducationAdvance((existingPaySlip.getEducationAdvance() != null ? existingPaySlip.getEducationAdvance() : 0L) + (data.getEducationAdvance() != null ? data.getEducationAdvance() : 0L));
                existingPaySlip.setMarriageAdvance((existingPaySlip.getMarriageAdvance() != null ? existingPaySlip.getMarriageAdvance() : 0L) + (data.getMarriageAdvance() != null ? data.getMarriageAdvance() : 0L));
                existingPaySlip.setPayAdvance((existingPaySlip.getPayAdvance() != null ? existingPaySlip.getPayAdvance() : 0L) + (data.getPayAdvance() != null ? data.getPayAdvance() : 0L));
                existingPaySlip.setMiscDeduction1((existingPaySlip.getMiscDeduction1() != null ? existingPaySlip.getMiscDeduction1() : 0L) + (data.getMiscDeduction1() != null ? data.getMiscDeduction1() : 0L));
                existingPaySlip.setMiscDeduction2((existingPaySlip.getMiscDeduction2() != null ? existingPaySlip.getMiscDeduction2() : 0L) + (data.getMiscDeduction2() != null ? data.getMiscDeduction2() : 0L));
                existingPaySlip.setGpfLoan((existingPaySlip.getGpfLoan() != null ? existingPaySlip.getGpfLoan() : 0L) + (data.getGpfLoan() != null ? data.getGpfLoan() : 0L));
                existingPaySlip.setSpecialPay((existingPaySlip.getSpecialPay() != null ? existingPaySlip.getSpecialPay() : 0L) + (data.getSpecialPay() != null ? data.getSpecialPay() : 0L));
                existingPaySlip.setPersonalPay((existingPaySlip.getPersonalPay() != null ? existingPaySlip.getPersonalPay() : 0L) + (data.getPersonalPay() != null ? data.getPersonalPay() : 0L));
                existingPaySlip.setHra((existingPaySlip.getHra() != null ? existingPaySlip.getHra() : 0L) + (data.getHra() != null ? data.getHra() : 0L));
                existingPaySlip.setHrr((existingPaySlip.getHrr() != null ? existingPaySlip.getHrr() : 0L) + (data.getHrr() != null ? data.getHrr() : 0L));
                existingPaySlip.setFta((existingPaySlip.getFta() != null ? existingPaySlip.getFta() : 0L) + (data.getFta() != null ? data.getFta() : 0));
                existingPaySlip.setOfficeCode(data.getOfficeCode());
                existingPaySlip.setOfficeName(data.getOfficeName());

            } else {
                EmployeePaySlipDto paySlipDto = new EmployeePaySlipDto();
                paySlipDto.setEmployeeId(employeeId);
                paySlipDto.setBasicPayEarning(data.getBasicPayEarning());
                paySlipDto.setDa(data.getDa());
                paySlipDto.setCca(data.getCca());
                paySlipDto.setHba(data.getHba());
                paySlipDto.setHbf(data.getHbf());
                paySlipDto.setEmployeeName(data.getEmployeeName());
                paySlipDto.setTotalEarning(data.getTotalEarning());
                paySlipDto.setTotalDeductions(data.getTotalDeductions());
                paySlipDto.setNetPay(data.getNetPay());
                paySlipDto.setDesignationName(data.getDesignationName());
                paySlipDto.setDesignationCode(data.getDesignationCode());
                paySlipDto.setRentDeductions(data.getRentDeductions());
                paySlipDto.setWashingAllowance(data.getWashingAllowance());
                paySlipDto.setCashAllowance(data.getCashAllowance());
                paySlipDto.setInterimRelief(data.getInterimRelief());
                paySlipDto.setMisc1(data.getMisc1());
                paySlipDto.setVpf(data.getVpf());
                paySlipDto.setFbf(data.getFbf());
                paySlipDto.setNhis(data.getNhis());
                paySlipDto.setSpecialPf(data.getSpecialPf());
                paySlipDto.setMedicalAllowance(data.getMedicalAllowance());
                paySlipDto.setWaterCharges(data.getWaterCharges());
                paySlipDto.setGpfSub(data.getGpfSub());
                paySlipDto.setGpfArrear(data.getGpfArrear());
                paySlipDto.setCps(data.getCps());
                paySlipDto.setProfessionalTax(data.getProfessionalTax());
                paySlipDto.setOneDayRecovery(data.getOneDayRecovery());
                paySlipDto.setIncomeTax(data.getIncomeTax());
                paySlipDto.setCpsArrear(data.getCpsArrear());
                paySlipDto.setIncomeTaxCess(data.getIncomeTaxCess());
                paySlipDto.setHrr(data.getHrr());
                paySlipDto.setHra(data.getHra());
                paySlipDto.setFta(data.getFta());
                paySlipDto.setHillAllowance(data.getHillAllowance());
                paySlipDto.setWinterAllowance(data.getWinterAllowance());
                paySlipDto.setConveyanceAllowanceEarnings(data.getConveyanceAllowanceEarnings());
                paySlipDto.setEoe(data.getEoe());
                paySlipDto.setFestivalAdvance(data.getFestivalAdvance());
                paySlipDto.setConveyanceAdvance(data.getConveyanceAdvance());
                paySlipDto.setEducationAdvance(data.getEducationAdvance());
                paySlipDto.setMarriageAdvance(data.getMarriageAdvance());
                paySlipDto.setPayAdvance(data.getPayAdvance());
                paySlipDto.setMiscDeduction1(data.getMiscDeduction1());
                paySlipDto.setMiscDeduction2(data.getMiscDeduction2());
                paySlipDto.setGpfLoan(data.getGpfLoan());
                paySlipDto.setSpecialPay(data.getSpecialPay());
                paySlipDto.setNumberOfWorkingDays(data.getNumberOfWorkingDays());
                paySlipDto.setPfcps(data.getPfcps());
                paySlipDto.setBankName(data.getBankName());
                paySlipDto.setBankAcNo(data.getBankAcNo());
                paySlipDto.setBankBranchName(data.getBankBranchName());
                paySlipDto.setBankIFSC(data.getBankIFSC());
                paySlipDto.setRent(data.getRent());
                paySlipDto.setPayStatus(data.getPayStatus());
                paySlipDto.setDifference((int) difference);
                paySlipDto.setTotalDays(daysInMonth);
                paySlipDto.setRentDeductions(data.getRentDeductions());
                paySlipDto.setDateOfJoiningService(data.getDateOfJoiningService());
                paySlipDto.setPersonalPay(data.getPersonalPay());
                paySlipDto.setOfficeCode(data.getOfficeCode());


                paySlips.add(paySlipDto);
            }
        }

        return paySlips;
    }



    @Override
    public List<MonthlySalaryNewData> getAggregatedMonthlySalaries() {
        // Fetch all monthly salary data
        List<MonthlySalaryNewData> allData = monthlysalarynewrepo.findAll();

        // Filter based on approved status
        List<MonthlySalaryNewData> approvedData = allData.stream()
                .filter(msnd -> "Approved".equals(msnd.getMonthlySalary().getStatusFA()))
                .collect(Collectors.toList());

        // Return the filtered list
        return approvedData;
    }


    @Override
    public List<String> getEmployeeId() {
        // Fetch all monthly salary data
        List<MonthlySalaryNewData> allData = monthlysalarynewrepo.findAll();

        // Filter based on approved status, map to employee IDs, and get distinct IDs
        List<String> employeeIds = allData.stream()
                .filter(msnd -> "Approved".equals(msnd.getMonthlySalary().getStatusFA()))
                .map(MonthlySalaryNewData::getEmployeeId)
                .distinct()
                .collect(Collectors.toList());

        // Return the list of distinct employee IDs
        return employeeIds;
    }


    @Override

    public List<MonthlySalaryNewData> getAggregatedMonthlySalaries(LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        List<MonthlySalaryNewData> allData = monthlysalarynewrepo.findAll();

        // Filter approved data and apply date range
        List<MonthlySalaryNewData> filteredData = allData.stream()
                .filter(data -> {
                    // Check if the status is Approved
                    boolean isApproved = "Approved".equals(data.getMonthlySalary().getStatusFA());
                    if (isApproved) {

                        // Parse the date and check if it falls within the given range
                        LocalDate salaryDate = LocalDate.parse(data.getMonthlySalary().getDate(), formatter);
                        return !salaryDate.isBefore(fromDate) && !salaryDate.isAfter(toDate);
                    }
                    return false; // If not approved, filter out
                })
                .collect(Collectors.toList());

        // Aggregate the data by employeeId
        Map<String, MonthlySalaryNewData> aggregatedData = new HashMap<>();
        for (MonthlySalaryNewData data : filteredData) {
            String key = data.getEmployeeId();

            if (aggregatedData.containsKey(key)) {
                MonthlySalaryNewData existingData = aggregatedData.get(key);
                sumLongFields(existingData, data); // Sum numeric fields
            } else {
                aggregatedData.put(key, data);
            }
        }

        return new ArrayList<>(aggregatedData.values());
    }

    private void sumLongFields(MonthlySalaryNewData existingReport, MonthlySalaryNewData newReport) {
        if (existingReport.getTotalEarning() != null && newReport.getTotalEarning() != null) {
            existingReport.setTotalEarning(sum(existingReport.getTotalEarning(), newReport.getTotalEarning()));
        }
        if (existingReport.getTotalDeductions() != null && newReport.getTotalDeductions() != null) {
            existingReport.setTotalDeductions(sum(existingReport.getTotalDeductions(), newReport.getTotalDeductions()));
        }
        if (existingReport.getNetPay() != null && newReport.getNetPay() != null) {
            existingReport.setNetPay(sum(existingReport.getNetPay(), newReport.getNetPay()));
        }
        if (existingReport.getBasicPay() != null && newReport.getBasicPay() != null) {
            existingReport.setBasicPay(sum1(existingReport.getBasicPay(), newReport.getBasicPay()));
        }
        if (existingReport.getRent() != null && newReport.getRent() != null) {
            existingReport.setRent(sum1(existingReport.getRent(), newReport.getRent()));
        }
        if (existingReport.getBasicPayEarning() != null && newReport.getBasicPayEarning() != null) {
            existingReport.setBasicPayEarning(sum(existingReport.getBasicPayEarning(), newReport.getBasicPayEarning()));
        }
        if (existingReport.getPersonalPay() != null && newReport.getPersonalPay() != null) {
            existingReport.setPersonalPay(sum(existingReport.getPersonalPay(), newReport.getPersonalPay()));
        }
        if (existingReport.getSpecialPay() != null && newReport.getSpecialPay() != null) {
            existingReport.setSpecialPay(sum(existingReport.getSpecialPay(), newReport.getSpecialPay()));
        }
        if (existingReport.getDa() != null && newReport.getDa() != null) {
            existingReport.setDa(sum(existingReport.getDa(), newReport.getDa()));
        }
        if (existingReport.getHra() != null && newReport.getHra() != null) {
            existingReport.setHra(sum(existingReport.getHra(), newReport.getHra()));
        }
        if (existingReport.getHrr() != null && newReport.getHrr() != null) {
            existingReport.setHrr(sum(existingReport.getHrr(), newReport.getHrr()));
        }
        if (existingReport.getCca() != null && newReport.getCca() != null) {
            existingReport.setCca(sum(existingReport.getCca(), newReport.getCca()));
        }
        if (existingReport.getMedicalAllowance() != null && newReport.getMedicalAllowance() != null) {
            existingReport.setMedicalAllowance(sum(existingReport.getMedicalAllowance(), newReport.getMedicalAllowance()));
        }
        if (existingReport.getFta() != null && newReport.getFta() != null) {
            existingReport.setFta(sum(existingReport.getFta(), newReport.getFta()));
        }
        if (existingReport.getHillAllowance() != null && newReport.getHillAllowance() != null) {
            existingReport.setHillAllowance(sum(existingReport.getHillAllowance(), newReport.getHillAllowance()));
        }
        if (existingReport.getWinterAllowance() != null && newReport.getWinterAllowance() != null) {
            existingReport.setWinterAllowance(sum(existingReport.getWinterAllowance(), newReport.getWinterAllowance()));
        }
        if (existingReport.getWashingAllowance() != null && newReport.getWashingAllowance() != null) {
            existingReport.setWashingAllowance(sum(existingReport.getWashingAllowance(), newReport.getWashingAllowance()));
        }
        if (existingReport.getConveyanceAllowanceEarnings() != null && newReport.getConveyanceAllowanceEarnings() != null) {
            existingReport.setConveyanceAllowanceEarnings(sum(existingReport.getConveyanceAllowanceEarnings(), newReport.getConveyanceAllowanceEarnings()));
        }
        if (existingReport.getCashAllowance() != null && newReport.getCashAllowance() != null) {
            existingReport.setCashAllowance(sum(existingReport.getCashAllowance(), newReport.getCashAllowance()));
        }
        if (existingReport.getInterimRelief() != null && newReport.getInterimRelief() != null) {
            existingReport.setInterimRelief(sum(existingReport.getInterimRelief(), newReport.getInterimRelief()));
        }
        if (existingReport.getMisc1() != null && newReport.getMisc1() != null) {
            existingReport.setMisc1(sum(existingReport.getMisc1(), newReport.getMisc1()));
        }
        if (existingReport.getGpfSub() != null && newReport.getGpfSub() != null) {
            existingReport.setGpfSub(sum(existingReport.getGpfSub(), newReport.getGpfSub()));
        }
        if (existingReport.getVpf() != null && newReport.getVpf() != null) {
            existingReport.setVpf(sum(existingReport.getVpf(), newReport.getVpf()));
        }
        if (existingReport.getCps() != null && newReport.getCps() != null) {
            existingReport.setCps(sum(existingReport.getCps(), newReport.getCps()));
        }
        if (existingReport.getFbf() != null && newReport.getFbf() != null) {
            existingReport.setFbf(sum(existingReport.getFbf(), newReport.getFbf()));
        }
        if (existingReport.getNhis() != null && newReport.getNhis() != null) {
            existingReport.setNhis(sum(existingReport.getNhis(), newReport.getNhis()));
        }
        if (existingReport.getSpecialPf() != null && newReport.getSpecialPf() != null) {
            existingReport.setSpecialPf(sum(existingReport.getSpecialPf(), newReport.getSpecialPf()));
        }
        if (existingReport.getHba() != null && newReport.getHba() != null) {
            existingReport.setHba(sum(existingReport.getHba(), newReport.getHba()));
        }
        if (existingReport.getHbf() != null && newReport.getHbf() != null) {
            existingReport.setHbf(sum(existingReport.getHbf(), newReport.getHbf()));
        }
        if (existingReport.getRentDeductions() != null && newReport.getRentDeductions() != null) {
            existingReport.setRentDeductions(sum(existingReport.getRentDeductions(), newReport.getRentDeductions()));
        }
        if (existingReport.getWaterCharges() != null && newReport.getWaterCharges() != null) {
            existingReport.setWaterCharges(sum(existingReport.getWaterCharges(), newReport.getWaterCharges()));
        }
        if (existingReport.getProfessionalTax() != null && newReport.getProfessionalTax() != null) {
            existingReport.setProfessionalTax(sum(existingReport.getProfessionalTax(), newReport.getProfessionalTax()));
        }
        if (existingReport.getOneDayRecovery() != null && newReport.getOneDayRecovery() != null) {
            existingReport.setOneDayRecovery(sum(existingReport.getOneDayRecovery(), newReport.getOneDayRecovery()));
        }
        if (existingReport.getIncomeTax() != null && newReport.getIncomeTax() != null) {
            existingReport.setIncomeTax(sum(existingReport.getIncomeTax(), newReport.getIncomeTax()));
        }
        if (existingReport.getIncomeTaxCess() != null && newReport.getIncomeTaxCess() != null) {
            existingReport.setIncomeTaxCess(sum(existingReport.getIncomeTaxCess(), newReport.getIncomeTaxCess()));
        }
        if (existingReport.getEoe() != null && newReport.getEoe() != null) {
            existingReport.setEoe(sum(existingReport.getEoe(), newReport.getEoe()));
        }
        if (existingReport.getGpfLoan() != null && newReport.getGpfLoan() != null) {
            existingReport.setGpfLoan(sum(existingReport.getGpfLoan(), newReport.getGpfLoan()));
        }
        if (existingReport.getGpfArrear() != null && newReport.getGpfArrear() != null) {
            existingReport.setGpfArrear(sum(existingReport.getGpfArrear(), newReport.getGpfArrear()));
        }
        if (existingReport.getCpsArrear() != null && newReport.getCpsArrear() != null) {
            existingReport.setCpsArrear(sum(existingReport.getCpsArrear(), newReport.getCpsArrear()));
        }
        if (existingReport.getFestivalAdvance() != null && newReport.getFestivalAdvance() != null) {
            existingReport.setFestivalAdvance(sum(existingReport.getFestivalAdvance(), newReport.getFestivalAdvance()));
        }
        if (existingReport.getConveyanceAdvance() != null && newReport.getConveyanceAdvance() != null) {
            existingReport.setConveyanceAdvance(sum(existingReport.getConveyanceAdvance(), newReport.getConveyanceAdvance()));
        }
        if (existingReport.getEducationAdvance() != null && newReport.getEducationAdvance() != null) {
            existingReport.setEducationAdvance(sum(existingReport.getEducationAdvance(), newReport.getEducationAdvance()));
        }
        if (existingReport.getMarriageAdvance() != null && newReport.getMarriageAdvance() != null) {
            existingReport.setMarriageAdvance(sum(existingReport.getMarriageAdvance(), newReport.getMarriageAdvance()));
        }
        if (existingReport.getPayAdvance() != null && newReport.getPayAdvance() != null) {
            existingReport.setPayAdvance(sum(existingReport.getPayAdvance(), newReport.getPayAdvance()));
        }
        if (existingReport.getMiscDeduction1() != null && newReport.getMiscDeduction1() != null) {
            existingReport.setMiscDeduction1(sum(existingReport.getMiscDeduction1(), newReport.getMiscDeduction1()));
        }
        if (existingReport.getMiscDeduction2() != null && newReport.getMiscDeduction2() != null) {
            existingReport.setMiscDeduction2(sum(existingReport.getMiscDeduction2(), newReport.getMiscDeduction2()));
        }
        if (existingReport.getVoucherNo() != null && newReport.getVoucherNo() != null) {
            existingReport.setVoucherNo(sum(existingReport.getVoucherNo(), newReport.getVoucherNo()));
        }
        if (existingReport.getGrossTotal() != null && newReport.getGrossTotal() != null) {
            existingReport.setGrossTotal(sum(existingReport.getGrossTotal(), newReport.getGrossTotal()));
        }
        if (existingReport.getOriginalBasicPay() != null && newReport.getOriginalBasicPay() != null) {
            existingReport.setOriginalBasicPay(sum(existingReport.getOriginalBasicPay(), newReport.getOriginalBasicPay()));
        }
        if (existingReport.getOriginalCca() != null && newReport.getOriginalCca() != null) {
            existingReport.setOriginalCca(sum(existingReport.getOriginalCca(), newReport.getOriginalCca()));
        }
        if (existingReport.getOriginalDa() != null && newReport.getOriginalDa() != null) {
            existingReport.setOriginalDa(sum(existingReport.getOriginalDa(), newReport.getOriginalDa()));
        }
        if (existingReport.getOriginalHra() != null && newReport.getOriginalHra() != null) {
            existingReport.setOriginalHra(sum(existingReport.getOriginalHra(), newReport.getOriginalHra()));
        }
        if (existingReport.getOriginalSpecialPay() != null && newReport.getOriginalSpecialPay() != null) {
            existingReport.setOriginalSpecialPay(sum(existingReport.getOriginalSpecialPay(), newReport.getOriginalSpecialPay()));
        }
        if (existingReport.getElBasicPay() != null && newReport.getElBasicPay() != null) {
            existingReport.setElBasicPay(sum(existingReport.getElBasicPay(), newReport.getElBasicPay()));
        }
        if (existingReport.getElSpecialPay() != null && newReport.getElSpecialPay() != null) {
            existingReport.setElSpecialPay(sum(existingReport.getElSpecialPay(), newReport.getElSpecialPay()));
        }
        if (existingReport.getElDa() != null && newReport.getElDa() != null) {
            existingReport.setElDa(sum(existingReport.getElDa(), newReport.getElDa()));
        }
        if (existingReport.getElHra() != null && newReport.getElHra() != null) {
            existingReport.setElHra(sum(existingReport.getElHra(), newReport.getElHra()));
        }
        if (existingReport.getElCca() != null && newReport.getElCca() != null) {
            existingReport.setElCca(sum(existingReport.getElCca(), newReport.getElCca()));
        }
        if (existingReport.getNetTotal() != null && newReport.getNetTotal() != null) {
            existingReport.setNetTotal(sum(existingReport.getNetTotal(), newReport.getNetTotal()));
        }

        if (existingReport.getOneDayRecoveryTotal() != null && newReport.getOneDayRecoveryTotal() != null) {
            existingReport.setOneDayRecoveryTotal(sum(existingReport.getOneDayRecoveryTotal(), newReport.getOneDayRecoveryTotal()));
        }
    }

    private Long parseLong(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof String) {
            try {
                return Long.parseLong((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    private Long sum(Long a, Long b) {
        return (a != null ? a : 0L) + (b != null ? b : 0L);
    }

    private Double parseDouble(Object value) {
        if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (value instanceof Double) {
            return (Double) value;
        } else {
            return null;
        }
    }

    private String sum1(Object existingValue, Object newValue) {
        Double existing = parseDouble(existingValue);
        Double newV = parseDouble(newValue);
        Double sum = (existing != null ? existing : 0.0) + (newV != null ? newV : 0.0);
        return sum.toString();
    }

    private double sum(Object existingValue, Object newValue) {
        Long existing = parseLong(existingValue);
        Long newV = parseLong(newValue);
        return (double) ((existing != null ? existing : 0L) + (newV != null ? newV : 0L));
    }


//    @Override
//    public List<PayArrear> getPayArrearsWithDateOfFA(String employeeId, int month, int year) {
//        // Step 1: Fetch distinct voucher numbers from payArrear
//        List<PayArrear> payArrears = payArrearRepo.findByEmployeeId(employeeId);
//        List<Long> voucherNos = payArrears.stream().map(PayArrear::getVoucherNo).distinct().collect(Collectors.toList());
//
//        // Step 2: Check if voucher numbers have dateOfFA in monthlySalary and match the given month and year
//        List<MonthlySalary> monthlySalaries = monthlysalaryrepo.findByVoucherNoIn(voucherNos);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        List<Long> voucherNosWithDateOfFA = monthlySalaries.stream()
//                .filter(salary -> {
//                    LocalDate dateOfFA = LocalDate.parse(salary.getDateOfFA(), formatter);
//                    return dateOfFA.getMonthValue() == month && dateOfFA.getYear() == year;
//                })
//                .map(MonthlySalary::getVoucherNo)
//                .collect(Collectors.toList());
//
//        // Step 3: Fetch data from payArrear using the filtered voucher numbers
//        List<PayArrear> filteredPayArrears = payArrearRepo.findByVoucherNoIn(voucherNosWithDateOfFA);
//
//        // Step 4: Aggregate the data by employeeId
//        Map<String, PayArrear> aggregatedPayArrears = filteredPayArrears.stream()
//                .collect(Collectors.toMap(
//                        PayArrear::getEmployeeId,
//                        pa -> pa,
//                        (pa1, pa2) -> {
//                            pa1.setBasicPay(Optional.ofNullable(pa1.getBasicPay()).orElse(0L) + Optional.ofNullable(pa2.getBasicPay()).orElse(0L));
//                            pa1.setPersonalPay(Optional.ofNullable(pa1.getPersonalPay()).orElse(0L) + Optional.ofNullable(pa2.getPersonalPay()).orElse(0L));
//                            pa1.setSpecialPay(Optional.ofNullable(pa1.getSpecialPay()).orElse(0L) + Optional.ofNullable(pa2.getSpecialPay()).orElse(0L));
//                            pa1.setDaArrear(Optional.ofNullable(pa1.getDaArrear()).orElse(0L) + Optional.ofNullable(pa2.getDaArrear()).orElse(0L));
//                            pa1.setHraArrear(Optional.ofNullable(pa1.getHraArrear()).orElse(0L) + Optional.ofNullable(pa2.getHraArrear()).orElse(0L));
//                            pa1.setCcaArrear(Optional.ofNullable(pa1.getCcaArrear()).orElse(0L) + Optional.ofNullable(pa2.getCcaArrear()).orElse(0L));
//                            pa1.setTotalEarning(Optional.ofNullable(pa1.getTotalEarning()).orElse(0.0) + Optional.ofNullable(pa2.getTotalEarning()).orElse(0.0));
//                            pa1.setAlreadyBasicPay(Optional.ofNullable(pa1.getAlreadyBasicPay()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyBasicPay()).orElse(0L));
//                            pa1.setAlreadyPersonalPay(Optional.ofNullable(pa1.getAlreadyPersonalPay()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyPersonalPay()).orElse(0L));
//                            pa1.setAlreadySpecialPay(Optional.ofNullable(pa1.getAlreadySpecialPay()).orElse(0L) + Optional.ofNullable(pa2.getAlreadySpecialPay()).orElse(0L));
//                            pa1.setAlreadyDaArrear(Optional.ofNullable(pa1.getAlreadyDaArrear()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyDaArrear()).orElse(0L));
//                            pa1.setAlreadyHraArrear(Optional.ofNullable(pa1.getAlreadyHraArrear()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyHraArrear()).orElse(0L));
//                            pa1.setAlreadyCcaArrear(Optional.ofNullable(pa1.getAlreadyCcaArrear()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyCcaArrear()).orElse(0L));
//                            pa1.setTotalDeductions(Optional.ofNullable(pa1.getTotalDeductions()).orElse(0.0) + Optional.ofNullable(pa2.getTotalDeductions()).orElse(0.0));
//                            pa1.setNetPay(Optional.ofNullable(pa1.getNetPay()).orElse(0.0) + Optional.ofNullable(pa2.getNetPay()).orElse(0.0));
//                            pa1.setCpsPercent(Optional.ofNullable(pa1.getCpsPercent()).orElse(0L) + Optional.ofNullable(pa2.getCpsPercent()).orElse(0L));
//                            pa1.setGpfPercent(Optional.ofNullable(pa1.getGpfPercent()).orElse(0L) + Optional.ofNullable(pa2.getGpfPercent()).orElse(0L));
//                            pa1.setTotalNetpay(Optional.ofNullable(pa1.getTotalNetpay()).orElse(0L) + Optional.ofNullable(pa2.getTotalNetpay()).orElse(0L));
//                            pa1.setToBemisc1(Optional.ofNullable(pa1.getToBemisc1()).orElse(0L) + Optional.ofNullable(pa2.getToBemisc1()).orElse(0L));
//                            pa1.setAlreadyMisc1(Optional.ofNullable(pa1.getAlreadyMisc1()).orElse(0L) + Optional.ofNullable(pa2.getAlreadyMisc1()).orElse(0L));
//                            pa1.setBasicPayEarning(Optional.ofNullable(pa1.getAlreadyBasicPay()).orElse(0L) - Optional.ofNullable(pa1.getBasicPay()).orElse(0L));
//                            pa1.setCca(Optional.ofNullable(pa1.getAlreadyCcaArrear()).orElse(0L) - Optional.ofNullable(pa1.getCcaArrear()).orElse(0L));
//                            pa1.setCps(Optional.ofNullable(pa1.getCpsPercent()).orElse(0L));
//                            pa1.setDa(Optional.ofNullable(pa1.getAlreadyDaArrear()).orElse(0L) - Optional.ofNullable(pa1.getDaArrear()).orElse(0L));
//                            pa1.setGpfPercent(Optional.ofNullable(pa1.getGpfPercent()).orElse(0L));
//                            pa1.setHra(Optional.ofNullable(pa1.getAlreadyHraArrear()).orElse(0L) - Optional.ofNullable(pa1.getHraArrear()).orElse(0L));
//                            pa1.setMisc1(Optional.ofNullable(pa1.getAlreadyMisc1()).orElse(0L) - Optional.ofNullable(pa1.getToBemisc1()).orElse(0L));
//                            pa1.setPersonalPays(Optional.ofNullable(pa1.getAlreadyPersonalPay()).orElse(0L) - Optional.ofNullable(pa1.getPersonalPay()).orElse(0L));
//                            pa1.setSpecialPays(Optional.ofNullable(pa1.getAlreadySpecialPay()).orElse(0L) - Optional.ofNullable(pa1.getSpecialPay()).orElse(0L));
//                            return pa1;
//                        }
//                ));
//
//        return aggregatedPayArrears.values().stream().collect(Collectors.toList());
//    }

    @Override
    public List<PayArrear> getPayArrearsWithDateOfFA(String employeeId, int month, int year) {
        // Step 1: Fetch distinct voucher numbers from payArrear
        List<PayArrear> payArrears = payArrearRepo.findByEmployeeId(employeeId);
        List<Long> voucherNos = payArrears.stream().map(PayArrear::getVoucherNo).distinct().collect(Collectors.toList());

        // Step 2: Check if voucher numbers have dateOfFA in monthlySalary and match the given month and year
        List<MonthlySalary> monthlySalaries = monthlysalaryrepo.findByVoucherNoIn(voucherNos);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Long> voucherNosWithDateOfFA = monthlySalaries.stream()
                .filter(salary -> {
                    LocalDate dateOfFA = LocalDate.parse(salary.getDateOfFA(), formatter);
                    return dateOfFA.getMonthValue() == month && dateOfFA.getYear() == year;
                })
                .map(MonthlySalary::getVoucherNo)
                .collect(Collectors.toList());

        // Step 3: Fetch data from payArrear using the filtered voucher numbers
        List<PayArrear> filteredPayArrears = payArrearRepo.findByVoucherNoIn(voucherNosWithDateOfFA);

        if (filteredPayArrears.size() == 1) {
            // Only one record, no need to aggregate, but apply the required calculations
            PayArrear pa = filteredPayArrears.get(0);
            pa.setBasicPayEarning(Optional.ofNullable(pa.getAlreadyBasicPay()).orElse(0L) - Optional.ofNullable(pa.getBasicPay()).orElse(0L));
            pa.setCca(Optional.ofNullable(pa.getAlreadyCcaArrear()).orElse(0L) - Optional.ofNullable(pa.getCcaArrear()).orElse(0L));
            pa.setCps(Optional.ofNullable(pa.getCpsPercent()).orElse(0L));
            pa.setDa(Optional.ofNullable(pa.getAlreadyDaArrear()).orElse(0L) - Optional.ofNullable(pa.getDaArrear()).orElse(0L));
            pa.setGpfPercent(Optional.ofNullable(pa.getGpfPercent()).orElse(0L));
            pa.setHra(Optional.ofNullable(pa.getAlreadyHraArrear()).orElse(0L) - Optional.ofNullable(pa.getHraArrear()).orElse(0L));
            pa.setMisc1(Optional.ofNullable(pa.getAlreadyMisc1()).orElse(0L) - Optional.ofNullable(pa.getToBemisc1()).orElse(0L));
            pa.setPersonalPays(Optional.ofNullable(pa.getAlreadyPersonalPay()).orElse(0L) - Optional.ofNullable(pa.getPersonalPay()).orElse(0L));
            pa.setSpecialPays(Optional.ofNullable(pa.getAlreadySpecialPay()).orElse(0L) - Optional.ofNullable(pa.getSpecialPay()).orElse(0L));
            return Collections.singletonList(pa);
        }

        // Step 4: Aggregate the data by employeeId if there are multiple records
        Map<String, PayArrear> aggregatedPayArrears = filteredPayArrears.stream()
                .collect(Collectors.toMap(
                        PayArrear::getEmployeeId,
                        pa -> {
                            // Initialize with current values
                            pa.setBasicPay(Optional.ofNullable(pa.getBasicPay()).orElse(0L));
                            pa.setPersonalPay(Optional.ofNullable(pa.getPersonalPay()).orElse(0L));
                            pa.setSpecialPay(Optional.ofNullable(pa.getSpecialPay()).orElse(0L));
                            pa.setDaArrear(Optional.ofNullable(pa.getDaArrear()).orElse(0L));
                            pa.setHraArrear(Optional.ofNullable(pa.getHraArrear()).orElse(0L));
                            pa.setCcaArrear(Optional.ofNullable(pa.getCcaArrear()).orElse(0L));
                            pa.setTotalEarning(Optional.ofNullable(pa.getTotalEarning()).orElse(0.0));
                            pa.setAlreadyBasicPay(Optional.ofNullable(pa.getAlreadyBasicPay()).orElse(0L));
                            pa.setAlreadyPersonalPay(Optional.ofNullable(pa.getAlreadyPersonalPay()).orElse(0L));
                            pa.setAlreadySpecialPay(Optional.ofNullable(pa.getAlreadySpecialPay()).orElse(0L));
                            pa.setAlreadyDaArrear(Optional.ofNullable(pa.getAlreadyDaArrear()).orElse(0L));
                            pa.setAlreadyHraArrear(Optional.ofNullable(pa.getAlreadyHraArrear()).orElse(0L));
                            pa.setAlreadyCcaArrear(Optional.ofNullable(pa.getAlreadyCcaArrear()).orElse(0L));
                            pa.setTotalDeductions(Optional.ofNullable(pa.getTotalDeductions()).orElse(0.0));
                            pa.setNetPay(Optional.ofNullable(pa.getNetPay()).orElse(0.0));
                            pa.setCpsPercent(Optional.ofNullable(pa.getCpsPercent()).orElse(0L));
                            pa.setGpfPercent(Optional.ofNullable(pa.getGpfPercent()).orElse(0L));
                            pa.setTotalNetpay(Optional.ofNullable(pa.getTotalNetpay()).orElse(0L));
                            pa.setToBemisc1(Optional.ofNullable(pa.getToBemisc1()).orElse(0L));
                            pa.setAlreadyMisc1(Optional.ofNullable(pa.getAlreadyMisc1()).orElse(0L));
                            return pa;
                        },
                        (pa1, pa2) -> {
                            // Sum up values
                            pa1.setBasicPay(pa1.getBasicPay() + Optional.ofNullable(pa2.getBasicPay()).orElse(0L));
                            pa1.setPersonalPay(pa1.getPersonalPay() + Optional.ofNullable(pa2.getPersonalPay()).orElse(0L));
                            pa1.setSpecialPay(pa1.getSpecialPay() + Optional.ofNullable(pa2.getSpecialPay()).orElse(0L));
                            pa1.setDaArrear(pa1.getDaArrear() + Optional.ofNullable(pa2.getDaArrear()).orElse(0L));
                            pa1.setHraArrear(pa1.getHraArrear() + Optional.ofNullable(pa2.getHraArrear()).orElse(0L));
                            pa1.setCcaArrear(pa1.getCcaArrear() + Optional.ofNullable(pa2.getCcaArrear()).orElse(0L));
                            pa1.setTotalEarning(pa1.getTotalEarning() + Optional.ofNullable(pa2.getTotalEarning()).orElse(0.0));
                            pa1.setAlreadyBasicPay(pa1.getAlreadyBasicPay() + Optional.ofNullable(pa2.getAlreadyBasicPay()).orElse(0L));
                            pa1.setAlreadyPersonalPay(pa1.getAlreadyPersonalPay() + Optional.ofNullable(pa2.getAlreadyPersonalPay()).orElse(0L));
                            pa1.setAlreadySpecialPay(pa1.getAlreadySpecialPay() + Optional.ofNullable(pa2.getAlreadySpecialPay()).orElse(0L));
                            pa1.setAlreadyDaArrear(pa1.getAlreadyDaArrear() + Optional.ofNullable(pa2.getAlreadyDaArrear()).orElse(0L));
                            pa1.setAlreadyHraArrear(pa1.getAlreadyHraArrear() + Optional.ofNullable(pa2.getAlreadyHraArrear()).orElse(0L));
                            pa1.setAlreadyCcaArrear(pa1.getAlreadyCcaArrear() + Optional.ofNullable(pa2.getAlreadyCcaArrear()).orElse(0L));
                            pa1.setTotalDeductions(pa1.getTotalDeductions() + Optional.ofNullable(pa2.getTotalDeductions()).orElse(0.0));
                            pa1.setNetPay(pa1.getNetPay() + Optional.ofNullable(pa2.getNetPay()).orElse(0.0));
                            pa1.setCpsPercent(pa1.getCpsPercent() + Optional.ofNullable(pa2.getCpsPercent()).orElse(0L));
                            pa1.setGpfPercent(pa1.getGpfPercent() + Optional.ofNullable(pa2.getGpfPercent()).orElse(0L));
                            pa1.setTotalNetpay(pa1.getTotalNetpay() + Optional.ofNullable(pa2.getTotalNetpay()).orElse(0L));
                            pa1.setToBemisc1(pa1.getToBemisc1() + Optional.ofNullable(pa2.getToBemisc1()).orElse(0L));
                            pa1.setAlreadyMisc1(pa1.getAlreadyMisc1() + Optional.ofNullable(pa2.getAlreadyMisc1()).orElse(0L));

                            // Apply the required calculations
                            pa1.setBasicPayEarning(pa1.getAlreadyBasicPay() - pa1.getBasicPay());
                            pa1.setCca(pa1.getAlreadyCcaArrear() - pa1.getCcaArrear());
                            pa1.setCps(pa1.getCpsPercent());
                            pa1.setDa(pa1.getAlreadyDaArrear() - pa1.getDaArrear());
                            pa1.setGpfPercent(pa1.getGpfPercent());
                            pa1.setHra(pa1.getAlreadyHraArrear() - pa1.getHraArrear());
                            pa1.setMisc1(pa1.getAlreadyMisc1() - pa1.getToBemisc1());
                            pa1.setPersonalPays(pa1.getAlreadyPersonalPay() - pa1.getPersonalPay());
                            pa1.setSpecialPays(pa1.getAlreadySpecialPay() - pa1.getSpecialPay());
                            return pa1;
                        }
                ));

        return new ArrayList<>(aggregatedPayArrears.values());
    }











}














