package com.Liv2train.registry.service;

import java.util.List;

import com.Liv2train.registry.exception.TrainingCenterException;
import com.Liv2train.registry.model.TrainingCenter;

public interface TrainingCenterService {

	public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) throws TrainingCenterException;

	public List<TrainingCenter> getAllTrainingCenters(String centerName, String course);
}
