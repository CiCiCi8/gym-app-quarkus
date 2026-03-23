package com.gym.model;

import java.util.List;

public class Trainer {

    public Long id;
    public String firstName;
    public String lastName;
    public String specialization;

    // OneToMany: jedan trener -> više grupnih treninga
    public List<GroupClass> groupClasses;

    // OneToMany: jedan trener -> više planova treninga
    public List<WorkoutPlan> workoutPlans;
}