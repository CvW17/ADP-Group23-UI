//AddBillUI.java
//Interface for Bill Add
//Author: Cameron van Wyk(219088470)

package za.ac.cput.userinterface.bills;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBillUI extends JFrame implements ActionListener
{
    public AddBillUI()
    {

    }

    public void setGUI()
    {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
