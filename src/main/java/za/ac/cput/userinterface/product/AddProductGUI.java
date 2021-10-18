/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.userinterface.product;

import za.ac.cput.dao.product.ProductDAO;
import za.ac.cput.models.entity.product.Product;
import za.ac.cput.models.factory.product.ProductFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductGUI extends JFrame implements ActionListener {
    private JPanel panelCenter, panelSouth;
    private JLabel headerLabel;
    private JButton btnAddProduct, btnFindProduct, btnGetAllProducts, btnBack;
    private JButton btnUpdate, btnDelete, btnExit;

    private JPanel addProductPanel;
    private JLabel jlabelTitle, labelName, labelPrice;
    private JLabel errorName, errorPrice;
    private JButton btnSave, btnClear;

    private JTextField textName, textPrice;

    public AddProductGUI() {
        this.setTitle("Products");
        JPanel mainPanelNorth = new JPanel();
        JPanel mainPanelCenter = new JPanel();
        JPanel mainPanelEast = new JPanel();
        JPanel mainPanelWest = new JPanel();
        JPanel mainPanelSouth;

        // Buttons
        btnAddProduct = new JButton("Add Product");
        btnFindProduct = new JButton("Find Product");
        btnGetAllProducts = new JButton("Get All Products");
        btnBack = new JButton("Back");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        btnAddProduct.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindProduct.setFont(new Font("Arial", Font.PLAIN, 20));
        btnGetAllProducts.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));

        // Panel North:
        headerLabel = new JLabel("Add Product");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(headerLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(4,1));
        mainPanelCenter.add(btnAddProduct);
        mainPanelCenter.add(btnFindProduct);
        mainPanelCenter.add(btnGetAllProducts);
        mainPanelCenter.add(btnBack);

        // Panel West
        mainPanelWest.setLayout(new GridLayout(1,1));

        // Panel East
        mainPanelEast.setLayout(new GridLayout(1,1));

        // Panel South
        mainPanelSouth = AddProductJPanel();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));

        this.add(mainPanelNorth, BorderLayout.NORTH);
        this.add(mainPanelCenter, BorderLayout.CENTER);
        this.add(mainPanelSouth, BorderLayout.SOUTH);
        this.add(mainPanelEast, BorderLayout.EAST);
        this.add(mainPanelWest, BorderLayout.WEST);
    }

    public void addProductsUI() {
        // Set UI:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public JPanel AddProductJPanel() {
        // Panels
        addProductPanel = new JPanel();
        addProductPanel.setLayout(new BorderLayout());
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        // Labels
        jlabelTitle = new JLabel(" Add Product", SwingConstants.CENTER);
        labelName = new JLabel("Name : ", SwingConstants.LEFT);
        labelPrice = new JLabel("Price : ", SwingConstants.LEFT);

        errorName = new JLabel(" ");
        errorPrice = new JLabel(" ");

        // Label Styles
        jlabelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelName.setFont(new Font("Arial", Font.BOLD, 15));
        labelPrice.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Styles
        errorName.setFont(new Font("Arial", Font.BOLD, 15));
        errorPrice.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Colour:
        errorName.setForeground(Color.RED);
        errorPrice.setForeground(Color.RED);

        // Buttons
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        // Button Styles
        btnSave.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        btnAddProduct.addActionListener(this);
        btnFindProduct.addActionListener(this);
        btnGetAllProducts.addActionListener(this);
        btnBack.addActionListener(this);

        // TextFields
        textName = new JTextField();
        textPrice = new JTextField();

        // Panel Styles

        panelCenter.setLayout(new GridLayout(8, 3));
        panelSouth.setLayout(new GridLayout(1, 3));

        // Add to Center
        panelCenter.add(labelName);
        panelCenter.add(textName);
        panelCenter.add(errorName);

        panelCenter.add(labelPrice);
        panelCenter.add(textPrice);
        panelCenter.add(errorPrice);

        // Add to South
        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        // Panels Added to Main Panel
        addProductPanel.add(panelCenter, BorderLayout.CENTER);
        addProductPanel.add(panelSouth, BorderLayout.SOUTH);

        return addProductPanel;
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Product")) {
            AddProductGUI addProductGUI = new AddProductGUI();
            addProductGUI.addProductsUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Find Product")) {
            FindProductGUI findProductGUI = new FindProductGUI();
            findProductGUI.findProductsUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Get All Products")) {
            ProductHomeUI productHomeUI = new ProductHomeUI();
            productHomeUI.productsUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            ProductHomeUI productHomeUI = new ProductHomeUI();
            productHomeUI.productsUI();
            this.dispose();
        }

        if (e.getActionCommand().equals("Save")) {
            String productName = textName.getText();
            String productPrice = textPrice.getText();

            boolean checkName = false;
            boolean checkPrice = false;

            if (productName.equals("") || !productName.matches("[a-zA-Z]+")) {
                errorName.setText(" * Invalid Name ");
            } else {
                checkName = true;
                errorName.setText("");
            }

            if (!GenericHelper.validPrice(productPrice)) {
                errorPrice.setText(" * Invalid Price ");
            } else {
                checkPrice = true;
                errorPrice.setText(" ");
            }

            if (checkName && checkPrice) {
                System.out.println("All Valid!");
                ProductDAO productDAO = new ProductDAO();

                // Create Product
                Product p = ProductFactory.build(GenericHelper.generateID(),productName, productPrice);

                // Call method to add to DB
                String answer = productDAO.addProductToDB(p);

                // Display Result
                if (answer.equals("Product Added!")) {
                    JOptionPane.showMessageDialog(null, answer, "Added Product", JOptionPane.INFORMATION_MESSAGE);
                    textName.setText("");
                    textPrice.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, answer, "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
        if (e.getActionCommand().equals("Clear")) {
            textName.setText("");
            textPrice.setText("");
            errorName.setText("");
            errorPrice.setText("");
            System.out.println("Clear");
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
            this.dispose();
        }
    }
}
