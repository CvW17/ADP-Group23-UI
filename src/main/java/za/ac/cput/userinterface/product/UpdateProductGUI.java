/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.userinterface.product;

import za.ac.cput.dao.product.ProductDAO;
import za.ac.cput.models.entity.product.Product;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductGUI extends JFrame implements ActionListener {

    private JPanel panelNorth, panelCenter, panelSouth;

    private JButton btnUpdateDB, btnReset, btnExit;

    private JLabel labelTitle, labelName, labelPrice;

    private JLabel errorName, errorPrice;

    private JLabel labelID, labelProductID;

    private JTextField textName, textPrice;

    String tempName, tempPrice;

    Product oldProduct;
    Product newProduct;



    public JFrame UpdateProductGUI(Product product) {
        this.oldProduct = product;
        this.newProduct = product;
        this.setTitle("Update Product");
        this.setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        tempName = product.getName();
        tempPrice = product.getPrice();

        labelTitle = new JLabel("Update Product", SwingConstants.CENTER);
        labelName = new JLabel("Name : ", SwingConstants.LEFT);
        labelPrice = new JLabel("Price : ", SwingConstants.LEFT);
        labelID = new JLabel("Customer ID : ", SwingConstants.LEFT);
        labelProductID = new JLabel(product.getProductId());

        errorName = new JLabel(" ");
        errorPrice = new JLabel(" ");

        // Label Styles
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelName.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Styles
        errorName.setFont(new Font("Arial", Font.BOLD, 15));
        errorPrice.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Colour:
        errorName.setForeground(Color.RED);
        errorPrice.setForeground(Color.RED);

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
        textName = new JTextField(product.getName());
        textPrice = new JTextField(product.getPrice());

        // Panel Styles
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(6, 2));
        panelSouth.setLayout(new GridLayout(2, 6));

        // Add to North

        panelNorth.add(labelTitle);

        // Add to Center
        panelCenter.add(labelID);
        panelCenter.add(labelProductID);

        panelCenter.add(labelName);
        panelCenter.add(textName);

        panelCenter.add(errorName);
        panelCenter.add(new JLabel(""));

        panelCenter.add(labelPrice);
        panelCenter.add(textPrice);

        panelCenter.add(errorPrice);
        panelCenter.add(new JLabel(""));

        // Add to South
        panelSouth.add(btnUpdateDB);
        panelSouth.add(btnReset);
        panelSouth.add(btnExit);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.pack();

        return this;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("UpdateDB")) {
            System.out.println("UpdateDB");

            boolean checkName = false;
            boolean checkPrice = false;

            if (textName.getText().equals("") || textName.getText().equals(" ")) {
                errorName.setText(" * Invalid Name ");
            } else {
                checkName = true;
                errorName.setText("");
            }

            if (!GenericHelper.validPrice(textPrice.getText())) {
                errorPrice.setText(" * Invalid Price ");
            } else {
                checkPrice = true;
                errorPrice.setText("");
            }



            if (checkName && checkPrice) {
                System.out.println("All Valid!");
                ProductDAO productDAO = new ProductDAO();

                System.out.println(textName.getText());
                System.out.println(textPrice.getText());

                tempName = textName.getText();
                tempPrice = textPrice.getText();


                newProduct = new Product.Builder().copy(oldProduct)
                        .setName(textName.getText())
                        .setPrice(textPrice.getText())
                        .Build();

                System.out.println(newProduct);
                productDAO.updateProduct(newProduct);
                if (!oldProduct.equals(newProduct)){
                    JOptionPane.showMessageDialog(null, "Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Oops", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.dispose();

            }
        }
        if (e.getActionCommand().equals("Reset")) {
            textName.setText(tempName);
            textPrice.setText(tempPrice);
        }

        if (e.getActionCommand().equals("Exit")) {
            this.dispose();
        }
    }
}
