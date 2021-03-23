package com.police.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.police.broadcast.BroadcastHandler;
import com.police.entities.CustomerViolationEntity;
import com.police.entities.ViolationDetailsEntity;
import com.police.exceptions.PoliceException;
import com.police.repositories.CustomerViolationRepository;
import com.police.repositories.ViolationRepository;

@Service
public class PoliceService {
	
	@Autowired
	private ViolationRepository violationRepository;
	
	@Autowired
	private CustomerViolationRepository customerViolationRepository;
	
	@Autowired
	private BroadcastHandler broadcastHandler;

	// method to get all violation details with penalties
	public List<ViolationDetailsEntity> getAllViolationDetails() {
		
		return violationRepository.findAll();
	}
	// method to save customer violation details
	public CustomerViolationEntity saveCustomerViolationDetails(CustomerViolationEntity customerViolationDetails) {
		
		return customerViolationRepository.save(customerViolationDetails);
		
	}
	// method to get violation details based on registration number or all 
	public List<CustomerViolationEntity> getCustomerViolationDetails(String regNumber) {
		List<CustomerViolationEntity> customerViolationList= null;
		if (regNumber == null) {
			customerViolationList = getAllCustomerViolationDetails();
		} else {
			customerViolationList = getSpecificCustomerViolationDetails(regNumber);
		}

		return customerViolationList;
	}

	private List<CustomerViolationEntity> getSpecificCustomerViolationDetails(String regNumber) {
		return customerViolationRepository.findAllByVehicleRegNumber(regNumber);
		
	}

	private List<CustomerViolationEntity> getAllCustomerViolationDetails() {
		return customerViolationRepository.findAll();
	}

	//method to get all pending violations of customer based on registration number and broadcast the same to portal
	public List<CustomerViolationEntity> getPendingViolationDetils(String regNumber) {
		 List<CustomerViolationEntity> findPendingViolationDetails = customerViolationRepository.findPendingViolationDetails(regNumber,"Pending");
		 broadcastHandler.broadcast(findPendingViolationDetails.toString());
		 return findPendingViolationDetails;
	}
	// method to update violation details of the customer
	public CustomerViolationEntity updateCustomerViolationDetails(CustomerViolationEntity customerViolationDetails) throws PoliceException {
		CustomerViolationEntity customerViolationEntity = null;
		if (customerViolationDetails.getVehicleRegNumber()!= null && !customerViolationDetails.getVehicleRegNumber().isEmpty()) {
			customerViolationEntity = customerViolationRepository.saveAndFlush(customerViolationDetails);
		} else {
			throw new PoliceException ("Wrong input",HttpStatus.CONFLICT);
		}
		return customerViolationEntity;
	}

}
