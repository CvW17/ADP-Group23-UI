package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

// TODO : Refactor Name to ..GUI

public class CustomerHomeUI implements ActionListener {

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

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15;
    private JLabel filler20, filler21, filler22, filler23, filler24, filler25, filler26, filler27;
    private JLabel filler28, filler29, filler30, filler31, filler32;

    private JLabel jlabelTitle, CustomerIDLabel;

    private JLabel errorID;

    private JTextField textCustomerID;

    private JTable getAllTable;

    public CustomerHomeUI() {
        frame = new JFrame("Customers");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        bottomPanelNorth = new JPanel();
        bottomPanelSouth = new JPanel();
        bottomPanelEast = new JPanel();
        bottomPanelWest = new JPanel();
        bottomPanelCenter = new JPanel();

        // Labels
        jlabelTitle = new JLabel(" All Customers ", SwingConstants.CENTER);
        jlabelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        CustomerIDLabel = new JLabel(" Enter Customer ID :  ", SwingConstants.RIGHT);
        errorID = new JLabel(" ", SwingConstants.LEFT);
        errorID.setForeground(Color.red);
        errorID.setFont(new Font("Arial", Font.BOLD, 15));

        // Textfield
        textCustomerID = new JTextField("");


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

        // Fillers
        filler1 = new JLabel(" ");
        filler2 = new JLabel(" ");
        filler3 = new JLabel("                        ");
        filler4 = new JLabel("                        ");
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

        btnAddCustomer.addActionListener(this);
        btnFindCustomer.addActionListener(this);
        btnGetAllCustomers.addActionListener(this);
        btnBack.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        // Table:
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
        JScrollPane table = new JScrollPane(getAllTable);

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
        panelCenter.add(btnGetAllCustomers);
        panelCenter.add(centerFiller4);
        panelCenter.add(btnBack);
        panelCenter.add(centerFiller5);

        // Panel South(Placeholder panel):
        panelSouth.setLayout(new BorderLayout());
        panelSouth.setPreferredSize(new Dimension(600,400));
        bottomPanelNorth.setLayout(new GridLayout(2,3));
        bottomPanelEast.setLayout(new GridLayout(1,1));
        bottomPanelWest.setLayout(new GridLayout(1,1));
        bottomPanelCenter.setLayout(new GridLayout(1,1));
        bottomPanelSouth.setLayout(new GridLayout(5,5));

            // Add to panelSouth
            bottomPanelNorth.add(filler1);
            bottomPanelNorth.add(jlabelTitle);
            bottomPanelNorth.add(filler2);
            bottomPanelNorth.add(filler30);
            bottomPanelNorth.add(filler31);
            bottomPanelNorth.add(filler32);

            bottomPanelWest.add(filler3);

            bottomPanelCenter.add(table);

            bottomPanelEast.add(filler4);

            bottomPanelSouth.add(filler5);
            bottomPanelSouth.add(filler6);
            bottomPanelSouth.add(errorID);
            bottomPanelSouth.add(filler8);
            bottomPanelSouth.add(filler9);

            bottomPanelSouth.add(filler10);
            bottomPanelSouth.add(CustomerIDLabel);
            bottomPanelSouth.add(textCustomerID);
            bottomPanelSouth.add(filler11);
            bottomPanelSouth.add(filler12);

            bottomPanelSouth.add(filler13);
            bottomPanelSouth.add(filler14);
            bottomPanelSouth.add(filler15);
            bottomPanelSouth.add(filler20);
            bottomPanelSouth.add(filler21);

            bottomPanelSouth.add(filler22);
            bottomPanelSouth.add(btnUpdate);
            bottomPanelSouth.add(btnDelete);
            bottomPanelSouth.add(btnExit);
            bottomPanelSouth.add(filler23);

            bottomPanelSouth.add(filler24);
            bottomPanelSouth.add(filler25);
            bottomPanelSouth.add(filler26);
            bottomPanelSouth.add(filler27);
            bottomPanelSouth.add(filler28);

        panelSouth.add(bottomPanelNorth, BorderLayout.NORTH);
        panelSouth.add(bottomPanelCenter, BorderLayout.CENTER);
        panelSouth.add(bottomPanelSouth, BorderLayout.SOUTH);
        panelSouth.add(bottomPanelEast, BorderLayout.EAST);
        panelSouth.add(bottomPanelWest, BorderLayout.WEST);


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

    @Override
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

        if (e.getActionCommand().equals("Exit")) {
            frame.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            frame.dispose();
        }
        if (e.getActionCommand().equals("Update")) {
            if (textCustomerID.getText().equals("") || textCustomerID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = textCustomerID.getText();
                CustomerDAO cDAO = new CustomerDAO();
                System.out.println("Update");
                UpdateCustomerGUI ucGUI = new UpdateCustomerGUI();
                Customer customer = cDAO.getCustomerByID(textIDInput);
                JFrame uFrame = ucGUI.UpdateCustomerGUI(customer);
                uFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                uFrame.setSize(780, 350);
                uFrame.setLocationRelativeTo(null);
                uFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Delete")) {
            if (textCustomerID.getText().equals("") || textCustomerID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = textCustomerID.getText();
                CustomerDAO cDAO = new CustomerDAO();
                Customer customer = cDAO.getCustomerByID(textIDInput);
                DeleteCustomerGUI dcGUI = new DeleteCustomerGUI();
                JFrame dFrame = dcGUI.deleteCustomerFrame(customer);
                dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dFrame.setSize(780, 350);
                dFrame.setLocationRelativeTo(null);
                dFrame.setVisible(true);
            }
        }
    }
}
