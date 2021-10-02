//BillFactory.java
//Factory for Bill
//Author: Cameron van Wyk(219088470)

package za.ac.cput.models.factory.product;

import za.ac.cput.models.entity.product.Bill;
import za.ac.cput.util.GenericHelper;

public class BillFactory
{
    public static Bill build(double subTotal, double tax, double total)
    {
        String billID = GenericHelper.generateID();

        Bill bill = new Bill.Builder().setBillID(billID).setSubTotal(subTotal).setTax(tax)
                .setTotal(total).build();

        return bill;
    }
}
