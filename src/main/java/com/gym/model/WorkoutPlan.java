package com.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class WorkoutPlan extends PanacheEntity {

    public String name;
    public String goal;

    @OneToOne
    public ExercisePlan exercisePlan;

    @ManyToOne
    @JsonIgnore
    public Member member;

    @Transient
    public Trainer trainer;

    @Transient
    public List<Member> members;
}