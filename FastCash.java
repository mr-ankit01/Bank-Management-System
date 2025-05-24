import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class FastCash extends JFrame implements ActionListener{

    JButton deposit,withdraw,ministatement,pinchange,fastcash,balance,exit;
    String pinnumber;

    FastCash(String pinnumber){

        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(240,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,345,150,22);
        deposit.addActionListener(this);
        image.add(deposit);
    
        withdraw = new JButton("Rs 500");
        withdraw.setBounds(350,345,150,22);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,375,150,22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(350,375,150,22);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,405,150,22);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Rs 10,000");
        balance.setBounds(350,405,150,22);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Back");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int ebalance =0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        ebalance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        ebalance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!=exit && ebalance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','"+withdraw+"','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs" +amount+ "Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    } 
}
