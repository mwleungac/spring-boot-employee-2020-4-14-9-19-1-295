package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CompanyService {

    @Autowired
    private CompanyService companyService;

    private int companyIdCount = 1;

    private List<Company> companyList = CompanyRepository.createTestCompanies();

    public Company addCompany(Company company){
        company.setId(companyIdCount);
        companyList.add(company);
        companyIdCount++;
        return company;
    }

    public List<Company> getCompanies(){
        return companyList;
    }

    public Company getCompany(int companyId){
        return companyList
                .stream()
                .filter(company -> company.getId() == companyId) //if equal then pass
                .findFirst()
                .get();
    }

    public Company updateCompany(int companyId, Company company){
        companyList
                .stream()
                .forEach(c-> {
                    if(c.getId() == companyId){
                        c.setName(company.getName());
                        c.setBasicInfo(company.getBasicInfo());
                    }

                });
        return companyList
                .stream()
                .filter(c -> c.getId() == companyId)
                .findFirst()
                .get();

    }

    public void deleteCompany(int companyId){
        companyList
                .stream()
                .forEach(c -> {
                    if(c.getId() == companyId) {
                        companyList.remove(c);
                    }
                });
    }
}

