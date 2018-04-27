/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.service;

import com.mycompany.customer.model.Account;
import com.mycompany.customer.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Java class that represents Transaction Service data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
public class TransactionService {

    private int customerID;
    private Account account;

    public TransactionService(Account account) {
        this.account = account;
    }

    public List<Transaction> getAccTrxs() {

        List<Transaction> ltrx = account.getTransactionsList();

        List<Transaction> retList = new ArrayList();
        for (Transaction trx : ltrx) {
            retList.add(trx);
        }
        return retList;

    }

    public Transaction getTransaction(int transactionId) {

        List<Transaction> ltrx = account.getTransactionsList();

        //  check that URI accID is for valid account in list of accounts
        if (ltrx.size() >= transactionId) {
            // get and return account for accID from list of accounts
            return ltrx.get(transactionId - 1);
        } else {
            return null;
        }
    }

    public Transaction addTrans(Transaction trx) {
        boolean result = false;

        List<Transaction> ltrx = account.getTransactionsList();
        
        // if transaction is a lodgement or a transferal
        if ((trx.getTransactionCode() == 1 || trx.getTransactionCode() == 2)) {
            result = account.credit(trx.getAmount());
            trx.setId(ltrx.size() + 1);
            trx.setPostTransactionBalance(account.getCurrentBalance());
            ltrx.add(trx);
            
            System.out.println("201 -  transaction create with id:" + String.valueOf(trx.getId()));

        } else if (trx.getTransactionCode() == 3) {
            
            // check balance meets withdrawal request
            if (account.getCurrentBalance() >= trx.getAmount()) {
                result = account.debit(trx.getAmount());
                trx.setId(ltrx.size() + 1);         // set trx id
                trx.setPostTransactionBalance(account.getCurrentBalance());     // set trx post balance
                ltrx.add(trx);
                
                System.out.println("201 -  transaction create with id:" + String.valueOf(trx.getId()));
                
            } else {
                throw new WebApplicationException(Response.Status.NOT_MODIFIED);

            }
        }
        if (result == false) {
            return null;
        } else {
            return trx;
        }

    }

}
