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
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JButton btnHome, btnAdd, btnDelete, btnUpdate;
    private JLabel lblHeading;

    public BillUI()
    {

        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnHome = new JButton("Home");
        btnAdd = new JButton("Add new Bill");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");

        lblHeading = new JLabel("Bills Home");
    }

    public void setBillUI()
    {
        this.setTitle("Bill");

        lblHeading.setFont(new Font("Arial", Font.PLAIN, 30));

        btnAdd.addActionListener(this);
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));

        btnHome.addActionListener(this);
        btnHome.setFont(new Font("Arial", Font.PLAIN, 20));

        btnDelete.addActionListener(this);
        btnDelete.setFont(new Font("Arial", Font.PLAIN, 20));

        btnUpdate.addActionListener(this);
        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));

        pnlNorth.setLayout(new GridLayout(6, 1));
        pnlNorth.add(lblHeading);
        pnlNorth.add(btnHome);
        pnlNorth.add(btnAdd);
        pnlNorth.add(btnUpdate);
        pnlNorth.add(btnDelete);

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(new AllBills().Display());

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);

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

            case("Delete"):
            {
                new DeleteBillGUI().setGUI();
                this.dispose();
                break;
            }

            case("Update"):
            {
                new UpdateBillUI().setGUI();
                this.dispose();
                break;
            }
        }
    }
}
