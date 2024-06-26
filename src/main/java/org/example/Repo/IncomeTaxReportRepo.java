package org.example.Repo;

import org.example.Entity.IncomeTaxReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeTaxReportRepo extends JpaRepository<IncomeTaxReport, Long> {
    List<IncomeTaxReport> findByEmployeeId(String employeeId);
}
