package org.example.Controller;

import net.minidev.json.JSONObject;
import org.example.Entity.*;

import org.example.Service.ReportNewService;
import org.example.Service.ReportService;
import org.example.common.ResponseDo;
import org.example.dataDto.EmployeeMonthlySalaryDto;
import org.example.dataDto.EmployeePaySlipDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://payrollapi.tnhb.in", "https://employee-corner.tnhb.in"}, allowedHeaders = "*")
//@CrossOrigin(origins = "https://payrollapi.tnhb.in", allowedHeaders = "*")

public class ReportController {


    private final ResponseDo responseDo;

    private final ReportService reportService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final ReportNewService reportNewService;

    public ReportController(ResponseDo responseDo, ReportService reportService, ReportNewService reportNewService) {
        this.responseDo = responseDo;
        this.reportService = reportService;
        this.reportNewService = reportNewService;

    }

    @PostMapping("/getAllMiscData")
    public ResponseDo getAllMiscData() {
        try {
            List<MiscDeductionReport> data = reportService.getAllMiscData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllMisc2Data")
    public ResponseDo getAllMisc2Data() {
        try {
            List<MiscDeductionReport2> data = reportService.getAllMisc2Data();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


    @PostMapping("/getAllPayData")
    public ResponseDo getAllPayData() {
        try {
            List<PayAdvanceReport> data = reportService.getAllPayData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllEducationData")
    public ResponseDo getAllEducationData() {
        try {
            List<EducationAdvanceReport> data = reportService.getAllEducationData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllMarriageData")
    public ResponseDo getAllMarriageData() {
        try {
            List<MarriageAdvanceReport> data = reportService.getAllMarriageData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllConvenyanceData")
    public ResponseDo getAllConveyanceData() {
        try {
            List<ConvenyanceAdvanceReport> data = reportService.getAllConveyanceData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllFestivalData")
    public ResponseDo getAllFestivalData() {
        try {
            List<FestivalAdvanceReport> data = reportService.getAllFestivalData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllNhisData")
    public ResponseDo getAllNhisData() {
        try {
            List<NhisReport> data = reportService.getAllNhisData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllProfessionalData")
    public ResponseDo getAllProfessionalData() {
        try {
            List<ProfessionalTaxReport> data = reportService.getAllPrpfessionalData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllIncomeTaxData")
    public ResponseDo getAllIncomeTaxData() {
        try {
            List<IncomeTaxReport> data = reportService.getAllIncomeTaxData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllOneDayRecoveryData")
    public ResponseDo getAllOneDayRecoveryData() {
        try {
            List<OneDayRecoveryReport> data = reportService.getAllOneDayRecoveryData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllCpsData")
    public ResponseDo getAllCpsData() {
        try {
            List<CpsReport> data = reportService.getAllCpsData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllRentData")
    public ResponseDo getAllRentData() {
        try {
            List<RentReport> data = reportService.getAllRentData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllFBFData")
    public ResponseDo getAllFbfData() {
        try {
            List<FBFReport> data = reportService.getAllFBFData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllSpecialPfData")
    public ResponseDo getAllSpecialPfData() {
        try {
            List<SpecialPfReport> data = reportService.getAllSpecialPfData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllGpfData")
    public ResponseDo getAllGpfData() {
        try {
            List<GpfReport> data = reportService.getAllGpfData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllHbaData")
    public ResponseDo getAllHbaData() {
        try {
            List<HbaReport> data = reportService.getAllHbaData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


    //TODO MONTHWISE REPORT-GOKUL
    @PostMapping("/MiscDeductionReportByEmpId")
    public ResponseDo getMiscDeductionReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                    HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<MiscDeductionReport> responseModel = reportService.getMiscDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/PayAdvanceReportByEmpId")
    public ResponseDo getPayAdvanceReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                 HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<PayAdvanceReport> responseModel = reportService.getPayDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    // Repeat similar methods for each type of report
    @PostMapping("/EducationAdvanceReportByEmpId")
    public ResponseDo getEducationAdvanceReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                       HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<EducationAdvanceReport> responseModel = reportService.getEducationDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/MarriageAdvanceReportByEmpId")
    public ResponseDo getMarriageAdvanceReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                      HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<MarriageAdvanceReport> responseModel = reportService.getMarriageDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();

            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }


    @PostMapping("/ConvenyanceAdvanceReportByEmpId")
    public ResponseDo getConvenyanceAdvanceReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                         HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<ConvenyanceAdvanceReport> responseModel = reportService.getConveyanceDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/FestivalAdvanceReportByEmpId")
    public ResponseDo getFestivalAdvanceReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                      HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<FestivalAdvanceReport> responseModel = reportService.getFestivalDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/NhisReportByEmpId")
    public ResponseDo getNhisReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                           HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<NhisReport> responseModel = reportService.getNhisDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/ProfessionalTaxReportByEmpId")
    public ResponseDo getProfessionalTaxReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                      HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<ProfessionalTaxReport> responseModel = reportService.getPrpfessionalDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/IncomeTaxReportByEmpId")
    public ResponseDo getIncomeTaxReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<IncomeTaxReport> responseModel = reportService.getIncomeTaxDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/OneDayRecoveryReportByEmpId")
    public ResponseDo getOneDayRecoveryReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                     HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<OneDayRecoveryReport> responseModel = reportService.getOneDayRecoveryDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/CpsReportByEmpId")
    public ResponseDo getCpsReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                          HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<CpsReport> responseModel = reportService.getCpsDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/RentReportByEmpId")
    public ResponseDo getRentReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                           HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<RentReport> responseModel = reportService.getRentDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/FBFReportByEmpId")
    public ResponseDo getFBFReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                          HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<FBFReport> responseModel = reportService.getFBFDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/SpecialPfReportByEmpId")
    public ResponseDo getSpecialPfReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<SpecialPfReport> responseModel = reportService.getSpecialPfDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/GpfReportByEmpId")
    public ResponseDo getGpfReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                          HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<GpfReport> responseModel = reportService.getGpfDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @PostMapping("/HbaReportByEmpId")
    public ResponseDo getHbaReportByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                          HttpServletResponse response) {

        String employeeId = json.getAsString("employeeId");

        try {
            List<HbaReport> responseModel = reportService.getHbaDataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }


    @PostMapping("/MiscDeductionReport2ByEmpId")
    public ResponseDo getMiscDeductionReport2ByEmpId(@RequestBody JSONObject json, final HttpServletRequest request,
                                                     HttpServletResponse response) {


        String employeeId = json.getAsString("employeeId");

        try {
            List<MiscDeductionReport2> responseModel = reportService.getMisc2DataByEmployeeId(employeeId);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @GetMapping("/misc-deductions")
    public ResponseEntity<List<MiscDeductionReport>> getAllMiscData(@RequestParam String fromDate, @RequestParam String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<MiscDeductionReport> reports = reportService.getAllMiscData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/pay-advances")
    public ResponseEntity<List<PayAdvanceReport>> getAllPayData(@RequestParam String fromDate, @RequestParam String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<PayAdvanceReport> reports = reportService.getAllPayData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/education-advances")
    public ResponseEntity<List<EducationAdvanceReport>> getAllEducationData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<EducationAdvanceReport> reports = reportService.getAllEducationData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/marriage-advances")
    public ResponseEntity<List<MarriageAdvanceReport>> getAllMarriageData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<MarriageAdvanceReport> reports = reportService.getAllMarriageData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/conveyance-advances")
    public ResponseEntity<List<ConvenyanceAdvanceReport>> getAllConveyanceData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<ConvenyanceAdvanceReport> reports = reportService.getAllConveyanceData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/festival-advances")
    public ResponseEntity<List<FestivalAdvanceReport>> getAllFestivalData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<FestivalAdvanceReport> reports = reportService.getAllFestivalData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/nhis")
    public ResponseEntity<List<NhisReport>> getAllNhisData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<NhisReport> reports = reportService.getAllNhisData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/professional-taxes")
    public ResponseEntity<List<ProfessionalTaxReport>> getAllProfessionalData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<ProfessionalTaxReport> reports = reportService.getAllProfessionalData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/income-taxes")
    public ResponseEntity<List<IncomeTaxReport>> getAllIncomeTaxData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<IncomeTaxReport> reports = reportService.getAllIncomeTaxData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/one-day-recoveries")
    public ResponseEntity<List<OneDayRecoveryReport>> getAllOneDayRecoveryData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<OneDayRecoveryReport> reports = reportService.getAllOneDayRecoveryData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/cps")
    public ResponseEntity<List<CpsReport>> getAllCpsData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<CpsReport> reports = reportService.getAllCpsData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/rents")
    public ResponseEntity<List<RentReport>> getAllRentData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<RentReport> reports = reportService.getAllRentData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/fbf")
    public ResponseEntity<List<FBFReport>> getAllFBFData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<FBFReport> reports = reportService.getAllFBFData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/special-pf")
    public ResponseEntity<List<SpecialPfReport>> getAllSpecialPfData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<SpecialPfReport> reports = reportService.getAllSpecialPfData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/gpf")
    public ResponseEntity<List<GpfReport>> getAllGpfData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<GpfReport> reports = reportService.getAllGpfData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/hba")
    public ResponseEntity<List<HbaReport>> getAllHbaData(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<HbaReport> reports = reportService.getAllHbaData(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/misc-deductions2")
    public ResponseEntity<List<MiscDeductionReport2>> getAllMisc2Data(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<MiscDeductionReport2> reports = reportService.getAllMisc2Data(startDate, endDate);
        return ResponseEntity.ok(reports);
    }

    //    @GetMapping("/employee/monthly-salary")
//    public ResponseEntity<List<EmployeeMonthlySalaryDto>> getEmployeeMonthlySalary(
//            @RequestParam String employeeId,@RequestParam String fromDate, @RequestParam String toDate) {
//        LocalDate startDate = LocalDate.parse(fromDate, formatter);
//        LocalDate endDate = LocalDate.parse(toDate, formatter);
//        List<EmployeeMonthlySalaryDto> data = reportService.getEmployeeIdAndMonthlySalary(employeeId, startDate, endDate);
//        return ResponseEntity.ok(data);
//    }
    @GetMapping("/employee/monthly-salary")
    public ResponseDo getEmployeeMonthlySalary(
            @RequestParam String employeeId, @RequestParam String fromDate, @RequestParam String toDate) {
        try {
            // Parse the input date strings
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate startDate = LocalDate.parse(fromDate, formatter);
            LocalDate endDate = LocalDate.parse(toDate, formatter);

            // Fetch the employee monthly salary data
            List<EmployeeMonthlySalaryDto> responseModel = reportService.getEmployeeIdAndMonthlySalary(employeeId, startDate, endDate);

            // Check if data is found and return appropriate response
            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureResponse("No Records Found on these Selected Days.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("No Records Found on these Selected Days.");
        }
    }




    @GetMapping("/Dashboard/monthly-salary")
    public ResponseDo getEmployeeMonthlySalaryDashboard(
            @RequestParam String fromDate, @RequestParam String toDate) {
        try {
            // Parse the input date strings
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate startDate = LocalDate.parse(fromDate, formatter);
            LocalDate endDate = LocalDate.parse(toDate, formatter);

            // Fetch the employee monthly salary data
            List<EmployeeMonthlySalaryDto> responseModel = reportService.getEmployeeIdAndMonthlySalaryDashboard(startDate, endDate);

            // Check if data is found and return appropriate response
            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureResponse("No Records Found on these Selected Days.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("No Records Found on these Selected Days.");
        }
    }



    @GetMapping("/getPaySlip")
    public ResponseDo getPaySlip(@RequestParam String employeeId, @RequestParam int month, @RequestParam int year) {

        try {
            List<EmployeePaySlipDto> responseModel = reportService.getPaySlip(employeeId, month, year);

            if (responseModel != null && !responseModel.isEmpty()) {
                return responseDo.setSuccessResponse(responseModel);
            } else {
                return responseDo.setFailureNoDataFoundResponse();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage());
        }
    }

    @GetMapping("/aggregateds")
    public List<MonthlySalaryNewData> getAggregatedSalaries() {
        return reportService.getAggregatedMonthlySalaries();
    }


    @GetMapping("/aggregated")
    public ResponseEntity<List<MonthlySalaryNewData>> getAllaggregated(@RequestParam String fromDate, @RequestParam String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        List<MonthlySalaryNewData> reports = reportService.getAggregatedMonthlySalaries(startDate, endDate);
        return ResponseEntity.ok(reports);
    }


    @GetMapping("/getEmployeeId")
    public List<String> getEmpolyeeid() {
        return reportService.getEmployeeId();
    }

    @GetMapping("/payArrears")
    public List<PayArrear> getPayArrears(
            @RequestParam String employeeId,
            @RequestParam int month,
            @RequestParam int year
    ) {
        return reportService.getPayArrearsWithDateOfFA(employeeId, month, year);
    }
}