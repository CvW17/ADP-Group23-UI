/**
 *  Name: Robin White
 *  Student Number: 218034555
 *  Group: 23
 *
 *  Employee Find Gui
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.dao.user.EmployeeDAO;
import za.ac.cput.models.entity.user.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class FindEmployeeGUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel north, center, south;
    private JButton btnMenu;
    private JLabel lblHeading, lblID, lblName, lblSurname, lblPhone, lblRate;       //employee description labels
    private JLabel lblempID, lblempName, lblempSurname, lblempPhone, lblempRate;    //employeee details labels


    Employee employee ;
    public JFrame FindEmployee(Employee e) {
        employee = e;
        frame = new JFrame("Find Employee");
        frame.setLayout(new BorderLayout());
        north = new JPanel();
        south = new JPanel();
        center = new JPanel();

        //labels
        lblHeading = new JLabel("Employee:");
        lblID = new JLabel("Employee ID:");
        lblName = new JLabel("Employee Name : ");
        lblSurname = new JLabel("Employee Surname : ");
        lblPhone = new JLabel("Employee Phone : ");
        lblRate = new JLabel("Employee Rate : ");
        lblempID = new JLabel(e.getEmployeeID());
        lblempName = new JLabel(e.getFirstName());
        lblempSurname = new JLabel(e.getLastName());
        lblempPhone = new JLabel(e.getPhoneNumber());
        lblempRate = new JLabel(e.getEmployeeRate().toString());

        // Label Styles and fonts
        lblHeading.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        lblSurname.setFont(new Font("Arial", Font.BOLD, 20));
        lblPhone.setFont(new Font("Arial", Font.BOLD, 20));
        lblRate.setFont(new Font("Arial", Font.BOLD, 20));
        lblID.setFont(new Font("Arial", Font.BOLD, 20));
        lblempID.setFont(new Font("Arial", Font.BOLD, 20));
        lblempName.setFont(new Font("Arial", Font.BOLD, 20));
        lblempSurname.setFont(new Font("Arial", Font.BOLD, 20));
        lblempPhone.setFont(new Font("Arial", Font.BOLD, 20));
        lblempRate.setFont(new Font("Arial", Font.BOLD, 20));

        // Buttons
        btnMenu = new JButton("Employee Menu");


        // Button Styles
        btnMenu.setFont(new Font("Arial", Font.BOLD, 20));
        btnMenu.addActionListener(this);

        // Panel Styles
        north.setLayout(new FlowLayout());
        south.setLayout(new FlowLayout());

        center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);


        // North Panel
        north.add(lblHeading);

        // Center Panel
        //Employee ID Details
        gbc.gridx = 0;
        gbc.gridy =0;
        center.add(lblID,gbc);
        gbc.gridx = 1;
        gbc.gridy =0;
        center.add(lblempID,gbc);

        //Employee Name Details
        gbc.gridx = 0;
        gbc.gridy =1;
        center.add(lblName,gbc);
        gbc.gridx = 1;
        gbc.gridy =1;
        center.add(lblempName,gbc);

        //Employee Surname Details
        gbc.gridx = 0;
        gbc.gridy =2;
        center.add(lblSurname,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        center.add(lblempSurname,gbc);


        //Employee phone Details
        gbc.gridx = 0;
        gbc.gridy =3;
        center.add(lblPhone,gbc);
        gbc.gridx = 1;
        gbc.gridy =3;
        center.add(lblempPhone,gbc);

        //Employee Rate Details
        gbc.gridx = 0;
        gbc.gridy =4;
        center.add(lblRate,gbc);
        gbc.gridx =1;
        gbc.gridy =4;
        center.add(lblempRate,gbc);

        //South Panel
        south.add(btnMenu);

        frame.add(north, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(south, BorderLayout.SOUTH);
        return frame;


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Employee Menu")) {
            System.out.println("Employee Menu");
            new EmployeeHomeGUI().employeeGUI();
            frame.dispose();

        }
    }
}
