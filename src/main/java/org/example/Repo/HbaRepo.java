package org.example.Repo;

import org.example.Entity.HbaReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HbaRepo extends JpaRepository<HbaReport, Long> {
    List<HbaReport> findByEmployeeId(String employeeId);
}
