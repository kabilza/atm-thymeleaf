package th.ac.ku.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {

    private int id;
    private int customerId;
    private String type;
    private double balance;


    //  ..Generate.. Getters, Setters, toString()

    public BankAccount(int id, int customerId, String type){
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = 0.00;
    }

    public int getId(){
        return id;
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getType(){
        return type;
    }

    public double getBalance(){
        return balance;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

}
