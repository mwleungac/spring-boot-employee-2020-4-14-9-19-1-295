package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController2 {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getCustomers(){
        return employeeService.getEmployees();
    }

    @GetMapping(value = "/{employeeId}")
    public Employee getEmployee(@PathVariable ("employeeId") int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping(params = "gender")
    public Employee getEmployeeGender(@RequestParam String gender){
        return employeeService.getEmployeeGender(gender);
    }

    @PutMapping (value = "/{employeeId}")
    public Employee updateEmployee (@PathVariable ("employeeId")
                                                int employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping (value = "/{employeeId}")
    public void deleteEmployee (@PathVariable ("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }




}
