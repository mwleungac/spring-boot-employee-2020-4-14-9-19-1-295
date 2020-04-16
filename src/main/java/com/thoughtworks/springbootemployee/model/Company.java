package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String basicInfo;
    private String employeeId;
    private List<Employee> employeeList;


    public Company(int id, String name, String basicInfo) {
        this.id = id;
        this.name = name;
        this.basicInfo = basicInfo;
    }

    public Company(){

    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
