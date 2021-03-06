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
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Java class that represents Customer Resources
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
@Path("/customers/{apiID}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResources {
    
    CustomerService customerService = new CustomerService();
    private static final String APIID = "35c4f3863a0d5efc60708589be6b12c5";
    
    private static final String ADMINAPIID = "35c4f3863a0d5efc60708589bef318a7";
     
     /**
     * Returns a list of customers for an APIID only for admin user.
     * curl -v -X GET http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5/1
     * @param apiID
     */
    @GET
    public List<Customer> getCustomers(@PathParam("apiID") String clApiID) {
        
        if (!(clApiID.equals(ADMINAPIID))){
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return customerService.getAllUsers();
    }
    
     /**
     * Returns a single customer retrieved by customer ID
     * curl -v -X GET http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5/1
     * @param id - the id of the user
     * @param apiID
     */
    @GET
    @Path("/{customerId}")
    public Response getCustomer(@PathParam("apiID") String clApiID, @PathParam("customerId") int id) {
        
        if (!(clApiID.equals(APIID))){
           return Response.status(401).build(); 
        }
        
        Customer cust = customerService.readUser(id);
        
        if (cust == null){
            return Response.status(404).build();
        }
        else{
             return Response.status(200).entity(cust).build();
        }
    }

     /**
       * Updates a user 
       * curl -v -X PUT http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5 -d '{"name":"Don", "address":"1 Main St", "email:"don@mail.com"}'
       * @param body - JSON object of the user
       * @param apiID
      */   
    @PUT
    @Path("/{customerId}")
    public Response putCustomer(@PathParam("apiID") String clApiID, @PathParam("customerId") int id, Customer cust) {
        
        if (!(clApiID.equals(APIID))){
           return Response.status(401).build(); 
        }
        
        cust.setId(id);
        Customer aCust = customerService.updateUser(cust);
        
        if (cust == null){
            return Response.status(404).build();
        }
        else{
             return Response.status(200).entity(cust).build();
        }    
    }
     
    /*
    *  accounts subresource handling
    */
  
    @Path("/{customerId}/accounts")
    public AccountResources getAccountResources(@PathParam("apiID") String clApiID, @PathParam("apiId") int apiId, @PathParam("customerId") int id) {
        
        if (!(clApiID.equals(APIID))){
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return new AccountResources(id);
    }
    
}
