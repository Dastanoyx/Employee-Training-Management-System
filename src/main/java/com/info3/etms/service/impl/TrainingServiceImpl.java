package com.info3.etms.service.impl;

import com.info3.etms.model.Training;
import com.info3.etms.repository.TrainingRepository;
import com.info3.etms.service.TrainingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long id, Training updatedTraining) {
        return trainingRepository.findById(id).map(existingTraining -> {
            existingTraining.setName(updatedTraining.getName());
            existingTraining.setDepartment(updatedTraining.getDepartment());
            return trainingRepository.save(existingTraining);
        }).orElseThrow(() -> new RuntimeException("Training not found with id " + id));
    }

    @Override
    public void deleteTraining(Long id) {
        if (!trainingRepository.existsById(id)) {
            throw new RuntimeException("Training not found with id " + id);
        }
        trainingRepository.deleteById(id);
    }
}
