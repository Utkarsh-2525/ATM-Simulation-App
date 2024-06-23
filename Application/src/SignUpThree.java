import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener
{
    JRadioButton acc_savings,acc_FD,acc_curr,acc_RD;
    JCheckBox srvc_ATM,srvc_MB,srvc_CB,srvc_IB,srvc_E_SMS,srvc_E_statmnt,ackment;
    JButton submit,cancel;
    String formNo;
    SignUpThree(String formNo)
    {
        this.formNo=formNo;
        setLayout(null);
        setUndecorated(true);

        JLabel label=new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway", Font.BOLD, 23));
        label.setBounds(275, 70, 320, 30);
        add(label);

        JLabel account = new JLabel("Select Account type:");
        account.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        account.setBounds(105, 190, 350, 30);
        add(account);

        acc_savings=new JRadioButton("Savings Account");
        acc_savings.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_savings.setBounds(115,230,190,20);
        acc_savings.setBackground(new Color(255, 252, 252));
        add(acc_savings);

        acc_curr=new JRadioButton("Current Account");
        acc_curr.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_curr.setBounds(115,270,190,20);
        acc_curr.setBackground(new Color(255, 252, 252));
        add(acc_curr);

        acc_FD=new JRadioButton("Fixed Deposit Account");
        acc_FD.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_FD.setBounds(385,230,250,20);
        acc_FD.setBackground(new Color(255, 252, 252));
        add(acc_FD);

        acc_RD=new JRadioButton("Recurring Deposit Account");
        acc_RD.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_RD.setBounds(385,270,265,20);
        acc_RD.setBackground(new Color(255, 252, 252));
        add(acc_RD);

        ButtonGroup acc=new ButtonGroup();
        acc.add(acc_curr);
        acc.add(acc_savings);
        acc.add(acc_RD);
        acc.add(acc_FD);

        JLabel card_nmbr=new JLabel("Card Number:");
        card_nmbr.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        card_nmbr.setBounds(105, 370, 350, 30);
        add(card_nmbr);
        card_nmbr=new JLabel("Your 16 Digit Card Number");
        card_nmbr.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
        card_nmbr.setBounds(108, 395, 220, 20);
        add(card_nmbr);
        card_nmbr=new JLabel("XXXX-XXXX-XXXX-XXXX");
        card_nmbr.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        card_nmbr.setBounds(385, 370, 350, 30);
        add(card_nmbr);

        JLabel services_required=new JLabel("Services Required:");
        services_required.setFont(new Font("SANS SERIF", Font.BOLD, 23));
        services_required.setBounds(105, 470, 350, 30);
        add(services_required);

        srvc_ATM=new JCheckBox("ATM Card");
        srvc_ATM.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_ATM.setBounds(115,510,190,20);
        srvc_ATM.setBackground(new Color(255, 252, 252));
        add(srvc_ATM);

        srvc_MB=new JCheckBox("Mobile Banking");
        srvc_MB.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_MB.setBounds(115,550,250,20);
        srvc_MB.setBackground(new Color(255, 252, 252));
        add(srvc_MB);

        srvc_CB=new JCheckBox("Cheque Book");
        srvc_CB.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_CB.setBounds(115,590,265,20);
        srvc_CB.setBackground(new Color(255, 252, 252));
        add(srvc_CB);

        srvc_IB=new JCheckBox("Internet Banking");
        srvc_IB.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_IB.setBounds(385,510,190,20);
        srvc_IB.setBackground(new Color(255, 252, 252));
        add(srvc_IB);

        srvc_E_SMS=new JCheckBox("EMAIL & SMS Alerts");
        srvc_E_SMS.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_E_SMS.setBounds(385,550,265,20);
        srvc_E_SMS.setBackground(new Color(255, 252, 252));
        add(srvc_E_SMS);

        srvc_E_statmnt=new JCheckBox("E-Statement");
        srvc_E_statmnt.setFont(new Font("Raleway", Font.BOLD, 18));
        srvc_E_statmnt.setBounds(385,590,265,20);
        srvc_E_statmnt.setBackground(new Color(255, 252, 252));
        add(srvc_E_statmnt);

        ackment=new JCheckBox("I, hereby declare that all the details entered are true and best of my knowledge.");
        ackment.setFont(new Font("Raleway", Font.BOLD, 16));
        ackment.setBounds(115,690,850,20);
        ackment.setBackground(new Color(255, 252, 252));
        add(ackment);

        submit=new JButton("Submit");
        submit.setBounds(320,730,85,25);
        submit.setBackground(new Color(6, 219, 3));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(440,730,85,25);
        cancel.setBackground(new Color(220, 2, 41));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(255, 252, 252));
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(acc_savings.isSelected())
                accountType="Savings Account";
            else if(acc_curr.isSelected())
                accountType="Current Account";
            else if(acc_RD.isSelected())
                accountType="Recurring Deposit Account";
            else if(acc_FD.isSelected())
                accountType="Fixed Deposit Account";

            String cardnmbr=""+Math.abs(new Random().nextLong()%900000000000L)+2573L;
            String pin_nmbr=""+Math.abs(new Random().nextInt())%9000;
            if(pin_nmbr.length()==3)
                pin_nmbr=0+pin_nmbr;

            String facility="";
            if(srvc_ATM.isSelected())
                facility+="ATM CARD ";
            if(srvc_MB.isSelected())
                facility+="Mobile Banking ";
            if(srvc_IB.isSelected())
                facility+="Internet Banking ";
            if(srvc_E_SMS.isSelected())
                facility+="EMAIL & SMS ALERTS ";
            if(srvc_E_statmnt.isSelected())
                facility+="E-Statement ";
            if(srvc_CB.isSelected())
                facility+="Cheque Book ";

            try
            {
                if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null,"Select Account Type");
                else if(!ackment.isSelected())
                    JOptionPane.showMessageDialog(null,"Kindly Acknowledge the declaration");
                else
                {
                    ConnToDB obj=new ConnToDB();
                    String query="insert into signupthree values('"+formNo+"','"+accountType+"','"+cardnmbr+"','"+pin_nmbr+"','"+facility+"')";
                    String query1="insert into login values('"+formNo+"','"+cardnmbr+"','"+pin_nmbr+"')";
                    obj.st.executeUpdate(query);
                    obj.st.executeUpdate(query1);
                }
                JOptionPane.showMessageDialog(null,"Card Number: "+cardnmbr+"\n PIN Number: "+pin_nmbr);
                setVisible(false);
                new Login();
//                new Deposit(pin_nmbr).setVisible(false);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new SignUpThree("");
    }
}
