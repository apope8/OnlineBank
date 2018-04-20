/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java class that represents Customer data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */

@XmlRootElement
public class Customer {
   
   // Overloaded constructor to hold Customer variables
    public Customer(int id, String name, String address, String email) {
        this.id = id;
        this.address = address;
        this.email = email;
    }

    // Default constructor
    public Customer() {
    }
    
    // Private variables
    private int id;
    private String name; 
    private String address;
     private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
}