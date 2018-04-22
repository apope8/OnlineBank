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
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
    
    /**
     * 
     * Search for a user using name and address.
     * curl -v -X GET http://localhost:49000/api/customers?name=Harry&address=16 Main St
     * @param name
     * @param occupation
     */
    @GET
    public List<Customer> getCustomers(@QueryParam("name") String name, @QueryParam("address") String address) {
        if ((name != null) && (address != null)) {
                     return customerService.getSearchUsers(name, address);   
        }
        // Return all customers if a match on particular name and address is not found
        //return customerService.getAllCustomers();
        return null;
    }    

     /**
     * 
     * Returns a single customer 
     * curl -v -X GET http://localhost:49000/api/customers/1
     * @param id - the id of the user
     */
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        return customerService.readUser(id);
    }

//    /**
//     * 
//     * Creates a user 
//     * curl -v -X POST http://localhost:49000/api/customers/ -d '{"name":"Don", "occupation":"teacher", "age":"33"}'
//     * @param body - JSON object of the user
//     */    
//    @POST
//    public TaxPayer postUser(TaxPayer u) {       
//        return customerService.createUser(u);
//    }
    
    
    // ??provide or take out
    ///**
//     * Updates a user 
//     * curl -v -X PUT http://localhost:49000/api/customers/ -d '{"name":"Don", "address":"1 Main St", "email:"don@mail.com", mMmaindenname: "smith" }'
//     * @param body - JSON object of the user
//     */   
    @PUT
    @Path("/{customerId}")
    public Customer putCustomer(@PathParam("customerId") int id, Customer cust) { 
        cust.setId(id);
        return customerService.updateUser(cust);
    }
     
    // ??provide or take out
    @DELETE
    @Path("/{userId}")
    public void deleteCustomer(@PathParam("userId") int id) { 
       customerService.deleteUser(id);
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
