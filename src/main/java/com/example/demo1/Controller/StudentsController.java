package com.example.demo1.Controller;


import com.example.demo1.Bean.Students;
import com.example.demo1.DAO.DAOImplementation.StudentsDAOImplemention;
import com.example.demo1.DAO.StudentsDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentsController extends Application {
    StudentsDAO studentsDAO=new StudentsDAOImplemention();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_student(Students student){
        System.out.println(String.valueOf(student));
        if (studentsDAO.addStudent(student)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_departments(){
        List<Students> students = studentsDAO.getStudentList();
        System.out.printf("Hello world");
        return Response.status(200).entity(students).build();
    }
}
