/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.service;

import com.mycompany.customer.model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class that represents Account Service data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
public class AccountService {
    //public static List<Address> list = new ArrayList<>();

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

           /* Account a1 = new Account(1, "708090", "1234567", "current");
            Account a2 = new Account(1, "708090", "1234568", "savings");
            Account a3 = new Account(1, "708090", "1234569", "savings");
            Account a4 = new Account(1, "708090", "1234570", "savings");
            Account a5 = new Account(1, "708090", "1234571", "current");*/
           
           Account a1 = new Account(1, 708090, "1234567", "7", "current");
           Account a2 = new Account(1, 708090, "1234568", "7", "savings");
           Account a3 = new Account(1, 708090, "1234569", "7", "savings");
           Account a4 = new Account(1, 708090, "1234570", "7", "savings");
           Account a5 = new Account(1, 708090, "1234571", "7", "current");
           

            listC1.add(a1);     //add 1 account customer 1 account list
            listC2.add(a2);     //add 1 account customer 2 account list  
            listC3.add(a3);     //add 1 account customer 3 account list
            listC4.add(a4);     //add 1 account customer 4 account list
            listC5.add(a5);     //add 1 account customer 5 account list

            csAList.add(listC1);  
            csAList.add(listC2); 
            csAList.add(listC3);  
            csAList.add(listC4); 
            csAList.add(listC5);  
            init = false;
        }
        customerId = id;
    }

    public List<Account> getACustAccounts() {
        System.out.println("in method of AccountServ getCustAccountss");
        if (csAList.size() >= customerId) {

            List<Account> cal = csAList.get(customerId - 1);
            System.out.println("taxPID " + customerId);
            System.out.println("cal size " + cal.size());
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
            System.out.println("custID " + customerId + ". addID " + (accId));
            System.out.println("cal size " + cal.size());
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
        System.out.println("taxPID " + customerId);
        acc.setAccountNumber(cal.size() + 1);
        cal.add(acc);

        System.out.println("201 -  address create with id:" + String.valueOf(acc.getId()));
        return acc;
    }

    public Account processAccTrans(int accId, int trx, double amount) {
        boolean result = false;
        if (csAList.size() >= customerId) {

            List<Account> cal = csAList.get(customerId - 1);
            System.out.println("custID " + customerId + ". addID " + (accId));
            System.out.println("cal size " + cal.size());
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
                        result = false;
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
   
}

