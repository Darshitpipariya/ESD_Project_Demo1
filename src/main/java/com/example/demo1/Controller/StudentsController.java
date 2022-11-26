package com.example.demo1.Controller;


import com.example.demo1.Bean.Student_Payment;
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
        System.out.println(student);
        if (studentsDAO.addStudent(student)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding student").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_students(){
        List<Students> students = studentsDAO.getStudentList();
        return Response.status(200).entity(students).build();
    }

    @GET
    @Path("/get/{s_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_student(@PathParam("s_id") int id){
        System.out.println(id);
        Students students=studentsDAO.getStudent(id);
        if(students!=null){
            return Response.status(200).entity(students).build();
        }
        return Response.status(400).entity("Failure in getting student details").build();
    }

    @GET
    @Path("/get_all_details/{s_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_student_details(@PathParam("s_id") int id){
        System.out.println(id);
        List<Student_Payment> result=studentsDAO.getDetails(id);
        if(result!=null){
            return Response.status(200).entity(result).build();
        }
        return Response.status(400).entity("Failure in getting student details").build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Students student) {
        Students student1 = studentsDAO.login(student);

        if (student1 == null)
            return Response.status(400).entity("Wrong Email or Password").build();
        else
            return Response.status(200).entity(student1).build();
    }
}
