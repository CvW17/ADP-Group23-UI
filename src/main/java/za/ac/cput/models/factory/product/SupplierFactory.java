package za.ac.cput.models.factory.product;

import za.ac.cput.models.entity.product.Supplier;
import za.ac.cput.util.GenericHelper;

public class SupplierFactory {

    public static Supplier build(String supplierName, String supplierEmail, String supplierContact){

        String supplierID = GenericHelper.generateID();

        if (!GenericHelper.emailValidation(supplierEmail)) {
            System.out.println("Please Insert a Valid Email");
            return null;
        }
        if (supplierName.isEmpty() || supplierContact.isEmpty() || supplierEmail.isEmpty()) {
            System.out.println("Please Enter All Information");
            return null;
        }

        return new Supplier.Builder().setSupplierID(supplierID).setSupplierName(supplierName)
                .setSupplierEmail(supplierEmail).setSupplierContact(supplierContact).build();
    }
}
