
package atm.simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
{
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("Automated Teller Machine");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(120, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
       
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {
            Con c = new Con();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                String cardNumber = cardTextField.getText(); 
                String pin = pinTextField.getText(); 

                
                if (cardNumber.isEmpty() || !cardNumber.matches("\\d{16}")) 
                { 
                    JOptionPane.showMessageDialog(this, "Please enter a valid 16-digit Card Number.");
                    return; 
                }

                if (pin.isEmpty() || !pin.matches("\\d{4}")) 
                { 
                    JOptionPane.showMessageDialog(this, "Please enter a valid 4-digit PIN.");
                    return; 
                }
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or PIN");
                }
                        
                
            } catch (Exception e) 
            {
                System.out.println("Error = "+e.getMessage());
                        
            }
            
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
           
    
    
    public static void main(String args[])
    {
        new Login();
    }
}
