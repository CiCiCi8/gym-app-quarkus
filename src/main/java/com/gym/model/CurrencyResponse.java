package com.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class CurrencyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "currency_from")
    public String from;

    @Column(name = "currency_to")
    public String to;

    public Double rate;

    public double value;
    public double convertedValue;

    @ManyToOne
    @JsonIgnore
    public Member member;
}