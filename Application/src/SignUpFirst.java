import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;


public class SignUpFirst extends JFrame implements ActionListener {
    Long random;
    static JTextField name_val;
    JTextField fname_val;
    JTextField email_val;
    JTextField add_val;
    JTextField zip_val;
    JDateChooser date;
    JComboBox<String> select_city,select_state;
    JButton next;
    JRadioButton male,female,other_gender,married,unmarried,other_status;
    SignUpFirst() {
        setLayout(null);
        setUndecorated(true);

        random = Math.abs(new Random().nextLong() % 9000L) + 1000L;
        JLabel formNo = new JLabel("Application Form No. " + "" + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(160, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 23));
        personalDetails.setBounds(260, 80, 280, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        name.setBounds(105, 190, 100, 30);
        add(name);

        name_val = new JTextField();
        name_val.setFont(new Font("Raleway", Font.BOLD, 20));
        name_val.setBounds(350, 190, 400, 30);
        add(name_val);

        new TextPrompt("Your Full Name",name_val);

        JLabel father_name = new JLabel("Father's Name:");
        father_name.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        father_name.setBounds(105, 240, 200, 30);
        add(father_name);

        fname_val = new JTextField();
        fname_val.setFont(new Font("Raleway", Font.BOLD, 20));
        fname_val.setBounds(350, 240, 400, 30);
        add(fname_val);

        new TextPrompt("Father's Full Name",fname_val);

        JLabel DOB = new JLabel("Date Of Birth (DOB):");
        DOB.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        DOB.setBounds(105, 290, 350, 30);
        add(DOB);

        date = new JDateChooser();
        date.setForeground(new Color(96, 130, 182));
        date.setFont(new Font("Raleway", Font.BOLD, 17));
        date.setBounds(350, 290, 150, 30);
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        gender.setBounds(105, 340, 150, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350, 340, 70, 30);
        male.setBackground(new Color(217, 244, 230));
        male.setFont(new Font("Raleway", Font.BOLD, 18));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(440, 340, 90, 30);
        female.setBackground(new Color(217, 244, 230));
        female.setFont(new Font("Raleway", Font.BOLD, 18));
        add(female);

        other_gender = new JRadioButton("Other");
        other_gender.setBounds(550, 340, 90, 30);
        other_gender.setBackground(new Color(217, 244, 230));
        other_gender.setFont(new Font("Raleway", Font.BOLD, 18));
        add(other_gender);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other_gender);

        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        email.setBounds(105, 390, 150, 30);
        add(email);

        email_val = new JTextField();
        email_val.setFont(new Font("Raleway", Font.BOLD, 20));
        email_val.setBounds(350, 390, 400, 30);
        add(email_val);

        new TextPrompt("Enter your Email ID",email_val);

        JLabel marital_status = new JLabel("Marital Status:");
        marital_status.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        marital_status.setBounds(105, 440, 180, 30);
        add(marital_status);

        married = new JRadioButton("Married");
        married.setBounds(350, 440, 100, 30);
        married.setBackground(new Color(217, 244, 230));
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(470, 440, 130, 30);
        unmarried.setBackground(new Color(217, 244, 230));
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        add(unmarried);

        other_status = new JRadioButton("Other");
        other_status.setBounds(620, 440, 90, 30);
        other_status.setBackground(new Color(217, 244, 230));
        other_status.setFont(new Font("Raleway", Font.BOLD, 18));
        add(other_status);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other_status);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        address.setBounds(105, 490, 150, 30);
        add(address);

        add_val = new JTextField();
        add_val.setFont(new Font("Raleway", Font.BOLD, 20));
        add_val.setBounds(350, 490, 400, 30);
        add(add_val);

        new TextPrompt("Enter your full address",add_val);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        state.setBounds(105, 540, 150, 30);
        add(state);

        select_state = new JComboBox<String>(new values().states);
        select_state.setBounds(350, 540, 250, 30);
        select_state.setFont(new Font("Raleway",Font.BOLD,17));
        select_state.setBackground(Color.WHITE);
        select_state.setVisible(true);
        add(select_state);


        JLabel city = new JLabel("City:");
        city.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        city.setBounds(105, 590, 150, 30);
        add(city);

        select_city = new JComboBox<String>(new values().cities);
        select_city.setBounds(350, 590, 250, 30);
        select_city.setFont(new Font("Raleway",Font.BOLD,17));
        select_city.setBackground(Color.WHITE);
        select_city.setVisible(true);
        add(select_city);

        JLabel zip = new JLabel("ZipCode:");
        zip.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        zip.setBounds(105, 640, 150, 30);
        add(zip);


        zip_val = new JTextField();
        zip_val.setFont(new Font("Raleway", Font.BOLD, 20));
        zip_val.setBounds(350, 640, 100, 30);
        add(zip_val);

        next = new JButton("Next =>");
        next.setBackground(new Color(247, 240, 240, 229));
        next.setForeground(new Color(38, 4, 4));
        next.setBounds(660, 700, 90, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(217, 244, 230));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String formNo=""+random;
        String name=name_val.getText();
        String fname=fname_val.getText();
        String email=email_val.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=(male.isSelected())?"Male":(female.isSelected())?"Female":"Other";
        String marital=(married.isSelected())?"married":(unmarried.isSelected())?"unmarried":"other";
        String address=add_val.getText();
        String state=select_state.getSelectedItem().toString();
        String city=select_city.getSelectedItem().toString();
        String zipcode=zip_val.getText();
        try
        {
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Name is required");
            else if(fname.equals(""))
                JOptionPane.showMessageDialog(null,"Father's Name is required");
            else if(dob.equals(""))
                JOptionPane.showMessageDialog(null,"D.O.B. is required");
            else if(gender.equals(""))
                JOptionPane.showMessageDialog(null,"Gender is required");
            else if(email.equals(""))
                JOptionPane.showMessageDialog(null,"Email is required");
            else if(marital.equals(""))
                JOptionPane.showMessageDialog(null,"Marital Status is required");
            else if(address.equals(""))
                JOptionPane.showMessageDialog(null,"Address is required");
            else if(zipcode.equals(""))
                JOptionPane.showMessageDialog(null,"ZipCode is required");
            else if(state.equals(""))
                JOptionPane.showMessageDialog(null,"State is required");
            else if(city.equals(""))
                JOptionPane.showMessageDialog(null,"City is required");
            else
            {
                ConnToDB ob=new ConnToDB();
                String query="insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+zipcode+"','"+state+"')";
                ob.st.executeUpdate(query);
                setVisible(false);
                new SignUpSecond(""+random).setVisible(true);
            }

        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new SignUpFirst();
    }
}


class TextPrompt extends JLabel implements FocusListener, DocumentListener {
    JTextComponent component;
    Document document;

    public TextPrompt(String text, JTextComponent component) {
        this.component = component;
        document = component.getDocument();

        setText(text);
        setFont(component.getFont());
        setBorder(new EmptyBorder(component.getInsets()));

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.add(this);
    }

    public void checkForPrompt() {
        if (document.getLength() == 0)
            setSize(component.getSize());
        else
            setSize(0, 0);
    }

    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    public void focusLost(FocusEvent e) {
        setSize(0, 0);
    }


    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void changedUpdate(DocumentEvent e) {
    }

}