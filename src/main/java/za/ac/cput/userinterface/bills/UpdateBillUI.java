package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.product.BillDAO;

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
    private JLabel lblHeading, lblUpdate;
    private JComboBox cmbID;

    public UpdateBillUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        btnBack = new JButton("Back");
        btnBack = new JButton("Update");

        lblHeading = new JLabel("Update Bill");
        lblUpdate = new JLabel("Choose Bill id to update");

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

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(lblUpdate);
        pnlCenter.add(cmbID);

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
        }
    }
}
