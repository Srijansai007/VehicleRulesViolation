package com.police.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer_violation_details")
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerViolationEntity implements Serializable {
	
	private static final long serialVersionUID = -3641002458443334406L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer customerId;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "vehicleRegNumber")
	private String vehicleRegNumber;
	
	@Column(name = "vehicleName")
	private String vehicleName;

	@Column(name = "violationDate")
	private String violationDate;
	
	@Column(name = "violationType")
	private String violationType;
	
	@Column(name = "violationPenalty")
	private String violationPenalty;
	
	@Column(name = "violationStatus")
	private String violationStatus;
	




}

