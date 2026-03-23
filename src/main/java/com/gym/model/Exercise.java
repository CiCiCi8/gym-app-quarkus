package com.gym.model;

public class Exercise {

    public Long id;
    public String name;
    public Integer reps;

    // OneToOne druga strana
    public WorkoutPlan workoutPlan;
}