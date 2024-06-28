package org.example;

import org.example.models.ConnectDB;
import org.example.models.ManageDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        //Product product = new Product(22, 1.2, 9, "goje", "khkhkhk", "sibzaminijat");
        GUI userGUI = new userGUI();
        ManageDB manageDB = new ManageDB();
        ArrayList<Product> products =manageDB.getAllProducts();
        userGUI.main(products);
        //userGUI.showInfo("abbas","flkjdsf", "98767789","88888");
   }

}
