package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //obtain company list
    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    //obtain a certain specific company
    @GetMapping(value = "/{companyId}")
    public Company getCompany(@PathVariable ("companyId") int companyId){
        return companyService.getCompany(companyId);
    }

    //add a company
    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    //update a company basic information
    @PutMapping (value = "/{companyId}")
    public Company updateCompanyInfo (@PathVariable ("companyId")
                                            int companyId, @RequestBody Company company){
        return companyService.updateCompany(companyId, company);
    }

    //delete all employees belong to this company
    @DeleteMapping (value = "/{companyId}")
    public void deleteEmployee (@PathVariable ("companyId") int companyId){
        companyService.deleteCompany(companyId);
    }


    //page query, page equals 1, pageSize equals 5
    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getPageCompany(@RequestParam int page, @RequestParam int pageSize){
        return companyService.getCompanyPage(page, pageSize);

    }
}
