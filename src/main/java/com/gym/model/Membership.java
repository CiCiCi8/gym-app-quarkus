package com.gym.model;

import java.util.List;

public class Membership {

    public Long id;
    public String name;
    public Double price;

    // OneToMany: jedan membership -> više članova
    public List<Member> members;
}