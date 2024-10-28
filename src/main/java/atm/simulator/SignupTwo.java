
package atm.simulator;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener 
{
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category, occupation, education,income;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        
        JLabel relegion1 = new JLabel("Relegion: ");
        relegion1.setFont(new Font("Raleway", Font.BOLD, 20));
        relegion1.setBounds(100,140,100,30);
        add(relegion1);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christan","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        JLabel category1 = new JLabel("Category: ");
        category1.setFont(new Font("Raleway", Font.BOLD, 20));
        category1.setBounds(100,190,200,30);
        add(category1);
        
        String valCategory[] = {"General","OBC","ST","Other"}; 
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        
        JLabel income1 = new JLabel("Income: ");
        income1.setFont(new Font("Raleway", Font.BOLD, 20));
        income1.setBounds(100,240,400,30);
        add(income1);
        
        String valincome[] = {"Null","< 1,50,00","< 2,50,000","< 5,00,000","Upto 10,00,000"}; 
        income = new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        
        JLabel educational = new JLabel("Educational: ");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String valeducation[] = {"Non-Gradution","Gradution","Post Gradution","< Doctrate","Other"}; 
        education = new JComboBox(valeducation);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.white);
        add(education);
       
        
        JLabel occupation1 = new JLabel("Occupation: ");
        occupation1.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation1.setBounds(100,390,200,30);
        add(occupation1);
        
        String valoccupation[] = {"Salaried","Self-Employed","Bussiness","< Student","Retired", "Other"}; 
        occupation = new JComboBox(valoccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        JLabel panno = new JLabel("PAN NO: ");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100,440,200,30);
        add(panno);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel aadharno = new JLabel("Aadhar No: ");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100,490,200,30);
        add(aadharno);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scitizens = new ButtonGroup();
        scitizens.add(syes);
        scitizens.add(sno);
                
        
        JLabel existingaccount = new JLabel("Existing Account: ");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingaccount.setBounds(100,590,200,30);
        add(existingaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup exaccount = new ButtonGroup();
        exaccount.add(eyes);
        exaccount.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String srelegion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen=null;
        if(syes.isSelected())
        {
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected())
        {
            seniorcitizen = "No";
        }
        
        String existingacc=null;
        if(eyes.isSelected())
        {
            existingacc = "Yes";
        }
        else if(eno.isSelected())
        {
            existingacc = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try 
        {
            if(saadhar.isEmpty() || !saadhar.matches("\\d{12}")) 
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid 12-digit Aadhar Number.");
            }
            else if (span.isEmpty() || !span.matches("[A-Z]{5}[0-9]{4}[A-Z]")) 
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid PAN Number in the format: ABCDE1234F.");
            }
            else
            {
                Con c =new Con();
                String query = "Insert into signuptwo values('"+formno+"','"+srelegion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingacc+"')";
                c.s.executeUpdate(query);
                
                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            
        } catch (Exception e) 
        {
            System.out.println("Error"+e.getMessage());
        }
        
        
        
    }
    
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
