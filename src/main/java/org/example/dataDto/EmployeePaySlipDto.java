package org.example.dataDto;


import lombok.*;


@Getter
@Setter
@Data
public class EmployeePaySlipDto {

    private String employeeId;
    private Long netPay;
    private Long monthlySalaryId;
    private Long voucherNo;
    private Long totalEarning;
    private Long totalDeductions;
    private String alreadyBasicPay;
    private Long cps;
    private String employeeName;
    private String designationName;
    private String dateOfJoiningService;
    private String panNo;
    private Long cpsArrear;
    private Long gpfSub;
    private Long gpfArrear;
    private Long alreadyPersonalPay;
    private Long alreadyHraArrear;
    private Long alreadyCcaArrear;
    private Long alreadySpecialPay;
    private Long alreadyMisc1;
    private String dateOfFA;
    private Long cca;
    private Long id;
    private String officeCode;
    private String officeName;
    private String designationCode;
    private String aadharNo;
    private String mobileNo;
    private String emailId;
    private String differentlyAbled;
    private String dateOfBirth;
    private String levelAsPerPayMatrix;
    private String basicPay;
    private String levelAsPerCellMatrix;
    private String scaleOfPay;
    private String incrementDueDate;
    private String dateOfRetirement;
    private String transferOfficeCode;
    private String transferOfficeName;
    private String dateOfJoiningTransfer;
    private String rent;
    private String bankName;
    private String bankBranchName;
    private Long bankAcNo;
    private String bankIFSC;
    private String payStatus;
    private String pfcps;
    private Long basicPayEarning;
    private Long personalPay;
    private Long specialPay;
    private Long da;
    private Long hra;
    private Long hrr;
    private Long medicalAllowance;
    private Long fta;
    private Long hillAllowance;
    private Long winterAllowance;
    private Long washingAllowance;
    private Long conveyanceAllowanceEarnings;
    private Long cashAllowance;
    private Long interimRelief;
    private Long misc1;
    private Long vpf;
    private Long fbf;
    private Long nhis;
    private Long specialPf;
    private Long hba;
    private Long hbf;
    private Long rentDeductions;
    private Long waterCharges;
    private Long professionalTax;
    private Long oneDayRecovery;
    private Long incomeTax;
    private Long incomeTaxCess;
    private Long eoe;
    private Long gpfLoan;
    private Long festivalAdvance;
    private Long conveyanceAdvance;
    private Long educationAdvance;
    private Long marriageAdvance;
    private Long payAdvance;
    private Long miscDeduction1;
    private Long miscDeduction2;
    private Long grossTotal;
    private String elMonth;
    private String noOfDays;
    private Long originalBasicPay;
    private Long originalCca;
    private Long originalDa;
    private Long originalHra;
    private Long originalSpecialPay;
    private Double elBasicPay;
    private Double elSpecialPay;
    private Double elDa;
    private Double elHra;
    private Double elCca;
    private String netTotal;
    private String date;
    private Long numberOfWorkingDays;
    private int workingDays;
    private int totalDays;
    private int difference;
    private Long daArrear;
    private Long alreadyDaArrear;
    private Long toBemisc1;
    private Long hraArrear;

