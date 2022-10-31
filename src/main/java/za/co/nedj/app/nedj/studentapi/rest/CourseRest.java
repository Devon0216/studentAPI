package za.co.nedj.app.nedj.studentapi.rest;

import io.swagger.annotations.Api;
import za.co.nedj.app.nedj.studentapi.model.Course;
import za.co.nedj.app.nedj.studentapi.model.Student;
import za.co.nedj.app.nedj.studentapi.service.DataService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Api(value = "course API")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CourseRest {

    @EJB
    private DataService dataService;

    @GET
    @Path("/{courseId}/course")
    public Response getCourse(@PathParam("courseId") Long courseId) {
        return Response.status(Response.Status.OK).entity(dataService.getCourse(courseId)).build();
    }

    @GET
    @Path("/course")
    public Response getAllCourses() {
        return Response.status(Response.Status.OK).entity(dataService.getAllCourses()).build();
    }

    @POST
    @Path("/course")
    public Response addCourse(Course course) {
        return Response.status(Response.Status.OK).entity(dataService.insertCourse(course)).build();
    }

    @PUT
    @Path("/course")
    public Response updateCourse(Course course) {
        return Response.status(Response.Status.OK).entity(dataService.updateCourse(course)).build();
    }

    @DELETE
    @Path("/{courseId}/course")
    public Response deleteCourse(@PathParam("courseId") Long courseId) {
        return Response.status(Response.Status.OK).entity(dataService.deleteCourse(courseId)).build();
    }
}
