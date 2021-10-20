package za.ac.cput.dao.product;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.product.Supplier;


import java.util.HashSet;
import java.util.Set;

public class SupplierDAO {

    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/supplier";
    private String securityUsername = "user";
    private String securityPassword = "password";

    public String addSupplierToDB(Supplier supplier) {
        String url = baseURL + "/create";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Supplier> response;
        try {
            HttpEntity<Supplier> request = new HttpEntity<>(supplier, header);
            response = restTemplate.exchange(url, HttpMethod.POST, request, Supplier.class);

            if (response.getStatusCode() == HttpStatus.valueOf(200)) {
                return "Supplier Added!";
            } else {
                return "System Error";
            }
        } catch(Error error) {
            throw error;
        }
    }

    public Set<Supplier> getAllSuppliers() {
        Set<Supplier> resultSet = new HashSet<>();
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);

        ResponseEntity<Supplier[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Supplier[].class);
        Supplier[] suppliers = response.getBody();
        for (Supplier s : suppliers) {
            resultSet.add(s);
        }
        return resultSet;
    }

    public Supplier getSupplierByID(String id) {
        String url = baseURL + "/read/" + id;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<Supplier> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Supplier.class);

        return response.getBody();
    }

    public Supplier updateSupplier(Supplier supplier) {
        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<Supplier> httpEntity = new HttpEntity<>(supplier, header);
        ResponseEntity<Supplier> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Supplier.class);

        return response.getBody();
    }

    public String deleteSupplier(Supplier s) {
        String id = s.getSupplierID();
        String url = baseURL + "/delete/" + id;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
        System.out.println(response);
        System.out.println("Supplier deleted");

        return "Success";
    }

    public Set<Supplier> searchName(String searchTerm) {
        Set<Supplier> resultSet = new HashSet<>();
        String url = baseURL + "/search/name/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Supplier[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Supplier[].class);
            Supplier[] suppliers = response.getBody();
            for (Supplier s : suppliers) {
                resultSet.add(s);
                System.out.println(s);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Supplier> searchEmail(String searchTerm) {
        Set<Supplier> resultSet = new HashSet<>();
        String url = baseURL + "/search/email/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Supplier[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Supplier[].class);
            Supplier[] suppliers = response.getBody();
            for (Supplier s : suppliers) {
                resultSet.add(s);
                System.out.println(s);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Supplier> searchContact(String searchTerm) {
        Set<Supplier> resultSet = new HashSet<>();
        String url = baseURL + "/search/contactnumber/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Supplier[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Supplier[].class);
            Supplier[] suppliers = response.getBody();
            for (Supplier s : suppliers) {
                resultSet.add(s);
                System.out.println(s);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }


}
