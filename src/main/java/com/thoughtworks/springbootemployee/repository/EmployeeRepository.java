package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import javax.xml.ws.RespectBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    public static List<Employee> createTestEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "xiaoming", 22, "male", 5000));
        employees.add(new Employee(2, "xiaohong", 24, "female", 6000));

        return employees;
    }

    private int employeeIdCount = 1;

    private List<Employee> employeeList = createTestEmployees();

    public Employee addEmployee(Employee employee){
        employee.setId(employeeIdCount);
        employeeList.add(employee);
        employeeIdCount++;
        return employee;
    }

    public List<Employee> getEmployees(int page, int pageSize){
        return employeeList;
    }

    public List<Employee> getEmployees(){
        return employeeList;
    }

    public Employee getEmployee(int employeeId){
        return employeeList
                .stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .orElse(null);
    }

    public Employee getEmployeeGender(String gender){
        return employeeList
                .stream()
                .filter(employed -> employed.getGender().equals(gender))
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(int employeeId, Employee employee){
        employeeList
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
                .orElse(null);

    }

    public void deleteEmployee(int employeeId){
        employeeList
                .forEach(employed -> {
                    if(employed.getId() == employeeId) {
                        employeeList.remove(employed);
                    }
                });
    }

    public List<Employee> getEmployeePage(int page, int pageSize) {
        return employeeList.stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}
