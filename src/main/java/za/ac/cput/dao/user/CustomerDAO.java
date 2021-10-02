package za.ac.cput.dao.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;


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



}
