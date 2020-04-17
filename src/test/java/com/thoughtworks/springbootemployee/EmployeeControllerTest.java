package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.controller.EmployeeController;
import com.thoughtworks.springbootemployee.model.Employee;
import io.restassured.http.ContentType;
import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;


    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(employeeController);
    }

    @Test
    public void shouldFindEmployeeById() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .get("/employees/1");

        Assert.assertEquals(200, response.getStatusCode());

        Employee employee = response.getBody().as(Employee.class);
        Assert.assertEquals(1, employee.getId());
        Assert.assertEquals("xiaoming", employee.getName());

    }

    @Test
    public void shouldFindEmployeeByGender() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .params("gender", "male")
                .when()
                .get("/employees");

        Assert.assertEquals(200, response.getStatusCode());

        Employee employee = response.getBody().as(Employee.class);
        Assert.assertEquals("male", employee.getGender());
        Assert.assertEquals("xiaoming", employee.getName());
    }

    @Test
    public void shouldFindEmployeeByPage() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .params("page", 1)
                .params("pageSize", 5)
                .when()
                .get("/employees");

        Assert.assertEquals(200, response.getStatusCode());

        List<Employee> employees = response.getBody().as(new TypeRef<List<Employee>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        Assert.assertEquals(0, employees.size());

    }

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(3,"XX",30,"male",2000);

        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(employee)
                .when()
                .post("/employees");

        Assert.assertEquals(200, response.getStatusCode());

        Employee employee1 = response.getBody().as(Employee.class);
        Assert.assertEquals(3, employee.getId());
        Assert.assertEquals("XX", employee.getName());
    }

    @Test
    public void shouldDeleteEmployee() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .delete("/employees/3");

        Assert.assertEquals(200, response.getStatusCode());

    }

    @Test
    public void shouldUpdateEmployee() {
        Employee employee = new Employee(3,"XXX",30,"male",2000);

        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(employee)
                .when()
                .post("/employees");

        Assert.assertEquals(200, response.getStatusCode());

        Employee employee1 = response.getBody().as(Employee.class);
        Assert.assertEquals(3, employee.getId());
        Assert.assertEquals("XXX", employee.getName());
    }


}
