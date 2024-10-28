
package atm.simulator;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame
{

    MiniStatement(String pinnumber)
    {
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

                    
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        bank.setForeground(Color.white);
        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 320, 20);
        add(balance);
        
        try 
        {
            Con c = new Con();
            
            ResultSet rs = c.s.executeQuery("Select * from login where pin ='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
                
            }
            
           
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
        try {
            Con c = new Con();
            int bal = 0;
            ResultSet rs1 = c.s.executeQuery("Select * from bank where pin ='"+pinnumber+"'");
            while(rs1.next())
            {
                mini.setText(mini.getText() + "<html>" + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br><html");
                if(rs1.getString("type").equals("deposite")) 
                {
                    bal += Integer.parseInt(rs1.getString("amount"));
                }
                else
                {
                    bal -= Integer.parseInt(rs1.getString("amount"));
                }
            }
            
            balance.setText("Your current Balance is Rs " + bal);
            
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
        getContentPane().setBackground(Color.white);
        setSize(400,600);
        setLocation(20,20);
        //setUndecorated(true);
        setVisible(true);
        
    }
    
    
    public static void main(String args[])
    {
        new MiniStatement("").setVisible(true);
    }
}
