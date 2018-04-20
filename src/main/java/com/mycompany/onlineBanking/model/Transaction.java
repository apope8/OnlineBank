/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlineBanking.model;

/**
 * Java class that represents Transaction data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
public class Transaction {

    // Overloaded Constructor
    public Transaction(int debit, String date, int postTransactionBalance, String description) {
        this.debit = debit;
        this.date = date;
        this.postTransactionBalance = postTransactionBalance;
        this.description = description;
    }

    // Default Constructor
    public Transaction() {
    }

    private int credit;
    private int debit;
    private String date;
    private int postTransactionBalance;
    private String description;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(int postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
