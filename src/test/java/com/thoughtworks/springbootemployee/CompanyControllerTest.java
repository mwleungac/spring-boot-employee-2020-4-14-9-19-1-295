package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.controller.CompanyController;
import com.thoughtworks.springbootemployee.controller.EmployeeController;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;


    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(companyController);
    }

    @Test
    public void shouldFindCompanyById() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .get("/companies/1");

        Assert.assertEquals(200, response.getStatusCode());

        Company company = response.getBody().as(Company.class);
        Assert.assertEquals(1, company.getId());
        Assert.assertEquals("CompanyA", company.getName());

    }

    @Test
    public void shouldAddCompany() {
        Company company = new Company();

        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(company)
                .when()
                .post("/companies");

        Assert.assertEquals(200, response.getStatusCode());

        Company company1 = response.getBody().as(Company.class);
        Assert.assertEquals(3, company.getId());
        Assert.assertEquals("XX", company.getName());
    }

    @Test
    public void shouldUpdateCompany() {
        Company company = new Company();

        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(company)
                .when()
                .post("/companies");

        Assert.assertEquals(200, response.getStatusCode());

        Company company1 = response.getBody().as(Company.class);
        Assert.assertEquals(3, company.getId());
        Assert.assertEquals("XXX", company.getName());
    }

    @Test
    public void shouldDeleteCompany() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .delete("/companies/3");

        Assert.assertEquals(200, response.getStatusCode());

    }
}
