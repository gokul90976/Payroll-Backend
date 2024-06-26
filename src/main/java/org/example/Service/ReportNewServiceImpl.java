package org.example.Service;


import org.example.Entity.*;
import org.example.Repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportNewServiceImpl implements ReportNewService {


    private final MiscDeductionReportNewRepository miscDeductionReportNewRepository;
    private final MiscDeductionReport2NewRepository misDedectionReportNewRepository2;
    private final IncomeTaxReportNewRepository incomeTaxReportNewRepository;
    private final MarriageAdvanceReportNewRepository marriageAdvanceReportNewRepository;
    private final RentReportNewRepository rentReportNewRepository;
    private final OneDayRecoveryReportNewRepository oneDayRecoveryReportNewRepository;
    private final PayAdvanceReportNewRepository payAdvanceReportNewRepository;
    private final HbaReportNewRepository hbaReportNewRepository;

    private final FBFReportNewRepository fbfReportNewRepository;


    private final FestivalAdvanceReportNewRepository festivalAdvanceReportNewRepository;
    private final NhisReportNewRepository nhisReportNewRepository;

    private final GpfReportNewRepository gpfReportNewRepository;

    private final MonthlySalaryNewRepo monthlySalaryNewDataRepository;

    public ReportNewServiceImpl(MiscDeductionReportNewRepository miscDeductionReportNewRepository, MiscDeductionReport2NewRepository misDedectionReportNewRepository2, IncomeTaxReportNewRepository incomeTaxReportNewRepository, MarriageAdvanceReportNewRepository marriageAdvanceReportNewRepository, RentReportNewRepository rentReportNewRepository, OneDayRecoveryReportNewRepository oneDayRecoveryReportNewRepository, PayAdvanceReportNewRepository payAdvanceReportNewRepository, HbaReportNewRepository hbaReportNewRepository, FBFReportNewRepository fbfReportNewRepository, FestivalAdvanceReportNewRepository festivalAdvanceReportNewRepository, NhisReportNewRepository nhisReportNewRepository, GpfReportNewRepository gpfReportNewRepository, MonthlySalaryNewRepo monthlySalaryNewDataRepository) {
        this.miscDeductionReportNewRepository = miscDeductionReportNewRepository;
        this.misDedectionReportNewRepository2 = misDedectionReportNewRepository2;
        this.incomeTaxReportNewRepository = incomeTaxReportNewRepository;
        this.marriageAdvanceReportNewRepository = marriageAdvanceReportNewRepository;
        this.rentReportNewRepository = rentReportNewRepository;
        this.oneDayRecoveryReportNewRepository = oneDayRecoveryReportNewRepository;
        this.payAdvanceReportNewRepository = payAdvanceReportNewRepository;
        this.hbaReportNewRepository = hbaReportNewRepository;
        this.fbfReportNewRepository = fbfReportNewRepository;
        this.festivalAdvanceReportNewRepository = festivalAdvanceReportNewRepository;
        this.nhisReportNewRepository = nhisReportNewRepository;
        this.gpfReportNewRepository = gpfReportNewRepository;
        this.monthlySalaryNewDataRepository = monthlySalaryNewDataRepository;
    }


    @Override
    public MiscDeductionReportNew createMis1(MiscDeductionReportNew miscDeductionReportNew) {
        return miscDeductionReportNewRepository.save(miscDeductionReportNew);
    }

    @Override
    public MiscDeductionReport2New createMis2(MiscDeductionReport2New misDeductionRepoNew2) {
        return misDedectionReportNewRepository2.save(misDeductionRepoNew2);
    }

    @Override
    public IncomeTaxReportNew createIncomeTax(IncomeTaxReportNew incomeTaxReportNew) {
        return incomeTaxReportNewRepository.save(incomeTaxReportNew);

    }

    @Override
    public MarriageAdvanceReportNew createMarriage(MarriageAdvanceReportNew marriageAdvanceReportrNew) {
        return marriageAdvanceReportNewRepository.save(marriageAdvanceReportrNew);
    }

    @Override
    public RentReportNew createReport(RentReportNew rentReportNew) {

        return rentReportNewRepository.save(rentReportNew);
    }


    @Override
    public OneDayRecoveryReportNew createOnedayRecovery(OneDayRecoveryReportNew oneDayRecoveryReportNew) {
        return oneDayRecoveryReportNewRepository.save(oneDayRecoveryReportNew);
    }


    @Override
    public PayAdvanceReportNew createPay(PayAdvanceReportNew payAdvanceReportNew) {
        return payAdvanceReportNewRepository.save(payAdvanceReportNew);
    }

    @Override
    public HbaReportNew createHba(HbaReportNew hbaReportNew) {
        return hbaReportNewRepository.save(hbaReportNew);
    }


    @Override
    public GpfReportNew createGpa(GpfReportNew gpaReportNew) {
        return gpfReportNewRepository.save(gpaReportNew);
    }

    @Override
    public FBFReportNew createFbf(FBFReportNew fbfReportNew) {
        return fbfReportNewRepository.save(fbfReportNew);
    }

    @Override
    public FestivalAdvanceReportNew createFestival(FestivalAdvanceReportNew festivalAdvanceReportNew) {
        return festivalAdvanceReportNewRepository.save(festivalAdvanceReportNew);
    }

    @Override
    public NhisReportNew createNhis(NhisReportNew nhisReportNew) {
        return nhisReportNewRepository.save(nhisReportNew);
    }


    @Override
    public List<MonthlySalaryNewData> getAggregatedSalaryData() {

        List<MonthlySalaryNewData> allData = monthlySalaryNewDataRepository.findAll();


        Map<String, MonthlySalaryNewData> aggregatedData = allData.stream()
                .filter(msnd -> "Approved".equals(msnd.getMonthlySalary().getStatusFA()))
                .collect(Collectors.groupingBy(MonthlySalaryNewData::getEmployeeId,
                        Collectors.reducing(new MonthlySalaryNewData(), this::aggregateMonthlySalaryNewData)));


        return aggregatedData.values().stream().collect(Collectors.toList());
    }

    private MonthlySalaryNewData aggregateMonthlySalaryNewData(MonthlySalaryNewData msnd1, MonthlySalaryNewData msnd2) {
        MonthlySalaryNewData aggregated = new MonthlySalaryNewData();

        // Assuming non-null employeeId and employeeName
        aggregated.setEmployeeId(msnd1.getEmployeeId());
        System.out.println(msnd1.getEmployeeId());

        aggregated.setEmployeeName(msnd1.getEmployeeName());

        // Aggregate fields
        aggregated.setTotalEarning(sum(msnd1.getTotalEarning(), msnd2.getTotalEarning()));
        aggregated.setTotalDeductions(sum(msnd1.getTotalDeductions(), msnd2.getTotalDeductions()));
        aggregated.setNetPay(sum(msnd1.getNetPay(), msnd2.getNetPay()));

        // Aggregate earnings
        aggregateEarnings(aggregated, msnd1, msnd2);

        // Aggregate deductions
        aggregateDeductions(aggregated, msnd1, msnd2);

        return aggregated;
    }

    private void aggregateEarnings(MonthlySalaryNewData aggregated, MonthlySalaryNewData msnd1, MonthlySalaryNewData msnd2) {
        aggregated.setBasicPayEarning(sum(msnd1.getBasicPayEarning(), msnd2.getBasicPayEarning()));
        aggregated.setPersonalPay(sum(msnd1.getPersonalPay(), msnd2.getPersonalPay()));
        aggregated.setSpecialPay(sum(msnd1.getSpecialPay(), msnd2.getSpecialPay()));
        aggregated.setDa(sum(msnd1.getDa(), msnd2.getDa()));
        aggregated.setHra(sum(msnd1.getHra(), msnd2.getHra()));
        aggregated.setCca(sum(msnd1.getCca(), msnd2.getCca()));
        aggregated.setMedicalAllowance(sum(msnd1.getMedicalAllowance(), msnd2.getMedicalAllowance()));
        aggregated.setFta(sum(msnd1.getFta(), msnd2.getFta()));
        aggregated.setHillAllowance(sum(msnd1.getHillAllowance(), msnd2.getHillAllowance()));
        aggregated.setWinterAllowance(sum(msnd1.getWinterAllowance(), msnd2.getWinterAllowance()));
        aggregated.setWashingAllowance(sum(msnd1.getWashingAllowance(), msnd2.getWashingAllowance()));
        aggregated.setConveyanceAllowanceEarnings(sum(msnd1.getConveyanceAllowanceEarnings(), msnd2.getConveyanceAllowanceEarnings()));
        aggregated.setCashAllowance(sum(msnd1.getCashAllowance(), msnd2.getCashAllowance()));
        aggregated.setInterimRelief(sum(msnd1.getInterimRelief(), msnd2.getInterimRelief()));
        aggregated.setMisc1(sum(msnd1.getMisc1(), msnd2.getMisc1()));
    }

    private void aggregateDeductions(MonthlySalaryNewData aggregated, MonthlySalaryNewData msnd1, MonthlySalaryNewData msnd2) {
        aggregated.setGpfSub(sum(msnd1.getGpfSub(), msnd2.getGpfSub()));
        aggregated.setVpf(sum(msnd1.getVpf(), msnd2.getVpf()));
        aggregated.setCps(sum(msnd1.getCps(), msnd2.getCps()));
        aggregated.setFbf(sum(msnd1.getFbf(), msnd2.getFbf()));
        aggregated.setNhis(sum(msnd1.getNhis(), msnd2.getNhis()));
        aggregated.setSpecialPf(sum(msnd1.getSpecialPf(), msnd2.getSpecialPf()));
        aggregated.setHba(sum(msnd1.getHba(), msnd2.getHba()));
        aggregated.setHbf(sum(msnd1.getHbf(), msnd2.getHbf()));
        aggregated.setRentDeductions(sum(msnd1.getRentDeductions(), msnd2.getRentDeductions()));
        aggregated.setWaterCharges(sum(msnd1.getWaterCharges(), msnd2.getWaterCharges()));
        aggregated.setProfessionalTax(sum(msnd1.getProfessionalTax(), msnd2.getProfessionalTax()));
        aggregated.setOneDayRecovery(sum(msnd1.getOneDayRecovery(), msnd2.getOneDayRecovery()));
        aggregated.setIncomeTax(sum(msnd1.getIncomeTax(), msnd2.getIncomeTax()));
        aggregated.setIncomeTaxCess(sum(msnd1.getIncomeTaxCess(), msnd2.getIncomeTaxCess()));
        aggregated.setEoe(sum(msnd1.getEoe(), msnd2.getEoe()));
        aggregated.setGpfLoan(sum(msnd1.getGpfLoan(), msnd2.getGpfLoan()));
        aggregated.setGpfArrear(sum(msnd1.getGpfArrear(), msnd2.getGpfArrear()));
        aggregated.setCpsArrear(sum(msnd1.getCpsArrear(), msnd2.getCpsArrear()));
        aggregated.setFestivalAdvance(sum(msnd1.getFestivalAdvance(), msnd2.getFestivalAdvance()));
        aggregated.setConveyanceAdvance(sum(msnd1.getConveyanceAdvance(), msnd2.getConveyanceAdvance()));
        aggregated.setEducationAdvance(sum(msnd1.getEducationAdvance(), msnd2.getEducationAdvance()));
        aggregated.setMarriageAdvance(sum(msnd1.getMarriageAdvance(), msnd2.getMarriageAdvance()));
        aggregated.setPayAdvance(sum(msnd1.getPayAdvance(), msnd2.getPayAdvance()));
        aggregated.setMiscDeduction1(sum(msnd1.getMiscDeduction1(), msnd2.getMiscDeduction1()));
        aggregated.setMiscDeduction2(sum(msnd1.getMiscDeduction2(), msnd2.getMiscDeduction2()));
    }

    private double sum(Double a, Double b) {
        return (a != null ? a : 0.0) + (b != null ? b : 0.0);
    }

    private long sum(Long a, Long b) {
        return (a != null ? a : 0L) + (b != null ? b : 0L);
    }


}

