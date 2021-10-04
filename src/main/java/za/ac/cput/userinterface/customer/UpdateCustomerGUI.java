package za.ac.cput.userinterface.customer;

import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomerGUI implements ActionListener {

    public JFrame updateFrame;

    private JPanel updatePanelNorth, updatePanelCenter, updatePanelSouth, updatePanelEast, updatePanelWest;

    private JButton btnUpdateDB, btnReset, btnExit;

    private JLabel labelTitle, labelFirstName, labelLastName, labelContactNumber, labelEmail;

    private JLabel errorFirstName, errorLastName, errorContactNumber, errorEmail;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15;
    private JLabel filler20, filler21, filler22, filler23, filler24, filler25, filler26, filler27;
    private JLabel filler28, filler29, filler30, filler31, filler32;
    private JLabel filler33, filler34, filler35, filler36;
    private JLabel filler40, filler41, filler42;

    private JLabel labelID, labelCustomerID;

    private JTextField textFirstName, textLastName, textContactNumber, textEmail;

    public JFrame UpdateCustomerGUI(Customer c) {
        updateFrame = new JFrame("Update Customer");
        updateFrame.setLayout(new BorderLayout());
        updatePanelNorth = new JPanel();
        updatePanelSouth = new JPanel();
        updatePanelWest = new JPanel();
        updatePanelCenter = new JPanel();
        updatePanelEast = new JPanel();

        labelTitle = new JLabel("Update Customer", SwingConstants.CENTER);
        labelFirstName = new JLabel("First Name : ", SwingConstants.RIGHT);
        labelLastName = new JLabel("Last Name : ", SwingConstants.RIGHT);
        labelContactNumber = new JLabel("Contact Number : ", SwingConstants.RIGHT);
        labelEmail = new JLabel("Update Customer : ", SwingConstants.RIGHT);
        labelID = new JLabel("Customer ID : ", SwingConstants.RIGHT);
        labelCustomerID = new JLabel(c.getCustomerID());

        errorFirstName = new JLabel(" ");
        errorLastName = new JLabel(" ");
        errorContactNumber = new JLabel(" ");
        errorEmail = new JLabel(" ");

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
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelFirstName.setFont(new Font("Arial", Font.BOLD, 15));
        labelLastName.setFont(new Font("Arial", Font.BOLD, 15));
        labelContactNumber.setFont(new Font("Arial", Font.BOLD, 15));
        labelEmail.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Styles
        errorFirstName.setFont(new Font("Arial", Font.BOLD, 15));
        errorLastName.setFont(new Font("Arial", Font.BOLD, 15));
        errorContactNumber.setFont(new Font("Arial", Font.BOLD, 15));
        errorEmail.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Colour:
        errorFirstName.setForeground(Color.RED);
        errorLastName.setForeground(Color.RED);
        errorContactNumber.setForeground(Color.RED);
        errorEmail.setForeground(Color.RED);

        // Buttons
        btnUpdateDB = new JButton("UpdateDB");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        // Button Styles
        btnUpdateDB.setFont(new Font("Arial", Font.BOLD, 15));
        btnReset.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnUpdateDB.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);

        // TextFields
        textFirstName = new JTextField(c.getFirstName());
        textLastName = new JTextField(c.getLastName());
        textContactNumber = new JTextField(c.getContactNumber());
        textEmail = new JTextField(c.getEmail());

        // Panel Styles
        updatePanelNorth.setLayout(new GridLayout(3, 3));
        updatePanelWest.setLayout(new GridLayout(1, 1));
        updatePanelCenter.setLayout(new GridLayout(6, 3));
        updatePanelEast.setLayout(new GridLayout(1, 1));
        updatePanelSouth.setLayout(new GridLayout(2, 6));

        // Add to North
        updatePanelNorth.add(filler20);
        updatePanelNorth.add(filler21);
        updatePanelNorth.add(filler22);

        updatePanelNorth.add(filler23);
        updatePanelNorth.add(labelTitle);
        updatePanelNorth.add(filler24);

        updatePanelNorth.add(filler25);
        updatePanelNorth.add(filler26);
        updatePanelNorth.add(filler27);

        // Add to West
        updatePanelWest.add(filler24);

        // Add to Center
        updatePanelCenter.add(labelID);
        updatePanelCenter.add(labelCustomerID);
        updatePanelCenter.add(filler40);

        updatePanelCenter.add(labelFirstName);
        updatePanelCenter.add(textFirstName);
        updatePanelCenter.add(errorFirstName);

        updatePanelCenter.add(labelLastName);
        updatePanelCenter.add(textLastName);
        updatePanelCenter.add(errorLastName);

        updatePanelCenter.add(labelContactNumber);
        updatePanelCenter.add(textContactNumber);
        updatePanelCenter.add(errorContactNumber);

        updatePanelCenter.add(labelEmail);
        updatePanelCenter.add(textEmail);
        updatePanelCenter.add(errorEmail);

        updatePanelCenter.add(filler1);
        updatePanelCenter.add(filler2);
        updatePanelCenter.add(filler3);

        // Add to East
        updatePanelEast.add(filler4);

        // Add to South
        updatePanelSouth.add(filler5);
        updatePanelSouth.add(btnUpdateDB);
        updatePanelSouth.add(btnReset);
        updatePanelSouth.add(btnExit);
        updatePanelSouth.add(filler9);

        updatePanelSouth.add(filler10);
        updatePanelSouth.add(filler11);
        updatePanelSouth.add(filler12);
        updatePanelSouth.add(filler13);
        updatePanelSouth.add(filler14);

        updateFrame.add(updatePanelNorth, BorderLayout.NORTH);
        updateFrame.add(updatePanelWest, BorderLayout.WEST);
        updateFrame.add(updatePanelCenter, BorderLayout.CENTER);
        updateFrame.add(updatePanelEast, BorderLayout.EAST);
        updateFrame.add(updatePanelSouth, BorderLayout.SOUTH);




        return updateFrame;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
