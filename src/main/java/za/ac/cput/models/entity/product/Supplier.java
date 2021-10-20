package za.ac.cput.models.entity.product;

public class Supplier {

    private String supplierID;
    private String supplierName, supplierEmail, supplierContact;


    public Supplier() {
    }

    public Supplier(String supplierID, String supplierName, String supplierEmail, String supplierContact) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierContact = supplierContact;
    }

    private Supplier(Builder builder)
    {
        this.supplierID = builder.supplierID;
        this.supplierName = builder.supplierName;
        this.supplierEmail = builder.supplierEmail;
        this.supplierContact = builder.supplierContact;

    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public static class Builder{

        private String supplierID, supplierName, supplierEmail, supplierContact;

        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder setSupplierEmail(String supplierEmail) {
            this.supplierEmail = supplierEmail;
            return this;
        }

        public Builder setSupplierContact(String supplierContact) {
            this.supplierContact = supplierContact;
            return this;
        }

        public Builder copy(Supplier s ) {
            this.supplierID = s.supplierID;
            this.supplierName = s.supplierName;
            this.supplierEmail = s.supplierEmail;
            this.supplierContact = s.supplierContact;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "supplierID='" + supplierID + '\'' +
                    ", supplierName='" + supplierName + '\'' +
                    ", supplierEmail='" + supplierEmail + '\'' +
                    ", supplierContact='" + supplierContact + '\'' +
                    '}';
        }

        public Supplier build() {

            return new Supplier(this);
        }
    }
}
