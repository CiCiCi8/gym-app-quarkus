package com.gym.clients;

import com.gym.model.TimeResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

// klijent za dobijanje vremenske zone
@RegisterRestClient(configKey = "timezone-api")
public interface TimeZoneClient {

    @GET
    @Path("/api/time/current/ip")
    TimeResponse getTimeByIp(@QueryParam("ipAddress") String ipAddress);
}