
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton deposite, withdrawl, fastcash, ministatement, pinchange, balance, exit;
    
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);
        
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(200, 280, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(155, 390, 140, 25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(340, 390, 140, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(155, 425, 140, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(340, 425, 140, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(155, 460, 140, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Rs 10000");
        balance.setBounds(340, 460, 140, 25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Back");
        exit.setBounds(340, 495, 140, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else 
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try {
                Con c = new Con();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
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

                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) 
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                
                Date date = new Date();
                String query = "Insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        
        
    }
    
    
    public static void main(String args[])
    {
        new  FastCash("");
    }
    
}
