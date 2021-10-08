package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBillGUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JLabel lblID;
    private JTextField txtID;
    private JButton btnDelete, btnBack;
    private JScrollPane data;

    public DeleteBillGUI()
    {
        AllBillsGUI billsGUI = new AllBillsGUI();

        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        lblID = new JLabel("Enter Bill ID to delete: ");
        txtID = new JTextField();

        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        data = new JScrollPane(billsGUI.Display());
    }

    public void setGUI()
    {
        pnlNorth.setLayout(new FlowLayout());

        pnlCenter.setLayout(new GridLayout(4, 1));
        pnlCenter.add(lblID);
        pnlCenter.add(txtID);
        pnlCenter.add(btnDelete);
        pnlCenter.add(data);
        btnDelete.addActionListener(this);

        pnlSouth.setLayout(new FlowLayout());
        pnlSouth.add(btnBack);
        btnBack.addActionListener(this);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Delete Bills");
    }

    private void delete()
    {
        AllBillsGUI billsGUI = new AllBillsGUI();

        String id =  txtID.getText();

        BillDAO billDAO = new BillDAO();
        billDAO.deleteBill(id);

        data.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case("Delete"):
            {
                if(txtID.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "ID field is empty!");
                else this.delete();

                txtID.setText("");
            }
        }
    }
}