    public EmployeePaySlipDto(String employeeId, Long netPay, Long monthlySalaryId, Long voucherNo, Long totalEarning, Long totalDeductions, Long cps, String employeeName, String designationName, String dateOfJoiningService, String panNo, Long cpsArrear, Long gpfSub, Long gpfArrear, Long da, String dateOfFA, Long cca, Long id, String officeCode, String officeName, String designationCode, String aadharNo, String mobileNo, String emailId, String differentlyAbled, String dateOfBirth, String levelAsPerPayMatrix, String basicPay, String levelAsPerCellMatrix, String scaleOfPay, String incrementDueDate, String dateOfRetirement, String transferOfficeCode, String transferOfficeName, String dateOfJoiningTransfer, String rent, String bankName, String bankBranchName, Long bankAcNo, String bankIFSC, String payStatus, String pfcps, Long basicPayEarning, Long personalPay, Long specialPay, Long hra, Long hrr, Long medicalAllowance, Long fta, Long hillAllowance, Long winterAllowance, Long washingAllowance, Long conveyanceAllowanceEarnings, Long cashAllowance, Long interimRelief, Long misc1, Long vpf, Long fbf, Long nhis, Long specialPf, Long hba, Long hbf, Long rentDeductions, Long waterCharges, Long professionalTax, Long oneDayRecovery, Long incomeTax, Long incomeTaxCess, Long eoe, Long gpfLoan, Long festivalAdvance, Long conveyanceAdvance, Long educationAdvance, Long marriageAdvance, Long payAdvance, Long miscDeduction1, Long miscDeduction2, Long grossTotal, String elMonth, Long numberOfWorkingDays, Long originalBasicPay, Long originalCca, Long originalDa, Long originalHra, Long originalSpecialPay, Double elBasicPay, Double elSpecialPay, Double elDa, Double elHra, Double elCca, Long netTotal, String date, String resultDate, int workingDays, int totalDays, int difference) {
        this.employeeId = employeeId;
        this.netPay = netPay;
        this.monthlySalaryId = monthlySalaryId;
        this.voucherNo = voucherNo;
        this.totalEarning = totalEarning;
        this.totalDeductions = totalDeductions;
        this.cps = cps;
        this.employeeName = employeeName;
        this.designationName = designationName;
        this.dateOfJoiningService = dateOfJoiningService;
        this.cpsArrear = cpsArrear;
        this.gpfSub = gpfSub;
        this.gpfArrear = gpfArrear;
        this.da = da;
        this.dateOfFA = dateOfFA;
        this.cca = cca;
        this.id = id;
        this.officeCode = officeCode;
        this.officeName = officeName;
        this.designationCode = designationCode;
        this.aadharNo = aadharNo;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.differentlyAbled = differentlyAbled;
        this.dateOfBirth = dateOfBirth;
        this.levelAsPerPayMatrix = levelAsPerPayMatrix;
        this.basicPay = basicPay;
        this.levelAsPerCellMatrix = levelAsPerCellMatrix;
        this.scaleOfPay = scaleOfPay;
        this.incrementDueDate = incrementDueDate;
        this.dateOfRetirement = dateOfRetirement;
        this.transferOfficeCode = transferOfficeCode;
        this.transferOfficeName = transferOfficeName;
        this.dateOfJoiningTransfer = dateOfJoiningTransfer;
        this.rent = rent;
        this.bankName = bankName;
        this.bankBranchName = bankBranchName;
        this.bankAcNo = bankAcNo;
        this.bankIFSC = bankIFSC;
        this.payStatus = payStatus;
        this.pfcps = pfcps;
        this.basicPayEarning = basicPayEarning;
        this.personalPay = personalPay;
        this.specialPay = specialPay;
        this.hra = hra;
        this.hrr = hrr;
        this.medicalAllowance = medicalAllowance;
        this.fta = fta;
        this.hillAllowance = hillAllowance;
        this.winterAllowance = winterAllowance;
        this.washingAllowance = washingAllowance;
        this.conveyanceAllowanceEarnings = conveyanceAllowanceEarnings;
        this.cashAllowance = cashAllowance;
        this.interimRelief = interimRelief;
        this.misc1 = misc1;
        this.vpf = vpf;
        this.fbf = fbf;
        this.nhis = nhis;
        this.specialPf = specialPf;
        this.hba = hba;
        this.hbf = hbf;
        this.rentDeductions = rentDeductions;
        this.waterCharges = waterCharges;
        this.professionalTax = professionalTax;
        this.oneDayRecovery = oneDayRecovery;
        this.incomeTax = incomeTax;
        this.incomeTaxCess = incomeTaxCess;
        this.eoe = eoe;
        this.gpfLoan = gpfLoan;
        this.festivalAdvance = festivalAdvance;
        this.conveyanceAdvance = conveyanceAdvance;
        this.educationAdvance = educationAdvance;
        this.marriageAdvance = marriageAdvance;
        this.payAdvance = payAdvance;
        this.miscDeduction1 = miscDeduction1;
        this.miscDeduction2 = miscDeduction2;
        this.grossTotal = grossTotal;
        this.elMonth = elMonth;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.originalBasicPay = originalBasicPay;
        this.originalCca = originalCca;
        this.originalDa = originalDa;
        this.originalHra = originalHra;
        this.originalSpecialPay = originalSpecialPay;
        this.elBasicPay = elBasicPay;
        this.elSpecialPay = elSpecialPay;
        this.elDa = elDa;
        this.elHra = elHra;
        this.elCca = elCca;
        this.netTotal = String.valueOf(netTotal);
        this.date = date;
        this.workingDays = workingDays;
        this.totalDays = totalDays;
        this.difference = difference;

    }

    public EmployeePaySlipDto() {

    }

    public void setDa(double v) {
        this.da = (long) v;
    }

    public void setCca(double v) {
        this.cca = (long) v;
    }
}
