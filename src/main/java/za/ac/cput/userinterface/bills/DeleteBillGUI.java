package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class DeleteBillGUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JLabel lblID, lblHeading;
    private JButton btnDelete, btnBack;
    private JComboBox cmbID;

    public DeleteBillGUI()
    {
        AllBills billsGUI = new AllBills();

        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        lblID = new JLabel("Enter Bill ID to delete: ");
        lblHeading = new JLabel("Choose Bill to delete: ");

        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        cmbID = new JComboBox();
    }

    public void setGUI()
    {
        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);
        lblHeading.setFont(new Font("Arial", Font.PLAIN, 30));

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.setPreferredSize(new Dimension(200,50));

        pnlCenter.add(lblID);
        lblID.setFont(new Font("Arial", Font.PLAIN, 15));

        this.getSet();
        pnlCenter.add(cmbID);
        pnlCenter.add(btnDelete);

        btnDelete.addActionListener(this);

        pnlSouth.setLayout(new FlowLayout());
        pnlSouth.add(btnBack);

        btnBack.addActionListener(this);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Delete Bills");
    }

    private void delete()
    {
        AllBills billsGUI = new AllBills();

        BillDAO billDAO = new BillDAO();
        billDAO.deleteBill(String.valueOf(cmbID.getSelectedItem()));
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case("Delete"):
            {
                this.delete();

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
