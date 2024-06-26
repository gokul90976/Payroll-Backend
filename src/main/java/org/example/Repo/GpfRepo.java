package org.example.Repo;

import org.example.Entity.GpfReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpfRepo extends JpaRepository<GpfReport, Long> {
    List<GpfReport> findByEmployeeId(String employeeId);
}
