package org.example.Repo;

import org.example.Entity.OneDayRecoveryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OneDayRecoveryRepo extends JpaRepository<OneDayRecoveryReport, Long> {
    List<OneDayRecoveryReport> findByEmployeeId(String employeeId);
}
