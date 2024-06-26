package org.example.Repo;

import org.example.Entity.EmployeeSalaryHierarechy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryHierarchyRepo extends JpaRepository<EmployeeSalaryHierarechy, Long> {

    // EmployeeSalaryHierarechy findByRole(String role);
}
