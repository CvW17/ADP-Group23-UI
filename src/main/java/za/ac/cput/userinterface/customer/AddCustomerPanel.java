package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;
import za.ac.cput.models.factory.user.CustomerFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO : Refactor Name to ..GUI

public class AddCustomerPanel implements ActionListener {

    private JFrame frame;

    private JPanel panelNorth, panelCenter, panelSouth, panelEast, panelWest;
    private JPanel bottomPanelNorth, bottomPanelSouth, bottomPanelEast, bottomPanelWest, bottomPanelCenter;
    private JLabel headerLabel;
    private JButton btnAddCustomer, btnFindCustomer, btnGetAllCustomers, btnBack;
    private JButton btnUpdate, btnDelete, btnExit;
    private JLabel centerFiller1, centerFiller2, centerFiller3, centerFiller4, centerFiller5, centerFiller6;
    private JLabel westFiller1;
    private JLabel eastFiller1;
    private JLabel southFiller1, southFiller2, southFiller3;


    private JPanel addCustomerPanel;


    private JLabel jlabelTitle, labelFirstName, labelLastName, labelContactNumber, labelEmail;
    private JLabel errorFirstName, errorLastName, errorContactNumber, errorEmail;
    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15;
    private JLabel filler20, filler21, filler22, filler23, filler24, filler25, filler26, filler27;
    private JLabel filler28, filler29, filler30, filler31, filler32;


    private JButton btnSave, btnClear;

    private JTextField textFirstName, textLastName, textContactNumber, textEmail;

