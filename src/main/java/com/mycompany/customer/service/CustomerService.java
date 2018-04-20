/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customer.service;

import com.mycompany.customer.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class that represents Customer Service data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
public class CustomerService {

    public static List<Customer> list = new ArrayList<>();
    public static boolean init = true;

    public CustomerService() {
        if (init) {
            // (id, name, address, email, mothers maiden name(security credential))
            Customer c1 = new Customer(1,"Noel Smith", "55 Main St", "noel.smith@eir.com", "Brown");
      
            Customer c2 = new Customer(2,"Gabriel White", "55 Main St", "noel.smith@eir.com", "Brown");
            Customer c3 = new Customer(3,"Eve", "55 Main St", "noel.smith@eir.com", "Brown");
            Customer c4 = new Customer(4,"Harry", "55 Main St", "noel.smith@eir.com", "Brown");
            Customer c5 = new Customer(5,"Noel", "55 Main St", "noel.smith@eir.com", "Brown");

            list.add(c1);
            list.add(c2);
            list.add(c3);
            list.add(c4);
            list.add(c5);
            init = false;
        }
    }

    public List<Customer> getAllUsers() {
        return list;
    }

    public List<Customer> getSearchUsers(String name, String address) {
        List<Customer> matcheslist = new ArrayList<>();

        for (Customer u : getAllUsers()) {
            if ((name == null || u.getAddress().equals(address))
                    && (name == null || u.getName().equals(name))) {
                matcheslist.add(u);
            }
        }
        return matcheslist;
    }

    public Customer createUser(Customer user) {

        for (Customer u : getAllUsers()) {
            if (user.getName().equals(u.getName())) {
                System.out.println("User name already exists: " + user.getName());
                return user;
            }
        }
        user.setId(list.size() + 1);
        list.add(user);
        System.out.println("201 -  user create with id:" + String.valueOf(user.getId()));
        return user;
    }

    public Customer readUser(int id) {
        return list.get(id - 1);
    }

    public Customer updateUser(Customer user) {
        if (user.getId() <= 0) {
            return null;
        }
        list.set(user.getId() - 1, user);
        System.out.println("200 -  user id:" + String.valueOf(user.getId()) + " updated");
        return user;
    }

    public Customer deleteUser(int id) {
        if (id <= 0) {
            return null;
        }
        Customer u = list.get(id - 1);
        list.remove(id - 1);
        System.out.println("204 -  user id:" + String.valueOf(id) + " deleted");
        return u;
    }
}
