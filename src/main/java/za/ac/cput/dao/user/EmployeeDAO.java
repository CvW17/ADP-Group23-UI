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


    public String addEmployee(Employee employee) {
        String url = baseURL + "/create";
        HttpEntity<Employee> request;
        ResponseEntity<Employee> response;

        try {

            request = new HttpEntity<>(employee);
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

    public Set<Employee> getAll() {
        Set<Employee> resultSet = new HashSet<>();
        String url = baseURL + "/getall";
        HttpHeaders head = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, head);

        ResponseEntity<Employee[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Employee[].class);
        Employee[] employees = response.getBody();
        for (Employee e : employees) {
            resultSet.add(e);
        }
        return resultSet;
    }

    public String removeEmployee(Employee e) {
        String id = e.getEmployeeID();
        String url = baseURL + "/delete/" + id;
        System.out.println(url);
        restTemplate.delete(url);
        System.out.println("Employee has been deleted and removed from the database");

        return "Deletion Succesful";
    }

    public Employee FindEmployeeByID(String id) {
        String url = baseURL + "/read/" + id;

        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);

        return response.getBody();
    }

    public Employee updateEmployee(Employee employee) {
        String url = baseURL + "/update";
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, employee, Employee.class);

        return response.getBody();
    }
}
