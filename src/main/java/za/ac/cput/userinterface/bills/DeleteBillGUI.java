package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBillGUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JLabel lblID, lblHeading;
    private JTextField txtID;
    private JButton btnDelete, btnBack;
    private JScrollPane data;

    public DeleteBillGUI()
    {
        AllBills billsGUI = new AllBills();

        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        lblID = new JLabel("Enter Bill ID to delete: ");
        lblHeading = new JLabel("Delete a Bill");

        txtID = new JTextField();

        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        data = new JScrollPane(billsGUI.Display());
    }

    public void setGUI()
    {
        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);
        lblHeading.setFont(new Font("Arial", Font.PLAIN, 30));

        pnlCenter.setLayout(new GridLayout(4, 1));
        pnlCenter.add(lblID);

        lblID.setFont(new Font("Arial", Font.PLAIN, 15));
        lblID.setPreferredSize(new Dimension(200,24));

        pnlCenter.add(txtID);
        txtID.setPreferredSize(new Dimension(200,24));
        pnlCenter.add(btnDelete);
        pnlCenter.add(data);

        btnDelete.addActionListener(this);
        btnDelete.setFont(new Font("Arial", Font.PLAIN, 20));

        pnlSouth.setLayout(new FlowLayout());
        pnlSouth.add(btnBack);

        btnBack.addActionListener(this);
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Delete Bills");
    }

    private void delete()
    {
        AllBills billsGUI = new AllBills();

        String id =  txtID.getText();

        BillDAO billDAO = new BillDAO();
        billDAO.deleteBill(id);
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
