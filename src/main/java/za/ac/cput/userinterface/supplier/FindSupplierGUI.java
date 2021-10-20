package za.ac.cput.userinterface.supplier;

import za.ac.cput.dao.product.SupplierDAO;
import za.ac.cput.models.entity.product.Supplier;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class FindSupplierGUI  implements ActionListener {

    private JFrame findFrame;
    private JLabel mainLabel;
    private JButton btnAddSupplier, btnFindSupplier, btnGetAllSuppliers, btnBack;
    private JButton btnSearch, btnUpdate, btnDelete, btnExit;


    private JTextField txtSearchField, txtSupplierID;

    private JLabel labelTitle, labelSearchOption, labelEnterKeyword, labelError;
    private JComboBox cmbSearchTerm;
    private JLabel lblSupplierID;
    private JLabel errorID;



    private JPanel resultPanel;

    public FindSupplierGUI() {
        findFrame = new JFrame("Suppliers");
        JPanel mainPanelNorth = new JPanel();
        JPanel mainPanelCenter = new JPanel();
        JPanel mainPanelSouth = new JPanel();

        // Labels
        lblSupplierID = new JLabel("Enter Supplier ID : ");



        // Buttons
        btnAddSupplier = new JButton("Add Supplier");
        btnFindSupplier = new JButton("Find Supplier");
        btnGetAllSuppliers = new JButton("Get All Suppliers");
        btnBack = new JButton("Back");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        btnAddSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnGetAllSuppliers.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        // Button Functionality
        btnAddSupplier.addActionListener(this);
        btnFindSupplier.addActionListener(this);
        btnGetAllSuppliers.addActionListener(this);
        btnBack.addActionListener(this);


        // Panel North:
        mainLabel = new JLabel("Find Supplier");
        mainLabel.setFont(new Font("Arial", Font.PLAIN, 100));
        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(mainLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(3,1));
        mainPanelCenter.add(btnAddSupplier);
        mainPanelCenter.add(btnFindSupplier);
        mainPanelCenter.add(btnGetAllSuppliers);
        mainPanelCenter.add(btnBack);


        // Panel South
        mainPanelSouth = searchByJP();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));

        findFrame.add(mainPanelNorth, BorderLayout.NORTH);
        findFrame.add(mainPanelCenter, BorderLayout.CENTER);
        findFrame.add(mainPanelSouth, BorderLayout.SOUTH);


    }

    public JPanel searchByJP() {
        JPanel searchByPanel = new JPanel();
        searchByPanel.setLayout(new BorderLayout());
        JPanel searchPanelNorth = new JPanel();
        JPanel searchPanelSouth = new JPanel();
        JPanel searchPanelCenter = new JPanel();

        labelTitle = new JLabel("Find Supplier", SwingConstants.CENTER);
        labelSearchOption = new JLabel("Search by : ");
        labelEnterKeyword = new JLabel("Enter Keyword : ");
        labelError = new JLabel(" ");

        labelSearchOption.setFont(new Font("Arial", Font.PLAIN, 10));
        labelEnterKeyword.setFont(new Font("Arial", Font.PLAIN, 10));
        labelError.setFont(new Font("Arial", Font.BOLD, 20));

        String choice[] = {"Supplier Name", "Email" ,"Contact Number"};
        cmbSearchTerm = new JComboBox(choice);

        // Textfield
        txtSearchField = new JTextField("");
        txtSupplierID = new JTextField("");

        // Label Styles
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        labelEnterKeyword.setFont(new Font("Arial", Font.BOLD, 15));
        labelSearchOption.setFont(new Font("Arial", Font.BOLD, 15));
        labelError.setFont(new Font("Arial", Font.BOLD, 15));
        errorID = new JLabel(" ", SwingConstants.LEFT);
        errorID.setForeground(Color.red);
        errorID.setFont(new Font("Arial", Font.BOLD, 15));

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
        searchPanelNorth.setLayout(new GridLayout(1, 1));
        searchPanelCenter.setLayout(new GridLayout(6, 3));
        searchPanelSouth.setLayout(new GridLayout(2, 3));


        searchPanelNorth.add(labelTitle);


        searchPanelCenter.add(labelSearchOption);
        searchPanelCenter.add(cmbSearchTerm);
        searchPanelCenter.add(labelEnterKeyword);
        searchPanelCenter.add(txtSearchField);
        searchPanelCenter.add(btnSearch);


        searchPanelCenter.add(labelError);


        searchPanelSouth.add(lblSupplierID);
        searchPanelSouth.add(txtSupplierID);
        searchPanelSouth.add(errorID);
        searchPanelSouth.add(btnUpdate);
        searchPanelSouth.add(btnDelete);
        searchPanelSouth.add(btnExit);


        searchByPanel.add(searchPanelNorth, BorderLayout.NORTH);
        searchByPanel.add(searchPanelCenter, BorderLayout.CENTER);
        searchByPanel.add(searchPanelSouth, BorderLayout.SOUTH);


        return searchByPanel;
    }




    public JFrame resultOfSearchPanel(Set<Supplier> suppliers) {
        JFrame popoutFrame = new JFrame("Suppliers");
        JPanel popoutPanel = new JPanel();


        String[] tableColumnTitle = {"Supplier ID","Supplier Name", "Email", "Contact Number"};
        String data[][] = new String[suppliers.size()][4];

        int i = 0;

        for (Supplier s : suppliers) {
            data[i][0] = s.getSupplierID();
            data[i][1] = s.getSupplierName();
            data[i][2] = s.getSupplierEmail();
            data[i][3] = s.getSupplierContact();

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

    public void findSuppliersUI() {

        findFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       findFrame.setSize(800,800);
       findFrame.setLocationRelativeTo(null);
       findFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        SupplierDAO sDAO = new SupplierDAO();
        String comboChoice = cmbSearchTerm.getSelectedItem().toString();
        String textInput = txtSearchField.getText();
        Set<Supplier> suppliers = new HashSet<>();
        String textIDInput = txtSupplierID.getText();

        if (e.getActionCommand().equals("Add Supplier")) {
            AddSupplierGUI sGUI = new AddSupplierGUI();
            sGUI.addSuppliersUI();
           findFrame.dispose();
        }

        if (e.getActionCommand().equals("Find Supplier")) {
            FindSupplierGUI fGUI = new FindSupplierGUI();
            fGUI.findSuppliersUI();
            findFrame.dispose();
        }

        if (e.getActionCommand().equals("Get All Suppliers")) {
            SupplierHome hGui = new SupplierHome();
            hGui.suppliersUI();
            findFrame.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            SupplierHome hGui = new SupplierHome();
            hGui.suppliersUI();
            findFrame.dispose();
        }

        // Search Functionality
        if (e.getActionCommand().equals("Search")) {
            if (textInput.equals("") || textInput.equals(" ")) {
                System.out.println("INVALID");
                labelError.setText("Error : Invalid Input");

            } else if (comboChoice.equals("Supplier Name")) {
                System.out.println("Search Choice : Supplier Name");
                suppliers= sDAO.searchName(textInput);
                resultOfSearchPanel(suppliers);
                labelError.setText(" ");


            } else if (comboChoice.equals("Contact Number")) {
                System.out.println("Search Choice : Contact Number");
                suppliers= sDAO.searchContact(textInput);
                resultOfSearchPanel(suppliers);
                labelError.setText(" ");

            } else if (comboChoice.equals("Email")) {
                System.out.println("Search Choice : Email");
                suppliers= sDAO.searchEmail(textInput);
                resultOfSearchPanel(suppliers);
                labelError.setText(" ");
                labelError.setText(" ");

            } else {
                System.out.println("Invalid Search?");
            }
        }

        // Customer ID Buttons
        if (e.getActionCommand().equals("Update")) {

            if (txtSupplierID.getText().equals("") || txtSupplierID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            }
            else {
                errorID.setText(" ");
                System.out.println("Update");
                UpdateSupplierGUI uGUI = new UpdateSupplierGUI();
                Supplier supplier = sDAO.getSupplierByID(textIDInput);
                JFrame uFrame = uGUI.USupplierGUI(supplier);
                uFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                uFrame.setSize(780, 350);
                uFrame.setLocationRelativeTo(null);
                uFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Delete")) {
            System.out.println("Delete");
            if (txtSupplierID.getText().equals("") || txtSupplierID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                errorID.setText(" ");
                textIDInput = txtSupplierID.getText();
                Supplier supplier = sDAO.getSupplierByID(textIDInput);
                DeleteSupplierGUI dGUI = new DeleteSupplierGUI();
                JFrame dFrame = dGUI.delSupplierFrame(supplier);
                dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dFrame.setSize(780, 350);
                dFrame.setLocationRelativeTo(null);
                dFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
           findFrame.dispose();
        }
    }
}
