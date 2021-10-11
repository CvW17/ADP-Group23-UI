/**
 *  Name: Robin White
 *  Student Number: 218034555
 *  Group: 23
 *
 *  Employee update Gui
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.dao.user.EmployeeDAO;
import za.ac.cput.models.entity.user.Employee;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployeeGUI implements ActionListener {
    public JFrame frame;

    private JPanel North, Center, South;
    private JButton btnUpdate,  btnExit;
    private JLabel labelTitle, lblName, lblSurname, lblPhone, lblRate;
    private JTextField txtName, txtSurname, txtPhone, txtRate;
    private JLabel error1, error2, error3, error4;
    private JLabel lblID, lblEmployeeID;
    String tempName, tempSurname, tempPhone, tempRate;

    Employee employee;

    public JFrame UpdateEmployee(Employee e) {
        employee = e;
        frame = new JFrame("Update Employee");
        frame.setLayout(new BorderLayout());
        North = new JPanel();
        South = new JPanel();
        Center = new JPanel();

        //temp labels
        tempName = e.getFirstName();
        tempSurname = e.getLastName();
        tempPhone = e.getPhoneNumber();
        tempRate = e.getEmployeeRate().toString();

        //labels
        labelTitle = new JLabel("Update Employee");
        lblName = new JLabel("Employee Name : ");
        lblSurname = new JLabel("Employee Surname : ");
        lblPhone = new JLabel("Employee Phone : ");
        lblRate = new JLabel("Employee Rate : ");
        lblID = new JLabel("Employee ID : ");
        lblEmployeeID = new JLabel(e.getEmployeeID());

        //Other labels
        error1 = new JLabel(" ");
        error2 = new JLabel(" ");
        error3 = new JLabel(" ");
        error4 = new JLabel(" ");

        // Label Styles and fonts
        labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        lblSurname.setFont(new Font("Arial", Font.BOLD, 20));
        lblPhone.setFont(new Font("Arial", Font.BOLD, 20));
        lblRate.setFont(new Font("Arial", Font.BOLD, 20));
        lblEmployeeID.setFont(new Font("Arial", Font.BOLD, 20));
        lblID.setFont(new Font("Arial", Font.BOLD, 20));

        // Error labels Styles amd fonts
        error1.setFont(new Font("Arial", Font.BOLD, 15));
        error2.setFont(new Font("Arial", Font.BOLD, 15));
        error3.setFont(new Font("Arial", Font.BOLD, 15));
        error4.setFont(new Font("Arial", Font.BOLD, 15));
        error1.setForeground(Color.RED);
        error2.setForeground(Color.RED);
        error3.setForeground(Color.RED);
        error4.setForeground(Color.RED);

        // TextFields
        txtName = new JTextField(e.getFirstName());
        txtSurname = new JTextField(e.getLastName());
        txtPhone = new JTextField(e.getPhoneNumber());
        txtRate = new JTextField(e.getEmployeeRate().toString());

        // Buttons
        btnUpdate = new JButton("Update");
        btnExit = new JButton("Exit");

        // Button Styles
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));

        btnUpdate.addActionListener(this);
        btnExit.addActionListener(this);



        // Panel Styles
        North.setLayout(new FlowLayout());
        South.setLayout(new GridLayout(1, 2));
        Center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);


        // North Panel
        North.add(labelTitle);


        // Center Panel
        //ID label and textfield
        gbc.gridx = 0;
        gbc.gridy =0;
        Center.add(lblID,gbc);
        gbc.gridx = 1;
        gbc.gridy =0;
        Center.add(lblEmployeeID,gbc);

        //Employee Name label and textfield
        gbc.gridx = 0;
        gbc.gridy =1;
        Center.add(lblName,gbc);
        gbc.gridx = 1;
        gbc.gridy =1;
        Center.add(txtName,gbc);
        gbc.gridx = 2;
        gbc.gridy =1;
        Center.add(error1,gbc);

        //Employee Surname label and textfield
        gbc.gridx = 0;
        gbc.gridy =2;
        Center.add(lblSurname,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        Center.add(txtSurname,gbc);
        gbc.gridx = 2;
        gbc.gridy =2;
        Center.add(error2,gbc);

        //Employee phone label and textfield
        gbc.gridx = 0;
        gbc.gridy =3;
        Center.add(lblPhone,gbc);
        gbc.gridx = 1;
        gbc.gridy =3;
        Center.add(txtPhone,gbc);
        gbc.gridx = 2;
        gbc.gridy =3;
        Center.add(error3,gbc);

        //Employee Rate label and textfield
        gbc.gridx = 0;
        gbc.gridy =4;
        Center.add(lblRate,gbc);
        gbc.gridx =1;
        gbc.gridy =4;
        Center.add(txtRate,gbc);
        gbc.gridx = 2;
        gbc.gridy =4;
        Center.add(error4,gbc);

        //South Panel
        South.add(btnUpdate);
        South.add(btnExit);

        frame.add(North, BorderLayout.NORTH);
        frame.add(Center, BorderLayout.CENTER);
        frame.add(South, BorderLayout.SOUTH);
        return frame;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {


            boolean validateName = false;
            boolean validateSurname = false;
            boolean validatePhone = false;
            boolean validateRate = false;

            if (txtName.getText().equals("") || txtName.getText().equals(" ")) {
                error1.setText(" * Invalid Data entered");
            } else {
                validateName = true;
                error1.setText(" ");
            }

            if (txtSurname.getText().equals("") || txtSurname.getText().equals(" ")) {
                error2.setText(" * Invalid Data entered");
            } else {
                validateSurname = true;
                error2.setText(" ");
            }

            if (txtPhone.getText().equals("") || txtPhone.getText().equals(" ")) {
                error3.setText(" * Invalid Data entered ");
            } else {
                validatePhone = true;
                error3.setText(" ");
            }

            if (txtRate.getText().equals("") || txtRate.getText().equals(" ")) {
                error4.setText(" * Field Cant be empty");
            } else {
                validateRate = true;
                error4.setText(" ");
            }

            if (validateName && validateSurname && validatePhone && validateRate) {
                System.out.println("All Valid!");
                double rate = Double.parseDouble(txtRate.getText());

                EmployeeDAO empDAO = new EmployeeDAO();

                System.out.println(txtName.getText());
                System.out.println(txtSurname.getText());
                System.out.println(txtPhone.getText());
                System.out.println(txtRate.getText());

                tempName = txtName.getText();
                tempSurname = txtSurname.getText();
                tempPhone = txtPhone.getText();
                tempRate = txtRate.getText();

                employee = new Employee.Builder().copy(employee)
                        .setFirstName(txtName.getText())
                        .setLastName(txtSurname.getText())
                        .setPhoneNumber(txtPhone.getText())
                        .setEmployeeRate(rate)
                        .build();

                System.out.println(employee);
                empDAO.updateEmployee(employee);
                JOptionPane.showMessageDialog(null,"Employee Details Updated");
                new AllEmployeeGUI().setAllGUI();
                frame.dispose();

            }
        }
        if (e.getActionCommand().equals("Exit")) {
            new AllEmployeeGUI().setAllGUI();
            frame.dispose();


        }
    }
}


