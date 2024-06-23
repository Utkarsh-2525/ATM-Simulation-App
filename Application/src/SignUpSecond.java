import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpSecond extends JFrame implements ActionListener
{
     String formNo;
    JTextField nmbr_val, add_val, pan_val;
    JComboBox<String> occ_select,religion_select,category_select,income_select,ed_select;
    JButton next;
    JRadioButton senior,non_senior,acc0,acc1;
    SignUpSecond(String formNo)
    {
        this.formNo=formNo;
        setLayout(null);
        setUndecorated(true);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 23));
        additionalDetails.setBounds(260, 80, 320, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        religion.setBounds(105, 190, 130, 30);
        add(religion);


        religion_select = new JComboBox<String>(new values().religion);
        religion_select.setBounds(350, 190, 250, 30);
        religion_select.setFont(new Font("Raleway",Font.BOLD,17));
        religion_select.setBackground(Color.WHITE);
        religion_select.setVisible(true);
        add(religion_select);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        category.setBounds(105, 240, 200, 30);
        add(category);

        category_select = new JComboBox<String>(new values().category);
        category_select.setBounds(350, 240, 250, 30);
        category_select.setFont(new Font("Raleway",Font.BOLD,17));
        category_select.setBackground(Color.WHITE);
        category_select.setVisible(true);
        add(category_select);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        income.setBounds(105, 290, 350, 30);
        add(income);

        income_select = new JComboBox<String>(new values().income);
        income_select.setBounds(350, 290, 250, 30);
        income_select.setFont(new Font("Raleway",Font.BOLD,17));
        income_select.setBackground(Color.WHITE);
        income_select.setVisible(true);
        add(income_select);


        JLabel education = new JLabel("Educational ");
        education.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        education.setBounds(105, 340, 150, 30);
        add(education);
        education=new JLabel("Qualification:");
        education.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        education.setBounds(105, 370, 180, 30);
        add(education);

        ed_select = new JComboBox<String>(new values().education);
        ed_select.setBounds(350, 370, 250, 30);
        ed_select.setFont(new Font("Raleway",Font.BOLD,17));
        ed_select.setBackground(Color.WHITE);
        ed_select.setVisible(true);
        add(ed_select);

        JLabel nmbr = new JLabel("Phone Number:");
        nmbr.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        nmbr.setBounds(105, 420, 200, 30);
        add(nmbr);
        JLabel temp = new JLabel("+91");
        temp.setFont(new Font("SANS SERIF", Font.BOLD, 20));
        temp.setBounds(350, 420, 40, 30);
        add(temp);


        nmbr_val = new JTextField();
        nmbr_val.setFont(new Font("Raleway", Font.BOLD, 20));
        nmbr_val.setBounds(400, 420, 200, 30);
        add(nmbr_val);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        occ.setBounds(105, 470, 150, 30);
        add(occ);

        occ_select = new JComboBox<String>(new values().occupation);
        occ_select.setBounds(350, 470, 250, 30);
        occ_select.setFont(new Font("Raleway",Font.BOLD,17));
        occ_select.setBackground(Color.WHITE);
        occ_select.setVisible(true);
        add(occ_select);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        aadhar.setBounds(105, 520, 220, 30);
        add(aadhar);

        add_val = new JTextField();
        add_val.setFont(new Font("Raleway", Font.BOLD, 20));
        add_val.setBounds(350, 520, 250, 30);
        add(add_val);

        new TextPrompt("Aadhar Card Number",add_val);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        pan.setBounds(105, 570, 220, 30);
        add(pan);
        pan=new JLabel("(Permanent Account Number)");
        pan.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
        pan.setBounds(105, 589, 220, 30);
        add(pan);


        pan_val = new JTextField();
        pan_val.setFont(new Font("Raleway", Font.BOLD, 20));
        pan_val.setBounds(350, 570, 250, 30);
        add(pan_val);
        new TextPrompt("PAN Number",pan_val);

        new TextPrompt("Aadhar Card Number",add_val);

        JLabel acc = new JLabel("Existing Account:");
        acc.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        acc.setBounds(105, 635, 250, 30);
        add(acc);

        acc1 = new JRadioButton("Yes");
        acc1.setBounds(350, 635, 100, 30);
        acc1.setBackground(new Color(217, 244, 230));
        acc1.setFont(new Font("Raleway", Font.BOLD, 18));
        add(acc1);

        acc0 = new JRadioButton("No");
        acc0.setBounds(470, 635, 130, 30);
        acc0.setBackground(new Color(217, 244, 230));
        acc0.setFont(new Font("Raleway", Font.BOLD, 18));
        add(acc0);


        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(acc0);
        maritalgroup.add(acc1);


        JLabel seniority = new JLabel("Senior Citizen:");
        seniority.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        seniority.setBounds(105, 685, 200, 30);
        add(seniority);

        senior = new JRadioButton("Yes");
        senior.setBounds(350, 685, 100, 30);
        senior.setBackground(new Color(217, 244, 230));
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        add(senior);

        non_senior = new JRadioButton("No");
        non_senior.setBounds(470, 685, 130, 30);
        non_senior.setBackground(new Color(217, 244, 230));
        non_senior.setFont(new Font("Raleway", Font.BOLD, 18));
        add(non_senior);

        ButtonGroup senior_citizen = new ButtonGroup();
        senior_citizen.add(senior);
        senior_citizen.add(non_senior);



        next = new JButton("Next =>");
        next.setBackground(new Color(247, 240, 240, 229));
        next.setForeground(new Color(38, 4, 4));
        next.setBounds(676, 740, 90, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(217, 244, 230));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String religion=religion_select.getSelectedItem().toString();
        String category=category_select.getSelectedItem().toString();
        String income=income_select.getSelectedItem().toString();
        String seniority=(senior.isSelected())?"Yes":"No";
        String exists=(acc1.isSelected())?"Yes":"No";
        String education=ed_select.getSelectedItem().toString();
        String nmbr=nmbr_val.getText();
        String aadhar=add_val.getText();
        String pan=pan_val.getText();
        String job=occ_select.getSelectedItem().toString();
        try
        {
            if(religion.equals(""))
                JOptionPane.showMessageDialog(null,"Select Religion!");
            else if(category.equals(""))
                JOptionPane.showMessageDialog(null,"Select Category!");
            else if(income.equals(""))
                JOptionPane.showMessageDialog(null,"Income is required");
            else if(education.equals(""))
                JOptionPane.showMessageDialog(null,"Education is required!");
            else if(nmbr.equals(""))
                JOptionPane.showMessageDialog(null,"Mobile Number is required!");
            else if(job.equals(""))
                JOptionPane.showMessageDialog(null,"Job Status is required!");
            else if(aadhar.equals(""))
                JOptionPane.showMessageDialog(null,"Aadhar Number is required!");
            else if(pan.equals(""))
                JOptionPane.showMessageDialog(null,"PAN is required!");
            else if(exists.equals(""))
                JOptionPane.showMessageDialog(null,"Select Account Existence!");
            else if(seniority.equals(""))
                JOptionPane.showMessageDialog(null,"Seniority Status is required!");

            else
            {
                ConnToDB ob=new ConnToDB();
                String query="insert into signuptwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+nmbr+"','"+job+"','"+pan+"','"+aadhar+"','"+seniority+"','"+exists+"')";
                ob.st.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new SignUpSecond("");
    }
}