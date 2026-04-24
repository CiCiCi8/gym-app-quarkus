package com.gym.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;

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
    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<TimeResponse> timeResponses = new ArrayList<>();

    @Transient
    public List<GroupClass> groupClasses;


}