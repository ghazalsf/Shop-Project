package org.example;

import org.example.models.ConnectDB;


import java.sql.*;


public class Main {

    public static void main(String[] args) {
        User user=new User("firstName", "lastName", "userName", "password",
                "address", "phoneNumber", "email", 333);
        System.out.println(user.getPassword());
    }

}
