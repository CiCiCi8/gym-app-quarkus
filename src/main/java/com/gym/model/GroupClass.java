package com.gym.model;

import java.util.List;

public class GroupClass {

    public Long id;
    public String name;
    public String schedule;

    // ManyToMany: više članova <-> više grupnih treninga
    public List<Member> members;

    // ManyToOne strana prema treneru
    public Trainer trainer;
}