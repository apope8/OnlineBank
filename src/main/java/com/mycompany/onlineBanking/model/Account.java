/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlineBanking.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java class that represents Account data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
@XmlRootElement
public class Account {

    // Overloaded constructor to hold Account variables
    public Account(int sortCode, int accountNumber, String currentBalance, String listOfTransaction, String accountName) {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.listOfTransactions = listOfTransaction;
        this.accountName = accountName;
    }

    // Default constructor
    public Account() {
    }

    // Private variables
    private int sortCode;
    private int accountNumber;
    private String currentBalance;
    private String listOfTransactions;
    private String accountName;

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(String listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    

}
