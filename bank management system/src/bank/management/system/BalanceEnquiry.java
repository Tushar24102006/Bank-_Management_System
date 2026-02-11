
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinno;
    JButton back;
    BalanceEnquiry(String pinno){
        this.pinno=pinno;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
         back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        int balance = 0;
        conn c=new conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" +pinno+"'");
                    while (rs.next()) {
            String type = rs.getString("type");
            if (type.equalsIgnoreCase("deposit")) {
                balance += Integer.parseInt(rs.getString("amount"));
            } else {
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
                }catch(Exception e){
                   System.out.println(e);
                }
        JLabel text = new JLabel("Your Current Account balance is Rs "+balance);
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transaction(pinno).setVisible(true);
//        try{
//            if(ae.getS)
//            
//        }catch(Exception e){
//            System.out.println(e);
//        }
    }
    public static void main(String ar[]){
        new BalanceEnquiry("");
            
        
    }
}
    

