/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.service;

import com.mycompany.customer.model.Account;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Java class that represents Account Service data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
public class AccountService {
    
    // customers array list of arraylist of accounts
    //For our purposes Customer x have account ids of 1,2,3,.., 
    // that is Customer 1 hac acc ids 1,2,3,.., and Customer 2 have acc ids 1,2,3..? 
    // So index i of 'csAList' matches up with index of a particular customer set up array 
    // in CustomerService
    
    
    public static List<List<Account>> csAList = new ArrayList<>();    
    public static List<Account> listC1 = new ArrayList<>();       
    public static List<Account> listC2 = new ArrayList<>();       
    public static List<Account> listC3 = new ArrayList<>();       
    public static List<Account> listC4 = new ArrayList<>();       
    public static List<Account> listC5 = new ArrayList<>();       
    public static boolean init = true;
    public int customerId;

    public AccountService(int id) {
        if (init) {


           Account a1 = new Account(1, 708090, 1234567, "current");
           Account a2 = new Account(1, 708090, 1234568, "savings");
           Account a3 = new Account(1, 708090, 1234569, "savings");
           Account a4 = new Account(1, 708090, 1234570, "savings");
           Account a5 = new Account(1, 708090, 1234571, "current");
         
           

            listC1.add(a1);     //add 1 account customer 1 account list
            listC2.add(a2);     //add 1 account customer 2 account list  
            listC3.add(a3);     //add 1 account customer 3 account list
            listC4.add(a4);     //add 1 account customer 4 account list
            listC5.add(a5);     //add 1 account customer 5 account list

            csAList.add(listC1);   // add customer 1 list to customers
            csAList.add(listC2);   // add customer 2 list to customers
            csAList.add(listC3);   // add customer 3 list to customers
            csAList.add(listC4);   // add customer 4 list to customers
            csAList.add(listC5);   // add customer 5 list to customers
            init = false;
        }
        customerId = id;
    }

    public List<Account> getACustAccounts() {
        System.out.println("in method of AccountServ getCustAccountss");
        if (csAList.size() >= customerId) {

            List<Account> cal = csAList.get(customerId - 1);
            List<Account> retList = new ArrayList();
            for (Account acc : cal) {
                System.out.println("acc " + acc);
                retList.add(acc);
            }
            System.out.println("size of retList " + retList.size());
            return retList;
        } else {
            return null;
        }
    }

    public Account getAccount(int accId) {
        if (csAList.size() >= customerId) {

            List<Account> cal = csAList.get(customerId - 1);           

            if (cal.size() >= accId) {
                return cal.get(accId - 1);

            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Account addAccount(Account acc) {
        List<Account> cal = csAList.get(customerId - 1);
        acc.setId(cal.size() + 1);
        cal.add(acc);
        System.out.println("herehere");
        System.out.println("201 -  address create with id:" + String.valueOf(acc.getId()));
        return acc;
    }

    public Account processAccTrans(int accId, int trx, double amount) {
        boolean result = false;
        if (csAList.size() >= customerId) {

            List<Account> cal = csAList.get(customerId - 1);
            if (cal.size() >= accId) {
                Account acc = cal.get(accId - 1);
                if ((trx == 1 || trx == 2)) {
                
                    result = acc.credit(amount);
                } 
                else if (trx == 3) {
                    if (acc.getCurrentBalance() >= amount) {
                        result = acc.debit(amount);
                    } 
                    else {
                        throw new WebApplicationException(Response.Status.NOT_MODIFIED);
                 
                    }
                }
                if (result == false) {
                    return null;
                }
                else{
                    return acc;
                }
            
            }
            else {
               return null;
            }
        } 
        else {
            return null;
        }
    }
    /*
     *   Method to retreieve balance of a particular account given by account for
     *   a particular customer given by customerID.
    */
    
    public  Account processAccTrans(int accId, int trx) {
        if (csAList.size() >= customerId) {

            // find the required arraylist for the customerID:
            List<Account> cal = csAList.get(customerId - 1);
            if (cal.size() >= accId) {
                // retrieve account from arraylist for account id accId
                Account acc = cal.get(accId - 1);
                // transaction id for balance
                if (trx == 4) {
                    return acc;
                }
                
//                    String balance = acc.getCurrentBalance() + "";

                else{ 
                    return null;
                }                           
            }
            else {
               return null;
            }
        } 
        else {
            return null;
        }
    }  
}

