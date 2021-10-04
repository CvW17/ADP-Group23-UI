/**
 *  Author: Robyn White - 218034555
 *  Add Employee Gui Interface
 */
package za.ac.cput.dao.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.user.Employee;

public class EmployeeDAO {
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/employee";


    public String addEmployee(Employee employee) {
        String url = baseURL + "/create";
        HttpEntity<Employee> request;
        ResponseEntity<Employee> response;

        try {
            // Send Employee
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
}
