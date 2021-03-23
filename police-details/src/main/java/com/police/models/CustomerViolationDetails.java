package com.police.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerViolationDetails {
	
	private String customerName;
	
	private String vehicleRegNumber;
	
	private String vehicleName;
	
	private String violationDate;
	
	private String violationType;
	
	private String violationPenalty;

}
