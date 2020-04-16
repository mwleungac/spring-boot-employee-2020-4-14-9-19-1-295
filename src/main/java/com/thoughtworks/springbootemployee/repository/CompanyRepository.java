package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    public static List<Company> createTestCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "CompanyA","CompanyA"));
        companies.add(new Company(2, "CompanyB","CompanyB"));

        return companies;
    }

}
