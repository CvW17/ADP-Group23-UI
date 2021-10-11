/**
 *  Name: Robin White
 *  Student Number: 218034555
 *  Group: 23
 *
 *  Employee Delete Gui
 */
package za.ac.cput.userinterface.employee;

import za.ac.cput.dao.user.EmployeeDAO;
import za.ac.cput.models.entity.user.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployeeGUI implements ActionListener {

    public JFrame frame;

    private JPanel North, Center, South;
    private JButton btnDelete,  btnExit;
    private JLabel labelTitle,lblID, lblName, lblSurname, lblPhone, lblRate;
    private JLabel lblempID, lblempName, lblempSurname, lblempPhone, lblempRate;

    Employee employee;

    public JFrame DeleteFrame(Employee e) {
        employee = e;
        frame = new JFrame("Delete Employee");
        frame.setLayout(new BorderLayout());
        North = new JPanel();
        South = new JPanel();
        Center = new JPanel();

        //labels
        labelTitle = new JLabel("Delete Employee");
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
        labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
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
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        // Button Styles
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));

        btnDelete.addActionListener(this);
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
        //Employee ID Details
        gbc.gridx = 0;
        gbc.gridy =0;
        Center.add(lblID,gbc);
        gbc.gridx = 1;
        gbc.gridy =0;
        Center.add(lblempID,gbc);

        //Employee Name Details
        gbc.gridx = 0;
        gbc.gridy =1;
        Center.add(lblName,gbc);
        gbc.gridx = 1;
        gbc.gridy =1;
        Center.add(lblempName,gbc);

        //Employee Surname Details
        gbc.gridx = 0;
        gbc.gridy =2;
        Center.add(lblSurname,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        Center.add(lblempSurname,gbc);


        //Employee phone Details
        gbc.gridx = 0;
        gbc.gridy =3;
        Center.add(lblPhone,gbc);
        gbc.gridx = 1;
        gbc.gridy =3;
        Center.add(lblempPhone,gbc);

        //Employee Rate Details
        gbc.gridx = 0;
        gbc.gridy =4;
        Center.add(lblRate,gbc);
        gbc.gridx =1;
        gbc.gridy =4;
        Center.add(lblempRate,gbc);

        //South Panel
        South.add(btnDelete);
        South.add(btnExit);

        frame.add(North, BorderLayout.NORTH);
        frame.add(Center, BorderLayout.CENTER);
        frame.add(South, BorderLayout.SOUTH);
        return frame;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Delete")) {
            EmployeeDAO dao = new EmployeeDAO();
            dao.removeEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee Deleted");
            frame.dispose();
            new AllEmployeeGUI().setAllGUI();
        }

        if (e.getActionCommand().equals("Exit")) {
            frame.dispose();
            new AllEmployeeGUI().setAllGUI();
        }
    }
}
