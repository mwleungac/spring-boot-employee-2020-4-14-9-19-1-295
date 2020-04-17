package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    //obtain company list
    @GetMapping
    public List<Company> getCompanies(){
        return companyRepository.getCompanies();
    }

    //obtain a certain specific company
    @GetMapping(value = "/{companyId}")
    public Company getCompany(@PathVariable ("companyId") int companyId){
        return companyRepository.getCompany(companyId);
    }

    //add a company
    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyRepository.addCompany(company);
    }

    //update a company basic information
    @PutMapping (value = "/{companyId}")
    public Company updateCompanyInfo (@PathVariable ("companyId")
                                            int companyId, @RequestBody Company company){
        return companyRepository.updateCompany(companyId, company);
    }

    //delete all employees belong to this company
    @DeleteMapping (value = "/{companyId}")
    public void deleteEmployee (@PathVariable ("companyId") int companyId){
        companyRepository.deleteCompany(companyId);
    }


    //page query, page equals 1, pageSize equals 5
    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getPageCompany(@RequestParam int page, @RequestParam int pageSize){
        return companyRepository.getCompanyPage(page, pageSize);

    }
}
