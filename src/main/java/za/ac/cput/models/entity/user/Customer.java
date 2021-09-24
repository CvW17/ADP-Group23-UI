/**
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  Customer class
 */
package za.ac.cput.models.entity.user;


public class Customer {

    private String customerID;

    private String firstName, lastName, contactNumber, email;

    private Customer() {}

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String customerID;
        private String firstName, lastName, DOB, contactNumber, email;

        public Builder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Customer builder() {
            return new Customer(this);
        }

        public Builder copy(Customer customer) {
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.contactNumber = customer.contactNumber;
            this.email = customer.email;
            return this;
        }


    }
    @Override
    public String toString() {
        return "Builder{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
