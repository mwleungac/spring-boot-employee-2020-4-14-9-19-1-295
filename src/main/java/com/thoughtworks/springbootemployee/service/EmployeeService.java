package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeService employeeService;

    private int employeeIdCount = 1;

    private List<Employee> employeeList = new CopyOnWriteArrayList<>();

    //add an employee
    // add to EmployeeList and pass data obj
    public Employee addEmployee(Employee employee){
        employee.setId(employeeIdCount);
        employeeList.add(employee);
        employeeIdCount++;
        return employee;
    }

    //obtain employee list
    public List<Employee> getEmployees(){
        return employeeList;
    }

    //obtain a certain specific employee
    //pass employeeId and retrieve from employeeList
    public Employee getEmployee(int employeeId){
        return employeeList
                .stream()
                .filter(employee -> employee.getId() == employeeId) //if equal then pass
                .findFirst()
                .get();
    }

    public Employee getEmployeeGender(String gender){
        return employeeList
                .stream()
                .filter(c -> c.getGender().equals(gender))
                .findFirst()
                .get();
    }

    public Employee updateEmployee(int employeeId, Employee employee){
        employeeList
                .stream()
                .forEach(c-> {
                    if(c.getId() == employeeId){
                        c.setAge(employee.getAge());
                        c.setGender(employee.getGender());
                        c.setName(employee.getName());
                    }

                });
        return employeeList
                .stream()
                .filter(c -> c.getId() == employeeId)
                .findFirst()
                .get();

    }

    //delete an employee
    public void deleteEmployee(int employeeId){
        employeeList
                .stream()
                .forEach(c -> {
                    if(c.getId() == employeeId) {
                        employeeList.remove(c);
                    }
                });
    }
}
