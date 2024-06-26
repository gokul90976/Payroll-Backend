package org.example.Repo;

import org.example.Entity.RentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepo extends JpaRepository<RentReport, Long> {
    List<RentReport> findByEmployeeId(String employeeId);
}
