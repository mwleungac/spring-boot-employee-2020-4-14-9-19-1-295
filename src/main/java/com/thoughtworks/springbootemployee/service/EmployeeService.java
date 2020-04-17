package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployee(int employeeId) {
        return  employeeRepository.getEmployee(employeeId);
    }

    public Employee getEmployeeGender(String gender) {
        return employeeRepository.getEmployeeGender(gender);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public Employee updateEmployee(int employeeId, Employee employee) {
        return employeeRepository.updateEmployee(employeeId, employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }

    public List<Employee> getEmployeePage(int page, int pageSize) {
        return employeeRepository.getEmployeePage(page, pageSize);
    }
}
