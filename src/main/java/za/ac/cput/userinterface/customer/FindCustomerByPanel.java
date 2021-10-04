package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

// TODO : Refactor Name to ..GUI

public class FindCustomerByPanel implements ActionListener {

    private JPanel findCustomerByPanel;
    private JFrame frame;
    private JPanel panelNorth, panelCenter, panelSouth, panelEast, panelWest;
    private JLabel headerLabel;
    private JButton btnAddCustomer, btnFindCustomer, btnGetAllCustomers, btnBack;
    private JButton btnSearch, btnUpdate, btnDelete, btnExit;

    private JLabel centerFiller1, centerFiller2, centerFiller3, centerFiller4, centerFiller5, centerFiller6;
    private JLabel westFiller1;
    private JLabel eastFiller1;
    private JLabel southFiller1, southFiller2, southFiller3;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15;
    private JLabel filler20, filler21, filler22, filler23, filler24, filler25, filler26, filler27;
    private JLabel filler28, filler29, filler30, filler31, filler32;
    private JLabel filler33, filler34, filler35, filler36;
    private JLabel filler40, filler41, filler42;

    private JTextField textSearchField, textCustomerID;

    private JLabel labelTitle, labelSearchOption, labelEnterKeyword, labelError;

    private JLabel CustomerIDLabel;

    private JComboBox comboboxSearchTerm;

    private JPanel resultPanel;

