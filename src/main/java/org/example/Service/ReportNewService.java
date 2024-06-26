package org.example.Service;

import org.example.Entity.*;

import java.util.List;

public interface ReportNewService {
    MiscDeductionReportNew createMis1(MiscDeductionReportNew miscDeductionReportNew);

    MiscDeductionReport2New createMis2(MiscDeductionReport2New misDeductionRepoNew2);

    IncomeTaxReportNew createIncomeTax(IncomeTaxReportNew incomeTaxReportNew);


    MarriageAdvanceReportNew createMarriage(MarriageAdvanceReportNew marriageAdvanceReportrNew);

    RentReportNew createReport(RentReportNew rentReportNew);

    OneDayRecoveryReportNew createOnedayRecovery(OneDayRecoveryReportNew oneDayRecoveryReportNew);

    PayAdvanceReportNew createPay(PayAdvanceReportNew payAdvanceReportNew);

    HbaReportNew createHba(HbaReportNew hbaReportNew);

    GpfReportNew createGpa(GpfReportNew gpaReportNew);

    FBFReportNew createFbf(FBFReportNew fbfReportNew);

    FestivalAdvanceReportNew createFestival(FestivalAdvanceReportNew festivalAdvanceReportNew);

    NhisReportNew createNhis(NhisReportNew nhisReportNew);


    List<MonthlySalaryNewData> getAggregatedSalaryData();
}
