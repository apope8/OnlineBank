/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlineBanking.resources;

import com.mycompany.onlineBanking.model.Account;
import com.mycompany.onlineBanking.service.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Java class that represents Accounts Resources
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
@Path("/")
public class AccountResources {
    
    private int customerID;
    AccountService AccountService;
    
    
    /**
     * Constructor for sub-resource of accounts that receives customerId
     *  
     * curl -v -X GET http://localhost:49000/api/customers/1/accounts
     * @param customerID
     * customerId from url
     */

    public AccountResources(int id) {
        System.out.println("accountRes constuctor");
        customerID = id;
        AccountService = new AccountService(customerID);
        System.out.println("testb");
    }    

    @GET
    public List<Account> getCustAccounts() {
        System.out.println("in method of AccountRes getCustAccountss");
        System.out.println("accService : " + AccountService);
        List<Account> la = AccountService.getACustAccounts();
        System.out.println("testa");
        return la;
    }    


//    
//    /**
//     * Search for an account by id 
//     * curl -v -X GET http://localhost:49000/api/customers/1/accounts/2
//     * @param id - id of the account
//     */
    @GET
    @Path("/{accountId}")
    public Account getAddress(@PathParam("accountId") int id) {
        return AccountService.getAccount(id);
    }    

    //    /**
//     * Add new account for a customer 
//     * curl -v -X POST http://localhost:49000/api/customers/1/accounts
//     * customerID - id of the customer from URL passed to AccountService
//     */
    @POST
    public Account addAccount(Account acc) {
        System.out.println("in method AccountService addAccount");
        return AccountService.addAccount(acc);
    }  
    
//    /**
//     * Process new transaction on an account for a customer 
//     * curl -v -X POST http://localhost:49000/api/customers/1/accounts/1?transaction=lodgement%amount=200.00
//     * customerID - id of the customer from URL passed to AccountService constructor
//     * @param accountId   -  account ID
//     * @param transaction -   transaction of lodgement, transferal or withdrawal
//     * @param amount  -   amount to be applied to balance according to transaction
//     */
    @PUT
    @Path("/{accountId}")
    public Account processAccTrans(@PathParam("accountId") int accId, @QueryParam("transaction") int transaction, 
            @QueryParam("ammount") double amount) {
        
        System.out.println("in method AccountService processAccTrans");
        return AccountService.processAccTrans(accId, transaction, amount);
    }  

//    /**
//     * Process new transaction to request balance on an account for a customer 
//     * curl -v -X POST http://localhost:49000/api/customers/1/accounts/1?transaction=balance
//     * customerID - id of the customer from URL passed to AccountService
//     * @param accountId   -  account ID
//     * @param transaction -   transaction of balance
//    
//     */
//    @POST
//    @Path("/{accountId}")
//    public Account processAccTrans(@PathParam("accountId") int accId, @QueryParam("transaction") String transaction) {
//        
//        System.out.println("in method AccountService processAccTrans");
//        return AccountService.processAccTrans(accId, transaction);
//    }  
}
