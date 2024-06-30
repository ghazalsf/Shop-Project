package org.example;

public class Admin extends Human{
    public Admin(String firstName, String lastName, String userName, String password, String address, String phoneNumber, String email){
        super(firstName, lastName, userName, password, address, phoneNumber, email);
    }
    private static int sold;

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}