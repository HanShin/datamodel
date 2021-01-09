package io.hanshin.datamodel.repository;

import io.hanshin.datamodel.model.entity.HomeMovingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeMovingRequestRepository extends JpaRepository<HomeMovingRequest,Integer> {
}
