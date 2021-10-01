//AddBillUI.java
//Interface for Bill Add
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBillUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JButton btnSave;
    private JLabel lblBillID, lblTax, lblSubTotal, lblTotal;
    private JTextField txtBillID, txtTax, txtSubTotal, txtTotal;

    public AddBillUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnSave = new JButton("Save");

        lblBillID = new JLabel("Bill ID: ");
        lblSubTotal = new JLabel("Sub Total: ");
        lblTax = new JLabel("Tax: ");
        lblTotal = new JLabel("Total: ");

        txtBillID = new JTextField();
        txtSubTotal = new JTextField();
        txtTax = new JTextField();
        txtTotal = new JTextField();
    }

    public void setGUI()
    {
        this.setTitle("Add new Bill");

        pnlNorth.setLayout(new FlowLayout());

        pnlCenter.setLayout(new GridLayout(4, 2));
        pnlCenter.add(lblBillID);
        pnlCenter.add(txtBillID);
        pnlCenter.add(lblSubTotal);
        pnlCenter.add(txtSubTotal);
        pnlCenter.add(lblTax);
        pnlCenter.add(txtTax);
        pnlCenter.add(lblTotal);
        pnlCenter.add(txtTotal);

        pnlSouth.add(btnSave);
        btnSave.addActionListener(this);

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

    }
}
