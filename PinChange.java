import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
// import javax.swing.JTextArea;
// import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("atm.jpg")));
        Image i2 = i1.getImage().getScaledInstance(900, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,250,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,290,180,20);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(330,290,180,20);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,320,180,20);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(330,320,180,20);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(330,400,150,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(330,430,150,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,750);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change) {
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null,"Enter PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update SignUP3 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);


            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
