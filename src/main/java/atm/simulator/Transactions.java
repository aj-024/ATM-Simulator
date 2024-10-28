
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposite, withdrawl, fastcash, ministatement, pinchange, balance, exit;
    
    String pinnumber;
    Transactions(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);
        
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200, 280, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposite = new JButton("Deposit");
        deposite.setBounds(155, 390, 140, 25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(340, 390, 140, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(155, 425, 140, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(340, 425, 140, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(155, 460, 140, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(340, 460, 140, 25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }
        else if(ae.getSource() == deposite)
        {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        
        else if(ae.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == ministatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[])
    {
        new  Transactions("");
    }
    
}
