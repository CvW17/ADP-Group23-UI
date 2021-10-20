/**
 *  Author: Robyn White - 218034555
 *  Add Employee Gui Interface
 */
package za.ac.cput.dao.user;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/employee";
    private String Username = "user";
    private String Password = "password";

    //CREATE
    public String addEmployee(Employee employee) {
        String url = baseURL + "/create";
        HttpEntity<Employee> request;
        ResponseEntity<Employee> response;
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);

        try {

            request = new HttpEntity<>(employee,head);
            response = restTemplate.exchange(url, HttpMethod.POST, request, Employee.class);

            if (response.getStatusCode() == HttpStatus.valueOf(200)) {
                return "Employee Added to Database";
            } else {
                return "Data Error";
            }
        } catch(Error e) {
            throw e;
        }
    }

    //READ
    public Employee FindEmployeeByID(String id) {
        String url = baseURL + "/read/" + id;
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<Employee> response = restTemplate.exchange(url,HttpMethod.GET,entity, Employee.class);
        return response.getBody();
    }

    //UPDATE
    public Employee updateEmployee(Employee employee) {
        String url = baseURL + "/update";
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<Employee> entity = new HttpEntity<>(employee, head);
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.POST, entity,Employee.class);
        System.out.println("Employee information has been updated");
        return response.getBody();

    }

    //DELETE
    public String removeEmployee(Employee e) {
        String id = e.getEmployeeID();
        String url = baseURL + "/delete/" + id;
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.DELETE,entity, String.class);
        System.out.println(response);
        System.out.println("Employee has been deleted and removed from the database");
        return "Deletion Succesful";
    }

    //GETALL
    public Set<Employee> getAll() {
        Set<Employee> resultSet = new HashSet<>();
        String url = baseURL + "/getall";
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<Employee[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
        Employee[] employees = response.getBody();
        for (Employee e : employees) {
            resultSet.add(e);
        }
        return resultSet;
    }
}
