
package atm.simulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
    JButton change, back;
    JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(250, 280, 400, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setBounds(165, 340, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,14));
        image.add(pintext);
        
        pin =  new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(310, 340, 175, 25);
        image.add(pin);
        
 
        JLabel repintext = new JLabel("Re-Enter NEW PIN:");
        repintext.setBounds(165, 380, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,14));
        image.add(repintext);
        
        repin =  new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(310, 380, 175, 25);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(340, 460, 140, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
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
        if (ae.getSource() == change)
        {
            try 
            {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not matched");
                    return;
                }
                
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Con c = new Con();
                String query1 = "Update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "Update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "Update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Chnage Succesfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
               
                
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
