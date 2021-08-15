package org.acme.rest.json;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/whoami")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WhoamiResource {

    private Set<Whoami> response = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));
    public WhoamiResource() {
        response.add(new Whoami("Quarkus", "I \uD83D\uDC95 Quarkus!!!"));
    }

    @GET
    public Whoami string() {
        return response.iterator().next();
    }
}