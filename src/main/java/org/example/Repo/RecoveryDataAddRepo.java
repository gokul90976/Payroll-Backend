package org.example.Repo;


import java.util.List;

import org.example.Entity.RecoveryDataAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RecoveryDataAddRepo extends JpaRepository<RecoveryDataAdd, Long> {


//    List<RecoveryDataAdd> findAllBymId(String nId);

//    List<RecoveryDataAdd> findAllByEmployeeId(String employeeId);


//    @Transactional
//    void deleteBymId(Long id);

//    @Transactional
//    void deleteByEmployeeId(String employeeId);
}
