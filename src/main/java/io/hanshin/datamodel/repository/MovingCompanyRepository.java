package io.hanshin.datamodel.repository;

import io.hanshin.datamodel.model.entity.MovingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovingCompanyRepository extends JpaRepository<MovingCompany,Integer> {
}
