package za.co.nedj.app.nedj.studentapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.studentapi.model.Student;
import za.co.nedj.app.nedj.studentapi.service.DataService;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
@Api(value = "student API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class StudentRest {

    @EJB
    private DataService dataService;

    @GET
    @Path("/{studentId}/student")
    public Response getStudent(@PathParam("studentId") Long studentID) {
        return Response.status(Response.Status.OK).entity(dataService.getStudent(studentID)).build();
    }

    @GET
    @Path("/student")
    public Response getAllStudents() {
        return Response.status(Response.Status.OK).entity(dataService.getAllStudents()).build();
    }

    @POST
    @Path("/student")
    public Response addStudent(Student student) {
        return Response.status(Response.Status.OK).entity(dataService.insertStudent(student)).build();
    }

    @PUT
    @Path("/student")
    public Response updateStudent(Student student) {
        return Response.status(Response.Status.OK).entity(dataService.updateStudent(student)).build();
    }

    @DELETE
    @Path("/{studentId}/student")
    public Response deleteStudent(@PathParam("studentId") Long studentID) {
        return Response.status(Response.Status.OK).entity(dataService.deleteStudent(studentID)).build();
    }
}
