//AllBillsGUI.java
//Interface for Bill(Get All)
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;
import za.ac.cput.models.entity.product.Bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class AllBillsGUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JTable tblDisplay;
    private JLabel lblHeading;
    private JButton btnBack;

    public AllBillsGUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        lblHeading = new JLabel("All Bills");

        btnBack = new JButton("Back");

    }

    public void setGUI()
    {
        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(this.Display());

        pnlSouth.setLayout(new FlowLayout());
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Display All Bills");
    }

    private JScrollPane Display()
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
        return display;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case("Back"):
            {
                new BillUI().setBillUI();
                this.dispose();
                break;
            }
        }
    }
}
