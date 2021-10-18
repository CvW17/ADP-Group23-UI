/**
 *  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 */

package za.ac.cput.userinterface.product;

import za.ac.cput.dao.product.ProductDAO;

import za.ac.cput.models.entity.product.Product;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class FindProductGUI extends JFrame implements ActionListener {
    private JLabel headerLabel;
    private JButton btnAddProduct, btnFindProduct, btnGetAllProducts, btnBack;
    private JButton btnSearch, btnUpdate, btnDelete, btnExit;

    private JTextField textSearchField, textProductId;

    private JLabel labelSearchOption, labelEnterKeyword, labelError;

    private JLabel ProductIdLabel;
    private JLabel errorID;

    private JComboBox comboboxSearchTerm;

    public FindProductGUI() {
        this.setTitle("Products");
        JPanel mainPanelNorth = new JPanel();
        JPanel mainPanelCenter = new JPanel();
        JPanel mainPanelEast = new JPanel();
        JPanel mainPanelWest = new JPanel();
        JPanel mainPanelSouth = new JPanel();

        // Labels
        ProductIdLabel = new JLabel("Enter Product ID : ");

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

        // Button Functionality
        btnAddProduct.addActionListener(this);
        btnFindProduct.addActionListener(this);
        btnGetAllProducts.addActionListener(this);
        btnBack.addActionListener(this);


        // Panel North:
        headerLabel = new JLabel("Find Products");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        mainPanelNorth.setLayout(new GridBagLayout());
        mainPanelNorth.add(headerLabel);

        // Panel Center:
        mainPanelCenter.setLayout(new GridLayout(4,1));
        mainPanelCenter.add(btnAddProduct);
        mainPanelCenter.add(btnFindProduct);
        mainPanelCenter.add(btnGetAllProducts);
        mainPanelCenter.add(btnBack);

        // Panel South
        mainPanelSouth = searchByJP();
        mainPanelSouth.setPreferredSize(new Dimension(600,400));

        this.add(mainPanelNorth, BorderLayout.NORTH);
        this.add(mainPanelCenter, BorderLayout.CENTER);
        this.add(mainPanelSouth, BorderLayout.SOUTH);
        this.add(mainPanelEast, BorderLayout.EAST);
        this.add(mainPanelWest, BorderLayout.WEST);

    }

    public JPanel searchByJP() {
        JPanel searchByPanel = new JPanel();
        searchByPanel.setLayout(new BorderLayout());
        JPanel searchPanelSouth = new JPanel();
        JPanel searchPanelCenter = new JPanel();

        labelSearchOption = new JLabel("Search by : ");
        labelEnterKeyword = new JLabel("Enter Keyword : ");
        labelError = new JLabel(" ");

        labelSearchOption.setFont(new Font("Arial", Font.PLAIN, 10));
        labelEnterKeyword.setFont(new Font("Arial", Font.PLAIN, 10));
        labelError.setFont(new Font("Arial", Font.BOLD, 20));

        String choice[] = {"Name", "Price"};
        comboboxSearchTerm = new JComboBox(choice);

        // Textfield
        textSearchField = new JTextField("");
        textProductId = new JTextField("");

        // Label Styles
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
        searchPanelCenter.setLayout(new GridLayout(10, 3));
        searchPanelSouth.setLayout(new GridLayout(2, 3));

        // Add to Center
        searchPanelCenter.add(labelSearchOption);
        searchPanelCenter.add(comboboxSearchTerm);

        searchPanelCenter.add(labelEnterKeyword);
        searchPanelCenter.add(textSearchField);
        searchPanelCenter.add(btnSearch);

        searchPanelCenter.add(labelError);



        // Add to South


        searchPanelSouth.add(ProductIdLabel);
        searchPanelSouth.add(textProductId);
        searchPanelSouth.add(errorID);

        searchPanelSouth.add(btnUpdate);
        searchPanelSouth.add(btnDelete);
        searchPanelSouth.add(btnExit);


//        searchByPanel.add(searchPanelNorth, BorderLayout.NORTH);
        searchByPanel.add(searchPanelCenter, BorderLayout.CENTER);
        searchByPanel.add(searchPanelSouth, BorderLayout.SOUTH);
//        searchByPanel.add(searchPanelEast, BorderLayout.EAST);
//        searchByPanel.add(searchPanelWest, BorderLayout.WEST);


        return searchByPanel;
    }




    public JFrame resultOfSearchPanel(Set<Product> products) {
        JFrame popoutFrame = new JFrame("Products");
        JPanel popoutPanel = new JPanel();


        String[] tableColumnTitle = {"Product ID","Supplier ID", "Name", "Price"};
        String data[][] = new String[products.size()][4];

        int i = 0;

        for (Product product : products) {
            data[i][0] = product.getProductId();
            data[i][1] = product.getSupplierId();
            data[i][2] = product.getName();
            data[i][3] = product.getPrice();

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

    public void findProductsUI() {
        // Set UI:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,650);
        //frame.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        ProductDAO productDAO = new ProductDAO();
        String comboChoice = comboboxSearchTerm.getSelectedItem().toString();
        String textInput = textSearchField.getText();
        Set<Product> products = new HashSet<>();
        String textIDInput = textProductId.getText();

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
            this.dispose();
            ProductHomeUI productHomeUI = new ProductHomeUI();
            productHomeUI.productsUI();
        }

        // Search Functionality
        if (e.getActionCommand().equals("Search")) {
            if (textInput.equals("") || textInput.equals(" ")) {
                System.out.println("INVALID");
                labelError.setText("Error : Invalid Input");

            } else if (comboChoice.equals("Name")) {
                System.out.println("Search Choice : Name");
                products = productDAO.searchName(textInput);
                resultOfSearchPanel(products);
                labelError.setText(" ");

            } else if (comboChoice.equals("Price")) {
                System.out.println("Search Choice : Last Name");
                products = productDAO.searchPrice(textInput);
                resultOfSearchPanel(products);
                labelError.setText(" ");

            } else {
                System.out.println("Invalid Search?");
            }
        }

        // Product ID Buttons
        if (e.getActionCommand().equals("Update")) {

            if (textProductId.getText().equals("") || textProductId.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            }
            else {
                errorID.setText(" ");
                System.out.println("Update");
                UpdateProductGUI updateProductGUI = new UpdateProductGUI();
                Product product = productDAO.getProductByID(textIDInput);
                JFrame updateFrame = updateProductGUI.UpdateProductGUI(product);
                updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateFrame.setSize(780, 350);
                updateFrame.setLocationRelativeTo(null);
                updateFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Delete")) {
            System.out.println("Delete");
            if (textProductId.getText().equals("") || textProductId.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                errorID.setText(" ");
                textIDInput = textProductId.getText();
                Product product = productDAO.getProductByID(textIDInput);
                DeleteProductGUI deleteProductGUI = new DeleteProductGUI();
                JFrame deleteFrame = deleteProductGUI.deleteProductFrame(product);
                deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                deleteFrame.setSize(780, 350);
                deleteFrame.setLocationRelativeTo(null);
                deleteFrame.setVisible(true);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit");
            this.dispose();
        }
    }
}
