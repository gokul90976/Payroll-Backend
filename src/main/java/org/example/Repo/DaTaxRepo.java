package org.example.Repo;

import org.example.Entity.DaTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaTaxRepo extends JpaRepository<DaTax, Long> {
}
