/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.kafkaproducerapp.model;

/**
 *
 * @author dlwlrma
 */
public class Models {
    private int id;
    private String model_name;
    private String company;

    public Models(int id, String model_name, String company) {
        this.id = id;
        this.model_name = model_name;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Model Detail: " + id + ", Company: " + company + ", Model Name: " + model_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

