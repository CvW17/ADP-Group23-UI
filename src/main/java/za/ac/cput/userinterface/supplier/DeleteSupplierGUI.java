package za.ac.cput.userinterface.supplier;

import za.ac.cput.dao.product.SupplierDAO;
import za.ac.cput.models.entity.product.Supplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSupplierGUI implements ActionListener {

    Supplier supplier;

    private JFrame deleteFrame;
    private JPanel mainPanelNorth, mainPanelEast, mainPanelCenter,mainPanelWest, mainPanelSouth;
    private  JLabel mainLabel,lblID, lblName,lblEmail,lblContact;
    private  JButton btnRemove,btnExit;
    private  JLabel txtID,txtName,txtEmail, txtCN;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16;
    private JLabel filler20, filler21, filler22, filler23, filler24;
    private JLabel filler25, filler26, filler27, filler28, filler29;
    private JLabel filler30, filler34;


    public JFrame delSupplierFrame(Supplier s){

        supplier = s;

        deleteFrame = new JFrame("Update Supplier");

        //Main
        mainPanelNorth = new JPanel();
        mainPanelCenter = new JPanel();
        mainPanelSouth = new JPanel();
        mainPanelEast = new JPanel();
        mainPanelWest = new JPanel();

        mainLabel = new JLabel("Delete Supplier?", SwingConstants.CENTER);
        lblName = new JLabel("Supplier Name : ", SwingConstants.RIGHT);
        lblEmail = new JLabel("Email : ", SwingConstants.RIGHT);
        lblContact = new JLabel("Contact Number : ", SwingConstants.RIGHT);
        lblID = new JLabel("Supplier ID : ", SwingConstants.RIGHT);

        mainLabel.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        lblContact.setFont(new Font("Arial", Font.BOLD, 15));
        lblID.setFont(new Font("Arial", Font.BOLD, 15));

        txtID = new JLabel(s.getSupplierID());
        txtName = new JLabel(s.getSupplierName());
        txtEmail = new JLabel(s.getSupplierEmail());
        txtCN = new JLabel(s.getSupplierContact());

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
        filler34 = new JLabel(" ");

        btnRemove = new JButton("Remove");
        btnExit = new JButton("Exit");

        btnRemove.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnRemove.addActionListener(this);
        btnExit.addActionListener(this);

        mainPanelNorth.setLayout(new GridLayout(3, 3));
        mainPanelWest.setLayout(new GridLayout(1, 1));
        mainPanelCenter.setLayout(new GridLayout(6, 3));
        mainPanelEast.setLayout(new GridLayout(1, 1));
        mainPanelSouth.setLayout(new GridLayout(3, 4));


        // Add to North
        mainPanelNorth.add(filler1);
        mainPanelNorth.add(filler2);
        mainPanelNorth.add(filler3);

        mainPanelNorth.add(filler4);
        mainPanelNorth.add(mainLabel);
        mainPanelNorth.add(filler5);

        mainPanelNorth.add(filler6);
        mainPanelNorth.add(filler34);
        mainPanelNorth.add(filler7);

        // Add to West
        mainPanelWest.add(filler8);

        // Add to Center
        mainPanelCenter.add(lblID);
        mainPanelCenter.add(txtID);
        mainPanelCenter.add(filler9);

        mainPanelCenter.add(lblName);
        mainPanelCenter.add(txtName);
        mainPanelCenter.add(filler10);

        mainPanelCenter.add(lblEmail);
        mainPanelCenter.add(txtEmail);
        mainPanelCenter.add(filler13);

        mainPanelCenter.add(lblContact);
        mainPanelCenter.add(txtCN);
        mainPanelCenter.add(filler12);


        mainPanelCenter.add(filler14);
        mainPanelCenter.add(filler15);
        mainPanelCenter.add(filler16);

        // Add to East
        mainPanelEast.add(filler20);

        // Add to South
        mainPanelSouth.add(filler21);
        mainPanelSouth.add(filler22);
        mainPanelSouth.add(filler23);
        mainPanelSouth.add(filler24);

        mainPanelSouth.add(filler25);
        mainPanelSouth.add(btnRemove);
        mainPanelSouth.add(btnExit);
        mainPanelSouth.add(filler26);

        mainPanelSouth.add(filler27);
        mainPanelSouth.add(filler28);
        mainPanelSouth.add(filler29);
        mainPanelSouth.add(filler30);

        deleteFrame.add(mainPanelNorth, BorderLayout.NORTH);
        deleteFrame.add(mainPanelWest, BorderLayout.WEST);
        deleteFrame.add(mainPanelCenter, BorderLayout.CENTER);
        deleteFrame.add(mainPanelEast, BorderLayout.EAST);
        deleteFrame.add(mainPanelSouth, BorderLayout.SOUTH);

        return deleteFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Remove")) {
            SupplierDAO sDAO = new SupplierDAO();
            sDAO.deleteSupplier(supplier);

            JOptionPane.showMessageDialog(null,"Supplier deleted");
            deleteFrame.dispose();
        }
        if (e.getActionCommand().equals("Exit")) {
            deleteFrame.dispose();
        }

    }
}
