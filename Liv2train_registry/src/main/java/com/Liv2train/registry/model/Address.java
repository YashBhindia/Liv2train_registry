package com.Liv2train.registry.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

	@NotBlank(message = "Detailed Address is mandatory")
	private String detailedAddress;

	@NotBlank(message = "City is mandatory")
	private String city;

	@NotBlank(message = "State is mandatory")
	private String state;

	@Pattern(regexp = "^\\d{6}$", message = "Pincode must be a 6-digit number")
	private String pincode;
}
