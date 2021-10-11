/**
 *  Author: Robyn White - 218034555
 *  Add Employee Gui Interface
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.dao.user.EmployeeDAO;
import za.ac.cput.models.entity.user.Employee;
import za.ac.cput.models.factory.user.EmployeeFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGUI extends JFrame implements ActionListener {
    private JPanel north, center, south;
    private JButton btnAdd, btnReset, btnCancel;
    private JLabel lblHeading, lblName, lblSurname, lblPhone, lblRate;
    private JLabel error1 , error2, error3, error4;
    private JTextField  txtName, txtSurname, txtPhone, txtRate;



    public AddEmployeeGUI() {
        //Panels
        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        //Buttons
        btnAdd = new JButton("Add");
        btnReset = new JButton("Reset");
        btnCancel = new JButton("Cancel");

        //Labels
        lblHeading = new JLabel("Add Employee");
        lblName = new JLabel("Name: ");
        lblSurname = new JLabel("LastName: ");
        lblPhone = new JLabel("Phone: ");
        lblRate = new JLabel("Rate: ");

        //Other Labels
        error1 = new JLabel(" ");
        error2 = new JLabel(" ");
        error3 = new JLabel(" ");
        error4 = new JLabel(" ");


        //Textfields
        txtName = new JTextField("");
        txtSurname = new JTextField("");
        txtPhone = new JTextField("");
        txtRate = new JTextField("");


    }

    public void setAddGUI() {
        this.setTitle("Add Employee");

        //Setting Panel Layouts
        north.setLayout(new FlowLayout());
        south.setLayout(new GridLayout(1, 3));
        //Panel Center GridBagLayout Constraints
        center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);


        //Panel North
        north.add(lblHeading);

        //Panel Center
        gbc.gridx = 0;
        gbc.gridy =0;
        center.add(lblName,gbc);
        gbc.gridx = 1;
        gbc.gridy =0;
        center.add(txtName,gbc);
        gbc.gridx = 2;
        gbc.gridy =0;
        center.add(error1,gbc);

        gbc.gridx = 0;
        gbc.gridy =1;
        center.add(lblSurname,gbc);
        gbc.gridx = 1;
        gbc.gridy =1;
        center.add(txtSurname,gbc);
        gbc.gridx = 2;
        gbc.gridy =1;
        center.add(error2,gbc);

        gbc.gridx = 0;
        gbc.gridy =2;
        center.add(lblPhone,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        center.add(txtPhone,gbc);
        gbc.gridx = 2;
        gbc.gridy =2;
        center.add(error3,gbc);

        gbc.gridx = 0;
        gbc.gridy =3;
        center.add(lblRate,gbc);
        gbc.gridx = 1;
        gbc.gridy =3;
        center.add(txtRate,gbc);
        gbc.gridx = 2;
        gbc.gridy =3;
        center.add(error4,gbc);

        //Panel South
        south.add(btnAdd);
        south.add(btnReset);
        south.add(btnCancel);

        // Label fonts and size
        lblHeading.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setFont(new Font("Arial", Font.BOLD, 25));
        lblSurname.setFont(new Font("Arial", Font.BOLD, 25));
        lblPhone.setFont(new Font("Arial", Font.BOLD, 25));
        lblRate.setFont(new Font("Arial", Font.BOLD, 25));

        // Error labels fonts and size
        error1.setFont(new Font("Arial", Font.BOLD, 15));
        error2.setFont(new Font("Arial", Font.BOLD, 15));
        error3.setFont(new Font("Arial", Font.BOLD, 15));
        error4.setFont(new Font("Arial", Font.BOLD, 15));

        // Error label Colour:
        error1.setForeground(Color.RED);
        error2.setForeground(Color.RED);
        error3.setForeground(Color.RED);
        error4.setForeground(Color.RED);

        //Textfield sizing
        txtName.setPreferredSize(new Dimension(200,24));
        txtSurname.setPreferredSize(new Dimension(200,24));
        txtPhone.setPreferredSize(new Dimension(200,24));
        txtRate.setPreferredSize(new Dimension(200,24));


        //Button Functionality
        btnAdd.addActionListener(this);
        btnReset.addActionListener(this);
        btnCancel.addActionListener(this);

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
        if (e.getActionCommand().equals("Add")) {
            String empFirstName = txtName.getText();
            String empLastName = txtSurname.getText();
            String empPhone = txtPhone.getText();
            String empRate = txtRate.getText();


            double rate = Double.parseDouble(empRate);

            boolean validateName = false;
            boolean validateSurname = false;
            boolean validatePhone = false;
            boolean validateRate = false;

            if (empFirstName.equals("") || !empFirstName.matches("[a-zA-Z]+")) {
                error1.setText(" * Invalid Data entered");
            } else {
                validateName = true;
                error1.setText(" ");
            }

            if (empLastName.equals("") || !empLastName.matches("[a-zA-Z]+")) {
                error2.setText(" * Invalid Data entered");
            } else {
                validateSurname = true;
                error2.setText(" ");
            }

            if (!GenericHelper.validContactNumber(empPhone)) {
                error3.setText(" * Invalid Data entered ");
            } else {
                validatePhone = true;
                error3.setText(" ");
            }

            if (empRate.equals("")) {
                error4.setText(" * Field Cant be empty");
            } else {
                validateRate = true;
                error4.setText(" ");
            }

            if (validateName && validateSurname && validatePhone && validateRate) {
                System.out.println("Validation Check Successful!");

                EmployeeDAO empDAO = new EmployeeDAO();

                // Create Employee
                Employee emp = EmployeeFactory.build(empFirstName, empLastName, empPhone, rate);


                String data = empDAO.addEmployee(emp);


                if (data.equals("Employee Added to Database")) {
                    JOptionPane.showMessageDialog(null,"Employee Added to Database");
                    txtName.setText("");
                    txtSurname.setText("");
                    txtPhone.setText("");
                    txtRate.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, data, "Error", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }

            if (e.getActionCommand().equals("Reset")) {
                txtName.setText(" ");
                txtSurname.setText(" ");
                txtPhone.setText(" ");
                txtRate.setText(" ");
                System.out.println("Reset");

            }

            if (e.getActionCommand().equals("Cancel")) {
                System.out.println("Cancel");
                new EmployeeHomeGUI().employeeGUI();
                this.dispose();

            }
        }
    }








































