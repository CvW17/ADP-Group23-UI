/**
 *  Author: Robyn White - 218034555
 *  Add Employee Gui Interface
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.dao.user.EmployeeDAO;
import za.ac.cput.models.entity.user.Employee;
import za.ac.cput.userinterface.home.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class EmployeeHomeGUI extends JFrame implements ActionListener {
    private JFrame main;
    private JPanel panelNorth, panelCenter, panelSouth, panelEast, panelWest;
    private JLabel lblHeading;
    private JButton btnAddEmployee, btnFindEmployee, btnUpdateEmployee, btnDeleteEmployee, btnMenu, btnAll;
    private JLabel lblempID;
    private JTextField txtempID;
    private JTable empTable;


    public EmployeeHomeGUI() {
        main = new JFrame("Employee Home Menu");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();

        // JLabels
        lblHeading = new JLabel("Employee Menu");
        lblempID = new JLabel("Enter Employee ID to Find:");

        //Jlabel fonts and styles
        lblHeading.setFont(new Font("Arial", Font.PLAIN, 25));
        lblempID.setFont(new Font("Arial", Font.PLAIN, 25));

        //JtextField and Style
        txtempID = new JTextField("");
        txtempID.setPreferredSize(new Dimension(200,24));

        // Buttons
        btnAddEmployee = new JButton("Add Employee");
        btnFindEmployee = new JButton("Find Employee ");
        btnUpdateEmployee = new JButton("Update Employee");
        btnDeleteEmployee = new JButton("Remove Employee");
        btnMenu = new JButton("Main Menu");
        btnAll = new JButton("Show All Employees");

        //Button styles and fonts
        btnAddEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
        btnFindEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdateEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
        btnDeleteEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
        btnMenu.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAll.setFont(new Font("Arial", Font.PLAIN, 20));

        btnAddEmployee.addActionListener(this);
        btnFindEmployee.addActionListener(this);
        btnUpdateEmployee.addActionListener(this);
        btnDeleteEmployee.addActionListener(this);
        btnMenu.addActionListener(this);
        btnAll.addActionListener(this);


        // North Panel
        panelNorth.setLayout(new GridBagLayout());
        panelNorth.add(lblHeading);

        // Center Panel
        panelCenter.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);

        gbc.gridx = 1;
        gbc.gridy =0;
        panelCenter.add(btnAddEmployee,gbc);

        gbc.gridx = 1;
        gbc.gridy =1;
        panelCenter.add(btnFindEmployee,gbc);

        gbc.gridx = 1;
        gbc.gridy =2;
        panelCenter.add(btnUpdateEmployee,gbc);

        gbc.gridx = 1;
        gbc.gridy =3;
        panelCenter.add(btnDeleteEmployee,gbc);

        gbc.gridx = 1;
        gbc.gridy =4;
        panelCenter.add(btnAll,gbc);

        gbc.gridx = 1;
        gbc.gridy =5;
        panelCenter.add(btnMenu,gbc);

        gbc.gridx = 0;
        gbc.gridy =6;
        panelCenter.add(lblempID,gbc);

        gbc.gridx = 1;
        gbc.gridy =6;
        panelCenter.add(txtempID,gbc);

        // South Panel
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setPreferredSize(new Dimension(600, 400));


        //Table with employee IDs only
        EmployeeDAO emp = new EmployeeDAO();
        Set<Employee> employees = emp.getAll();
        String[] ColumnNames = {"Employee ID"};
        String[][] data = new String[employees.size()][1];
        int i = 0;
        for (Employee e : employees) {
            data[i][0] = e.getEmployeeID();
            i++;
        }

        empTable = new JTable(data, ColumnNames);
        JScrollPane table = new JScrollPane(empTable);
        panelSouth.add(table);

        main.add(panelNorth, BorderLayout.NORTH);
        main.add(panelCenter, BorderLayout.CENTER);
        main.add(panelSouth, BorderLayout.SOUTH);


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
            new HomeUI().setUI();
            main.dispose();
        }

        if (txtempID.getText().equals("") || txtempID.getText().equals(" ")) {
            System.out.println("No Data Entered");
        } else {
            String textIDInput = txtempID.getText();
            EmployeeDAO dao = new EmployeeDAO();
            Employee employee = dao.FindEmployeeByID(textIDInput);
            FindEmployeeGUI findGUI = new FindEmployeeGUI();
            JFrame frame = findGUI.FindEmployee(employee);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(780, 350);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            main.dispose();
        }

        if(e.getActionCommand().equals("Show All Employees")) {
            System.out.println("Get All Employees");
            new AllEmployeeGUI().setAllGUI();
            main.dispose();
        }
        if(e.getActionCommand().equals("Update Employee")) {
            System.out.println("Find Employee");
            new AllEmployeeGUI().setAllGUI();
            main.dispose();
        }
        if(e.getActionCommand().equals("Remove Employee")) {
            System.out.println("Find Employee");
            new AllEmployeeGUI().setAllGUI();
            main.dispose();
        }


    }

    }

