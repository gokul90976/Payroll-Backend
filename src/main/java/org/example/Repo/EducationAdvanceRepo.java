package org.example.Repo;

import org.example.Entity.EducationAdvanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationAdvanceRepo extends JpaRepository<EducationAdvanceReport, Long> {
    List<EducationAdvanceReport> findByEmployeeId(String employeeId);
}
