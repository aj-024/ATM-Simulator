
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(250, 40, 400, 40 );
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100, 140, 200, 30 );
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 220, 150, 20);
        add(r3);
        
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 220, 250, 20);
        add(r4);
        
        ButtonGroup groupacc =  new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);
        
        
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100, 300, 200, 30 );
        add(cardno);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330, 300, 300, 30 );
        add(number);
        
        JLabel details = new JLabel("(Your 16 Digit Card Number)");
        details.setFont(new Font("Raleway",Font.BOLD,12));
        details.setBounds(100, 330, 300, 20 );
        add(details);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 370, 200, 30 );
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330, 370, 300, 30 );
        add(pnumber);
        
        JLabel pdetails = new JLabel("(Your 4 Digit Password)");
        pdetails.setFont(new Font("Raleway",Font.BOLD,12));
        pdetails.setBounds(100, 400, 300, 20 );
        add(pdetails);
        
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100, 450, 230, 30 );
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 650, 600, 30);
        add(c7);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(230,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(450,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String accountType = "";
            if(r1.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(r2.isSelected())
            {
                accountType = "Fixed Deposite Account";
            }
            else if(r3.isSelected())
            {
                accountType = "Current Account";
            }
            else if(r4.isSelected())
            {
                accountType = "Recurring Deposite Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
//            String facility = "";
//            boolean option1 = false;
//            if(c1.isSelected())
//            {
//                facility = facility + " ATM CARD";
//                option1 = true;
//            }
//            
//            else if(c2.isSelected())
//            {
//                facility = facility + " Internet Banking";
//                option1 = true;
//            }
//            
//            else if(c3.isSelected())
//            {
//                facility = facility + " Mobile Banking";
//                option1 = true;
//            }
//            
//            else if(c4.isSelected())
//            {
//                facility = facility + " Email & SMS Alerts";
//                option1 = true;
//            }
//            
//            else if(c5.isSelected())
//            {
//                facility = facility + " Checkbook";
//                option1 = true;
//            }
//            
//            else if(c6.isSelected())
//            {
//                facility = facility + " E-Statement";
//                option1 = true;
//            }
//            else if(c7.isSelected() == true)
//            {
//                option1 = true;
//            }

            StringBuilder facility = new StringBuilder();
            boolean option = false;

            for (JCheckBox checkbox : new JCheckBox[]{c1, c2, c3, c4, c5, c6}) 
            {
                if (checkbox.isSelected()) 
                {
                    facility.append(checkbox.getText()).append(", ");
                    option = true;
                }
            }

            
            
            try {
                if(accountType.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Account Type is Required");
                }
                else if(!option)
                {
                    JOptionPane.showMessageDialog(this, "Check the Empty Boxes");
                    
                }
                
                else 
                {
                    Con c = new Con();
                    String query = "Insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    c.s.executeUpdate(query);
                    String query1 = "Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    
                    JOptionPane.showMessageDialog(null, "CARD NUMBER: "+ cardnumber + "\n PIN: " + pinnumber);
                    
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                }
                
            } 
            catch (Exception e) 
            {
                System.out.println("Error = "+ e.getMessage());
            }
            
        }
        
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String args[])
    {
        new SignupThree("");
    }
    
}
