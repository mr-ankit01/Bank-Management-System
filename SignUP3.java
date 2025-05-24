import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUP3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignUP3(String formno) {
        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("Page-3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 140, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 140, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 180, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 180, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 240, 200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3565");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 240, 300, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 270, 300, 20);
        add(cardDetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 310, 200, 30);
        add(pin);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pNumber.setBounds(330, 310, 300, 30);
        add(pNumber);

        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 340, 300, 20);
        add(pinDetails);

        JLabel service = new JLabel("Services Required");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 390, 200, 30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(100, 440, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(350, 440, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(100, 490, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(350, 490, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(100, 540, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        c6.setBounds(350, 540, 300, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 590, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 640, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 640, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility = facility + " Email & SMS Alert";
            }
            if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into SignUP3 values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n PIN: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            // Action for cancel button
            setVisible(false);
            new Login().setVisible(true);
            // Optionally, you can add code here to navigate to a previous screen or close the application
        }
    }

    public static void main(String[] args) {
        new SignUP3("");
    }
}
