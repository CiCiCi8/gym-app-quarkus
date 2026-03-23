package com.gym.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Member extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String email;

    // Relacije predstavljene bez JPA anotacija
    public transient Membership membership;
    public transient List<GroupClass> groupClasses;
    public transient List<WorkoutPlan> workoutPlans;
}