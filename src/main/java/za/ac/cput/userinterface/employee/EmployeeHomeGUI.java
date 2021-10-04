/**
 *  Author: Robyn White - 218034555
 *  Add Employee Gui Interface
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.userinterface.customer.CustomerHomeUI;
import za.ac.cput.userinterface.home.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeHomeGUI extends JFrame implements ActionListener{
    private JFrame main;
    private JPanel panelNorth, panelCenter, panelSouth, panelEast, panelWest;
    private JLabel headerLabel;
    private JButton btnAddEmployee, btnFindEmployee, btnUpdateEmployee, btnDeleteEmployee, btnMenu;
    private JLabel centerFiller1, centerFiller2, centerFiller3, centerFiller4, centerFiller5, centerFiller6;
    private JLabel westFiller1;
    private JLabel eastFiller1;
    private JLabel southFiller1;

    public EmployeeHomeGUI() {
        main = new JFrame("Employee");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();

        // Temp JLabels
        centerFiller1 = new JLabel(" ");
        centerFiller2 = new JLabel(" ");
        centerFiller3 = new JLabel(" ");
        centerFiller4 = new JLabel(" ");
        centerFiller5 = new JLabel(" ");
        centerFiller6 = new JLabel(" ");
        westFiller1 = new JLabel("                                                                                       ");
        eastFiller1 = new JLabel("                                                                                       ");
        southFiller1 = new JLabel(" ");

        // Buttons
        btnAddEmployee = new JButton("Add Employee");
        btnFindEmployee  = new JButton("Find Employee ");
        btnUpdateEmployee  = new JButton("Update Employee ");
        btnDeleteEmployee  = new JButton("Remove Employee ");
        btnMenu = new JButton("Main Menu");

        btnAddEmployee .setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindEmployee .setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdateEmployee .setFont(new Font("Arial", Font.PLAIN, 20));
        btnDeleteEmployee .setFont(new Font("Arial", Font.PLAIN, 20));
        btnMenu .setFont(new Font("Arial", Font.PLAIN, 20));

        btnAddEmployee.addActionListener(this);
        btnFindEmployee.addActionListener(this);
        btnUpdateEmployee.addActionListener(this);
        btnDeleteEmployee.addActionListener(this);
        btnMenu.addActionListener(this);



        // Panel North:
        headerLabel = new JLabel("Employee");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 100));
        panelNorth.setLayout(new GridBagLayout());
        panelNorth.add(headerLabel);

        // Panel Center:
        panelCenter.setLayout(new GridLayout(10,1));
        panelCenter.add(centerFiller1);
        panelCenter.add(btnAddEmployee);
        panelCenter.add(centerFiller2);
        panelCenter.add(btnFindEmployee);
        panelCenter.add(centerFiller3);
        panelCenter.add(btnUpdateEmployee);
        panelCenter.add(centerFiller4);
        panelCenter.add(btnDeleteEmployee);
        panelCenter.add(centerFiller5);
        panelCenter.add(btnMenu);

        // Panel South(Placeholder panel):
        panelSouth.setLayout(new GridLayout(1,1));
        panelSouth.setPreferredSize(new Dimension(600,400));
        panelSouth.add(southFiller1);




        // uncomment to check size of panel
//         panelSouth.setBackground(Color.GREEN);

        panelWest.setLayout(new GridLayout(1,1));
        panelWest.add(westFiller1);

        panelEast.setLayout(new GridLayout(1,1));
        panelEast.add(eastFiller1);

        main.add(panelNorth, BorderLayout.NORTH);
        main.add(panelCenter, BorderLayout.CENTER);
        main.add(panelSouth, BorderLayout.SOUTH);
        main.add(panelEast, BorderLayout.EAST);
        main.add(panelWest, BorderLayout.WEST);

    }

    public void employeeGUI() {
        // Set UI:
        main.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        main.setSize(800, 800);
        //frame.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Add Employee")) {
            System.out.println("Add");
            new AddEmployeeGUI().setAddGUI();
            main.dispose();

        }

        if(e.getActionCommand().equals("Main Menu")) {
            System.out.println("Back To Main Menu");
            new HomeUI().setUI();
            main.dispose();


        }

        if(e.getActionCommand().equals("Cancel")) {
            System.out.println("Cancel");
        }


    }

}
