package io.hanshin.datamodel.repository;

import io.hanshin.datamodel.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
