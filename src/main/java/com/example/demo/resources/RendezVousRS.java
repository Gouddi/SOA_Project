package com.example.demo.resources;

import com.example.demo.entities.RendezVous;
import com.example.demo.services.RendezVousService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Path("/rendezvous")
public class RendezVousRS {

    @Autowired
    private RendezVousService rendezVousService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRendezVous(RendezVous rendezVous) {
        RendezVous created = rendezVousService.createRendezVous(rendezVous);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRendezVousById(@PathParam("id") Long id) {
        return rendezVousService.getRendezVousById(id)
                .map(rdv -> Response.ok(rdv).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRendezVous(@PathParam("id") Long id, RendezVous rendezVous) {
        RendezVous updated = rendezVousService.updateRendezVous(id, rendezVous);
        return updated != null ? Response.ok(updated).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRendezVous(@PathParam("id") Long id) {
        rendezVousService.deleteRendezVous(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
