package com.example.demo.resources;

import com.example.demo.entities.Patient;
import com.example.demo.services.PatientService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Path("/patients")
public class PatientRS {

    @Autowired
    private PatientService patientService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPatient(Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return Response.status(Response.Status.CREATED).entity(createdPatient).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") Long id) {
        return patientService.getPatientById(id)
                .map(patient -> Response.ok(patient).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("id") Long id, Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return updatedPatient != null ? Response.ok(updatedPatient).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") Long id) {
        patientService.deletePatient(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
