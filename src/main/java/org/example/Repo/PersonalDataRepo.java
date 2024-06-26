package org.example.Repo;

import org.example.Entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDataRepo extends JpaRepository<PersonalData, Long> {
    PersonalData findByEmployeeId(String empId);
    // List<PersonalData> findAllByEmployeeIdIn(List<String> employeeIds);

    //PersonalData findByEmployeeId(String employeeId);
}
