package com.example.demo.resources;

import com.example.demo.entities.Medecin;
import com.example.demo.services.MedecinService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Path("/medecins")
public class MedecinRS {

    @Autowired
    private MedecinService medecinService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMedecin(Medecin medecin) {
        Medecin createdMedecin = medecinService.createMedecin(medecin);
        return Response.status(Response.Status.CREATED).entity(createdMedecin).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medecin> getAllMedecins() {
        return medecinService.getAllMedecins();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedecinById(@PathParam("id") Long id) {
        return medecinService.getMedecinById(id)
                .map(medecin -> Response.ok(medecin).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMedecin(@PathParam("id") Long id, Medecin medecin) {
        Medecin updatedMedecin = medecinService.updateMedecin(id, medecin);
        return updatedMedecin != null ? Response.ok(updatedMedecin).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedecin(@PathParam("id") Long id) {
        medecinService.deleteMedecin(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
