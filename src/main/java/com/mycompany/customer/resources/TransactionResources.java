/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.resources;

import com.mycompany.customer.model.Account;
import com.mycompany.customer.model.Transaction;
import com.mycompany.customer.service.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {

    private int customerID;
    private Account account;
    private TransactionService transactionService;
  
    /**
     * Constructor for sub-resource of accounts that receives customerId
     *  
     * curl -v -X GET http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5/1/accounts
     * @param customerID
     * customerId from url
     */

    public TransactionResources(int id, Account account) {
        customerID = id;
        transactionService = new TransactionService(account);
        System.out.println("xxx " + account);
    }    

    @GET
    public List<Transaction> getAccountTrxs() {
        List<Transaction> trxList = transactionService.getAccTrxs();
        if (trxList == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else{
            return trxList;
        }        
    }   
    
    //    /**
//     * Search for an account by id 
//     * curl -v -X GET http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5/1/accounts/2
//     * @param id - id of the account
//     */
    @GET
    @Path("/{transactionId}")
    public Transaction getTransaction(@PathParam("transactionId") int id) {
        Transaction trx = transactionService.getTransaction(id);
        if (trx == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else{
            return trx;
        }
    }    
    
        //    /**
//     * Add new transaction for an account for a customer 
//     * curl -v -X POST http://localhost:49000/api/customers/35c4f3863a0d5efc60708589be6b12c5/1/accounts
//     * customerID - id of the customer from URL passed to AccountService
//     */
    @POST
    public Transaction addTransaction(Transaction trx) {
        System.out.println("xxx "+ trx);
        trx = transactionService.addTrans(trx);
        if (trx == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else{
            return trx;
        }
    }  
}
