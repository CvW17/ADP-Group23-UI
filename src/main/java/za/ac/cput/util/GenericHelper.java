package za.ac.cput.util;

import java.util.UUID;

public class GenericHelper {

    public static String generateID()
    {
        return UUID.randomUUID().toString();
    }

    public static boolean validEmail(String email) { // checks that email is valid
        String regex = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return email.matches(regex);
    }

    public static boolean validContactNumber(String contactNumber) {
        String regex = "[0-9]+";
        return contactNumber.matches(regex);
    }
    public static boolean validPrice(String contactNumber) {
        String regex = "[0-9]+";
        return contactNumber.matches(regex);
    }

    public static boolean nameValidation(String supplierName) {
        String regex = "[a-zA-Z ']+";
        return supplierName.matches(regex);
    }

    public static boolean emailValidation(String supplierEmail) {
        String regex = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return supplierEmail.matches(regex);
    }

    public static boolean contactValidation(String supplierContact) {
        String regex = "[0-9]+";
        return supplierContact.matches(regex);
    }

}
