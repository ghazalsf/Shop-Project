package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Human {
    public User(String firstName,String lastName, String userName, String password,
                String address,String phoneNumber,String email,int budget){
        super(firstName, lastName, userName, password, address, phoneNumber, email, budget);

    }

}
