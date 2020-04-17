package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.thoughtworks.springbootemployee.repository.EmployeeRepository.createTestEmployees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

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
        return employeeRepository.getEmployee(employeeId);
    }

    //screen all male employees
    @GetMapping(params = "gender")
    public Employee getEmployeeGender(@RequestParam String gender){
        return employeeRepository.getEmployeeGender(gender);
    }

    //add an employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.addEmployee(employee);
    }

    //update an employee
    @PutMapping (value = "/{employeeId}")
    public Employee updateEmployee (@PathVariable ("employeeId")
                                                int employeeId, @RequestBody Employee employee){
        return employeeRepository.updateEmployee(employeeId, employee);
    }

    //delete an employee
    @DeleteMapping (value = "/{employeeId}")
    public void deleteEmployee (@PathVariable ("employeeId") int employeeId){
        employeeRepository.deleteEmployee(employeeId);
    }

    //page query, page equals 1, pageSize equals 5
    @GetMapping(params = {"page", "pageSize"})
    public List<Employee> getPageEmployee(@RequestParam int page, @RequestParam int pageSize){
        return employeeRepository.getEmployeePage(page, pageSize);

    }

}
