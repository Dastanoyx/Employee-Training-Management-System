package com.info3.etms.service;

import com.info3.etms.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<Training> getAllTrainings();

    Optional<Training> getTrainingById(Long id);

    Training createTraining(Training training);

    Training updateTraining(Long id, Training updatedTraining);

    void deleteTraining(Long id);
}
