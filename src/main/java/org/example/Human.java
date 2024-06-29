package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Human {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;

    public Human(String firstName,String lastName, String userName, String password,
                 String address,String phoneNumber,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void  setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setEmail(String  email){
        this.email=email;
    }
    public String getemail() {
        return this.email;
    }
    public String getFirstName(){return this.firstName;}
    public String getLastName(){
        return this.lastName;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}