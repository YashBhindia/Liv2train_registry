package com.Liv2train.registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Liv2train.registry.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>{

	List<TrainingCenter> findByCenterName(String centerName);
    List<TrainingCenter> findByCoursesOffered(String course);
}
