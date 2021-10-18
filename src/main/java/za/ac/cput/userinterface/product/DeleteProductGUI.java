/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.userinterface.product;

import za.ac.cput.dao.product.ProductDAO;
import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.product.Product;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductGUI extends JFrame implements ActionListener {
    Product product;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JButton btnRemove, btnExit;
    private JLabel labelTitle, labelProductID, labelSupplierID, labelName, labelPrice;
    private JLabel textProductID, textSupplierID, textName, textPrice;

    public JFrame deleteProductFrame(Product product) {
        this.product = product;
        this.setTitle("Delete Product");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        labelTitle = new JLabel("Delete Product?", SwingConstants.CENTER);
        labelSupplierID = new JLabel("SupplierId : ", SwingConstants.RIGHT);
        labelName = new JLabel("Name : ", SwingConstants.RIGHT);
        labelPrice = new JLabel("Price : ", SwingConstants.RIGHT);
        labelProductID = new JLabel("Product ID : ", SwingConstants.RIGHT);
        textProductID = new JLabel(product.getProductId());
        textSupplierID = new JLabel(product.getSupplierId());
        textName = new JLabel(product.getName());
        textPrice = new JLabel(product.getPrice());

        // Label Styles
        labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
        labelSupplierID.setFont(new Font("Arial", Font.BOLD, 15));
        labelName.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));

        // Buttons
        btnRemove = new JButton("Remove");
        btnExit = new JButton("Exit");

        btnRemove.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnRemove.addActionListener(this);
        btnExit.addActionListener(this);

        panelNorth.setLayout(new GridLayout(3, 3));
        panelCenter.setLayout(new GridLayout(6, 3));
        panelSouth.setLayout(new GridLayout(3, 4));


        // Add to North
        panelNorth.add(labelTitle);

        // Add to Center
        panelCenter.add(labelProductID);
        panelCenter.add(textProductID);

        panelCenter.add(labelSupplierID);
        panelCenter.add(textSupplierID);

        panelCenter.add(labelName);
        panelCenter.add(textName);

        panelCenter.add(labelPrice);
        panelCenter.add(textPrice);

        // Add to South
        panelSouth.add(btnRemove);
        panelSouth.add(btnExit);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.pack();
        return this;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove")) {
            ProductDAO productDAO = new ProductDAO();
            String answer = productDAO.deleteProduct(product);
            if (answer.equals("Success")){
                JOptionPane.showMessageDialog(null, answer, "Deleted", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, answer, "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();

        }
        if (e.getActionCommand().equals("Exit")) {
            this.dispose();
        }

    }
}
