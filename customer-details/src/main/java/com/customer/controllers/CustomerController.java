package com.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exceptions.CustomerException;
import com.customer.models.CustomerDetails;
import com.customer.services.CustomerService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Endpoint to get customer details based on registration number or all customers

	@GetMapping({ "/customerDetails", "/customerDetails/{regNumber}" })
	public ResponseEntity<?> getCustomerDetails(@PathVariable(required = false) @ApiParam("regNumber") String regNumber)
			throws CustomerException {

		return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerDetails(regNumber));
	}

	// End point to save customer details to customer db
	@PostMapping("/customerDetails/saveCustomer")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerDetails customerDetails) throws CustomerException {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.saveCustomer(customerDetails));
	}

}
