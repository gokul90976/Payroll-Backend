package org.example.Repo;

import net.minidev.json.JSONObject;
import org.example.Entity.ProfessionalTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalTaxRepo extends JpaRepository<ProfessionalTax, Long> {


}
