
package atm.simulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);
        
        
        back = new JButton("BACK");
        back.setBounds(340, 495, 140, 25);
        back.addActionListener(this);
        image.add(back);
        int balance = 0;
        try 
        {
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           
            while (rs.next()) 
            {
                if(rs.getString("type").equals("deposite")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error retrieving balance information.");
           
        }
                    
        JLabel text = new JLabel("Your Current Account Balance is Rs "+ balance);
        text.setBounds(155, 280, 400, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
        
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("").setVisible(true);
    }
}
