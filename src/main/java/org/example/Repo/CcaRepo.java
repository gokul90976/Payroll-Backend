package org.example.Repo;

import org.example.Entity.Cca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcaRepo extends JpaRepository<Cca, Long> {
}
