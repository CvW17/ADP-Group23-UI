package za.ac.cput.userinterface.supplier;


import za.ac.cput.dao.product.SupplierDAO;
import za.ac.cput.models.entity.product.Supplier;
import za.ac.cput.models.factory.product.SupplierFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSupplierGUI extends JFrame implements ActionListener {

    private  JPanel mainPanelNorth, mainPanelCenter, mainPanelSouth;
    private  JPanel bottomPanelNorth;
    private  JPanel bottomPanelSouth;
    private  JPanel bottomPanelCenter;
    private  JLabel mainLabel,lblName,lblEmail,lblContact, lblInvName, lblInvEmail, lblInvCN, titleLabel;
    private  JButton btnAddSupplier, btnFindSupplier, btnGetAllSuppliers, btnBack, btnSave, btnClear, btnExit;
    private  JTextField idTextField, txtName,txtEmail, txtCN;
    private JPanel addSupplierPanel;


    public AddSupplierGUI() {

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
        addSupplierPanel = new JPanel();

        //Labels
        mainLabel = new JLabel("Suppliers");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 100));


        //Button
        btnAddSupplier = new JButton("Add Supplier");
        btnAddSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindSupplier = new JButton("Find Supplier");
        btnFindSupplier.setFont(new Font("Arial", Font.PLAIN, 20));
        btnGetAllSuppliers = new JButton("Get All Suppliers");
        btnGetAllSuppliers.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));


        btnAddSupplier.addActionListener(this);
        btnFindSupplier.addActionListener(this);
        btnGetAllSuppliers.addActionListener(this);
        btnBack.addActionListener(this);

        btnAddSupplier.addActionListener(this);
        btnFindSupplier.addActionListener(this);
        btnGetAllSuppliers.addActionListener(this);
        btnBack.addActionListener(this);

        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(mainLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(4,1));
        mainPanelCenter.add(btnAddSupplier);
        mainPanelCenter.add(btnFindSupplier);
        mainPanelCenter.add(btnGetAllSuppliers);
        mainPanelCenter.add(btnBack);




        mainPanelSouth = AddSupplierJPanel();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));


        this.add(mainPanelNorth, BorderLayout.NORTH);
        this.add(mainPanelCenter, BorderLayout.CENTER);
        this.add(mainPanelSouth, BorderLayout.SOUTH);
    }

    public void addSuppliersUI() {
        // Set UI:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 650);
        //frame.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel AddSupplierJPanel(){

        addSupplierPanel = new JPanel();
        addSupplierPanel.setLayout(new BorderLayout());
       JPanel panelNorth = new JPanel();
       JPanel panelCenter = new JPanel();
       JPanel panelSouth = new JPanel();

        titleLabel = new JLabel(" Add Supplier", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        lblName = new JLabel("Supplier Name : ", SwingConstants.LEFT);
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmail = new JLabel("Email : ", SwingConstants.LEFT);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        lblContact = new JLabel("Contact Number : ", SwingConstants.LEFT);
        lblContact.setFont(new Font("Arial", Font.BOLD, 15));

        lblInvName = new JLabel(" ");
        lblInvEmail = new JLabel(" ");
        lblInvCN = new JLabel(" ");

        lblInvName.setFont(new Font("Arial", Font.BOLD, 15));
        lblInvEmail.setFont(new Font("Arial", Font.BOLD, 15));
        lblInvCN.setFont(new Font("Arial", Font.BOLD, 15));

        lblInvName.setForeground(Color.RED);
        lblInvEmail.setForeground(Color.RED);
        lblInvCN.setForeground(Color.RED);

        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");


        btnSave.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));


        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);



        txtName = new JTextField();
        txtEmail = new JTextField();
        txtCN = new JTextField();


        panelCenter.setLayout(new GridLayout(9, 3));
        panelSouth.setLayout(new GridLayout(1, 3));

        //North
        panelNorth.add(titleLabel);


        panelCenter.add(lblName);
        panelCenter.add(txtName);
        panelCenter.add(lblInvName);

        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);
        panelCenter.add(lblInvEmail);

        panelCenter.add(lblContact);
        panelCenter.add(txtCN);
        panelCenter.add(lblInvCN);

        // South
        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        // Panels Added to Main Panel
        addSupplierPanel.add(panelNorth, BorderLayout.NORTH);
        addSupplierPanel.add(panelCenter, BorderLayout.CENTER);
        addSupplierPanel.add(panelSouth, BorderLayout.SOUTH);
        return addSupplierPanel;
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
//            findSupplierGUI.findSuppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Get All Suppliers")) {
            SupplierHome supplierHomeUI = new SupplierHome();
            supplierHomeUI.suppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            SupplierHome ui = new SupplierHome();
            ui.suppliersUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Save")) {
            String supplierName = txtName.getText();
            String supplierEmail = txtEmail.getText();
            String supplierContact = txtCN.getText();

            boolean checkName = false;
            boolean checkEmail = false;
            boolean checkContact = false;


            if (!GenericHelper.nameValidation(supplierName)) {
                lblInvName.setText(" * Invalid Supplier Name ");
            } else {
                checkName = true;
                lblInvName.setText("");
            }

            if (!GenericHelper.emailValidation(supplierEmail)) {
                lblInvEmail.setText(" * Invalid Email ");
            } else {
                checkEmail = true;
                lblInvEmail.setText(" ");
            }

            if (!GenericHelper.contactValidation(supplierContact)) {
                lblInvCN.setText(" * Invalid Contact Number ");
            } else {
                checkContact = true;
                lblInvCN.setText(" ");
            }



            if (checkName && checkEmail && checkContact) {
                System.out.println("All Valid!");
                SupplierDAO supplierDAO = new SupplierDAO();

                // Create Supplier
                Supplier s = SupplierFactory.build(supplierName, supplierEmail , supplierContact );

                // Call method to add to DB
                String answer = supplierDAO.addSupplierToDB(s);

                // Display Result
                if (answer.equals("Supplier Added!")) {
                    JOptionPane.showMessageDialog(null, answer, "Add Supplier", JOptionPane.INFORMATION_MESSAGE);
                    txtName.setText("");
                    txtEmail.setText("");
                    txtCN.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, answer, "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
        if (e.getActionCommand().equals("Clear")) {
            txtName.setText("");
            txtEmail.setText("");
            txtCN.setText("");
            System.out.println("Clear");
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
            this.dispose();
        }
    }
}
