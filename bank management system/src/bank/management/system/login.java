package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.security.MessageDigest;

public class login extends JFrame implements ActionListener {

    JButton login, sign, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
       public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : hash){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    login() {

        setTitle("Bank Management System");
        setLayout(null);

        getContentPane().setBackground(new Color(200, 225, 255));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel logo = new JLabel(new ImageIcon(i2));
        logo.setBounds(40, 50, 80, 80);
        add(logo);
        
        


        
        JLabel heading = new JLabel("WELCOME TO THE BANK");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setBounds(140, 35, 400, 40);
        add(heading);

        JLabel loginText = new JLabel("LOGIN PAGE");
        loginText.setFont(new Font("Arial", Font.BOLD, 22));
        loginText.setBounds(180, 120, 200, 30);
        add(loginText);

        JLabel cardno = new JLabel("Account No");
        cardno.setFont(new Font("Arial", Font.BOLD, 16));
        cardno.setBounds(100, 170, 100, 25);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(220, 170, 200, 25);
        add(cardTextField);

        JLabel pin = new JLabel("Password");
        pin.setFont(new Font("Arial", Font.BOLD, 16));
        pin.setBounds(100, 210, 100, 25);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(220, 210, 200, 25);
        add(pinTextField);

        login = new JButton("LOGIN");
        login.setBounds(120, 260, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        sign = new JButton("SIGNUP");
        sign.setBounds(260, 260, 120, 30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.addActionListener(this);
        add(sign);

        clear = new JButton("RESET");
        clear.setBounds(120, 310, 260, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/logini.png"));
        Image i4 = i3.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i4));
        image.setBounds(450, 80, 350, 350);
        add(image);
        
        
            


        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }

        else if (ae.getSource() == login) {

            conn conn=new conn();
            String cardnu=cardTextField.getText();
            String pinno=pinTextField.getText();
            String hashedPin = hashPassword(pinno);
            String query="select *from login where cardnumber = '"+cardnu+"' and pin = '"+hashedPin+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incoreect card number and Pin");
                }
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }

        else if (ae.getSource() == sign) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

