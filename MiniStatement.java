import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder miniStatementHtml = new StringBuilder("<html>");
            while (rs.next()) {
                miniStatementHtml.append(rs.getString("date"))
                                 .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                                 .append(rs.getString("type"))
                                 .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                                 .append(rs.getString("amount"))
                                 .append("<br><br>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            miniStatementHtml.append("</html>");
            mini.setText(miniStatementHtml.toString());

            balance.setText("Your current account balance is Rs: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
