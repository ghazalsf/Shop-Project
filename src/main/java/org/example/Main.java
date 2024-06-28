package org.example;

import org.example.models.ConnectDB;
import org.example.models.ManageDB;


import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        //Product product = new Product(22, 1.2, 9, "goje", "khkhkhk", "sibzaminijat");
        ManageDB manageDB = new ManageDB();
        manageDB.createTable();
        List<Product> dbProducts= manageDB.getAllProducts();
   }

}
