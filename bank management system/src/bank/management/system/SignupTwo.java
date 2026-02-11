package bank.management.system;   

import javax.swing.*;           
import java.awt.*;             
import java.util.*;             
import com.toedter.calendar.JDateChooser; 
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    
    
    
    JTextField nameTextField,fnameTextField ,emailTextField,addressTextField,cityTextField,pinTextField,stateTextField,pan,aadhar;
    JButton next;
    JRadioButton male,female,syes,sno,eyes,eno;
 
    JComboBox religion,category,income,education,occupation;
    String formno;
    SignupTwo(String formno) {
        ImageIcon bgIcon = new ImageIcon("src/icon/bg.png");
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 850, 800);
        setContentPane(background);
        
        
        this.formno=formno;
        setLayout(null); 
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
       String val[]={"Hindu", "Muslim","Sikh","Christian","Other"}; 
         religion =new JComboBox(val);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String cat[]={"General", "OBC","SC","ST","Other"}; 
         category =new JComboBox(cat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

       

        JLabel in = new JLabel("Income:");
        in.setFont(new Font("Raleway", Font.BOLD, 20));
        in.setBounds(100, 240, 200, 30);
        add(in);
        
        String IncomeR[]={"Null", "<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"}; 
         income =new JComboBox(IncomeR);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

       

        JLabel gen = new JLabel("Education");
        gen.setFont(new Font("Raleway", Font.BOLD, 20));
        gen.setBounds(100, 290, 200, 30);
        add(gen);

        JLabel mail = new JLabel("Qualification:");
        mail.setFont(new Font("Raleway", Font.BOLD, 20));
        mail.setBounds(100, 315, 200, 30);
        add(mail);
        
        String edu[]={"Non-Graduation", "Graduate","Post-Graduate","Doctrate","Others"}; 
         education =new JComboBox(edu);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

         

        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 390, 200, 30);
        add(occu);
        
         String occ[]={"Salaried", "Self-Employed","Bussiness","Student","Retired","Others"}; 
        occupation =new JComboBox(occ);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


         

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

         aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

         sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

//         stateTextField = new JTextField();
//        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        stateTextField.setBounds(300, 540, 400, 30);
//        add(stateTextField);

        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

          eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

         eno = new JRadioButton("No");
        eno.setBounds(450, 590, 120, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exitAcco = new ButtonGroup();
        exitAcco.add(eyes);
        exitAcco.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String rel =(String)religion.getSelectedItem();
        String cate=(String)category.getSelectedItem();
        String inco=(String)income.getSelectedItem();
        String edu=(String)education.getSelectedItem();
        String occu=(String)occupation.getSelectedItem();
        String seni=null;
        if(syes.isSelected()){
            seni="Yes";   
        }
        else if(sno.isSelected())
            seni="No";
        
        String esist=null;
        if(eyes.isSelected())
            esist="Yes";
        else if(eno.isSelected())
            esist="No";
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        
        try{
            
                conn c=new conn();
String query = "insert into signuptwo values('" + formno+ "','" + rel + "','" + cate + "', '"+inco+"', '"+edu+"', '"+occu+"', '"+span+"', '"+saadhar+"', '"+seni+"', '"+esist+"')";
        c.s.executeUpdate(query);
         setVisible(false);
         
                new signupthree(formno).setVisible(true);
            

            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }

    public static void main(String[] args) {
        new SignupTwo("");    
    }
}
