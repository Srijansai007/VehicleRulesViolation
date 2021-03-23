package com.police.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.police.entities.CustomerViolationEntity;
import com.police.exceptions.PoliceException;
import com.police.services.PoliceService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/police")
public class PoliceController {

	@Autowired
	private PoliceService policeService;
	
	// Endpoint to get all violation types
	@GetMapping("/allViolationDetails/")
	public ResponseEntity<?> getAllViolationDetails() {

		return ResponseEntity.status(HttpStatus.OK).body(policeService.getAllViolationDetails());
	}

	// Endpoint to  save customer violations
	@PostMapping("/customerViolationDetails/saveCustomerviolation")
	public ResponseEntity<?> saveCustomerViolationDetails(
			@RequestBody CustomerViolationEntity customerViolationDetails) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(policeService.saveCustomerViolationDetails(customerViolationDetails));
	}

	// Endpoint to get all violations based on registration number or all violations from db
	@GetMapping({ "/customerAllViolationDetails", "/customerViolationDetails/{regNumber}" })
	public ResponseEntity<?> getCustomerViolationDetails(
			@PathVariable(required = false) @ApiParam("regNumber") String regNumber) {

		return ResponseEntity.status(HttpStatus.OK).body(policeService.getCustomerViolationDetails(regNumber));
	}
	// Endpoint to get all pending violations of customer based on registration number
	@GetMapping ("customerPendingViolations/{regNumber}")
	public ResponseEntity<?> getCustomerPendingViolation (@PathVariable String regNumber){
		return ResponseEntity.status(HttpStatus.OK).body(policeService.getPendingViolationDetils(regNumber));
	}
	
	// Endpoint to update customer violation details
	@PutMapping("/customerViolationDetails/updateCustomerviolation")
	public ResponseEntity<?> updateCustomerViolationDetails(
			@RequestBody CustomerViolationEntity customerViolationDetails) throws PoliceException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(policeService.updateCustomerViolationDetails(customerViolationDetails));
	}
}
