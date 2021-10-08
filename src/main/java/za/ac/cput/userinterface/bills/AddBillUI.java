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
    private JButton btnSave, btnReset, btnBack;
    private JLabel lblTax, lblSubTotal, lblTotal;
    private JTextField txtTax, txtSubTotal, txtTotal;

    public AddBillUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnSave = new JButton("Save");
        btnReset = new JButton("Reset");
        btnBack = new JButton("Back");

        lblSubTotal = new JLabel("Sub Total: ");
        lblTax = new JLabel("Tax: ");
        lblTotal = new JLabel("Total: ");

        txtSubTotal = new JTextField();
        txtTax = new JTextField();
        txtTotal = new JTextField();
    }

    public void setGUI()
    {
        this.setTitle("Add new Bill");

        pnlNorth.setLayout(new FlowLayout());

        pnlCenter.setLayout(new GridLayout(4, 2));
        pnlCenter.add(lblSubTotal);
        pnlCenter.add(txtSubTotal);
        pnlCenter.add(lblTax);
        pnlCenter.add(txtTax);
        pnlCenter.add(lblTotal);
        pnlCenter.add(txtTotal);

        pnlSouth.add(btnSave);
        btnSave.addActionListener(this);
        pnlSouth.add(btnReset);
        btnReset.addActionListener(this);
        pnlSouth.add(btnBack);
        btnBack.addActionListener(this);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

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
                int subTotal = Integer.parseInt(txtSubTotal.getText());
                int tax = Integer.parseInt(txtTax.getText());
                int total = Integer.parseInt(txtTotal.getText());

                if ((subTotal < 1) && (tax < 1) && (total< 1))
                {
                    JOptionPane.showMessageDialog(null, "Not all fields have values!");
                }
                else this.Save();
            }

            case("Reset"):
            {
                txtSubTotal.setText("");
                txtTax.setText("");
                txtTotal.setText("");
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
