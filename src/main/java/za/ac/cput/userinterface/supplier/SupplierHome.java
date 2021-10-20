package za.ac.cput.userinterface.supplier;

import za.ac.cput.dao.product.SupplierDAO;
import za.ac.cput.models.entity.product.Supplier;
import za.ac.cput.userinterface.home.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class SupplierHome extends JFrame implements ActionListener {

    private final JPanel mainPanelNorth, mainPanelCenter, mainPanelSouth;
    private final JPanel bottomPanelNorth, bottomPanelSouth, bottomPanelCenter;
    private final JLabel mainLabel,tableTitleLabel,idLabel, errorID;
    private final JButton btnAddSupplier, btnFindSupplier, btnGetAllSuppliers, btnBack, btnUpdate, btnDelete, btnExit;
    private final JTextField idTextField;
    private final JTable getAllTable;

    public SupplierHome() {
         //Frame
        this.setTitle("Suppiers");

        //Main
         mainPanelNorth = new JPanel();
         mainPanelCenter = new JPanel();
         mainPanelSouth = new JPanel();

         //Sup
        bottomPanelNorth = new JPanel();
        bottomPanelCenter = new JPanel();
        bottomPanelSouth = new JPanel();

        //Labels
        mainLabel = new JLabel("Suppliers");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 100));
        tableTitleLabel = new JLabel(" All Suppliers", SwingConstants.CENTER);
        tableTitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        idLabel = new JLabel(" Enter Supplier ID :  ", SwingConstants.RIGHT);
        errorID = new JLabel(" ", SwingConstants.LEFT);
        errorID.setForeground(Color.red);
        errorID.setFont(new Font("Arial", Font.BOLD, 15));

        //Button
        btnAddSupplier = new JButton("Add Supplier");
        btnAddSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindSupplier = new JButton("Find Supplier");
        btnFindSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnGetAllSuppliers = new JButton("Get All Suppliers");
        btnGetAllSuppliers.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");


        btnAddSupplier.addActionListener(this);
        btnFindSupplier.addActionListener(this);
        btnGetAllSuppliers.addActionListener(this);
        btnBack.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        // Table:
        String[] tableColumnTitle = {"Supplier ID", " Supplier Name", "Email", "Contact Number"};

        // Add Suppliers to table
        SupplierDAO supplierDAO = new SupplierDAO();
        Set<Supplier> suppliers = supplierDAO.getAllSuppliers();
        String[][] data = new String[suppliers.size()][4];
        int i = 0;
        for (Supplier s : suppliers) {
            data[i][0] = s.getSupplierID();
            data[i][1] = s.getSupplierName();
            data[i][2] = s.getSupplierEmail();
            data[i][3] = s.getSupplierContact();
            i++;
        }

        getAllTable = new JTable(data, tableColumnTitle);
        JScrollPane table = new JScrollPane(getAllTable);


        //TextField
        idTextField = new JTextField();

        // Panel North:

        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(mainLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(4,1));
        mainPanelCenter.add(btnAddSupplier);
        mainPanelCenter.add(btnFindSupplier);
        mainPanelCenter.add(btnGetAllSuppliers);
        mainPanelCenter.add(btnBack);


        mainPanelSouth.setLayout(new BorderLayout());
        mainPanelSouth.setPreferredSize(new Dimension(600,400));
        bottomPanelNorth.setLayout(new GridLayout(2,3));
        bottomPanelCenter.setLayout(new GridLayout(1,1));
        bottomPanelSouth.setLayout(new GridLayout(2,3));

        bottomPanelNorth.add(tableTitleLabel);

        bottomPanelCenter.add(table);

        bottomPanelSouth.add(idLabel);
        bottomPanelSouth.add(idTextField);
        bottomPanelSouth.add(errorID);


        bottomPanelSouth.add(btnUpdate);
        bottomPanelSouth.add(btnDelete);
        bottomPanelSouth.add(btnExit);

        mainPanelSouth.add(bottomPanelNorth, BorderLayout.NORTH);
        mainPanelSouth.add(bottomPanelCenter, BorderLayout.CENTER);
        mainPanelSouth.add(bottomPanelSouth, BorderLayout.SOUTH);

        this.add(mainPanelNorth, BorderLayout.NORTH);
        this.add(mainPanelCenter, BorderLayout.CENTER);
        this.add(mainPanelSouth, BorderLayout.SOUTH);


    }

    public void suppliersUI() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 650);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Add Supplier")) {
            AddSupplierGUI addSupplierGUI = new AddSupplierGUI();
            addSupplierGUI.addSuppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Find Supplier")) {
            FindSupplierGUI findSupplierGUI = new FindSupplierGUI();
            findSupplierGUI.findSuppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Get All Suppliers")) {
            SupplierHome supplierHomeUI = new SupplierHome();
            supplierHomeUI.suppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Exit")) {
            this.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            new HomeUI().setUI();
            this.dispose();
        }
        if (e.getActionCommand().equals("Update")) {
            if (idTextField.getText().equals("") || idTextField.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = idTextField.getText();
                SupplierDAO supplierDAO = new SupplierDAO();
                System.out.println("Update");
                UpdateSupplierGUI updateSupplierGUI = new UpdateSupplierGUI();
               Supplier supplier =supplierDAO.getSupplierByID(textIDInput);
                JFrame updateFrame = updateSupplierGUI.USupplierGUI(supplier);
                updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateFrame.setSize(780, 350);
                updateFrame.setLocationRelativeTo(null);
                updateFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Delete")) {
            if (idTextField.getText().equals("") || idTextField.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = idTextField.getText();
                SupplierDAO supplierDAO = new SupplierDAO();
                Supplier supplier = supplierDAO.getSupplierByID(textIDInput);
                DeleteSupplierGUI deleteSupplierGUI = new DeleteSupplierGUI();
                JFrame dFrame = deleteSupplierGUI.delSupplierFrame(supplier);
                dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dFrame.setSize(780, 350);
                dFrame.setLocationRelativeTo(null);
                dFrame.setVisible(true);
            }
        }
    }
}

