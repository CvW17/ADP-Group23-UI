package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;
import za.ac.cput.models.entity.product.Bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class UpdateBillUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JButton btnBack, btnUpdate;
    private JLabel lblHeading, lblUpdate, lblID, lblSubTotal, lblTax;
    private JTextField txtID, txtSubTotal, txtTax;
    private JComboBox cmbID;

    Bill bill;

    public UpdateBillUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnBack = new JButton("Back");
        btnUpdate = new JButton("Update");

        lblHeading = new JLabel("Update Bill");
        lblUpdate = new JLabel("Choose Bill id to update");
        lblID = new JLabel("Insert new Bill ID");
        lblSubTotal = new JLabel("Insert new Bill SubTotal");
        lblTax = new JLabel("Insert new Bill Tax");

        txtID = new JTextField();
        txtSubTotal = new JTextField();
        txtTax = new JTextField();

        cmbID = new JComboBox();
    }

    public void getSet()
    {
        BillDAO billDAO = new BillDAO();

        Set<String> data = new HashSet();
        data.addAll(billDAO.getID());

        String[] id = new String[0];

        id = data.toArray(id);

        for (int i = 0; i < id.length; i++)
        {
            cmbID.addItem(id[i]);
        }
    }

    public void setGUI()
    {
        this.getSet();

        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);

        pnlCenter.setLayout(new GridLayout(4, 2));
        pnlCenter.setPreferredSize(new Dimension(200,200));

        pnlCenter.add(lblUpdate);
        pnlCenter.add(cmbID);
        pnlCenter.add(lblID);
        txtID.setPreferredSize(new Dimension(50,50));
        pnlCenter.add(txtID);
        pnlCenter.add(lblSubTotal);
        txtSubTotal.setPreferredSize(new Dimension(50,50));
        pnlCenter.add(txtSubTotal);
        pnlCenter.add(lblTax);
        txtTax.setPreferredSize(new Dimension(50,50));
        pnlCenter.add(txtTax);

        pnlSouth.setLayout(new FlowLayout());
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);
        btnUpdate.addActionListener(this);
        pnlSouth.add(btnUpdate);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlSouth, BorderLayout.SOUTH);
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
            case("Back"):
            {
                new BillUI().setBillUI();
                this.dispose();
                break;
            }

            case("Update"):
            {
                BillDAO billDAO = new BillDAO();

                String id = String.valueOf(cmbID.getSelectedItem());

                bill = billDAO.getByID(id);

                double Total = Double.parseDouble(txtSubTotal.getText()) - Double.parseDouble(txtTax.getText());

                bill = new Bill.Builder().copy(bill)
                        .setBillID(txtID.getText())
                        .setSubTotal(Double.parseDouble(txtSubTotal.getText()))
                        .setTax(Double.parseDouble(txtTax.getText()))
                        .setTotal(Total).build();

                new BillDAO().updateBill(bill);

                new BillUI().setBillUI();
                this.dispose();
                break;
            }
        }
    }
}
