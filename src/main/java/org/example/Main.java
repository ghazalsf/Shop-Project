package org.example;

import org.example.models.ConnectDB;
import org.example.models.ManageDB;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //Product product = new Product(22, 1.2, 9, "goje", "khkhkhk", "sibzaminijat");
        GUI userGUI = new userGUI();
        ManageDB manageDB = new ManageDB();
        ArrayList<Product> products =manageDB.getAllProducts();
        userGUI.main(products);
        //userGUI.showInfo("abbas","flkjdsf", "98767789","88888");
   }

        ArrayList<Product> products = new ArrayList<>();
        GUI gui = new GUI();
//        gui.showInfo("hfhs","hdrhfg","srgrhgf","dfhgrhr");
//        gui.main(products);
//
//        products.add(new Product(3314,3413,46246,"hello","fhhsdh","this"));
//        products.add(new Product(3314,3413,46246,"hello","fhhsdh","cool"));
//        products.add(new Product(3314,3413,46246,"hello","fhhsdh","shit"));
//        products.add(new Product(3314,3413,46246,"bye","fhhsdh","fun"));
//        products.add(new Product(3314,3413,46246,"bye","fhhsdh","stop"));
//        products.add(new Product(3314,3413,46246,"bye","fhhsdh","an"));
//        products.add(new Product(3314,3413,46246,"bye","fhhsdh","guz"));
//


    }


    }

}
