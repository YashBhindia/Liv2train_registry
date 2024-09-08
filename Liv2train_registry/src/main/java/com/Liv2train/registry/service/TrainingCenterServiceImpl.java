package com.Liv2train.registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Liv2train.registry.exception.TrainingCenterException;
import com.Liv2train.registry.model.TrainingCenter;
import com.Liv2train.registry.repository.TrainingCenterRepository;

@Service

public class TrainingCenterServiceImpl implements TrainingCenterService {

	@Autowired
	private TrainingCenterRepository trainingCenterRepository;

	@Override
	public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) throws TrainingCenterException {
		// TODO Auto-generated method stub

		return trainingCenterRepository.save(trainingCenter);

	}

	@Override
	public List<TrainingCenter> getAllTrainingCenters(String centerName, String course) {
		// TODO Auto-generated method stub
		if (centerName != null && !centerName.isEmpty()) {
			return trainingCenterRepository.findByCenterName(centerName);
		} else if (course != null && !course.isEmpty()) {
			return trainingCenterRepository.findByCoursesOffered(course);
		} else {
			return trainingCenterRepository.findAll(); 
		}
	}

}
