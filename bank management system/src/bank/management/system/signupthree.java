package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    signupthree(String formno) {

        this.formno = formno;

        setLayout(null);
        
        ImageIcon bgIcon = new ImageIcon("src/icon/bg.png");
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 850, 800);
        setContentPane(background);

          JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
          l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
          type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Fixed Deposit Account");
          r1.setBounds(100, 180, 250, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(350, 180, 250, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Recurring Deposit Account");
        r3.setBounds(100, 220, 250, 30);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Saving Account");
        r4.setBounds(350, 220, 250, 30);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100, 300, 200, 30);
        add(cardno);
        
        JLabel cardLabel = new JLabel("XXXX-XXXX-XXXX-4184");
cardLabel.setFont(new Font("Raleway",Font.BOLD,22));
cardLabel.setBounds(330, 300, 300, 30);
add(cardLabel);

JLabel carddet=new JLabel("Your 16 digit card number");
carddet.setFont(new Font("Raleway",Font.BOLD,12));
carddet.setBounds(100, 330, 300, 20);
add(carddet);



        JLabel pinno = new JLabel("PIN:");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(100, 370, 200, 30);
        add(pinno);
        
        
        JLabel pinLabel = new JLabel("XXXX");
        pinLabel.setFont(new Font("Raleway",Font.BOLD,22));
        pinLabel.setBounds(330, 370, 300, 30);
        add(pinLabel);
        
        JLabel pindet=new JLabel("Your 4 digit PIN number");
        pindet.setFont(new Font("Raleway",Font.BOLD,12));
        pindet.setBounds(100, 400, 300, 20);
        add(pindet);


        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 250, 30);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct");
        c7.setBounds(100, 650, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(220, 720, 120, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 720, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String accountType = null;

            if (r1.isSelected())
                accountType = "Fixed Deposit";
            else if (r2.isSelected()) 
                accountType = "Current";
            else if (r3.isSelected()) 
                accountType = "Recurring Deposit";
            else if (r4.isSelected())
                accountType = "Saving";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Select Account Type");
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please confirm declaration");
                return;
            }

            Random ran = new Random();
            String cardNumber = "" + Math.abs((ran.nextLong() % 9000000000000000L) + 1000000000000000L);
            String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

            String facility = "";

            if (c1.isSelected()) 
                facility += " ATM Card";
            if (c2.isSelected())
                facility += " Internet Banking";
            if (c3.isSelected())
                facility += " Mobile Banking";
            if (c4.isSelected())
                facility += " Email & SMS Alerts";
            if (c5.isSelected())
                facility += " Cheque Book";
            if (c6.isSelected()) 
                facility += " E-Statement";

            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null," Account Type is Required");
                }else{

                conn c = new conn();
                String query = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardNumber + "','" + pin + "','" + facility + "')";
                String query2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pin + "')";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,
                        "Account Created Successfully\nCard Number: " + cardNumber + "\nPIN: " + pin);
                        
                setVisible(false);
                new Deposit(pin).setVisible(false);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signupthree("");
    }
}
