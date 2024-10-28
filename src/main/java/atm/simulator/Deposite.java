
package atm.simulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;


public class Deposite extends JFrame implements ActionListener
{
    
    JTextField amount;
    JButton deposite,back;
    String pinnumber;
    
    Deposite(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);
        
        
        JLabel text = new JLabel("Enter the amount you want to Deposite");
        text.setBounds(170, 280, 400, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(160, 350, 320, 25);
        image.add(amount);
        
        deposite = new JButton("Deposit");
        deposite.setBounds(340, 460, 140, 25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        back = new JButton("Back");
        back.setBounds(340, 495, 140, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == deposite)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter emount you want to deposite");
            }
            else
            {
                try {
                    Con c =new Con();
                    String query = "Insert into bank values('"+pinnumber+"','"+date+"','deposite','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+ " Deposited Successfully ");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } 
                catch (Exception e) 
                {
                    System.out.println(e.getMessage());
                }
                
                
                
            }
            
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
            
    }
    
    public static void main(String args[])
    {
        new Deposite("");
    }
}
