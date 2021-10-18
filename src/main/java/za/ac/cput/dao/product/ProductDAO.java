/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.dao.product;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.models.entity.product.Product;
import za.ac.cput.models.entity.user.Customer;

import java.util.HashSet;
import java.util.Set;

public class ProductDAO {
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:8080/product";
    private String securityUsername = "user";
    private String securityPassword = "password";

    public String addProductToDB(Product product) {
        String url = baseURL + "/create";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Product> response;
        try {
            HttpEntity<Product> request = new HttpEntity<>(product, header);
            response = restTemplate.exchange(url, HttpMethod.POST, request, Product.class);

            if (response.getStatusCode() == HttpStatus.valueOf(200)) {
                return "Product Added!";
            } else {
                return "System Error";
            }
        } catch(Error error) {
            throw error;
        }
    }

    public Set<Product> searchName(String searchTerm) {
        Set<Product> resultSet = new HashSet<>();
        String url = baseURL + "/search/name/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Product[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product[].class);
            Product[] products = response.getBody();
            for (Product p : products) {
                resultSet.add(p);
                System.out.println(p);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }

    public Set<Product> searchPrice(String searchTerm) {
        Set<Product> resultSet = new HashSet<>();
        String url = baseURL + "/search/price/" + searchTerm;
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
            ResponseEntity<Product[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product[].class);
            Product[] products = response.getBody();
            for (Product p : products) {
                resultSet.add(p);
                System.out.println(p);
            }
        }catch (Error error) {
            throw error;
        }
        return resultSet;
    }


    public Set<Product> getAllProducts() {
        Set<Product> resultSet = new HashSet<>();
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);

        ResponseEntity<Product[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product[].class);
        Product[] products = response.getBody();
        for (Product p : products) {
            resultSet.add(p);
        }
        return resultSet;
    }

    public Product getProductByID(String id) {
        String url = baseURL + "/read/" + id;

        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);

        return response.getBody();
    }

    public Product updateProduct(Product product) {
        String url = baseURL + "/update";
        ResponseEntity<Product> response = restTemplate.postForEntity(url, product, Product.class);

        return response.getBody();
    }

    public String deleteProduct(Product p) {
        String id = p.getProductId();
        String url = baseURL + "/delete/" + id;
        System.out.println(url);
        restTemplate.delete(url);
        System.out.println("Product deleted");

        return "Success";
    }
}
