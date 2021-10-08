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

    public BillDAO()
    {

    }

    public String addBill(Bill bill)
    {
        String url = baseURL + "/create";
        HttpEntity<Bill> send;
        ResponseEntity<Bill> receive;

        try
        {
            send = new HttpEntity<>(bill);
            receive = restTemplate.exchange(url, HttpMethod.POST, send, Bill.class);

            if (receive.getStatusCode().equals(HttpStatus.valueOf(200)))
                return "Success";
            else return "Error";
        }
        catch  (Error error)
        {
            throw error;
        }
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
}
