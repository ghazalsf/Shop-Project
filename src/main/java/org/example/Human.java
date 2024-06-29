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
        this.MD5hash();
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
    public void setPassword(String password){this.password=password;}
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

    public void MD5hash(){
        String originalPass = this.getPassword();


        try {
            //computes the MD5 hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(originalPass.getBytes());

            //Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            setPassword(hexString.toString());
        }
        catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 hash algorithm doesn't work");
        }
    }
}