package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeGender(String gender) {
        return employeeRepository.findAllByGender(gender);
    }

    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer employeeId, Employee employee) {
        employeeRepository.findById(employeeId).orElse(null);
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAll(Integer page, Integer pageSize){
      return employeeRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }
}
