package com.gym.resource;

import com.gym.clients.IpClient;
import com.gym.clients.TimeZoneClient;
import com.gym.model.Member;
import com.gym.model.TimeResponse;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class TimeZoneResource {

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeZoneClient timeZoneClient;

    @Inject
    EntityManager em;

    @GET
    @Path("timezone/current")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentTimeZone() {
        String ip = ipClient.getPublicIp();
        System.out.println("IP adresa je: " + ip);

        TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);
        System.out.println(timeResponse);

        return Response.ok(timeResponse).build();
    }

    @GET
    @Path("getTimezoneByIP")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getTimezoneByIP(@QueryParam("userId") Long userId) {
        Member member = em.find(Member.class, userId);

        if (member == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Member nije pronadjen")
                    .build();
        }

        String ip = ipClient.getPublicIp();
        System.out.println("IP adresa je: " + ip);

        TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);

        timeResponse.member = member;
        em.persist(timeResponse);

        System.out.println(timeResponse);

        return Response.ok(timeResponse).build();
    }
}