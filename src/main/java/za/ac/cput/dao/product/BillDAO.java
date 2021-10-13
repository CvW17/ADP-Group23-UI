//BillDAO.java
//Class for BillDAO
//Author: Cameron van Wyk(219088470)

package za.ac.cput.dao.product;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.product.Bill;
import za.ac.cput.models.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;

public class BillDAO
{
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/bill";

    public BillDAO()
    {

    }

    public void addBill(Bill bill)
    {
        String url = baseURL + "/create";
        HttpEntity<Bill> send;
        ResponseEntity<Bill> receive;

        try
        {
            send = new HttpEntity<>(bill);
            receive = restTemplate.exchange(url, HttpMethod.POST, send, Bill.class);
        }
        catch  (Error error)
        {
            throw error;
        }
    }

    public void deleteBill(String id)
    {
        String url = baseURL + "/delete/" + id;
        restTemplate.delete(url);
    }

    public Bill updateBill(Bill bill)
    {
        String url = baseURL + "/update";
        ResponseEntity<Bill> responseEntity = restTemplate.postForEntity(url, bill, Bill.class);

        return responseEntity.getBody();
    }

    public Bill getByID(String id)
    {
        String url = baseURL + "/read/" + id;

        ResponseEntity<Bill> response = restTemplate.getForEntity(url, Bill.class);

        return response.getBody();
    }

    public Set<Bill> getAll()
    {
        Set<Bill> set = new HashSet<>();
        String url = baseURL + "/getAll";

        HttpHeaders header = new HttpHeaders();
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
