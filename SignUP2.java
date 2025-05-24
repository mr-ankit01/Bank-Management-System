import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignUP2 extends JFrame implements ActionListener{

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sNO, eyes, eNO;
    JComboBox religion,category,occupation,education,income;
    String formno;

    SignUP2(String formno){

        this.formno=formno;

        setLayout(null);

        setTitle("New Account Application Form:Page-2");



        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]= {"General","OBC","SC","ST","Other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomecategory[]= {"NUll","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational /");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String educationalvalue[]= {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        education=new JComboBox(educationalvalue);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationalvalue[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation=new JComboBox(occupationalvalue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sNO= new JRadioButton("NO");
        sNO.setBounds(400,540,100,30);
        sNO.setBackground(Color.white);
        add(sNO);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sNO);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eNO = new JRadioButton("NO");
        eNO.setBounds(400,590,100,30);
        eNO.setBackground(Color.white);
        add(eNO);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eNO);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        }

    public void actionPerformed(ActionEvent ae){
        // String formno = "" + random;
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        }
        else if (sNO.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        }
        else if(eNO.isSelected()){
            existingaccount = "No";
        }


        String span = pan.getText();
        String saadhar = aadhar.getText();

        try{
                Conn c = new Conn();
                String query = "insert into SignUP2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existingaccount+"','"+seniorcitizen+"')";

                c.s.executeUpdate(query);

                setVisible(false);
                new SignUP3(formno).setVisible(true);

                //signup3 object
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    
    public static void main(String[] args) {
        new SignUP2("");
    }
}
