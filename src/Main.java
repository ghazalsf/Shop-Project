import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        GUI mainGuI = new GUI();
        //userGUI usergui = new userGUI();
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(100, 3, 0, "joorab", "yooooo"));
        products.add(new Product(100, 3, 0, "kafsh", "yooooo"));
        products.add(new Product(300,3.5,200,"فرنگیس","amooo"));
        products.add(new Product(100, 3, 0, "joorab", "yooooo"));
        products.add(new Product(100, 3, 0, "kafsh", "yooooo"));
        products.add(new Product(300,3.5,200,"فرنگیس","amooo"));
        products.add(new Product(100, 3, 0, "joorab", "yooooo"));
        products.add(new Product(100, 3, 0, "kafsh", "yooooo"));
        products.add(new Product(300,3.5,200,"فرنگیس","amooo"));

        mainGuI.main(products);

//        userGUI usertest = new userGUI();
//        usertest.cart(products);
//
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("Alice","k", "yooo", "1234"));
//        users.add(new User("Bob","nooo", "ofjdf", "ijd.fjaks.,"));
//        users.add(new User("Bob","hfuifj", "ilk.jdi", "ijflkj"));
//        users.add(new User("kdnflaknd", "flajk.jd", "ijfdiol","fidljfij"));

        //adminGUI panelTest = new adminGUI();
        //panelTest.userList(users);
        //usergui.main(products);
        //usergui.showInfo("غزل", "تهران", "0987654567","345000");
       //usergui.login("هستی", "097970");
        //usergui.showInfo("غزل", "تهران", "0987654567","345000");
        //usergui.register();
        Product product = new Product(300,3.5,200,"فرنگیس","amooo");

    }
}