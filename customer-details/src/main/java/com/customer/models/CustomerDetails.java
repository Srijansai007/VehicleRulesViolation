package com.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDetails {
	
	private String customerName;
	
	private String vehicleRegNumber;
	
	private String vehicleColor;
	
	private String purchaseDate;
	
	private String vehicleType;
	
	private String vehicleName;

}
