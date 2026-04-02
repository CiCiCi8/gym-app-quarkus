package com.gym.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class Member extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String email;

    @OneToOne
    public MembershipCard membershipCard;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    public List<WorkoutPlan> workoutPlans;

    @Transient
    public List<GroupClass> groupClasses;
}