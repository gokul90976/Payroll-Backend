package org.example.Repo;

import org.example.Entity.Percentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageRepo extends JpaRepository<Percentage, Long> {

}
