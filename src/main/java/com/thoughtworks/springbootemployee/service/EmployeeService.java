package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeService employeeService;

    private int employeeIdCount = 1;

    private List<Employee> employeeList = new CopyOnWriteArrayList<>();

    public Employee addEmployee(Employee employee){
        employee.setId(employeeIdCount);
        employeeList.add(employee);
        employeeIdCount++;
        return employee;
    }

    public List<Employee> getEmployees(){
        return employeeList;
    }

    public Employee getEmployee(int employeeId){
        return employeeList
                .stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .get();
    }

    public Employee getEmployeeGender(String gender){
        return employeeList
                .stream()
                .filter(employed -> employed.getGender().equals(gender))
                .findFirst()
                .get();
    }

    public Employee updateEmployee(int employeeId, Employee employee){
        employeeList
                .stream()
                .forEach(employed -> {
                    if(employed.getId() == employeeId){
                        employed.setAge(employee.getAge());
                        employed.setGender(employee.getGender());
                        employed.setName(employee.getName());
                        employed.setSalary(employee.getSalary());
                    }

                });
        return employeeList
                .stream()
                .filter(employed -> employed.getId() == employeeId)
                .findFirst()
                .get();

    }

    public void deleteEmployee(int employeeId){
        employeeList
                .stream()
                .forEach(employed -> {
                    if(employed.getId() == employeeId) {
                        employeeList.remove(employed);
                    }
                });
    }
}
