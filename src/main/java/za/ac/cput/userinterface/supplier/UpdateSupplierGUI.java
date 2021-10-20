package za.ac.cput.userinterface.supplier;

import za.ac.cput.dao.product.SupplierDAO;
import za.ac.cput.models.entity.product.Supplier;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateSupplierGUI extends JFrame implements ActionListener {

    private JPanel mainPanelNorth, mainPanelEast, mainPanelCenter,mainPanelWest, mainPanelSouth;
    private  JLabel mainLabel, lblName,lblEmail,lblContact,lblInvName, lblInvEmail, lblInvCN;
    private  JButton btnUpdate,btnReset, btnExit;
    private  JTextField txtName,txtEmail, txtCN;

    private JLabel lblID, lblSupplierID;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16, filler17,filler18, filler19;
    private JLabel filler20, filler21;


    String tempName, tempContact, tempEmail;

    Supplier supplier;

    public JFrame USupplierGUI(Supplier s) {
        supplier = s;

        //Main
        mainPanelNorth = new JPanel();
        mainPanelCenter = new JPanel();
        mainPanelSouth = new JPanel();
        mainPanelEast = new JPanel();
        mainPanelWest = new JPanel();

        tempName = s.getSupplierName();
        tempContact = s.getSupplierContact();
        tempEmail = s.getSupplierEmail();

        mainLabel = new JLabel("Update Supplier?", SwingConstants.CENTER);
        lblName = new JLabel("Supplier Name : ", SwingConstants.RIGHT);
        lblEmail = new JLabel("Email : ", SwingConstants.RIGHT);
        lblContact = new JLabel("Contact Number : ", SwingConstants.RIGHT);
        lblID = new JLabel("Supplier ID : ", SwingConstants.RIGHT);
        lblSupplierID = new JLabel(s.getSupplierID());

        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
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
        filler17 = new JLabel(" ");
        filler18 = new JLabel(" ");
        filler19 = new JLabel(" ");

        filler20 = new JLabel(" ");
        filler21 = new JLabel(" ");



        btnUpdate = new JButton("Update");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        // Button Styles
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnReset.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnUpdate.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);

        // TextFields
        txtName = new JTextField(s.getSupplierName());
        txtCN = new JTextField(s.getSupplierContact());
        txtEmail = new JTextField(s.getSupplierEmail());

        // Panel Styles
        mainPanelNorth.setLayout(new GridLayout(3, 3));
        mainPanelWest.setLayout(new GridLayout(1, 1));
        mainPanelCenter.setLayout(new GridLayout(6, 3));
        mainPanelEast.setLayout(new GridLayout(1, 1));
        mainPanelSouth.setLayout(new GridLayout(2, 6));

        // Add to North
        mainPanelNorth.add(filler1);
        mainPanelNorth.add(filler2);
        mainPanelNorth.add(filler3);

        mainPanelNorth.add(filler4);
        mainPanelNorth.add(mainLabel);
        mainPanelNorth.add(filler5);

        mainPanelNorth.add(filler6);
        mainPanelNorth.add(filler7);
        mainPanelNorth.add(filler8);

        // Add to West
        mainPanelWest.add(filler9);

        // Add to Center
        mainPanelCenter.add(lblID);
        mainPanelCenter.add(lblSupplierID);
        mainPanelCenter.add(filler10);

        mainPanelCenter.add(lblName);
        mainPanelCenter.add(txtName);
        mainPanelCenter.add(lblInvName);

        mainPanelCenter.add(lblEmail);
        mainPanelCenter.add(txtEmail);
        mainPanelCenter.add(lblInvEmail);

        mainPanelCenter.add(lblContact);
        mainPanelCenter.add(txtCN);
        mainPanelCenter.add(lblInvCN);

        mainPanelCenter.add(filler11);
        mainPanelCenter.add(filler12);
        mainPanelCenter.add(filler13);

        // Add to East
        mainPanelEast.add(filler14);

        // Add to South
        mainPanelSouth.add(filler15);
        mainPanelSouth.add(btnUpdate);
        mainPanelSouth.add(btnReset);
        mainPanelSouth.add(btnExit);
        mainPanelSouth.add(filler16);

        mainPanelSouth.add(filler17);
        mainPanelSouth.add(filler18);
        mainPanelSouth.add(filler19);
        mainPanelSouth.add(filler20);
        mainPanelSouth.add(filler21);

        this.add(mainPanelNorth, BorderLayout.NORTH);
        this.add(mainPanelWest, BorderLayout.WEST);
        this.add(mainPanelCenter, BorderLayout.CENTER);
        this.add(mainPanelEast, BorderLayout.EAST);
        this.add(mainPanelSouth, BorderLayout.SOUTH);



        return this;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Update")) {
            System.out.println("Update");


            boolean checkName = false;
            boolean checkEmail = false;
            boolean checkContact = false;


            if (!GenericHelper.nameValidation(txtName.getText())) {
                lblInvName.setText(" * Invalid Supplier Name ");
            } else {
                checkName = true;
                lblInvName.setText("");
            }

            if (!GenericHelper.emailValidation(txtEmail.getText())) {
                lblInvEmail.setText(" * Invalid Email ");
            } else {
                checkEmail = true;
                lblInvEmail.setText(" ");
            }

            if (!GenericHelper.contactValidation(txtCN.getText())) {
                lblInvCN.setText(" * Invalid Contact Number ");
            } else {
                checkContact = true;
                lblInvCN.setText(" ");
            }

            if (checkName && checkEmail && checkContact) {
                System.out.println("All Valid!");
                SupplierDAO supplierDAO = new SupplierDAO();

                System.out.println(txtName.getText());
                System.out.println(txtEmail.getText());
                System.out.println(txtCN.getText());

                tempName = txtName.getText();
                tempEmail = txtEmail.getText();
                tempContact = txtCN.getText();


                supplier = new Supplier.Builder().copy(supplier)
                        .setSupplierName(txtName.getText())
                        .setSupplierEmail(txtEmail.getText())
                        .setSupplierContact(txtCN.getText())
                        .build();

                System.out.println(supplier);
                supplierDAO.updateSupplier(supplier);

                JOptionPane.showMessageDialog(null,"Supplier updated!");
                this.dispose();



            }
        }
        if (e.getActionCommand().equals("Reset")) {
            txtName.setText(tempName);
            txtCN.setText(tempContact);
            txtEmail.setText(tempEmail);
        }

        if (e.getActionCommand().equals("Exit")) {
            this.dispose();
        }
    }
 }

