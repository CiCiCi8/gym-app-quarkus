package com.gym.resource;

import com.gym.clients.CurrencyClient;
import com.gym.model.CurrencyResponse;
import com.gym.model.Member;
import jakarta.annotation.security.RolesAllowed;
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
public class CurrencyResource {

    @Inject
    @RestClient
    CurrencyClient currencyClient;

    @Inject
    EntityManager em;

    @GET
    @Path("currencyConversion")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response currencyConversion(@QueryParam("from") String from,
                                       @QueryParam("to") String to,
                                       @QueryParam("value") double value,
                                       @QueryParam("userId") Long userId) {

        Member member = em.find(Member.class, userId);

        if (member == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Member nije pronadjen")
                    .build();
        }

        CurrencyResponse currencyResponse = currencyClient.getRates(from, to);

        currencyResponse.value = value;
        currencyResponse.convertedValue = value * currencyResponse.rate;
        currencyResponse.member = member;

        em.persist(currencyResponse);

        return Response.ok(currencyResponse).build();
    }
}