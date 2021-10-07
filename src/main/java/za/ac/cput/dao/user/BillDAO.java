package za.ac.cput.dao.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
