package com.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class GroupClass extends PanacheEntity {

    public String name;
    public String schedule;

    @ManyToOne
    @JsonIgnore
    public Trainer trainer;

    @Transient
    public List<Member> members;
}