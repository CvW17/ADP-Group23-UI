/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.models.entity.product;


public class Product {
    private String productId, supplierId, name, price;

    private Product(){

    }
    private Product(Builder builder) {
        this.productId = builder.productId;
        this.supplierId = builder.supplierId;
        this.name = builder.name;
        this.price = builder.price;
    }


    public String getProductId() {
        return productId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private String productId, supplierId, name;
        private String price;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(String price){
            this.price = price;
            return this;
        }

        public Product Build() {

            return new Product(this);
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.supplierId = product.supplierId;
            this.name = product.name;
            this.price = product.price;
            return this;
        }


    }
}