    public FindCustomerByPanel() {
        frame = new JFrame("Customers");
        JPanel mainPanelNorth = new JPanel();
        JPanel mainPanelCenter = new JPanel();
        JPanel mainPanelEast = new JPanel();
        JPanel mainPanelWest = new JPanel();
        JPanel mainPanelSouth = new JPanel();

        // Labels
        CustomerIDLabel = new JLabel("Enter Customer ID : ");

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

        // Button Functionality
        btnAddCustomer.addActionListener(this);
        btnFindCustomer.addActionListener(this);
        btnGetAllCustomers.addActionListener(this);
        btnBack.addActionListener(this);


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
        mainPanelSouth = searchByJP();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));

        frame.add(mainPanelNorth, BorderLayout.NORTH);
        frame.add(mainPanelCenter, BorderLayout.CENTER);
        frame.add(mainPanelSouth, BorderLayout.SOUTH);
        frame.add(mainPanelEast, BorderLayout.EAST);
        frame.add(mainPanelWest, BorderLayout.WEST);

    }

    public JPanel searchByJP() {
        JPanel searchByPanel = new JPanel();
        searchByPanel.setLayout(new BorderLayout());
        JPanel searchPanelNorth = new JPanel();
        JPanel searchPanelSouth = new JPanel();
        JPanel searchPanelWest = new JPanel();
        JPanel searchPanelEast = new JPanel();
        JPanel searchPanelCenter = new JPanel();

        labelTitle = new JLabel("Find Customer", SwingConstants.CENTER);
        labelSearchOption = new JLabel("Search by : ");
        labelEnterKeyword = new JLabel("Enter Keyword : ");
        labelError = new JLabel(" ");

        labelSearchOption.setFont(new Font("Arial", Font.PLAIN, 10));
        labelEnterKeyword.setFont(new Font("Arial", Font.PLAIN, 10));
        labelError.setFont(new Font("Arial", Font.BOLD, 20));

        String choice[] = {"First Name", "Last Name", "Contact Number", "Email"};
        comboboxSearchTerm = new JComboBox(choice);

        // Fillers
        filler1 = new JLabel(" ");
        filler2 = new JLabel(" ");
        filler3 = new JLabel(" ");
        filler4 = new JLabel(" ");
        filler5 = new JLabel(" ");
        filler6 = new JLabel("                                        "); // panel west
        filler7 = new JLabel(" ");
        filler8 = new JLabel(" ");
        filler9 = new JLabel(" ");
        filler10 = new JLabel(" ");
        filler11 = new JLabel(" ");
        filler12 = new JLabel(" ");
        filler13 = new JLabel(" ");
        filler14 = new JLabel(" ");
        filler15 = new JLabel(" ");

        filler20 = new JLabel("                                        "); // panel east
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

        filler33 = new JLabel(" ");
        filler34 = new JLabel(" ");
        filler35 = new JLabel(" ");
        filler36 = new JLabel(" ");

        filler40 = new JLabel(" ");
        filler41 = new JLabel(" ");
        filler42 = new JLabel(" ");

        // Textfield
        textSearchField = new JTextField("");
        textCustomerID = new JTextField("");

        // Label Styles
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelEnterKeyword.setFont(new Font("Arial", Font.BOLD, 15));
        labelSearchOption.setFont(new Font("Arial", Font.BOLD, 15));
        labelError.setFont(new Font("Arial", Font.BOLD, 15));

        labelError.setForeground(Color.RED);

        // Buttons
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");
        btnSearch = new JButton("Search");

        // Button Styles
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));

        // Button Functionality
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnBack.addActionListener(this);
        btnExit.addActionListener(this);


        // Panel Styles
        searchPanelNorth.setLayout(new GridLayout(2, 3));
        searchPanelWest.setLayout(new GridLayout(1, 1));
        searchPanelCenter.setLayout(new GridLayout(6, 3));
        searchPanelEast.setLayout(new GridLayout(1, 1));
        searchPanelSouth.setLayout(new GridLayout(4, 5));

        // Add to North
        searchPanelNorth.add(filler1);
        searchPanelNorth.add(labelTitle);
        searchPanelNorth.add(filler2);

        searchPanelNorth.add(filler3);
        searchPanelNorth.add(filler4);
        searchPanelNorth.add(filler5);

        // Add to West
        searchPanelWest.add(filler6);

        // Add to Center
        searchPanelCenter.add(filler7);
        searchPanelCenter.add(filler8);
        searchPanelCenter.add(filler9);

        searchPanelCenter.add(labelSearchOption);
        searchPanelCenter.add(labelEnterKeyword);
        searchPanelCenter.add(filler10);

        searchPanelCenter.add(comboboxSearchTerm);
        searchPanelCenter.add(textSearchField);
        searchPanelCenter.add(btnSearch);

        searchPanelCenter.add(filler11);
        searchPanelCenter.add(labelError);
        searchPanelCenter.add(filler12);

        searchPanelCenter.add(filler13);
        searchPanelCenter.add(filler14);
        searchPanelCenter.add(filler15);

        searchPanelCenter.add(filler40);
        searchPanelCenter.add(filler41);
        searchPanelCenter.add(filler42);

        // Add to East
        searchPanelEast.add(filler20);

        // Add to South
        searchPanelSouth.add(filler21);
        searchPanelSouth.add(CustomerIDLabel);
        searchPanelSouth.add(textCustomerID);
        searchPanelSouth.add(filler23);
        searchPanelSouth.add(filler24);

        searchPanelSouth.add(filler25);
        searchPanelSouth.add(filler26);
        searchPanelSouth.add(filler27);
        searchPanelSouth.add(filler28);
        searchPanelSouth.add(filler29);

        searchPanelSouth.add(filler30);
        searchPanelSouth.add(btnUpdate);
        searchPanelSouth.add(btnDelete);
        searchPanelSouth.add(btnExit);
        searchPanelSouth.add(filler31);

        searchPanelSouth.add(filler32);
        searchPanelSouth.add(filler33);
        searchPanelSouth.add(filler34);
        searchPanelSouth.add(filler35);
        searchPanelSouth.add(filler36);

        searchByPanel.add(searchPanelNorth, BorderLayout.NORTH);
        searchByPanel.add(searchPanelCenter, BorderLayout.CENTER);
        searchByPanel.add(searchPanelSouth, BorderLayout.SOUTH);
        searchByPanel.add(searchPanelEast, BorderLayout.EAST);
        searchByPanel.add(searchPanelWest, BorderLayout.WEST);


        return searchByPanel;
    }




    public JFrame resultOfSearchPanel(Set<Customer> customers) {
        JFrame popoutFrame = new JFrame("Customers");
        JPanel popoutPanel = new JPanel();


        String[] tableColumnTitle = {"Customer ID","First Name", "Last Name", "Contact Number", "Email"};
        String data[][] = new String[customers.size()][5];

        int i = 0;

        for (Customer c : customers) {
            data[i][0] = c.getCustomerID();
            data[i][1] = c.getFirstName();
            data[i][2] = c.getLastName();
            data[i][3] = c.getContactNumber();
            data[i][4] = c.getEmail();
            i++;
            if(i >= 1000) {
                i = 0;
                break;
            }
        }
        // Table:
        JTable resultTable = new JTable(data, tableColumnTitle);
        JScrollPane sp = new JScrollPane(resultTable);

        // Panel:
        popoutPanel.add(sp, new GridLayout());

        // Frame:
        popoutFrame.add(popoutPanel);
        popoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popoutFrame.setSize(600,400);
        popoutFrame.setLocationRelativeTo(null);
        popoutFrame.setVisible(true);


        return popoutFrame;
    }

    public void findCustomersUI() {
        // Set UI:
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,800);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        CustomerDAO cDAO = new CustomerDAO();
        String comboChoice = comboboxSearchTerm.getSelectedItem().toString();
        String textInput = textSearchField.getText();
        Set<Customer> customers = new HashSet<>();
        String textIDInput = textCustomerID.getText();

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

        // Search Functionality
        if (e.getActionCommand().equals("Search")) {
            if (textInput.equals("") || textInput.equals(" ")) {
                System.out.println("INVALID");
                labelError.setText("Error : Invalid Input");

            } else if (comboChoice.equals("First Name")) {
                System.out.println("Search Choice : First Name");
                customers = cDAO.searchFirstName(textInput);
                resultOfSearchPanel(customers);
                labelError.setText(" ");

            } else if (comboChoice.equals("Last Name")) {
                System.out.println("Search Choice : Last Name");
                customers = cDAO.searchLastName(textInput);
                resultOfSearchPanel(customers);
                labelError.setText(" ");

            } else if (comboChoice.equals("Contact Number")) {
                System.out.println("Search Choice : Contact Number");
                customers = cDAO.searchContactNumber(textInput);
                resultOfSearchPanel(customers);
                labelError.setText(" ");

            } else if (comboChoice.equals("Email")) {
                System.out.println("Search Choice : Email");
                customers = cDAO.searchEmail(textInput);
                resultOfSearchPanel(customers);
                labelError.setText(" ");
                labelError.setText(" ");

            } else {
                System.out.println("Invalid Search?");
            }
        }

        // Customer ID Buttons
        if (e.getActionCommand().equals("Update")) {
            System.out.println("Update");
            UpdateCustomerGUI ucGUI = new UpdateCustomerGUI();


            Customer customer = cDAO.getCustomerByID(textIDInput);
            JFrame uFrame = ucGUI.UpdateCustomerGUI(customer);

            uFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            uFrame.setSize(780, 350);
            uFrame.setLocationRelativeTo(null);
            uFrame.setVisible(true);

        }
        if (e.getActionCommand().equals("Delete")) {
            System.out.println("Delete");
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
            frame.dispose();
        }

    }

}
