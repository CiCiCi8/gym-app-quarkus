package com.gym.model;

import java.util.List;

public class WorkoutPlan {

    public Long id;
    public String name;
    public String goal;

    // ManyToMany: više članova <-> više planova
    public List<Member> members;

    // ManyToOne strana prema treneru
    public Trainer trainer;

    // OneToOne: plan <-> exercise
    public Exercise exercise;
}