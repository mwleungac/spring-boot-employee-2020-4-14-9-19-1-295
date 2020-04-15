/*package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
//import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(){
        employees.add(new Employee(0, "Xiaoming", 20,"Male"));
        employees.add(new Employee(1, "Xiaohong", 19,"Female"));
        employees.add(new Employee(2 ,"Xiaozhi", 15,"Male"));
        employees.add(new Employee(3 ,"Xiaogang", 16,"Male"));
        employees.add(new Employee(4 ,"Xiaoxia", 15,"Female"));
        return employees;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(Employee employee) {
        employees.add(new Employee(2, "Xiaoming", 20 ,"Male"));
        return employee;
    }


}*/
