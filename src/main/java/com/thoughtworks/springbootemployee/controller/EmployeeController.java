package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.thoughtworks.springbootemployee.EmployeeFactory.createTestEmployees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return createTestEmployees();
    }

    /*//obtain employee list
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }*/

    //obtain a certain specific employee
    @GetMapping(value = "/{employeeId}")
    public Employee getEmployee(@PathVariable ("employeeId") int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    //screen all male employees
    @GetMapping(params = "gender")
    public Employee getEmployeeGender(@RequestParam String gender){
        return employeeService.getEmployeeGender(gender);
    }

    //add an employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //update an employee
    @PutMapping (value = "/{employeeId}")
    public Employee updateEmployee (@PathVariable ("employeeId")
                                                int employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);
    }

    //delete an employee
    @DeleteMapping (value = "/{employeeId}")
    public void deleteEmployee (@PathVariable ("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }




}
