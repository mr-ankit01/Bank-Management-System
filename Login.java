import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JButton login, SignUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label); 

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        // pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear=new JButton("clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        SignUp=new JButton("SIGN UP");
        SignUp.setBounds(300,350,230,30);
        SignUp.setBackground(Color.black);
        SignUp.setForeground(Color.white);
        SignUp.addActionListener(this);
        add(SignUp);

        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == clear) {
        cardTextField.setText("");
        pinTextField.setText("");
    } else if (ae.getSource() == login) {
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "select * from login where cardnumber='" + cardnumber + "' and pin ='" + pinnumber + "'";
        try {
            ResultSet r = conn.s.executeQuery(query);
            if (r.next()) {
                // setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == SignUp) {
        setVisible(false);
        new SignUP1().setVisible(true);
    }
}

    public static void main(String[] args) {
        new Login();
    }
}