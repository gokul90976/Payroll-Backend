package org.example.Repo;

import org.example.Entity.ProfessionalTaxReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalTaxReportRepo extends JpaRepository<ProfessionalTaxReport, Long> {
    List<ProfessionalTaxReport> findByEmployeeId(String employeeId);
}
