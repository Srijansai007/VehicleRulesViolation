package com.customer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer.entities.CustomerEntity;
import com.customer.exceptions.CustomerException;
import com.customer.models.CustomerDetails;
import com.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// method to get customer details based on registration number or call customer details
	public List<CustomerDetails> getCustomerDetails(String regNumber) throws CustomerException {
		List<CustomerDetails> customerDetailsList = null;
		if (regNumber == null) {
			customerDetailsList = getAllCustomerDetails();
		} else {
			customerDetailsList = getCustomer(regNumber);
		}
		return customerDetailsList;
	}

	private List<CustomerDetails> getCustomer(String regNumber) throws CustomerException {
		CustomerDetails customerDetails = new CustomerDetails();
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		if (!regNumber.isEmpty() && regNumber != null) {
			CustomerEntity customerEntity = customerRepository.findByVehicleRegNumber(regNumber);
			if (customerEntity != null) {
				customerDetails = new CustomerDetails();
				customerDetails.setCustomerName(customerEntity.getCustomerName());
				customerDetails.setPurchaseDate(customerEntity.getPurchaseDate());
				customerDetails.setVehicleColor(customerEntity.getVehicleColor());
				customerDetails.setVehicleName(customerEntity.getVehicleName());
				customerDetails.setVehicleRegNumber(customerEntity.getVehicleRegNumber());
				customerDetails.setVehicleType(customerEntity.getVehicleType());
				customerDetailsList.add(customerDetails);
			} else {
				throw new CustomerException("Customer is not present", HttpStatus.NOT_FOUND);
			}
		}
		return customerDetailsList;
	}

	private List<CustomerDetails> getAllCustomerDetails() {
		CustomerDetails customerDetails = new CustomerDetails();
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		List<CustomerEntity> findAll = customerRepository.findAll();
		for (CustomerEntity customerEntity : findAll) {
			customerDetails.setCustomerName(customerEntity.getCustomerName());
			customerDetails.setPurchaseDate(customerEntity.getPurchaseDate());
			customerDetails.setVehicleColor(customerEntity.getVehicleColor());
			customerDetails.setVehicleName(customerEntity.getVehicleName());
			customerDetails.setVehicleRegNumber(customerEntity.getVehicleRegNumber());
			customerDetails.setVehicleType(customerEntity.getVehicleType());
			customerDetailsList.add(customerDetails);
		}
		return customerDetailsList;
	}
	// method to save customer details
	public String saveCustomer(CustomerDetails customerDetails) throws CustomerException {
		CustomerEntity savedCustomer = null;
		var status = "";
		if (customerDetails != null) {
			if (customerRepository.findByVehicleRegNumber(customerDetails.getVehicleRegNumber()) == null) {
				CustomerEntity customerEntity = new CustomerEntity();
				customerEntity.setCustomerName(customerDetails.getCustomerName());
				customerEntity.setPurchaseDate(customerDetails.getPurchaseDate());
				customerEntity.setVehicleColor(customerDetails.getVehicleColor());
				customerEntity.setVehicleName(customerDetails.getVehicleName());
				customerEntity.setVehicleRegNumber(customerDetails.getVehicleRegNumber());
				customerEntity.setVehicleType(customerDetails.getVehicleType());
				savedCustomer = customerRepository.save(customerEntity);
			} else {
				throw new CustomerException("Customer is already present", HttpStatus.FORBIDDEN);
			}
			
			if(savedCustomer!=null) {
				status = "Customer Saved Successfully";
			} else {
				status ="Customer not saved Scuccessfully";
			}

		}
		return status;
	}

}
