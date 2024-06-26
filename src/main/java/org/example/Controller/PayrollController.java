package org.example.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.example.DTO.MonthlysalaryData;
import org.example.Entity.*;
import org.example.Model.EmployeeIdFilter;
import org.example.Repo.RecoveryDataRepo;
import org.example.Service.PayrollService;
import org.example.common.ResponseDo;
import org.example.dataDto.*;
import org.example.exception.DuplicateEmployeeIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

//@CrossOrigin(origins = "https://payrollapi.tnhb.in", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200", "https://payrollapi.tnhb.in", "https://employee-corner.tnhb.in"}, allowedHeaders = "*")

// @RequestMapping("/api")
@RestController
public class PayrollController {
    private final ResponseDo responseDo;
    private final PayrollService payrollService;

    private final RecoveryDataRepo recoveryDataRepo;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    public PayrollController(PayrollService payrollService,
                             ResponseDo responseDo, RecoveryDataRepo recoveryDataRepo) {
        this.responseDo = responseDo;
        this.payrollService = payrollService;

        this.recoveryDataRepo = recoveryDataRepo;
    }

    @PostMapping("/saveEmployeePayRoll")
    public ResponseDo saveEmployeePayRoll(@RequestBody EmployeePayRoll employeePayRoll) {
        try {
            EmployeePayRoll savedEmployeePayRoll = payrollService.saveEmployeePayRoll(employeePayRoll);

            if (savedEmployeePayRoll != null) {
                return responseDo.setSuccessResponse(savedEmployeePayRoll);
            } else {
                return responseDo.setFailureResponse("Failed to save Employee PayRoll.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Employee PayRoll.");
        }
    }

    @PostMapping("/getEmployeePayRollByEmployeeId")
    public ResponseDo getEmployeePayRollByEmployeeId(@RequestBody JSONObject json) {

        String empId = json.getAsString("employeeId");
        try {
            EmployeePayRoll employeePayRoll = payrollService.getEmployeePayRollByEmployeeId(empId);
            return responseDo.setSuccessResponse(employeePayRoll);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/getEmployeePayRollBynId")
    public ResponseDo getEmployeePayRollBynId(@RequestBody JSONObject json) {

        Long nId = json.getAsNumber("nId").longValue();
        try {
            EmployeePayRoll employeePayRoll = payrollService.getEmployeePayRollBynId(nId);
            return responseDo.setSuccessResponse(employeePayRoll);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/getAllEmployeePayRoll")
    public ResponseDo getAllEmployeePayRoll(@RequestBody JSONObject json) {

        Long id = json.getAsNumber("id").longValue();
        try {
            List<EmployeePayRoll> salary = payrollService.getAllEmployeePayRoll();

            return responseDo.setSuccessResponse(salary);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/deleteEmployeePayRollBynId")
    public ResponseDo deleteEmployee(@RequestBody JSONObject json) {

        Long id = json.getAsNumber("id").longValue();
        try {
            EmployeePayRoll employeePayRoll = payrollService.deleteEmployeePayRoll(id);

            return responseDo.setSuccessResponse(employeePayRoll);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/saveTemporaryPayRoll")
    public ResponseDo saveTemporaryPayRoll(@RequestBody TemporaryEmployeePayroll temporaryEmployeePayroll) {
        try {
            TemporaryEmployeePayroll savedTemporaryPayRoll = payrollService.saveTemporaryEmployeePayRoll(temporaryEmployeePayroll);

            if (savedTemporaryPayRoll != null) {
                return responseDo.setSuccessResponse(savedTemporaryPayRoll);
            } else {
                return responseDo.setFailureResponse("Failed to save  Temporary Employee PayRoll.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Temporary Employee PayRoll.");
        }
    }

    @PostMapping("/getTemporaryEmployeePayRollById")
    public ResponseDo getTemporaryEmployeePayRollById(@RequestBody JSONObject json) {

        Long nId = json.getAsNumber("nId").longValue();
        try {
            TemporaryEmployeePayroll temporaryEmployeePayroll = payrollService.getTemporaryEmployeePayRollById(nId);
            return responseDo.setSuccessResponse(temporaryEmployeePayroll);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }


    //----------------------------------------------------------------------------------------------

    // check recovery data exist by employee id
//     @PostMapping("/checkRecoveryDataByEmpId")
//     public ResponseDo checkRecoveryDataById(@RequestBody JSONObject json) {
//         String employeeId = json.getAsString("employeeId");
//         try {
//             String recoveryData = payrollService.checkRecoveryDataByEmployeeId(employeeId);
//
//                 return responseDo.setSuccessResponse(recoveryData);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return responseDo.setFailureResponse("An error occurred");
//         }
//     }

    @PostMapping("/getAllTemporaryEmployeePayRoll")
    public ResponseDo getAllEmployeePayRoll() {

        try {
            List<TemporaryEmployeePayroll> salary = payrollService.getAllTemporaryEmployeePayRoll();

            return responseDo.setSuccessResponse(salary);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/saveRecoveryDataAndAdd")
    public ResponseDo saveRecoveryDataAndAdd(@RequestBody RecoveryData recovery) {
        try {
            RecoveryData data = payrollService.saveOrUpdateRecoveryDataAndAdd(recovery);

            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred during save.");
        }
    }

    @PostMapping("/getRecoveryDataByEmpId")

    public ResponseDo getRecoveryData(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("recoveryId").longValue();
        try {
            RecoveryData recoverydata = payrollService.getRecoveryDataById(id);
            return responseDo.setSuccessResponse(recoverydata);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


//    @PostMapping("/updateRecoveryData")
//    public ResponseDo updateRecoveryData(@RequestBody RecoveryData recovery) {
//        //Long id = json.getAsNumber("recoveryId").longValue();
//
//
//        try {
//            RecoveryData data = payrollService.updateRecoveryDataAndAdd(recovery);
//
//
//            return responseDo.setSuccessResponse(data);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred during save.");
//        }
//    }


//    @PostMapping("/updateRecoveryData")
//    public ResponseDo updateRecoveryData(@RequestBody RecoveryDataAdd recovery) {
//        try {
//            if (recovery.getRecoverydataId() != null) {
//                RecoveryData existingRecoveryData = payrollService.getRecoveryDataById(recovery.getRecoverydataId());
//
//                if (existingRecoveryData != null) {
//                    // Update relevant fields of existing RecoveryData object with values from the provided recovery object
//                    existingRecoveryData.setRecoveryData(recovery.getRecoveryData());
//
//                    // Save the updated RecoveryData object
//                    RecoveryData updatedRecoveryData = payrollService.saveRecoveryData(existingRecoveryData);
//
//                    return responseDo.setSuccessResponse(updatedRecoveryData);
//                } else {
//                    return responseDo.setFailureResponse("Recovery data not found for the provided ID");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred during save.");
//        }
//
//    }


//    @PostMapping("/updateRecoveryData")
//    public ResponseEntity<Object> updateRecoveryDataAdd(@RequestBody RecoveryDataAdd recoveryDataAdd) {
//        try {
//            // Update the RecoveryDataAdd object
//            ResponseEntity<Object> response = payrollService.updateRecoveryDataAdd(recoveryDataAdd);
//            return response;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("An error occurred during update.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/getAllRecoveryData")
    public ResponseDo getAllRecoveryData() {
        try {
            List<RecoveryData> data = payrollService.getAllRecoverysData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/deleteRecoveryDataAndAddById")
    public ResponseDo deleteRecoveryData(@RequestBody JSONObject json) {

        Long id = json.getAsNumber("recoveryId").longValue();
        try {
            payrollService.deleteRecoveryDataAndAddById(id);

            return responseDo.setSuccessResponse("Deleted Succesfully");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    // Recovery data main view delete
//    @PostMapping("/deleteRecoveryDataAndAddById")
//    public ResponseDo deleteRecoveryData(@RequestBody JSONObject json) {
//
//        Long id = json.getAsNumber("id").longValue();
//        try {
//            payrollService.deleteRecoveryDataAndAddById(id);
//
//            return responseDo.setSuccessResponse("Deleted Succesfully");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
//        }
//    }
//
//    // Recovery data main view delete
//    @PostMapping("/deleteRecoveryIndividualDeleteById")
//    public ResponseDo deleteRecoveryDataById(@RequestBody JSONObject json) {
//
//        Long id = json.getAsNumber("id").longValue();
//        try {
//            payrollService.deleteRecoveryIndData(id);
//
//            return responseDo.setSuccessResponse("Deleted Succesfully");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
//        }
//    }

    @PostMapping("/deleteRecoveryDataAddById")
    public ResponseDo deleteRecoveryAdd(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("recoverydataId").longValue();
        try {
            payrollService.deleteRecoveryDataAddById(id);
            return responseDo.setSuccessResponse("Deleted Succesfully");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    //ProfessionalTax ------------------------------------------------------------------------------
    @PostMapping("/saveProfessionalTax")
    public ResponseDo saveProfessional(@RequestBody ProfessionalTax taxCalculation) {
        try {
            ProfessionalTax savedProfessionalTax = payrollService.saveProfessionalTax(taxCalculation);

            return responseDo.setSuccessResponse(savedProfessionalTax);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllProfessionalTax")
    public ResponseDo getAllProfessionalTax(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<ProfessionalTax> calculation = payrollService.getAllProfessionalTax();

            return responseDo.setSuccessResponse(calculation);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

//    @PostMapping("/getTaxCalculationById")
//    public ResponseDo getTaxCalculationById(@RequestBody JSONObject json) {
//        Long id = json.getAsNumber("id").longValue();
//        try {
//            TaxCalculation calculation = payrollService.getTaxCalculationById(id);
//
//                return responseDo.setSuccessResponse(calculation);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
//        }
//    }

    @PostMapping("/updatedProfessionalTaxById")
    public ResponseDo updatedProfessionalTaxById(@RequestBody ProfessionalTax tax) {
        try {
            if (tax.getId() != null) {
                ProfessionalTax updatedProfessionalTaxList = payrollService.updateProfessionalTaxById(tax);
                return responseDo.setSuccessResponse(updatedProfessionalTaxList);
            } else {
                return responseDo.setFailureResponse("id not founded");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating ProfessionalTax");
        }
    }

    @PostMapping("/getProfessionalById")
    public ResponseDo getProfessionalById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            ProfessionalTax professionalTaxp = payrollService.getByIdProfessionalTax(id);

            return responseDo.setSuccessResponse(professionalTaxp);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/deleteProfessionalTaxById")
    public ResponseDo deleteProfessionalTaxById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteProfessionalTaxById(id);
            return responseDo.setSuccessResponse("Professional taxes deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    // Income Tax ------------------------------
    @PostMapping("/saveIncomeTax")
    public ResponseDo saveIncomeTax(@RequestBody IncomeTax taxCalculation) {
        try {
            IncomeTax saveIncomeTax = payrollService.saveIncomeTax(taxCalculation);

            return responseDo.setSuccessResponse(saveIncomeTax);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllIncomeTax")
    public ResponseDo getAllIncomeTax(@RequestBody JSONObject json) {
        // Long id = json.getAsNumber("id").longValue();
        try {
            List<IncomeTax> calculation = payrollService.getAllIncomeTax();

            return responseDo.setSuccessResponse(calculation);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getIncomeTaxById")
    public ResponseDo getIncomTaxById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();

        try {
            IncomeTax intax = payrollService.getIncomeTaxById(id);
            return responseDo.setSuccessResponse(intax);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/updatedIncomeTaxById")
    public ResponseDo updatedIncomeTaxById(@RequestBody IncomeTax tax) {
        try {
            if (tax.getId() != null) {
                IncomeTax updatedIncomeTaxList = payrollService.updatedIncomeTaxById(tax);
                return responseDo.setSuccessResponse(updatedIncomeTaxList);
            } else {
                return responseDo.setFailureResponse("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating IncomeTax");
        }
    }

    @PostMapping("/deleteIncomeTaxById")
    public ResponseDo deleteIncomeTaxById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteIncomeTaxById(id);
            return responseDo.setSuccessResponse("Income taxes deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    // DA Tax -----------------------------
    @PostMapping("/saveDaTax")
    public ResponseDo saveDaTax(@RequestBody DaTax taxCalculation) {
        try {
            DaTax saveDaTax = payrollService.saveDaTax(taxCalculation);

            return responseDo.setSuccessResponse(saveDaTax);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllDaTax")
    public ResponseDo getAllDaTax(@RequestBody JSONObject json) {
        // Long id = json.getAsNumber("id").longValue();
        try {
            List<DaTax> calculation = payrollService.getAllDaTax();

            return responseDo.setSuccessResponse(calculation);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getDaTaxById")
    public ResponseDo getDaTaxById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            DaTax da = payrollService.getDaById(id);
            return responseDo.setSuccessResponse(da);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");


        }
    }

    @PostMapping("/updateDaTaxById")
    public ResponseDo updateDaTaxById(@RequestBody DaTax tax) {

        try {
            if (tax.getId() != null) {
                DaTax updatedDaTax = payrollService.updateDaTax(tax);
                return responseDo.setSuccessResponse(updatedDaTax);
            } else {
                return responseDo.setFailureResponse("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating DaTax");
        }
    }

    //Common Field ------------------------------
//    @PostMapping("/saveCommonFields")
//    public ResponseDo saveCommonFields(@RequestBody CommonFields common){
//        try {
//            CommonFields saveCommon = payrollService.saveCommon(common);
//            return responseDo.setSuccessResponse(saveCommon);
//        } catch (Exception e){
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred while saving CommonField.");
//        }
//    }

    @PostMapping("/deleteDaTaxById")
    public ResponseDo deleteDaTaxById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteDaTaxById(id);
            return responseDo.setSuccessResponse("DA Tax deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    // Save Employee salary------------------------------------------------------------------------
    @PostMapping("/saveMonthlySalary")
    public ResponseDo saveMonthlySalary(@RequestBody MonthlySalary monthlySalary) {
        try {

            MonthlySalary saveMonthlySalary = payrollService.saveMonthlySalary(monthlySalary);

            return responseDo.setSuccessResponse(saveMonthlySalary);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving MonthlySalary.");
        }
    }

    @PostMapping("/getAllMonthlySalary")
    public ResponseDo getAllMonthlySalary() {

        try {
            List<MonthlySalary> monthlySalary = payrollService.getAllMonthlySalary();
            monthlySalary.sort(Comparator.comparing(MonthlySalary::getVoucherNo).reversed());
            return responseDo.setSuccessResponse(monthlySalary);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/saveMonthlySalaryNewData")
    public ResponseDo saveMonthlySalary(@RequestBody List<MonthlySalaryNewData> monthlySalaryNewData) {
        try {
            List<MonthlySalaryNewData> saveMonthlySalaryNewData = payrollService.saveMonthlySalaryNewData(monthlySalaryNewData);

            return responseDo.setSuccessResponse(saveMonthlySalaryNewData);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving MonthlySalary.");
        }
    }


//
//    @PostMapping("/getMonthlySalaryByVocherNo")
//    public ResponseDo getMonthlySalaryNewDataById(@RequestBody JSONObject json) {
//
//        Long voucherNo = json.getAsNumber("voucherNo").longValue();
//        try {
//            List<MonthlySalary> monthlySalaryNew = payrollService.getMonthlySalaryNewDataById(voucherNo);
//
//            return responseDo.setSuccessResponse(monthlySalaryNew);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred");
//        }
//
//    }

    @PostMapping("/getMonthlySalaryNewById")
    public ResponseDo getMonthlySalaryNewById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            MonthlySalaryNewData monthlySalaryNewData = payrollService.getMonthlySalaryNewById(id);

            if (monthlySalaryNewData != null) {
                return responseDo.setSuccessResponse(monthlySalaryNewData);
            } else {
                return responseDo.setFailureResponse("MonthlySalary with id " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while fetching MonthlySalary.");
        }
    }


//   @PostMapping("/getAllMonthlySalary")
//        public ResponseDo getAllMonthlySalary (@RequestBody JSONObject json){
//            String loggedInBy = json.getAsString("loggedInBy");
//            try {
//                List<MonthlySalary> monthlySalary = payrollService.getAllMonthlySalary(loggedInBy);
//
//                return responseDo.setSuccessResponse(monthlySalary);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return responseDo.setFailureResponse("An error occurred");
//            }
//        }

    @PostMapping("/updateMonthlySalaryById")
    public ResponseDo updateDaTaxById(@RequestBody MonthlySalary monthlySalary) {

        try {
            if (monthlySalary.getNId() != null) {
                MonthlySalary updatedMonthlysalary = payrollService.updateMonthlySalary(monthlySalary);
                return responseDo.setSuccessResponse(updatedMonthlysalary);
            } else {
                return responseDo.setFailureResponse("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating DaTax");
        }
    }

    // get monthly salary details by id
    @PostMapping("/getMonthlySalaryById")
    public ResponseDo getMonthlySalaryById(@RequestBody JSONObject json) {

        Long id = json.getAsNumber("id").longValue();
        try {
            MonthlySalary monthlySalary = payrollService.getMonthlySalaryById(id);

            return responseDo.setSuccessResponse(monthlySalary);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    //    @PostMapping("/getMonthlySalaryDataById")
//    public ResponseDo getMonthlySalaryDataById(@RequestBody JSONObject json) {
//
//        Long id = json.getAsNumber("id").longValue();
//        try {
//            MonthlySalaryNewData monthlySalaryNew = payrollService.getMonthlySalaryNewDataById(id);
//
//            return responseDo.setSuccessResponse(monthlySalaryNew);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred");
//        }
//    }
    @PostMapping("/getMonthlySalaryByVoucherNo")
    public ResponseDo getMonthlySalaryVoucherNo(@RequestBody JSONObject json) {

        Long voucher = json.getAsNumber("voucherNo").longValue();
        try {
            List<MonthlySalary> monthlySalary = payrollService.getMonthlySalaryVoucherNo(voucher);

            return responseDo.setSuccessResponse(monthlySalary);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }

    }

    // This Api except Assistant
//    @PostMapping("/getSalaryDetailsByRole")
//    public ResponseDo getSalaryDetailsByRole(@RequestBody JSONObject json) {
//        String role = json.getAsString("role");
//        try {
//            EmployeeSalaryHierarechy monthlySalaryData = payrollService.getAllEmployeeSalaryByRole(role);
//
//            return responseDo.setSuccessResponse(monthlySalaryData);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
//        }
//    }

    // Save Api For Employee Salary hierarchy
//    @PostMapping("/saveSalaryDetailsHierarechyByRole")
//    public ResponseDo saveSalaryDetailsHierarechy(@RequestBody EmployeeSalaryHierarechy savEmployeeSalaryHierarechy) {
//        try {
//            EmployeeSalaryHierarechy savedHierarechyData = payrollService.saveSalaryDetailsHierarechy(savEmployeeSalaryHierarechy);
//
//            return responseDo.setSuccessResponse(savedHierarechyData);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
//        }
//    }

    @PostMapping("/deleteMonthlySalaryById")
    public ResponseDo deleteMonthlySalaryById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            MonthlySalary monthlySalary = payrollService.deleteMonthlySalaryById(id);

            return responseDo.setSuccessResponse(monthlySalary);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/savePercentage")
    public ResponseDo createPercentage(@RequestBody Percentage percentage) {
        try {
            Percentage savedPercentage = payrollService.savePercentage(percentage);

            if (savedPercentage != null) {
                return responseDo.setSuccessResponse(savedPercentage);
            } else {
                return responseDo.setFailureResponse("Failed to save Employee PayRoll.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Employee PayRoll.");
        }
    }

    @PostMapping("/percentage")
    public ResponseDo getPercentageById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("percentageId").longValue();
        try {
            Percentage percentages = payrollService.getPercentageById(id);

            if (percentages != null) {
                return responseDo.setSuccessResponse(percentages);
            } else {
                return responseDo.setFailureResponse("Percentage with id " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while retrieving Percentage.");
        }

    }

    @PostMapping("/update/{id}") // Use appropriate mapping
    public ResponseDo updatePercentage(@PathVariable Long id, @RequestBody Percentage updatedPercentage) {
        try {
            // Fetch the existing Percentage entity from the database
            Percentage existingPercentage = payrollService.getPercentageById(id);

            if (existingPercentage != null) {
                // Update the existing Percentage entity with the new data
                existingPercentage.setCpsPercentage(updatedPercentage.getCpsPercentage());
                existingPercentage.setGpfPercentage(updatedPercentage.getGpfPercentage());
                existingPercentage.setHbfPercentage(updatedPercentage.getHbfPercentage());
                existingPercentage.setHrrPercentage(updatedPercentage.getHrrPercentage());
                existingPercentage.setItcPercentage(updatedPercentage.getItcPercentage());

                Percentage updatedPercentageEntity = payrollService.updatePercentage(existingPercentage);

                // Return success response with the updated entity
                return responseDo.setSuccessResponse(updatedPercentageEntity);
            } else {
                return responseDo.setFailureResponse("Percentage with id " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating Percentage.");
        }
    }

    @PostMapping("/getAllEmpId")
    public ResponseDo getAllEmployeeIds() {
        EmployeeIdFilter[] employeeIds = payrollService.getAllEmpId();
        return responseDo.setSuccessResponse(employeeIds);
    }

    @PostMapping("/updateRecoveryById/{recoveryId}")
    public ResponseDo updateRecoveryById(@RequestBody RecoveryData recovery, @PathVariable Long recoveryId) {
        try {
            if (recovery == null || recoveryId == null) {
                return responseDo.setFailureResponse("Invalid Recovery data or ID");
            }

            RecoveryData existingRecovery = payrollService.getRecoveryDataById(recoveryId);
            if (existingRecovery != null) {
                // Update only necessary fields of existingRecovery
                existingRecovery.setRecoveryDataAdd(recovery.getRecoveryDataAdd());

                // Save or update recovery data and associated additions
                RecoveryData updatedRecoveryData = payrollService.saveOrUpdateRecoveryDataAndAdd(existingRecovery);

                return responseDo.setSuccessResponse(updatedRecoveryData);
            } else {
                return responseDo.setFailureResponse("Recovery with ID " + recoveryId + " not found");
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating recovery data");
        }
    }

    @GetMapping("/next-nid-sequence")

    public ResponseEntity<Long> getNextNIdSequence() {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM tnestablishment.n_id_seq;");
            Long nextVal = ((Number) query.getSingleResult()).longValue();
            return new ResponseEntity<>(nextVal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //---------------------------HRA---------------------------//

    @PostMapping("/saveHra")
    public ResponseDo createHra(@RequestBody Hra hra) {
        try {
            Hra savedHra = payrollService.saveHra(hra);

            if (savedHra != null) {
                return responseDo.setSuccessResponse(savedHra);
            } else {
                return responseDo.setFailureResponse("Failed to save HRA.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Hra.");
        }
    }

    @PostMapping("/getHrayId")
    public ResponseDo getHraById(@RequestBody JSONObject json) {

        Long Hraid = json.getAsNumber("hraId").longValue();
        try {
            Hra Hraa = payrollService.getHraById(Hraid);

            return responseDo.setSuccessResponse(Hraa);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllHra")
    public ResponseEntity<ResponseDo> getAllHra(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Hra> hraPage = payrollService.getAllHra(pageable);
            return ResponseEntity.ok().body(responseDo.setSuccessResponse(hraPage));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDo.setFailureResponse("An error occurred while saving hra"));
        }
    }


    @PostMapping("/updateHra/{id}") // Use appropriate mapping
    public ResponseDo updatePercentage(@PathVariable Long id, @RequestBody Hra updatedHra) {
        try {
            // Fetch the existing Percentage entity from the database
            Hra existingHra = payrollService.getHraById(id);

            if (existingHra != null) {
                // Update the existing Percentage entity with the new data
                existingHra.setGrade01(updatedHra.getGrade01());
                existingHra.setGrade02(updatedHra.getGrade02());
                existingHra.setGrade03(updatedHra.getGrade03());
                existingHra.setGrade04(updatedHra.getGrade04());
                existingHra.setGrade05(updatedHra.getGrade05());
                existingHra.setPayRangeFrom(updatedHra.getPayRangeFrom());
                existingHra.setPayRangeTo(updatedHra.getPayRangeTo());

                Hra updatedHraData = payrollService.updateHra(existingHra);

                // Return success response with the updated entity
                return responseDo.setSuccessResponse(updatedHraData);
            } else {
                return responseDo.setFailureResponse("HRa with id " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while updating HRA.");
        }
    }

    @PostMapping("/deleteHraById")
    public ResponseDo deleteHraById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteHraById(id);
            return responseDo.setSuccessResponse("HRA deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting HRA");
        }
    }

    @PostMapping("/getAllHraData")
    public ResponseDo getAllHraData() {
        try {
            List<Hra> data = payrollService.getAllHraData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getGradeValue")
    public Long getGradeValue(@RequestParam Long range, @RequestParam String officeCode) {
        return payrollService.findGradeValue(range, officeCode);
    }

    //------------------------------------CCA--------------------------------------//
    @PostMapping("/saveCca")
    public ResponseDo createCca(@RequestBody Cca cca) {
        try {
            Cca savedCca = payrollService.saveCca(cca);

            if (savedCca != null) {
                return responseDo.setSuccessResponse(savedCca);
            } else {
                return responseDo.setFailureResponse("Failed to save CCA.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving CCA.");
        }
    }

    @PostMapping("/getCcaId")
    public ResponseDo getCcaById(@RequestBody JSONObject json) {

        Long Ccaid = json.getAsNumber("ccaId").longValue();
        try {
            Cca ccc = payrollService.getCcaById(Ccaid);

            return responseDo.setSuccessResponse(ccc);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllCcaData")
    public ResponseDo getAllCcaData() {
        try {
            List<Cca> data = payrollService.getAllCcaData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/deleteCcaById")
    public ResponseDo deleteCcaById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteCcaById(id);
            return responseDo.setSuccessResponse("CCA deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting CCA");
        }
    }

    @PostMapping("/getCCAValue")
    public Long getCCAValue(@RequestParam Long range, @RequestParam String officeCode) {
        return payrollService.findCCAValue(range, officeCode);

    }

    @PostMapping("/daPercentage")
    public Long getDaPercentage(@RequestParam("currentDate") String currentDate) {
        LocalDate currentDateParsed = LocalDate.parse(currentDate);
        return payrollService.findDaPercentage(currentDateParsed);
    }

    @PostMapping(value = "/special-pf-date")
    public ResponseEntity<String> calculateSpecialPFDate(@RequestBody TemporaryEmployeePayroll request) {
        // Parse the date of joining from the request
        LocalDate dateOfJoining = LocalDate.parse(request.getDateOfJoiningService());

        // Calculate the special PF date after 148 months
        LocalDate specialPFDate = dateOfJoining.plusMonths(148);

        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Create a JSON object to hold the response
        String jsonResponse = "{\"specialPFDate\": \"" + specialPFDate.format(formatter) + "\"}";

        // Return the response as JSON with HTTP status OK
        return ResponseEntity.ok().body(jsonResponse);
    }

    @PostMapping("/recovery-types")
    public ResponseEntity<Map<String, Long>> getRecoveryTypesByEmployeeId(@RequestBody Map<String, String> requestBody) {
        String employeeId = requestBody.get("employeeId");
        if (employeeId == null || employeeId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Assuming you have a service method to fetch the recovery types by employeeId
        Map<String, Long> recoveryTypes = payrollService.getRecoveryTypesByEmployeeId(employeeId);

        if (recoveryTypes == null || recoveryTypes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recoveryTypes);
    }


    //-------------------------------Pay Arrear------------------------------//

    @PostMapping("/savePayArrear")
    public ResponseDo createPayArrear(@RequestBody PayArrear[] payArrear) {
        try {
            List<PayArrear> savedPayArrear = payrollService.savePayArrears(payArrear);

            if (savedPayArrear != null) {
                return responseDo.setSuccessResponse(savedPayArrear);
            } else {
                return responseDo.setFailureResponse("Failed to save Pay Arrear.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Pay Arrear  .");
        }
    }

    @PostMapping("/getPayArrearData")
    public ResponseDo getPayArrearData(@RequestParam List<String> employeeIds, @RequestParam Long voucherNo) {

        try {
            List<PayArrear> data = payrollService.getPayArrearData(employeeIds, voucherNo);
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllPayArrearData")
    public ResponseDo getAllPayArrearData() {
        try {
            List<PayArrear> data = payrollService.getAllPayArrearData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/deletePayArrearById")
    public ResponseDo deletePayArrearById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deletePayArrearById(id);
            return responseDo.setSuccessResponse("Pay Arrear deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting Pay Arrear");
        }
    }


    @PostMapping("/getEmployeeData")
    public ResponseDo getEmployeeData(@RequestBody List<String> employeeIds) {
        try {
            List<EmployeeDataDto> data = payrollService.getEmployeeData(employeeIds);
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


    @PostMapping("/daPercentage-pay-arrear")
    public Long getDaPercentageInRange(@RequestParam("fromDate") String fromDate,
                                       @RequestParam("toDate") String toDate) {
        LocalDate fromDateParsed = LocalDate.parse(fromDate);
        LocalDate toDateParsed = LocalDate.parse(toDate);
        return payrollService.findDaPercentageInRange(fromDateParsed, toDateParsed);
    }

    //-------------------------------DA ARREAR ------------------------------------------//
    @PostMapping("/saveDaArrear")
    public ResponseDo createDaArrear(@RequestBody DaArrear[] daArrear) {
        try {
            List<DaArrear> savedDaArrear = payrollService.saveDaArrears(daArrear);

            if (savedDaArrear != null) {
                return responseDo.setSuccessResponse(savedDaArrear);
            } else {
                return responseDo.setFailureResponse("Failed to save DA Arrear.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving DA Arrear.");
        }
    }


    @PostMapping("/getDaArrearData")
    public ResponseDo getDaArrearData(@RequestParam List<String> employeeIds, Long voucherNo) {

        try {
            List<DaArrear> data = payrollService.getDaArrearData(employeeIds, voucherNo);
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllDaArrearData")
    public ResponseDo getAllDaArrearData() {
        try {
            List<DaArrear> data = payrollService.getAllDaArrearData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


    @PostMapping("/deleteDaArrearById")
    public ResponseDo deleteDaArrearById(@RequestBody JSONObject json) {
        Long id = json.getAsNumber("id").longValue();
        try {
            payrollService.deleteDaArrearById(id);
            return responseDo.setSuccessResponse("Da Arrear deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting DA Arrear");
        }
    }

    @PostMapping("/getDaEmployeeData")
    public ResponseDo getDaEmployeeData(@RequestBody List<String> employeeIds) {
        try {
            List<DaEmployeeDto> data = payrollService.getDaEmployeeData(employeeIds);
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/savePersonalDAta")
    public ResponseDo savePersoalData(@RequestBody PersonalData[] personalData) {
        try {
            List<PersonalData> savedPersonalData = payrollService.savePersonalData(personalData);

            if (savedPersonalData != null) {
                return responseDo.setSuccessResponse(savedPersonalData);
            } else {
                return responseDo.setFailureResponse("Failed to save Personal Data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Personal Data.");
        }
    }


    @PostMapping("/getAllPersonalData")
    public ResponseDo getAllDPersonalData() {
        try {
            List<PersonalData> data = payrollService.getAllPersonalData();
            return responseDo.setSuccessResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getPersonalByEmployeeId")
    public ResponseDo getPersonalByEmployeeId(@RequestBody JSONObject json) {

        String empId = json.getAsString("employeeId");
        try {
            PersonalData personalData = payrollService.getPersonalByEmployeeId(empId);
            return responseDo.setSuccessResponse(personalData);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/deleteAllPersonalData")
    public ResponseDo deleteAllPersonalData() {
        try {
            // Call a method in your service or repository to delete all personal data
            payrollService.deleteAllPersonalData();

            // Return success response
            return responseDo.setSuccessResponse("All personal data deleted successfully");
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting personal data");
        }
    }

    @PostMapping("/getEmployeePersonalData")
    public ResponseDo getEmployeePersonalData(@RequestBody JSONObject json) {
        String empId = json.getAsString("employeeId");

        PersonalData personalData = payrollService.getPersonalByEmployeeId(empId);
        EmployeePayRoll employeePayRoll = payrollService.getEmployeePayRollByEmployeeId(empId);
        EmployeeDataResponse employeeDataResponse = new EmployeeDataResponse(personalData, employeePayRoll);
        return responseDo.setSuccessResponse(employeeDataResponse);


    }

    @PostMapping("/saveConcess")
    public ResponseEntity<ResponseDo> createConcentional(@RequestBody Concessional concessional) {
        try {
            Concessional savedConcentional = payrollService.saveConcessional(concessional);

            if (savedConcentional != null) {
                return ResponseEntity.ok().body(responseDo.setSuccessResponse(savedConcentional));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(responseDo.setFailureResponse("Failed to save Concentional."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseDo.setFailureResponse("An error occurred while saving Concentional."));
        }
    }

    @PostMapping("/getConcentionalId")
    public ResponseDo getconcentionalById(@RequestBody JSONObject json) {

        Long ConcessionalId = json.getAsNumber("ConcessionalId").longValue();
        try {
            Concessional concentional = payrollService.getConcentionalById(ConcessionalId);

            return responseDo.setSuccessResponse(concentional);

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }


    @PostMapping("/getAllConcessData")
    public ResponseEntity<ResponseDo> getAllConcessData() {
        try {
            List<Concessional> data = payrollService.getAllConcessData();
            return ResponseEntity.ok().body(responseDo.setSuccessResponse(data));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseDo.setFailureResponse("An error occurred"));
        }
    }

    @PostMapping("/deleteConcessById")
    public ResponseDo deleteConcessById(@RequestBody Long concessionalId) {
        try {
            payrollService.deleteConcessById(concessionalId);
            return responseDo.setSuccessResponse("Concessional deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while deleting Concessional.");
        }
    }

    @PostMapping("/getConcessionValue")
    public Double getConcessionValue(@RequestParam Double range, @RequestParam String officeCode) {
        return payrollService.getConcessionValue(range, officeCode);

    }

    @PostMapping("/getProfessionalTaxAmount")
    public Long getProfessionalTaxAmount(@RequestBody String dateString) {
        dateString = dateString.trim().replace("\"", ""); // Remove leading/trailing whitespace and quotes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return payrollService.getProfessionalTaxAmount(date);
    }


    @PostMapping("/get-da-monthlySalary")
    public List<EmployeeDetails> getMonthlyDaData(@RequestParam("from") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
                                                  @RequestParam("to") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to) {

        return payrollService.getDamonthdata(from, to);
    }

    @PostMapping("/employee-details")
    public ResponseEntity<ResponseDo> getEmployeeDetails(
            @RequestParam("from") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
            @RequestParam("to") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to,
            @RequestParam Long daDiff) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            List<MonthlySalaryNewData> monthlySalaryNewDataList = payrollService.getMonthlySalaryNewDataList();
            List<MonthlySalary> monthlySalaryList = payrollService.getMonthlySalaryList();

            if (monthlySalaryNewDataList != null && !monthlySalaryNewDataList.isEmpty()) {
                List<Map<String, Object>> successResponse = payrollService.filterAndGroupEmployeeDetails(
                        monthlySalaryNewDataList, monthlySalaryList, from, to, formatter, daDiff);
                return ResponseEntity.ok(responseDo.setSuccessResponse(successResponse));
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDo.setFailureNoDataFoundResponse());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDo.setFailureResponse("Error occurred while fetching data: " + e.getMessage()));
        }
    }

    @PostMapping("/checkEmployeeId")
    public ResponseDo getEmployeeId(@RequestParam String employeeId) {
        if (recoveryDataRepo.existsByEmployeeId(employeeId)) {
            return responseDo.setFailureResponse("Already exist the employeeId " + employeeId);
        } else {
            return responseDo.setSuccessResponse(employeeId);
        }

    }

    @PostMapping("/EmployeeDataBasedOn-paymentStatus")
    public List<TemporaryEmployeePayroll> getAllEmployeeDataBasedOnpaymentStatus(String status) {


        return payrollService.getEmployeePayRollsByStatus(status);
    }
    @PostMapping("/saveAllMonthlySalaryId")
    public List<MonthlySalaryNewData> saveAllMonthlySalaryId(@RequestBody MonthlysalaryData monthlysalaryData){
        return payrollService.saveMonthlySalaryId(monthlysalaryData);
    }

//    @GetMapping("/financialYear")
//    public ResponseEntity<Map<String, Object>> getPayArrears(
//            @RequestParam List<String> employeeIds,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
//
//        Map<String, Object> result = payrollService.getPayArrearsWithDateOfFA(employeeIds, startDate, endDate);
//        return ResponseEntity.ok(result);
//    }

}









