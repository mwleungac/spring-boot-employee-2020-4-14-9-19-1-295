package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyRepository {
    public static List<Company> createTestCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "CompanyA","CompanyA"));
        companies.add(new Company(2, "CompanyB","CompanyB"));

        return companies;
    }

    private int companyIdIndex = 1;

    private List<Company> companyList = CompanyRepository.createTestCompanies();

    public Company addCompany(Company company) {
        company.setId(companyIdIndex);
        companyList.add(company);
        companyIdIndex++;
        return company;
    }

    public List<Company> getCompanies() {
        return companyList;
    }

    public Company getCompany(int companyId) {
        return companyList
                .stream()
                .filter(company -> company.getId() == companyId) //if equal then pass
                .findFirst()
                .orElse(null);
    }

    //@TODO: naming
    public Company updateCompany(int companyId, Company company) {
        companyList
                .forEach(c -> {
                    if (c.getId() == companyId) {
                        c.setName(company.getName());
                        c.setBasicInfo(company.getBasicInfo());
                    }

                });
        return companyList
                .stream()
                .filter(c -> c.getId() == companyId)
                .findFirst()
                .orElse(null);

    }

    public void deleteCompany(int companyId) {
        companyList
                .forEach(c -> {
                    if (c.getId() == companyId) {
                        companyList.remove(c);
                    }
                });
    }

    public List<Company> getCompanyPage(int page, int pageSize) {
        return companyList.stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

}
