//AddBillUI.java
//Interface for Bill Add
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;
import za.ac.cput.models.entity.product.Bill;
import za.ac.cput.models.factory.product.BillFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBillUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JButton btnSave, btnBack;
    private JLabel lblTax, lblSubTotal, lblTotal, lblHeading;
    private JTextField txtTax, txtSubTotal, txtTotal;

    public AddBillUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnSave = new JButton("Save");
        btnBack = new JButton("Back");

        lblSubTotal = new JLabel("Sub Total: ");
        lblTax = new JLabel("Tax: ");
        lblTotal = new JLabel("Total: ");
        lblHeading = new JLabel("Add new Bill");

        txtSubTotal = new JTextField();
        txtTax = new JTextField();
        txtTotal = new JTextField();
    }

    public void setGUI()
    {
        this.setTitle("Add new Bill");

        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);
        lblHeading.setFont(new Font("Arial", Font.PLAIN, 30));

        pnlCenter.setLayout(new GridLayout(4, 2));
        pnlCenter.add(lblSubTotal);
        lblSubTotal.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlCenter.add(txtSubTotal);
        txtSubTotal.setPreferredSize(new Dimension(200,24));

        pnlCenter.add(lblTax);
        lblTax.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlCenter.add(txtTax);
        txtTax.setPreferredSize(new Dimension(200,24));

        pnlCenter.add(lblTotal);
        lblTotal.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlCenter.add(txtTotal);
        txtTotal.setPreferredSize(new Dimension(200,24));

        pnlSouth.add(btnSave);
        btnSave.addActionListener(this);
        btnSave.setFont(new Font("Arial", Font.PLAIN, 20));

        pnlSouth.add(btnBack);
        btnBack.addActionListener(this);
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void Save()
    {
        int subTotal = Integer.parseInt(txtSubTotal.getText());
        int tax = Integer.parseInt(txtTax.getText());
        int total = Integer.parseInt(txtTotal.getText());

        BillDAO billDAO = new BillDAO();

        Bill bill = BillFactory.build(subTotal, tax, total);
        billDAO.addBill(bill);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case("Save"):
            {
                if ((Integer.parseInt(txtSubTotal.getText()) < 1) && (Integer.parseInt(txtTax.getText()) < 1)
                        && (Integer.parseInt(txtTotal.getText())< 1))
                {
                    System.out.println("Not all fields have values!");
                }
                else this.Save();

                new BillUI().setBillUI();
                this.dispose();
                break;
            }

            case("Back"):
            {
                new BillUI().setBillUI();
                this.dispose();
                break;
            }
        }

    }
}
