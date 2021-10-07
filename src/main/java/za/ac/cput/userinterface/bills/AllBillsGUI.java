package za.ac.cput.userinterface.bills;

import za.ac.cput.dao.user.BillDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllBillsGUI extends JFrame implements ActionListener
{
    private JPanel pnlNorth, pnlCenter;
    private JTextArea txfAll;
    private JLabel lblHeading;

    public AllBillsGUI()
    {
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();

        txfAll = new JTextArea(10, 10);

        lblHeading = new JLabel("All Bills");
    }

    public void setGUI()
    {
        pnlNorth.setLayout(new FlowLayout());
        pnlNorth.add(lblHeading);

        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(txfAll);
        txfAll.append(String.valueOf(new BillDAO().getAll()));

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

    }
}
