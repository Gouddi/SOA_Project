package com.example.demo.resources;

import com.example.demo.entities.Prescription;
import com.example.demo.services.PrescriptionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Path("/prescriptions")
public class PrescriptionRS {

    @Autowired
    private PrescriptionService prescriptionService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPrescription(Prescription prescription) {
        Prescription createdPrescription = prescriptionService.createPrescription(prescription);
        return Response.status(Response.Status.CREATED).entity(createdPrescription).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("id") Long id) {
        return prescriptionService.getPrescriptionById(id)
                .map(prescription -> Response.ok(prescription).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("id") Long id, Prescription prescription) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescription);
        return updatedPrescription != null ? Response.ok(updatedPrescription).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") Long id) {
        prescriptionService.deletePrescription(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
