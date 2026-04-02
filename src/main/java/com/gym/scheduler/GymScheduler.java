package com.gym.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GymScheduler {

    @Scheduled(every = "10s")
    void printMessage() {
        System.out.println("Scheduler radi - provjera svakih 10 sekundi");
    }
}