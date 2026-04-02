package com.gym.resource;

import com.gym.model.GroupClass;
import com.gym.model.Trainer;
import com.gym.service.TrainerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TrainerResource {

    @Inject
    TrainerService trainerService;

    @GET
    @Path("trainer/{id}")
    public Trainer getTrainerById(@PathParam("id") Long id) {
        return trainerService.getTrainerById(id);
    }

    @GET
    @Path("trainer/{id}/groupclasses")
    public List<GroupClass> getGroupClasses(@PathParam("id") Long id) {
        return trainerService.getGroupClassesByTrainerId(id);
    }
}