    public AddCustomerPanel() {
        frame = new JFrame("Customers");
        JPanel mainPanelNorth = new JPanel();
        JPanel mainPanelCenter = new JPanel();
        JPanel mainPanelEast = new JPanel();
        JPanel mainPanelWest = new JPanel();
        JPanel mainPanelSouth = new JPanel();

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
        southFiller2 = new JLabel(" ");
        southFiller3 = new JLabel(" ");

        // Buttons
        btnAddCustomer = new JButton("Add Customer");
        btnFindCustomer = new JButton("Find Customer");
        btnGetAllCustomers = new JButton("Get All Customers");
        btnBack = new JButton("Back");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        btnAddCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnGetAllCustomers.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        // Panel North:
        headerLabel = new JLabel("Header");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 100));
        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(headerLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(9,1));
        mainPanelCenter.add(centerFiller1);
        mainPanelCenter.add(btnAddCustomer);
        mainPanelCenter.add(centerFiller2);
        mainPanelCenter.add(btnFindCustomer);
        mainPanelCenter.add(centerFiller3);
        mainPanelCenter.add(btnGetAllCustomers);
        mainPanelCenter.add(centerFiller4);
        mainPanelCenter.add(btnBack);
        mainPanelCenter.add(centerFiller5);

        // Panel West
        mainPanelWest.setLayout(new GridLayout(1,1));
        mainPanelWest.add(westFiller1);

        // Panel East
        mainPanelEast.setLayout(new GridLayout(1,1));
        mainPanelEast.add(eastFiller1);

        // Panel South
        mainPanelSouth = AddCustomerJP();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));

        frame.add(mainPanelNorth, BorderLayout.NORTH);
        frame.add(mainPanelCenter, BorderLayout.CENTER);
        frame.add(mainPanelSouth, BorderLayout.SOUTH);
        frame.add(mainPanelEast, BorderLayout.EAST);
        frame.add(mainPanelWest, BorderLayout.WEST);
    }

    public void addCustomersUI() {
        // Set UI:
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,800);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel AddCustomerJP() {
        // Panels
        addCustomerPanel = new JPanel();
        addCustomerPanel.setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();

        // Labels
        jlabelTitle = new JLabel(" Add Customer", SwingConstants.CENTER);
        labelFirstName = new JLabel("First Name : ", SwingConstants.RIGHT);
        labelLastName = new JLabel("Last Name : ", SwingConstants.RIGHT);
        labelContactNumber = new JLabel("Contact Number : ", SwingConstants.RIGHT);
        labelEmail = new JLabel(" Email : ", SwingConstants.RIGHT);

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


        // Label Styles
        jlabelTitle.setFont(new Font("Arial", Font.BOLD, 30));
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

        // Filler Styles
        filler3.setFont(new Font("Arial", Font.BOLD, 15));
        filler4.setFont(new Font("Arial", Font.BOLD, 15));
        filler5.setFont(new Font("Arial", Font.BOLD, 15));
        filler6.setFont(new Font("Arial", Font.BOLD, 15));
        filler7.setFont(new Font("Arial", Font.BOLD, 15));
        filler8.setFont(new Font("Arial", Font.BOLD, 15));

        // Buttons
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        // Button Styles
        btnSave.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        // Button Functionality
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        btnAddCustomer.addActionListener(this);
        btnFindCustomer.addActionListener(this);
        btnGetAllCustomers.addActionListener(this);
        btnBack.addActionListener(this);

        // TextFields
        textFirstName = new JTextField();
        textLastName = new JTextField();
        textContactNumber = new JTextField();
        textEmail = new JTextField();

        // Panel Styles
        panelNorth.setLayout(new GridLayout(2, 3));
        panelWest.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(8, 3));
        panelEast.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(2, 5));

        // Add to North
        panelNorth.add(filler1);
        panelNorth.add(jlabelTitle);
        panelNorth.add(filler2);
        panelNorth.add(filler3);
        panelNorth.add(filler4);
        panelNorth.add(filler5);

        // Add to West
        panelWest.add(filler6);


        // Add to Center
        panelCenter.add(labelFirstName);
        panelCenter.add(textFirstName);
        panelCenter.add(errorFirstName);
        panelCenter.add(filler20);
        panelCenter.add(filler21);
        panelCenter.add(filler22);
        panelCenter.add(labelLastName);
        panelCenter.add(textLastName);
        panelCenter.add(errorLastName);
        panelCenter.add(filler23);
        panelCenter.add(filler24);
        panelCenter.add(filler25);
        panelCenter.add(labelContactNumber);
        panelCenter.add(textContactNumber);
        panelCenter.add(errorContactNumber);
        panelCenter.add(filler26);
        panelCenter.add(filler27);
        panelCenter.add(filler28);
        panelCenter.add(labelEmail);
        panelCenter.add(textEmail);
        panelCenter.add(errorEmail);
        panelCenter.add(filler29);
        panelCenter.add(filler30);
        panelCenter.add(filler31);


        // Add to East
        panelEast.add(filler7);


        // Add to South
        panelSouth.add(filler9);
        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);
        panelSouth.add(filler10);

        panelSouth.add(filler11);
        panelSouth.add(filler12);
        panelSouth.add(filler13);
        panelSouth.add(filler14);
        panelSouth.add(filler15);

        // Panels Added to Main Panel
        addCustomerPanel.add(panelNorth, BorderLayout.NORTH);
        addCustomerPanel.add(panelWest, BorderLayout.WEST);
        addCustomerPanel.add(panelCenter, BorderLayout.CENTER);
        addCustomerPanel.add(panelEast, BorderLayout.EAST);
        addCustomerPanel.add(panelSouth, BorderLayout.SOUTH);

        return addCustomerPanel;
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Customer")) {
            AddCustomerPanel acp = new AddCustomerPanel();
            acp.addCustomersUI();
            frame.dispose();
        }

        if (e.getActionCommand().equals("Find Customer")) {
            FindCustomerByPanel fcbp = new FindCustomerByPanel();
            fcbp.findCustomersUI();
            frame.dispose();
        }

        if (e.getActionCommand().equals("Get All Customers")) {
            CustomerHomeUI chui = new CustomerHomeUI();
            chui.customersUI();
            frame.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            frame.dispose();
        }

        if (e.getActionCommand().equals("Save")) {
            String customerFirstName = textFirstName.getText();
            String customerLastName = textLastName.getText();
            String customerContact = textContactNumber.getText();
            String customerEmail = textEmail.getText();

            boolean checkFirstName = false;
            boolean checkLastName = false;
            boolean checkContactNumber = false;
            boolean checkEmail = false;

            if (customerFirstName.equals("") || !customerFirstName.matches("[a-zA-Z]+")) {
                errorFirstName.setText(" * Invalid First Name ");
            } else {
                checkFirstName = true;
                errorFirstName.setText("");
            }

            if (customerLastName.equals("") || !customerLastName.matches("[a-zA-Z]+")) {
                errorLastName.setText(" * Invalid Last Name ");
            } else {
                checkLastName = true;
                errorLastName.setText(" ");
            }

            if (!GenericHelper.validContactNumber(customerContact)) {
                errorContactNumber.setText(" * Invalid Contact Number ");
            } else {
                checkContactNumber = true;
                errorContactNumber.setText(" ");
            }

            if (!GenericHelper.validEmail(customerEmail)) {
                errorEmail.setText(" * Invalid Email ");
            } else {
                checkEmail = true;
                errorEmail.setText(" ");
            }

            if (checkFirstName && checkLastName && checkContactNumber && checkEmail) {
                System.out.println("All Valid!");
                CustomerDAO customerDAO = new CustomerDAO();

                // Create Customer
                Customer c = CustomerFactory.build(customerFirstName, customerLastName, customerContact, customerEmail);

                // Call method to add to DB
                String answer = customerDAO.addCustomerToDB(c);

                // Display Result
                if (answer.equals("Customer Added!")) {
                    JOptionPane.showMessageDialog(null, answer, "Add Customer", JOptionPane.INFORMATION_MESSAGE);
                    textFirstName.setText("");
                    textLastName.setText("");
                    textContactNumber.setText("");
                    textEmail.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, answer, "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
        if (e.getActionCommand().equals("Clear")) {
            textFirstName.setText("");
            textLastName.setText("");
            textContactNumber.setText("");
            textEmail.setText("");
            System.out.println("Clear");
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
            frame.dispose();
        }
    }

}
