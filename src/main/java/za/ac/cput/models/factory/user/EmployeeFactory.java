/**
 *  Name: Robin White
 *  Student Number: 218034555
 *  Group: 23
 *
 *  EmployeeFactory class
 */
package za.ac.cput.models.factory.user;

import za.ac.cput.models.entity.user.Employee;
import za.ac.cput.util.GenericHelper;

import java.util.UUID;

public class EmployeeFactory {
    public static Employee build(String firstName, String lastName, String phoneNumber, Double employeeRate) {

        String employeeID = GenericHelper.generateID();
        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || employeeRate.equals(null))
            return null;

        return new Employee.Builder()
                .setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmployeeRate(employeeRate)
                .build();
    }
}
