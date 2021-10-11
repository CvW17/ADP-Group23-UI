package za.ac.cput.userinterface.employee;
/**
 *  Name: Robin White
 *  Student Number: 218034555
 *  Group: 23
 *
 *  Employee Show All Gui
 */


import za.ac.cput.dao.user.EmployeeDAO;

import za.ac.cput.models.entity.user.Employee;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class AllEmployeeGUI extends JFrame implements ActionListener {
    private JPanel north, center, south;
    private JButton btnBack, btnUpdate, btnDelete;
    private JLabel lblHeading , lblempID, lblblank;
    private JTextField txtempID;
    private JTable empTable;




    public AllEmployeeGUI() {
        //Panels
        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        //Buttons
        btnBack = new JButton("Employee Menu");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));
        btnDelete = new JButton("Delete Employee");
        btnDelete.setFont(new Font("Arial", Font.PLAIN, 20));

        //Labels
        lblHeading = new JLabel("All Employees");
        lblHeading.setFont(new Font("Arial", Font.PLAIN, 25));
        lblempID = new JLabel("Enter EmployeeID: ");
        lblempID.setFont(new Font("Arial", Font.PLAIN, 25));
        lblblank = new JLabel("");

        //TextFields
        txtempID = new JTextField(" ");
        txtempID.setPreferredSize(new Dimension(200,24));

    }

    public void setAllGUI() {
        this.setTitle("All Employees");

        //Setting Panel Layouts
        north.setLayout(new FlowLayout());
        south.setLayout(new GridLayout(1, 3));

        //Panel Center GridBagLayout Constraints
        center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);


        //Panel North
        //JTable
        String[] ColumnNames = {"Employee ID","Employee Name", "Employee Surname ", "Employee Contact", "Employee Rate"};

        // Add Employees to table
        EmployeeDAO emp = new EmployeeDAO();
        Set<Employee> employees = emp.getAll();
        String[][] data = new String[employees.size()][5];
        int i = 0;
        for (Employee e : employees) {
            data[i][0] = e.getEmployeeID();
            data[i][1] = e.getFirstName();
            data[i][2] = e.getLastName();
            data[i][3] = e.getPhoneNumber();
            data[i][4] = e.getEmployeeRate().toString();
            i++;
        }

        empTable = new JTable(data, ColumnNames);
        JScrollPane table = new JScrollPane(empTable);
        north.add(table);

        //Panel Center
        gbc.gridx = 0;
        gbc.gridy =2;
        center.add(lblempID,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        center.add(txtempID,gbc);


        //Panel South
        south.add(btnBack);
        south.add(btnUpdate);
        south.add(btnDelete);

        //Button Functionality
        btnBack.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);


        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setSize(800, 800);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Employee Menu")) {
            System.out.println("Employee Menu");
            new EmployeeHomeGUI().employeeGUI();
            this.dispose();

        }
        if (e.getActionCommand().equals("Update")) {
            if (txtempID.getText().equals("") || txtempID.getText().equals(" ")) {
                System.out.println("Error");
            } else {
                String textIDInput = txtempID.getText();
                EmployeeDAO dao = new EmployeeDAO();
                System.out.println("Update");
                UpdateEmployeeGUI updateGUI = new UpdateEmployeeGUI();
                Employee employee = dao.FindEmployeeByID(textIDInput);
                JFrame Frame = updateGUI.UpdateEmployee(employee);
                Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Frame.setSize(780, 350);
                Frame.setLocationRelativeTo(null);
                Frame.setVisible(true);
                this.dispose();

            }
        }

        if(e.getActionCommand().equals("Delete Employee"))
        if (txtempID.getText().equals("") || txtempID.getText().equals(" ")) {
            System.out.println("Invalid data entry");
        } else {
            String textIDInput = txtempID.getText();
            EmployeeDAO dao = new EmployeeDAO();
            Employee employee = dao.FindEmployeeByID(textIDInput);
            DeleteEmployeeGUI deleteGUI = new DeleteEmployeeGUI();
            JFrame Frame = deleteGUI.DeleteFrame(employee);
            Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Frame.setSize(780, 350);
            Frame.setLocationRelativeTo(null);
            Frame.setVisible(true);
            this.dispose();
        }
    }
}

