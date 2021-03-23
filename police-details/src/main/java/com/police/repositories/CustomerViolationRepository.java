package com.police.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.police.entities.CustomerViolationEntity;

@Repository
public interface CustomerViolationRepository extends JpaRepository<CustomerViolationEntity, Integer> {

	List<CustomerViolationEntity> findAllByVehicleRegNumber(String regNumber);

	@Query("from CustomerViolationEntity where vehicleRegNumber =?1 and violationStatus = 'Pending' ")
	List<CustomerViolationEntity> findPendingViolationDetails(String regNumber, String string);

}
