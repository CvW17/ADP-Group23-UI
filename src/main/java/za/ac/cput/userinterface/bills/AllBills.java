//AllBills.java
//Interface for Bill(Get All)
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;
import za.ac.cput.models.entity.product.Bill;

import javax.swing.*;
import java.util.Set;

public class AllBills
{
    private JTable tblDisplay;

    public AllBills()
    {


    }


    public JScrollPane Display()
    {
        String[] table = {"Bill ID", "SubTotal", "Tax", "Total"};

        BillDAO bills = new BillDAO();
        Set<Bill> bill = bills.getAll();

        String[][] tblData = new String[bill.size()][4];
        int count = 0;

        for (Bill b: bill)
        {
            tblData[count][0] = b.getBillID();
            tblData[count][1] = String.valueOf(b.getSubTotal());
            tblData[count][2] = String.valueOf(b.getTax());
            tblData[count][3] = String.valueOf(b.getTotal());

            count++;
        }

        tblDisplay = new JTable(tblData, table);
        JScrollPane display = new JScrollPane(tblDisplay);
        display.setSize(50, 50);
        return display;
    }

}
