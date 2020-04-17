package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getCompany(Integer employeeId) {
        return companyRepository.findById(employeeId).orElse(null);
    }


    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Integer companyId, Company company) {
        companyRepository.findById(companyId).orElse(null);
        companyRepository.save(company);
        return company;
    }

    public void deleteCompany(Integer companyId) {
        companyRepository.deleteById(companyId);
    }

}

