package com.Liv2train.registry.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrainingCenters")
public class TrainingCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centerId;

	@NotBlank(message = "CenterName is mandatory")
	@Size(max = 40, message = "CenterName should not be a more then 40 characters")
	private String centerName;

	@NotBlank(message = "CenterCode is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
	private String centerCode;

	@Embedded
	@Valid
	private Address address;

	@Min(value = 1, message = "StudentCapacity is not less then zero")
	private Long studentCapacity;

	@ElementCollection
	private List<String> coursesOffered;

	private Instant createdOn;

	@Email(message = "Invalid email format")
	private String contactEmail;

	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	private String contactPhone;

	@PrePersist
	public void prePersist() {
		this.createdOn = Instant.now();
	}

}
