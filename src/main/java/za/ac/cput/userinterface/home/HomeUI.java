package za.ac.cput.userinterface.home;

import za.ac.cput.userinterface.customer.CustomerHomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI implements ActionListener {

    private JFrame frame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16;
    private JButton btnCustomer, btnAppointment, btnBill, btnEmployee, btnProduct, btnSupplier;

    public HomeUI() {
        frame = new JFrame("Home Page");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();

        // Header:


        // Temporary fillers for layout:
        filler1 = new JLabel(" ");
//        filler2 = new JLabel("-------2-------");
        filler3 = new JLabel(" ");
//        filler4 = new JLabel("-------4-------");
//        filler5 = new JLabel("-------5-------");
//        filler6 = new JLabel("-------6-------");
        filler7 = new JLabel(" ");
        filler8 = new JLabel("                                                                    ");
        filler9 = new JLabel("                                                                    ");
        filler10 = new JLabel(" ");
        filler11 = new JLabel(" ");
        filler12 = new JLabel(" ");
        filler13 = new JLabel(" ");
        filler14 = new JLabel(" ");
        filler15 = new JLabel(" ");
        filler16 = new JLabel(" ");


        // Buttons:
        btnCustomer = new JButton("1. Customers");
        btnAppointment = new JButton("2. Appointments");
        btnBill = new JButton("3. Bills");
        btnEmployee = new JButton("4. Employees");
        btnProduct = new JButton("5. Products");
        btnSupplier = new JButton("6. Suppliers");

    }

    public void setUI() {

        // Button font and size:
        btnCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAppointment.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBill.setFont(new Font("Arial", Font.PLAIN, 20));
        btnEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
        btnProduct.setFont(new Font("Arial", Font.PLAIN, 20));
        btnSupplier.setFont(new Font("Arial", Font.PLAIN, 20));

        // Giving buttons functionality:
        btnCustomer.addActionListener(this);
        btnAppointment.addActionListener(this);
        btnBill.addActionListener(this);
        btnEmployee.addActionListener(this);
        btnProduct.addActionListener(this);
        btnSupplier.addActionListener(this);

        // Temporary fillers for layout
        filler1.setFont(new Font("Arial", Font.PLAIN, 100));
        filler3.setFont(new Font("Arial", Font.PLAIN, 100));

        // Set panels:
        panelNorth.setLayout(new GridLayout(1,1));
        panelSouth.setLayout(new GridLayout(1,1));
        panelCenter.setLayout(new GridLayout(12,1));
        panelEast.setLayout(new GridLayout(1,1));
        panelWest.setLayout(new GridLayout(1,1));

        // Add components to panels:
        panelNorth.add(filler1);

        panelCenter.add(btnCustomer);
        panelCenter.add(filler7);
        panelCenter.add(btnAppointment);
        panelCenter.add(filler10);
        panelCenter.add(btnBill);
        panelCenter.add(filler11);
        panelCenter.add(btnEmployee);
        panelCenter.add(filler12);
        panelCenter.add(btnProduct);
        panelCenter.add(filler13);
        panelCenter.add(btnSupplier);
        panelCenter.add(filler14);

        panelSouth.add(filler3);

        panelEast.add(filler8);

        panelWest.add(filler9);

        // Add to frame:
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelWest, BorderLayout.WEST);

        // Set UI:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("1. Customers")) {
            System.out.println("1. Customers");
            CustomerHomeUI chui = new CustomerHomeUI();
            chui.customersUI();
        }

        if(e.getActionCommand().equals("2. Appointments")) {
            System.out.println("2. Appointments");
        }

        if(e.getActionCommand().equals("3. Bills")) {
            System.out.println("3. Bills");
        }

        if(e.getActionCommand().equals("4. Employees")) {
            System.out.println("4. Employees");
        }

        if(e.getActionCommand().equals("5. Products")) {
            System.out.println("5. Products");
        }

        if(e.getActionCommand().equals("6. Suppliers")) {
            System.out.println("6. Suppliers");
        }
    }

}
