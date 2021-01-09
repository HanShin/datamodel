package io.hanshin.datamodel.repository;

import io.hanshin.datamodel.model.entity.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {
}
