package za.ac.cput.userinterface.customer;

import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerHomeUI {

    private JFrame frame;
    private JPanel panelNorth, panelCenter, panelSouth, panelEast, panelWest;
    private JLabel headerLabel;
    private JButton btnAddCustomer, btnFindCustomer, btnUpdateCustomer, btnDeleteCustomer;
    private JLabel centerFiller1, centerFiller2, centerFiller3, centerFiller4, centerFiller5, centerFiller6;
    private JLabel westFiller1;
    private JLabel eastFiller1;
    private JLabel southFiller1;

    public CustomerHomeUI() {
        frame = new JFrame("Customers");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();

        // Temp JLabels
        centerFiller1 = new JLabel(" ");
        centerFiller2 = new JLabel(" ");
        centerFiller3 = new JLabel(" ");
        centerFiller4 = new JLabel(" ");
        centerFiller5 = new JLabel(" ");
        centerFiller6 = new JLabel(" ");
        westFiller1 = new JLabel("                                                                                       ");
        eastFiller1 = new JLabel("                                                                                       ");
        southFiller1 = new JLabel(" ");

        // Buttons
        btnAddCustomer = new JButton("Add Customer");
        btnFindCustomer = new JButton("Find Customer");
        btnUpdateCustomer = new JButton("Update Customer Details");
        btnDeleteCustomer = new JButton("Remove Customer");

        btnAddCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdateCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnDeleteCustomer.setFont(new Font("Arial", Font.PLAIN, 20));

        // Panel North:
        headerLabel = new JLabel("Header");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 100));
        panelNorth.setLayout(new GridBagLayout());
        panelNorth.add(headerLabel);

        // Panel Center:
        panelCenter.setLayout(new GridLayout(9,1));
        panelCenter.add(centerFiller1);
        panelCenter.add(btnAddCustomer);
        panelCenter.add(centerFiller2);
        panelCenter.add(btnFindCustomer);
        panelCenter.add(centerFiller3);
        panelCenter.add(btnUpdateCustomer);
        panelCenter.add(centerFiller4);
        panelCenter.add(btnDeleteCustomer);
        panelCenter.add(centerFiller5);

        // Panel South(Placeholder panel):
        panelSouth.setLayout(new GridLayout(1,1));
        panelSouth.setPreferredSize(new Dimension(600,400));
        panelSouth.add(southFiller1);

        // uncomment to check size of panel
//         panelSouth.setBackground(Color.GREEN);

        panelWest.setLayout(new GridLayout(1,1));
        panelWest.add(westFiller1);

        panelEast.setLayout(new GridLayout(1,1));
        panelEast.add(eastFiller1);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelWest, BorderLayout.WEST);


    }

    public void customersUI() {
        // Set UI:
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,800);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
