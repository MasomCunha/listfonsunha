package www.github.MasomCunha.weblist.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestEndpoint {

    @GET
    @Produces(value = MediaType.TEXT_HTML)
    public Response test() {
        return Response.ok("Hello World!!").build();
    }
}
