package com.example.demo1.Controller;

import com.example.demo1.Bean.Bills;
import com.example.demo1.DAO.BillsDAO;
import com.example.demo1.DAO.DAOImplementation.BillsDAOImplementation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/bill")
public class Bill_Controller extends Application {

    BillsDAO billsDAO=new BillsDAOImplementation();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_bill(Bills bills){
        System.out.println(bills);
        if (billsDAO.addBills(bills)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding bill").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_payments(){
        List<Bills> billsList=billsDAO.getAllBillsList();
        return Response.status(200).entity(billsList).build();
    }

    @GET
    @Path("/get_all_bill_for_student/{student_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_payment(@PathParam("student_id") int student_id){
        List<Bills> billsList=billsDAO.getBillList(student_id);
        return Response.status(200).entity(billsList).build();
    }
}
