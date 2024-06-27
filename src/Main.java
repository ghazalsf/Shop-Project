import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product("hi"));
//        products.add(new Product("helllllo"));
//
//        userGUI usertest = new userGUI();
//        usertest.cart(products);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Bob"));
        users.add(new User("kdnflaknd"));

        adminGUI panelTest = new adminGUI();
        panelTest.userList(users);
        //usergui.main(products);
        //usergui.showInfo("غزل", "تهران", "0987654567","345000");
       //usergui.login();
        //usergui.showInfo("غزل", "تهران", "0987654567","345000");
        //usergui.register();
    }
}