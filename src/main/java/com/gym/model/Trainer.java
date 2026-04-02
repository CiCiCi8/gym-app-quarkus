package com.gym.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Trainer extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String specialization;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    public List<GroupClass> groupClasses;
}