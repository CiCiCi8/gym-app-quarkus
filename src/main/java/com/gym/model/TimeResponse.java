package com.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class TimeResponse extends PanacheEntity {

    public String timeZone;
    public String dateTime;
    public String date;
    public String time;
    public String dayOfWeek;

    public boolean dstActive;

    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int seconds;

    @ManyToOne
    @JsonIgnore
    public Member member;
}