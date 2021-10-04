package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomerGUI implements ActionListener {

    Customer customer;
    private JFrame deleteFrame;
    private JPanel deletePanelNorth, deletePanelSouth, deletePanelWest, deletePanelCenter, deletePanelEast;

    private JButton btnRemove, btnExit;

    private JLabel labelTitle, labelID, labelFirstName, labelLastName, labelContactNumber, labelEmail;
    private JLabel textID, textFirstName, textLastName, textContactNumber, textEmail;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16;
    private JLabel filler20, filler21, filler22, filler23, filler24, filler25, filler26, filler27;
    private JLabel filler28, filler29, filler30, filler31, filler32;
    private JLabel filler33, filler34, filler35, filler36;
    private JLabel filler40, filler41, filler42;

    public JFrame deleteCustomerFrame(Customer c) {
        customer = c;
        deleteFrame = new JFrame("Update Customer");
        deletePanelNorth = new JPanel();
        deletePanelWest = new JPanel();
        deletePanelCenter = new JPanel();
        deletePanelEast = new JPanel();
        deletePanelSouth = new JPanel();

        labelTitle = new JLabel("Delete Customer?", SwingConstants.CENTER);
        labelFirstName = new JLabel("First Name : ", SwingConstants.RIGHT);
        labelLastName = new JLabel("Last Name : ", SwingConstants.RIGHT);
        labelContactNumber = new JLabel("Contact Number : ", SwingConstants.RIGHT);
        labelEmail = new JLabel("Update Customer : ", SwingConstants.RIGHT);
        labelID = new JLabel("Customer ID : ", SwingConstants.RIGHT);
        textID = new JLabel(c.getCustomerID());
        textFirstName = new JLabel(c.getFirstName());
        textLastName = new JLabel(c.getLastName());
        textContactNumber = new JLabel(c.getContactNumber());
        textEmail = new JLabel(c.getEmail());

        // Fillers
        filler1 = new JLabel(" ");
        filler2 = new JLabel(" ");
        filler3 = new JLabel(" ");
        filler4 = new JLabel(" ");
        filler5 = new JLabel(" ");
        filler6 = new JLabel(" ");
        filler7 = new JLabel(" ");
        filler8 = new JLabel(" ");
        filler9 = new JLabel(" ");
        filler10 = new JLabel(" ");
        filler11 = new JLabel(" ");
        filler12 = new JLabel(" ");
        filler13 = new JLabel(" ");
        filler14 = new JLabel(" ");
        filler15 = new JLabel(" ");
        filler16 = new JLabel(" ");

        filler20 = new JLabel(" ");
        filler21 = new JLabel(" ");
        filler22 = new JLabel(" ");
        filler23 = new JLabel(" ");
        filler24 = new JLabel(" ");
        filler25 = new JLabel(" ");
        filler26 = new JLabel(" ");
        filler27 = new JLabel(" ");
        filler28 = new JLabel(" ");
        filler29 = new JLabel(" ");
        filler30 = new JLabel(" ");
        filler31 = new JLabel(" ");
        filler32 = new JLabel(" ");

        filler40 = new JLabel(" ");

        // Label Styles
        labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
        labelFirstName.setFont(new Font("Arial", Font.BOLD, 15));
        labelLastName.setFont(new Font("Arial", Font.BOLD, 15));
        labelContactNumber.setFont(new Font("Arial", Font.BOLD, 15));
        labelEmail.setFont(new Font("Arial", Font.BOLD, 15));

        // Buttons
        btnRemove = new JButton("Remove");
        btnExit = new JButton("Exit");

        btnRemove.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnRemove.addActionListener(this);
        btnExit.addActionListener(this);

        deletePanelNorth.setLayout(new GridLayout(3, 3));
        deletePanelWest.setLayout(new GridLayout(1, 1));
        deletePanelCenter.setLayout(new GridLayout(6, 3));
        deletePanelEast.setLayout(new GridLayout(1, 1));
        deletePanelSouth.setLayout(new GridLayout(3, 4));


        // Add to North
        deletePanelNorth.add(filler1);
        deletePanelNorth.add(filler2);
        deletePanelNorth.add(filler3);

        deletePanelNorth.add(filler4);
        deletePanelNorth.add(labelTitle);
        deletePanelNorth.add(filler5);

        deletePanelNorth.add(filler6);
        deletePanelNorth.add(filler40);
        deletePanelNorth.add(filler7);

        // Add to West
        deletePanelWest.add(filler8);

        // Add to Center
        deletePanelCenter.add(labelID);
        deletePanelCenter.add(textID);
        deletePanelCenter.add(filler9);

        deletePanelCenter.add(labelFirstName);
        deletePanelCenter.add(textFirstName);
        deletePanelCenter.add(filler10);

        deletePanelCenter.add(labelLastName);
        deletePanelCenter.add(textLastName);
        deletePanelCenter.add(filler11);

        deletePanelCenter.add(labelContactNumber);
        deletePanelCenter.add(textContactNumber);
        deletePanelCenter.add(filler12);

        deletePanelCenter.add(labelEmail);
        deletePanelCenter.add(textEmail);
        deletePanelCenter.add(filler13);

        deletePanelCenter.add(filler14);
        deletePanelCenter.add(filler15);
        deletePanelCenter.add(filler16);

        // Add to East
        deletePanelEast.add(filler20);

        // Add to South
        deletePanelSouth.add(filler21);
        deletePanelSouth.add(filler22);
        deletePanelSouth.add(filler23);
        deletePanelSouth.add(filler24);

        deletePanelSouth.add(filler25);
        deletePanelSouth.add(btnRemove);
        deletePanelSouth.add(btnExit);
        deletePanelSouth.add(filler26);

        deletePanelSouth.add(filler27);
        deletePanelSouth.add(filler28);
        deletePanelSouth.add(filler29);
        deletePanelSouth.add(filler30);

        deleteFrame.add(deletePanelNorth, BorderLayout.NORTH);
        deleteFrame.add(deletePanelWest, BorderLayout.WEST);
        deleteFrame.add(deletePanelCenter, BorderLayout.CENTER);
        deleteFrame.add(deletePanelEast, BorderLayout.EAST);
        deleteFrame.add(deletePanelSouth, BorderLayout.SOUTH);

        return deleteFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove")) {
            CustomerDAO cDAO = new CustomerDAO();
            cDAO.deleteCustomer(customer);
        }
        if (e.getActionCommand().equals("Exit")) {
            deleteFrame.dispose();
        }

    }
}
