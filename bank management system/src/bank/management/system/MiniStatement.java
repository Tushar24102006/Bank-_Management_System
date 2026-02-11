package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinno;

    MiniStatement(String pinno) {
        this.pinno = pinno;

        setTitle("Mini Statement");
        setLayout(null);

        
        ImageIcon bgIcon = new ImageIcon("src/icon/bg2.png");
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 850, 800);
        setContentPane(background);
        
        
        JLabel bank = new JLabel("STATE BANK OF INDIA");
        bank.setBounds(120, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 60, 350, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 70, 350, 300);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20, 390, 300, 20);
        add(balance);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(
                    "select * from login where pin = '" + pinno + "'");
            if (rs.next()) {
                card.setText("Card Number: "
                        + rs.getString("cardnumber").substring(0, 4)
                        + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));
            }

            ResultSet rs2 = c.s.executeQuery(
                    "select * from bank where pin = '" + pinno + "'");

            StringBuilder statement = new StringBuilder();
            int bal = 0;

            while (rs2.next()) {

                statement.append(rs2.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;")
                        .append(rs2.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;Rs ")
                        .append(rs2.getString("amount"))
                        .append("<br>");

                if (rs2.getString("type").equalsIgnoreCase("deposit")) {
                    bal += Integer.parseInt(rs2.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }
            }

            mini.setText("<html>" + statement.toString() + "</html>");
            balance.setText("Your Current Balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("1234"); 
    }
}
