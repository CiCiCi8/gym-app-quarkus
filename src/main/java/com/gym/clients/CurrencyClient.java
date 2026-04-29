package com.gym.clients;

import com.gym.model.CurrencyResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "currency-api")
public interface CurrencyClient {

    @GET
    @Path("/api/rates")
    CurrencyResponse getRates(@QueryParam("from") String from,
                              @QueryParam("to") String to);
}