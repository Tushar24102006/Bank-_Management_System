package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.Color;
public class SignupOne extends JFrame implements ActionListener {

    long random;

    JTextField nameTextField, fnameTextField, emailTextField,
            addressTextField, cityTextField, pinTextField, stateTextField;

    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {

        setSize(850, 800);
        setLocation(350, 10);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo2.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel logo = new JLabel(new ImageIcon(i2));
        logo.setBounds(40, 50, 80, 80);
        add(logo);

        ImageIcon bgIcon = new ImageIcon("src/icon/bg.png");
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 850, 800);
        setContentPane(background);

        

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 32));
        formno.setForeground(Color.BLACK);
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setForeground(Color.BLACK);
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setForeground(Color.BLACK);
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setForeground(Color.BLACK);
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);


        JLabel gen = new JLabel("Gender:");
        gen.setFont(new Font("Raleway", Font.BOLD, 20));
        gen.setForeground(Color.BLACK);
        gen.setBounds(100, 290, 200, 30);
        add(gen);

        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 80, 30);
        male.setOpaque(false);
        male.setForeground(Color.BLACK);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(420, 290, 100, 30);
        female.setOpaque(false);
        female.setForeground(Color.BLACK);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel mail = new JLabel("Email Address:");
        mail.setFont(new Font("Raleway", Font.BOLD, 20));
        mail.setForeground(Color.BLACK);
        mail.setBounds(100, 340, 200, 30);
        add(mail);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marry = new JLabel("Marital Status:");
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setForeground(Color.BLACK);
        marry.setBounds(100, 390, 200, 30);
        add(marry);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setOpaque(false);
        married.setForeground(Color.BLACK);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 390, 120, 30);
        unmarried.setOpaque(false);
        unmarried.setForeground(Color.BLACK);
        add(unmarried);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setForeground(Color.BLACK);
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setForeground(Color.BLACK);
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setForeground(Color.BLACK);
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);


        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setForeground(Color.BLACK);
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);


        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected()) marital = "Married";
        else if (unmarried.isSelected()) marital = "Unmarried";

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pin = pinTextField.getText();
        String state = stateTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                conn c = new conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" +
                        fname + "','" + dob + "','" + gender + "','" + email + "','" +
                        marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";

                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
