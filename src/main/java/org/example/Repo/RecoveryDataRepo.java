package org.example.Repo;

import java.util.List;
import java.util.Optional;

import org.example.Entity.RecoveryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecoveryDataRepo extends JpaRepository<RecoveryData, Long> {

    List<RecoveryData> findByEmployeeId(String employeeId);


    boolean existsByEmployeeId(String employeeId);
}
