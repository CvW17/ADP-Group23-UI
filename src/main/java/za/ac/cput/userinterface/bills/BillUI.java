//BillUI.java
//Interface for Bill
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import za.ac.cput.userinterface.home.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlSouth, pnlCenter;
    private JButton btnHome, btnAdd, btnSave;
    private JTable tblBills;

    public BillUI()
    {

        pnlNorth = new JPanel();
        pnlSouth = new JPanel();
        pnlCenter = new JPanel();

        btnHome = new JButton("Home");
        btnAdd = new JButton("Add new Bill");
        btnSave = new JButton("Save Bill");

        tblBills = new JTable();
    }

    public void setBillUI()
    {
        this.setTitle("Bill");

        btnSave.addActionListener(this);
        btnAdd.addActionListener(this);
        btnHome.addActionListener(this);

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(tblBills);

        pnlSouth.setLayout(new GridLayout(1,2));
        pnlSouth.add(btnHome);
        pnlSouth.add(btnAdd);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case("Home"):
            {
                new HomeUI().setUI();
                this.dispose();
                break;
            }

            case("Add new Bill"):
            {
                new AddBillUI().setGUI();
                this.dispose();
                break;
            }
        }
    }
}
