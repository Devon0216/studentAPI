package za.co.nedj.app.nedj.studentapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.studentapi.model.Course;
import za.co.nedj.app.nedj.studentapi.model.Enrolment;
import za.co.nedj.app.nedj.studentapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Api(value = "enrolment API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class EnrolmentRest {
    @EJB
    private DataService dataService;

    @GET
    @Path("/{enrolmentId}/enrolment")
    public Response getEnrolment(@PathParam("enrolmentId") Long enrolmentId) {
        return Response.status(Response.Status.OK).entity(dataService.getEnrolment(enrolmentId)).build();
    }

    @GET
    @Path("/enrolment")
    public Response getAllEnrolments() {
        return Response.status(Response.Status.OK).entity(dataService.getAllEnrolments()).build();
    }

    @POST
    @Path("/enrolment")
    public Response addEnrolment(Enrolment enrolment) {
        return Response.status(Response.Status.OK).entity(dataService.insertEnrolment(enrolment)).build();
    }

    @PUT
    @Path("/enrolment")
    public Response updateEnrolment(Enrolment enrolment) {
        return Response.status(Response.Status.OK).entity(dataService.updateEnrolment(enrolment)).build();
    }

    @DELETE
    @Path("/{enrolmentId}/enrolment")
    public Response deleteEnrolment(@PathParam("enrolmentId") Long enrolmentId) {
        return Response.status(Response.Status.OK).entity(dataService.deleteEnrolment(enrolmentId)).build();
    }
}
