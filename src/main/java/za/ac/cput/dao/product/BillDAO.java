//BillDAO.java
//Class for BillDAO
//Author: Cameron van Wyk(219088470)

package za.ac.cput.dao.product;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.product.Bill;

import java.util.HashSet;
import java.util.Set;

public class BillDAO
{
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/bill";

    private String username = "user";
    private String password = "password";

    public BillDAO()
    {

    }

    public void addBill(Bill bill)
    {
        String url = baseURL + "/create";

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);

        HttpEntity<Bill> entity;
        ResponseEntity<Bill> response;

        try
        {
            entity = new HttpEntity<>(bill, header);
            response = restTemplate.exchange(url, HttpMethod.POST, entity, Bill.class);
        }
        catch  (Error error)
        {
            throw error;
        }
    }

    public void deleteBill(String id)
    {
        String url = baseURL + "/delete/" + id;

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<String> entity= new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
    }

    public Bill updateBill(Bill bill)
    {
        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(bill, header);
        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.POST, entity, Bill.class);

        return response.getBody();
    }

    public Bill getByID(String id)
    {
        String url = baseURL + "/read/" + id;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(null, header);

        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.GET, entity, Bill.class);

        return response.getBody();
    }

    public Set<Bill> getAll()
    {
        Set<Bill> set = new HashSet<>();
        String url = baseURL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);

        ResponseEntity<Bill[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Bill[].class);
        Bill[] bill = responseEntity.getBody();

        for (Bill b: bill)
        {
            set.add(b);
        }

        return set;
    }

    public Set<String> getID()
    {
        Set<String> set = new HashSet<>();
        String url = baseURL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);

        ResponseEntity<Bill[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Bill[].class);
        Bill[] bill = responseEntity.getBody();

        for (Bill b: bill)
        {
            set.add(b.getBillID());
        }

        return set;
    }
}
