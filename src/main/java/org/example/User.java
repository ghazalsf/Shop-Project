package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User extends Human {
    private int budget;

    public User(String firstName,String lastName, String userName, String password,
                String address,String phoneNumber,String email,int budget){
        super(firstName, lastName, userName, password, address, phoneNumber, email);
        this.budget=budget;

    }
    public void setBudget(int budget){
        this.budget=budget;
    }
    public int getBudget(){
        return this.budget;
    }

}