import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Transaction extends JFrame implements ActionListener{

    JButton deposit,withdraw,ministatement,pinchange,fastcash,balance,exit;
    String pinnumber;

    Transaction(String pinnumber){

        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,345,150,22);
        deposit.addActionListener(this);
        image.add(deposit);
    
        withdraw = new JButton("Cash Withdrawl");
        withdraw.setBounds(350,345,150,22);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fash Cash");
        fastcash.setBounds(170,375,150,22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(350,375,150,22);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(170,405,150,22);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(350,405,150,22);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(260,435,150,22);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        // setUndecorated(true);
        setVisible(true);
        
    }   

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit) {
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()==pinchange) {
            setVisible(true);
            new PinChange(pinnumber).setVisible(true);        
        }else if (ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement) {
            // setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    } 
}
