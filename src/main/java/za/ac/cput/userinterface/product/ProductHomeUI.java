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
import za.ac.cput.userinterface.customer.*;
import za.ac.cput.userinterface.home.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ProductHomeUI extends JFrame implements ActionListener {
    private final JPanel panelNorth, panelCenter, panelSouth;
    private final JPanel bottomPanelNorth, bottomPanelSouth, bottomPanelCenter;
    private final JLabel headerLabel;
    private final JButton btnAddProduct, btnFindProduct, btnGetAllProducts, btnBack;
    private final JButton btnUpdate, btnDelete, btnExit;

    private final JLabel jlabelTitle, productIDLabel;

    private final JLabel errorID;

    private final JTextField textProductID;

    private final JTable getAllTable;

    public ProductHomeUI() {
        this.setTitle("Products");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        bottomPanelNorth = new JPanel();
        bottomPanelSouth = new JPanel();
        bottomPanelCenter = new JPanel();

        // Labels
        jlabelTitle = new JLabel(" All Products ", SwingConstants.CENTER);
        jlabelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        productIDLabel = new JLabel(" Enter Product ID :  ", SwingConstants.LEFT);
        errorID = new JLabel(" ", SwingConstants.LEFT);
        errorID.setForeground(Color.red);
        errorID.setFont(new Font("Arial", Font.BOLD, 15));

        // Textfield
        textProductID = new JTextField("");

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

        btnAddProduct.addActionListener(this);
        btnFindProduct.addActionListener(this);
        btnGetAllProducts.addActionListener(this);
        btnBack.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        // Table:
        String[] tableColumnTitle = {"Product ID","Supplier ID", "Name", "Price"};

        // Add Products to table
        ProductDAO productDAO = new ProductDAO();
        Set<Product> products = productDAO.getAllProducts();
        String[][] data = new String[products.size()][4];
        int i = 0;
        for (Product p : products) {
            data[i][0] = p.getProductId();
            data[i][1] = p.getSupplierId();
            data[i][2] = p.getName();
            data[i][3] = String.valueOf(p.getPrice());
            i++;
        }

        getAllTable = new JTable(data, tableColumnTitle);
        JScrollPane table = new JScrollPane(getAllTable);

        // Panel North:
        headerLabel = new JLabel("Products");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panelNorth.setLayout(new GridBagLayout());
        panelNorth.add(headerLabel);

        // Panel Center:
        panelCenter.setLayout(new GridLayout(4,1));
        panelCenter.add(btnAddProduct);
        panelCenter.add(btnFindProduct);
        panelCenter.add(btnGetAllProducts);
        panelCenter.add(btnBack);

        // Panel South(Placeholder panel):
        panelSouth.setLayout(new BorderLayout());
        panelSouth.setPreferredSize(new Dimension(600,400));
        bottomPanelNorth.setLayout(new GridLayout(2,3));
        bottomPanelCenter.setLayout(new GridLayout(1,1));
        bottomPanelSouth.setLayout(new GridLayout(2,3));

        bottomPanelNorth.add(jlabelTitle);

        bottomPanelCenter.add(table);

        bottomPanelSouth.add(productIDLabel);
        bottomPanelSouth.add(textProductID);
        bottomPanelSouth.add(errorID);

        bottomPanelSouth.add(btnUpdate);
        bottomPanelSouth.add(btnDelete);
        bottomPanelSouth.add(btnExit);

        panelSouth.add(bottomPanelNorth, BorderLayout.NORTH);
        panelSouth.add(bottomPanelCenter, BorderLayout.CENTER);
        panelSouth.add(bottomPanelSouth, BorderLayout.SOUTH);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void productsUI() {
        // Set UI:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,650);
        //frame.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    @Override
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

        if (e.getActionCommand().equals("Exit")) {
            this.dispose();
        }

        if (e.getActionCommand().equals("Back")) {
            System.out.println("Back");
            new HomeUI().setUI();
            this.dispose();
        }
        if (e.getActionCommand().equals("Update")) {
            if (textProductID.getText().equals("") || textProductID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = textProductID.getText();
                ProductDAO productDAO = new ProductDAO();
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
            if (textProductID.getText().equals("") || textProductID.getText().equals(" ")) {
                System.out.println("Error");
                errorID.setText("Error: Invalid ID");
            } else {
                String textIDInput = textProductID.getText();
                ProductDAO productDAO = new ProductDAO();
                Product product = productDAO.getProductByID(textIDInput);
                DeleteProductGUI deleteProductGUI = new DeleteProductGUI();
                JFrame deleteFrame = deleteProductGUI.deleteProductFrame(product);
                deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                deleteFrame.setSize(780, 350);
                deleteFrame.setLocationRelativeTo(null);
                deleteFrame.setVisible(true);
            }
        }
    }
}
