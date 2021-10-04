package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GetAllCustomersPanel implements ActionListener {

    private JPanel getAllCustomersPanel;

    private JPanel panelNorth, panelSouth, panelWest, panelCenter, panelEast;

    private JLabel title;

    private JTable getAllTable;

    private JButton btnUpdate, btnDelete, btnExit;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16, filler17;
    private JLabel filler18, filler19;

    public JPanel GetAllPanel() {
        // Panels
        getAllCustomersPanel = new JPanel();
        getAllCustomersPanel.setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();

        // Labels
        title = new JLabel("All Customers");
        title.setFont(new Font("Arial", Font.BOLD, 25));

        // Fillers
        filler1 = new JLabel(" ");
        filler2 = new JLabel(" ");
        filler3 = new JLabel(" ");
        filler4 = new JLabel(" ");
        filler5 = new JLabel(" ");
        filler6 = new JLabel("                                ");
        filler7 = new JLabel("                                ");
        filler8 = new JLabel(" ");
        filler9 = new JLabel(" ");
        filler10 = new JLabel(" ");
        filler11 = new JLabel(" ");
        filler12 = new JLabel(" ");
        filler13 = new JLabel(" ");
        filler14 = new JLabel(" ");
        filler15 = new JLabel(" ");
        filler16 = new JLabel(" ");
        filler17 = new JLabel(" ");
        filler18 = new JLabel(" ");
        filler19 = new JLabel(" ");

        // Buttons
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        // Button Styles
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        // Button Functionality
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        btnUpdate.addActionListener(this);

        // Table
        String[] tableColumnTitle = {"Customer ID","First Name", "Last Name", "Contact Number", "Email"};

        // Add Customers to table
        CustomerDAO cdao = new CustomerDAO();
        Set<Customer> customers = cdao.getAllCustomers();
        String[][] data = new String[customers.size()][5];
        int i = 0;

        for (Customer c : customers) {
            data[i][0] = c.getCustomerID();
            data[i][1] = c.getFirstName();
            data[i][2] = c.getLastName();
            data[i][3] = c.getContactNumber();
            data[i][4] = c.getEmail();

            i++;
        }

        getAllTable = new JTable(data, tableColumnTitle);
        JScrollPane sp = new JScrollPane(getAllTable);

        // Panel Styles
        panelNorth.setLayout(new GridLayout(2, 3));
        panelCenter.setLayout(new GridLayout(1, 1));
        panelWest.setLayout(new GridLayout(1, 1));
        panelEast.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(3, 5));

        // Add to North
        panelNorth.add(filler1);
        panelNorth.add(title);
        panelNorth.add(filler2);
        panelNorth.add(filler3);
        panelNorth.add(filler4);
        panelNorth.add(filler5);

        // Add to West
        panelWest.add(filler6);

        // Add to Center
        panelCenter.add(sp);

        // Add to East
        panelEast.add(filler7);

        // Add to South
        panelSouth.add(filler8);
        panelSouth.add(filler9);
        panelSouth.add(filler10);
        panelSouth.add(filler11);
        panelSouth.add(filler12);

        panelSouth.add(filler13);
        panelSouth.add(btnUpdate);
        panelSouth.add(btnDelete);
        panelSouth.add(btnExit);
        panelSouth.add(filler14);

        panelSouth.add(filler15);
        panelSouth.add(filler16);
        panelSouth.add(filler17);
        panelSouth.add(filler18);
        panelSouth.add(filler19);

        getAllCustomersPanel.add(panelNorth, BorderLayout.NORTH);
        getAllCustomersPanel.add(panelWest, BorderLayout.WEST);
        getAllCustomersPanel.add(panelCenter, BorderLayout.CENTER);
        getAllCustomersPanel.add(panelEast, BorderLayout.EAST);
        getAllCustomersPanel.add(panelSouth, BorderLayout.SOUTH);




        return getAllCustomersPanel;
    }


    public void actionPerformed(ActionEvent e) {


    }

}
