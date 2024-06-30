package org.example;
import org.example.models.ManageDB;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //GUI userGUI = new GUI();
        ManageDB manageDB = new ManageDB();
        manageDB.createTable();

        new StartGui();
    }
        ArrayList<Product> products = new ArrayList<>();
}
