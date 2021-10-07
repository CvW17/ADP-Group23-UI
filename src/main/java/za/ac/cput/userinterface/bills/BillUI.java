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
    private JPanel pnlNorth, pnlCenter;
    private JButton btnHome, btnAdd, btnRead, btnDelete, btnUpdate, btnGetAll;

    public BillUI()
    {

        pnlNorth = new JPanel();
        pnlCenter = new JPanel();

        btnHome = new JButton("Home");
        btnAdd = new JButton("Add new Bill");
        btnRead = new JButton("Read Data");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        btnGetAll = new JButton("Get All");

    }

    public void setBillUI()
    {
        this.setTitle("Bill");

        btnAdd.addActionListener(this);
        btnHome.addActionListener(this);
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnGetAll.addActionListener(this);

        pnlCenter.setLayout(new GridLayout(6, 1));
        pnlCenter.add(btnHome);
        pnlCenter.add(btnAdd);
        pnlCenter.add(btnRead);
        pnlCenter.add(btnUpdate);
        pnlCenter.add(btnDelete);
        pnlCenter.add(btnGetAll);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);

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

            case("Get All"):
            {
                new AllBillsGUI().setGUI();
                this.dispose();
                break;
            }
        }
    }
}
