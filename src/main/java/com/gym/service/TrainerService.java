package com.gym.service;

import com.gym.model.GroupClass;
import com.gym.model.Trainer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TrainerService {

    public List<GroupClass> getGroupClassesByTrainerId(Long id) {
        return GroupClass.list("trainer.id", id);
    }

    public Trainer getTrainerById(Long id) {
        return Trainer.findById(id);
    }
}