/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.resources;

import com.mycompany.customer.model.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.mycompany.customer.service.CustomerService;
import com.sun.javafx.scene.web.Debugger;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Java class that represents Customer Resources
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResources {
    
    CustomerService customerService = new CustomerService();
    
    @GET
    public Response getCustomers() {
    
         return Response.status(403).build();
    }
    
     /**
     * Returns a single customer retrieved by customer ID
     * curl -v -X GET http://localhost:49000/api/customers/1
     * @param id - the id of the user
     */
    @GET
    @Path("/{customerId}")
    public Response getCustomer(@PathParam("customerId") int id) {
        
        Customer cust = customerService.readUser(id);
        if (cust == null){
            return Response.status(404).build();
        }
        else{
             return Response.status(200).entity(cust).build();
        }
    }

    
    // ??provide or take out
    ///**
//     * Updates a user 
//     * curl -v -X PUT http://localhost:49000/api/customers/ -d '{"name":"Don", "address":"1 Main St", "email:"don@mail.com"}'
//     * @param body - JSON object of the user
//     */   
    @PUT
    @Path("/{customerId}")
    public Customer putCustomer(@PathParam("customerId") int id, Customer cust) { 
        cust.setId(id);
        return customerService.updateUser(cust);
    }
     
    /*
    *  account subresources handling
    */

    @Path("/{customerId}/accounts")
    public AccountResources getAccountResources(@PathParam("customerId") int id) {
        
        // code to helpd debug 500 error that did not give a stack trace. will take out
        ResourceConfig config = new ResourceConfig()
        .register(Debugger.class);
        //
    
        return new AccountResources(id);
    }
    
}
