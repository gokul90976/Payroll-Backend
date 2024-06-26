package org.example.Repo;

import org.example.Entity.SpecialPfReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialPfRepo extends JpaRepository<SpecialPfReport, Long> {
    List<SpecialPfReport> findByEmployeeId(String employeeId);
}
