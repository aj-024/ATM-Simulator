
package atm.simulator;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener 
{
    Long random;
    JTextField nameTextField, fnameTextField,emailTextField,addresTextField,cityTextField,stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, other, married, Unmarried;
    JDateChooser datechooser;
    
    SignupOne()
    {
        setLayout(null);
        setTitle("Sign Up");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        
        JLabel formno = new JLabel("Application Form no: "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno); 
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,400,30);
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 400, 30);
        datechooser.setForeground(new Color(105, 105, 105));
        add(datechooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel maritial = new JLabel("Maritial Status: ");
        maritial.setFont(new Font("Raleway", Font.BOLD, 20));
        maritial.setBounds(100,390,200,30);
        add(maritial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(450,390,100,30);
        Unmarried.setBackground(Color.white);
        add(Unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(Unmarried);
        marriedgroup.add(other);
        
        JLabel addres = new JLabel("Address: ");
        addres.setFont(new Font("Raleway", Font.BOLD, 20));
        addres.setBounds(100,440,200,30);
        add(addres);
        
        addresTextField = new JTextField();
        addresTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addresTextField.setBounds(300, 440, 400, 30);
        add(addresTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
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
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritial = null;
        if(married.isSelected())
        {
            maritial = "Married";
        }
        else if(Unmarried.isSelected())
        {
            maritial ="Unmarried";
        }
        else if(other.isSelected())
        {
            maritial="other";
        }
        String address = addresTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        try {
            
            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || email.isEmpty() || city.isEmpty() || state.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required details.");
                return; 
            }

            
            if (!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Name should contain only letters.");
                return;
            }

            if (!fname.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Father's Name should contain only letters.");
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
                return;
            }

            if (!pin.matches("\\d{6}")) { 
                JOptionPane.showMessageDialog(this, "Pincode must be 6 digits.");
                return;
            }
            else
            {
                Con c = new Con();
                String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) 
        {
            System.out.println("Error"+e.getMessage());
        }
        
        
        
    }
    
    
    public static void main(String args[])
    {
        new SignupOne();
    }
}
