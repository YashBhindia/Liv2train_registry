package com.Liv2train.registry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Liv2train.registry.model.TrainingCenter;
import com.Liv2train.registry.service.TrainingCenterServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
@Validated
public class TrainingCeneterController {

	@Autowired
	private TrainingCenterServiceImpl trainingCenterServiceImpl;

	@PostMapping
	public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		TrainingCenter savedTrainingCenter = trainingCenterServiceImpl.createTrainingCenter(trainingCenter);
		return new ResponseEntity<>(savedTrainingCenter, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(@RequestParam(required = false) String centerName,
			@RequestParam(required = false) String course) {
		List<TrainingCenter> response = trainingCenterServiceImpl.getAllTrainingCenters(centerName, course);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
