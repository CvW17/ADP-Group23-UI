package za.ac.cput.userinterface.customer;

import za.ac.cput.dao.user.CustomerDAO;
import za.ac.cput.models.entity.user.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class FindCustomerByPanel implements ActionListener {

    private JPanel findCustomerByPanel;
    private JPanel panelNorth, panelSouth, panelWest, panelCenter, panelEast;

    private JLabel jlabelsearchBy, jlabelTitle;

    private JLabel errorSearch;

    private JLabel filler1, filler2, filler3, filler4, filler5, filler6, filler7, filler8, filler9;
    private JLabel filler10, filler11, filler12, filler13, filler14, filler15, filler16, filler17;

    private JButton btnSearch, btnUpdate, btnDelete, btnExit;

    private JTable resultTable;

    public JTextField textSearch;

    private JComboBox comboBoxSearchBy;

    String searchText = "";

    JScrollPane resultScrollPane;

    private JPanel resultPanel;

    public JPanel FindCustomerJP() {
        // Panels
        findCustomerByPanel = new JPanel();
        findCustomerByPanel.setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();

        // Labels:
        jlabelTitle = new JLabel(" Add Customer: ", SwingConstants.CENTER);
        jlabelsearchBy = new JLabel();
        errorSearch = new JLabel(" ");

        // Fillers
        filler1 = new JLabel(" ");
        filler2 = new JLabel(" ");
        filler3 = new JLabel(" ");
        filler4 = new JLabel("                  ");
        filler5 = new JLabel("                  ");
        filler6 = new JLabel(" ");
        filler7 = new JLabel(" ");
        filler8 = new JLabel(" ");
        filler9 = new JLabel(" ");
        filler10 = new JLabel(" ");
        filler11 = new JLabel(" ");
        filler12 = new JLabel(" ");
        filler13 = new JLabel(" ");
        filler14 = new JLabel(" ");
        filler15 = new JLabel(" ");
        filler16 = new JLabel(" ");
        filler17 = new JLabel(" ");

        // Label Styles
        jlabelTitle.setFont(new Font("Arial", Font.BOLD, 25));
        jlabelsearchBy.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Styles
        errorSearch.setFont(new Font("Arial", Font.BOLD, 15));

        // Error Colour
        errorSearch.setForeground(Color.RED);

        // Buttons
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");
        btnUpdate = new JButton("Update");
        btnExit = new JButton("Exit");

        // Button Styles
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));

        // Button Functionality
        btnSearch.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        btnUpdate.addActionListener(this);

        // TextFields
        textSearch = new JTextField("");

        // ComboBox
        String[] choice = {"First Name", "Last Name", "Contact Number", "Email"};
        comboBoxSearchBy = new JComboBox(choice);

        // Table
        String[] tableColumnTitle = {"First Name", "Last Name", "Contact Number", "Email", "Select"};
        String[][] data = {{" ", " ", " ", " ", " "}};

        resultTable = new JTable(data, tableColumnTitle);
        JScrollPane sp = new JScrollPane(resultTable);

        // Panel Styles
        panelNorth.setLayout(new GridLayout(3, 3));
        panelWest.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1, 1));
        panelEast.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(3, 5));

        // Add to North
        panelNorth.add(filler1);
        panelNorth.add(jlabelTitle);
        panelNorth.add(filler2);
        panelNorth.add(jlabelsearchBy);
        panelNorth.add(errorSearch);
        panelNorth.add(filler3);
        panelNorth.add(comboBoxSearchBy);
        panelNorth.add(textSearch);
        panelNorth.add(btnSearch);

        // Add to West
        panelWest.add(filler4);

        // Add to Center
        panelCenter.add(sp);

        // Add to East
        panelEast.add(filler5);

        // Add to South
        panelSouth.add(filler6);
        panelSouth.add(filler7);
        panelSouth.add(filler8);
        panelSouth.add(filler9);
        panelSouth.add(filler10);
        panelSouth.add(filler11);
        panelSouth.add(btnUpdate);
        panelSouth.add(btnDelete);
        panelSouth.add(btnExit);
        panelSouth.add(filler12);
        panelSouth.add(filler13);
        panelSouth.add(filler14);
        panelSouth.add(filler15);
        panelSouth.add(filler16);
        panelSouth.add(filler17);

        // Panels Added to Main Panel
        findCustomerByPanel.add(panelNorth, BorderLayout.NORTH);
        findCustomerByPanel.add(panelWest, BorderLayout.WEST);
        findCustomerByPanel.add(panelCenter, BorderLayout.CENTER);
        findCustomerByPanel.add(panelEast, BorderLayout.EAST);
        findCustomerByPanel.add(panelSouth, BorderLayout.SOUTH);

        return findCustomerByPanel;
    }

    public JPanel resultOfSearchPanel(Set<Customer> customers) {
        resultPanel = new JPanel();

        String[] tableColumnTitle = {"ID", "First Name", "Last Name", "Contact Number", "Email"};
        String[][] data = new String[customers.size()][5];
        int i = 0;
        for (Customer c : customers) {
            data[i][0] = c.getCustomerID();
            data[i][1] = c.getFirstName();
            data[i][2] = c.getLastName();
            data[i][3] = c.getContactNumber();
            data[i][4] = c.getEmail();

            i++;

        }

        JTable newResultTable = new JTable(data, tableColumnTitle);
        JScrollPane sp = new JScrollPane(newResultTable);

        resultPanel.add(sp);


        return resultPanel;
    }


    public void actionPerformed(ActionEvent e) {
        CustomerDAO cdao = new CustomerDAO();
        if (e.getActionCommand().equals("Search")) {
            searchText = textSearch.getText();
            Set<Customer> searchCustomerSet = new HashSet<>();

            String searchTerm = comboBoxSearchBy.getSelectedItem().toString();
            if (searchText.equals("") || searchText.equals(" ")){
                errorSearch.setText("Invalid Search Term");
                return;
            }
            if (searchTerm.equals("First Name")) {
                errorSearch.setText(" ");
                searchCustomerSet = cdao.searchFirstName(searchText);
                JPanel newPanel = resultOfSearchPanel(searchCustomerSet);

                findCustomerByPanel.remove(panelCenter);

                newPanel.setPreferredSize(new Dimension(600,400));
                findCustomerByPanel.add(newPanel, BorderLayout.CENTER);
                findCustomerByPanel.invalidate();
                findCustomerByPanel.validate();

            }
            if (searchTerm.equals("Last Name")) {
                errorSearch.setText(" ");
                searchCustomerSet = cdao.searchLastName(searchText);
                JPanel newPanel = resultOfSearchPanel(searchCustomerSet);

                findCustomerByPanel.remove(panelCenter);
                newPanel.setPreferredSize(new Dimension(600,400));
                findCustomerByPanel.add(newPanel, BorderLayout.CENTER);
                findCustomerByPanel.invalidate();
                findCustomerByPanel.validate();
            }
            if (searchTerm.equals("Contact Number")) {
                errorSearch.setText(" ");
                searchCustomerSet = cdao.searchContactNumber(searchText);
                JPanel newPanel = resultOfSearchPanel(searchCustomerSet);

                findCustomerByPanel.remove(panelCenter);
                newPanel.setPreferredSize(new Dimension(600,400));
                findCustomerByPanel.add(newPanel, BorderLayout.CENTER);
                findCustomerByPanel.invalidate();
                findCustomerByPanel.validate();

            }
            if (searchTerm.equals("Email")) {
                errorSearch.setText(" ");
                searchCustomerSet = cdao.searchEmail(searchText);
                JPanel newPanel = resultOfSearchPanel(searchCustomerSet);

                findCustomerByPanel.remove(panelCenter);
                newPanel.setPreferredSize(new Dimension(600,400));
                findCustomerByPanel.add(newPanel, BorderLayout.CENTER);
                findCustomerByPanel.invalidate();
                findCustomerByPanel.validate();

            }

        }
    }

}
