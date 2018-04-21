package com.example.apu5n.firebaseone;

import java.util.Date;

/**
 * Created by apu5n on 15-04-2018.
 */

public class CustumerDetails {

    String cust_id;
    String cust_name;
    String cust_address;
    String cust_mobile_number;
    String puja_id;


    public CustumerDetails(){

    }

    public CustumerDetails(String cust_id, String cust_name, String cust_address, String cust_mobile_number, String puja_id) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_address = cust_address;
        this.cust_mobile_number = cust_mobile_number;
        this.puja_id = puja_id;
    }

    public String getCust_id() {
        return cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getCust_address() {
        return cust_address;
    }

    public String getCust_mobile_number() {
        return cust_mobile_number;
    }

    public String getPuja_id() {return puja_id;}
}
