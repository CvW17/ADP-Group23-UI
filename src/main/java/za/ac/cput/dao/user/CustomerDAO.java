package za.ac.cput.dao.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.util.*;


public class CustomerDAO {

    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/customer";


    public String addCustomerToDB(Customer customer) {
        String url = baseURL + "/create";
        HttpEntity<Customer> request;
        ResponseEntity<Customer> response;

        try {
            // Send Customer
            request = new HttpEntity<>(customer);
            response = restTemplate.exchange(url, HttpMethod.POST, request, Customer.class);

            if (response.getStatusCode() == HttpStatus.valueOf(200)) {
                return "Customer Added!";
            } else {
                return "System Error";
            }
        } catch(Error error) {
            throw error;
        }
    }

    public Set<Customer> searchFirstName(String searchTerm) {
        Set<Customer> resultSet = new HashSet<>();
        String url = baseURL + "/search/firstname/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
            Customer[] customers = response.getBody();
            for (Customer c : customers) {
                resultSet.add(c);
                System.out.println(c);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Customer> searchLastName(String searchTerm) {
        Set<Customer> resultSet = new HashSet<>();
        String url = baseURL + "/search/lastname/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
            Customer[] customers = response.getBody();
            for (Customer c : customers) {
                resultSet.add(c);
                System.out.println(c);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Customer> searchContactNumber(String searchTerm) {
        Set<Customer> resultSet = new HashSet<>();
        String url = baseURL + "/search/contactnumber/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
            Customer[] customers = response.getBody();
            for (Customer c : customers) {
                resultSet.add(c);
                System.out.println(c);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Customer> searchEmail(String searchTerm) {
        Set<Customer> resultSet = new HashSet<>();
        String url = baseURL + "/search/email/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
            Customer[] customers = response.getBody();
            for (Customer c : customers) {
                resultSet.add(c);
                System.out.println(c);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Customer> getAllCustomers() {
        Set<Customer> resultSet = new HashSet<>();
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);

        ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
        Customer[] customers = response.getBody();
        for (Customer c : customers) {
            resultSet.add(c);
        }
        return resultSet;
    }

    public Customer getCustomerByID(String id) {
        String url = baseURL + "/read/" + id;

        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);

        return response.getBody();
    }


}
