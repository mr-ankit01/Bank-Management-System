import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        back = new JButton("Back");
        back.setBounds(360,430,150,25);
        back.addActionListener(this);
        image.add(back);

         Conn c = new Conn();
         int ebalance =0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        ebalance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        ebalance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
            }catch(Exception e){
                System.out.println(e);
            }

            JLabel text =new JLabel("Your Current Account balance is RS:  " + ebalance);
            text.setForeground(Color.white);
            text.setBounds(210,250,400,30);
            image.add(text);

        setSize(900,750);
        setLocation(300,0);
        setVisible(true);
    }

    

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String[]args){
        new BalanceEnquiry("");
    }
}