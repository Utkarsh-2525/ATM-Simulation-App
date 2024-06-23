import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposit,withdraw,PINchng,fastCash,MiniStatmnt,balance,exit;
    String PIN;
    Transactions(String PIN)
    {
        this.PIN=PIN;
        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(225,300,700,35);
        text.setFont(new Font("System",Font.BOLD,18));
        label.add(text);

        deposit=new JButton("Deposit");
        deposit.setBackground(new Color(55, 6, 245));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(160,392,165,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw=new JButton("Cash Withdrawal");
        withdraw.setBounds(403,392,165,30);
        withdraw.setBackground(new Color(55, 6, 245));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastCash=new JButton("Fast Cash");
        fastCash.setBackground(new Color(55, 6, 245));
        fastCash.setForeground(Color.WHITE);
        fastCash.setFont(new Font("System",Font.BOLD,16));
        fastCash.setBounds(160,430,165,30);
        fastCash.addActionListener(this);
        label.add(fastCash);

        MiniStatmnt=new JButton("Mini Statement");
        MiniStatmnt.setBackground(new Color(55, 6, 245));
        MiniStatmnt.setForeground(Color.WHITE);
        MiniStatmnt.setFont(new Font("System",Font.BOLD,16));
        MiniStatmnt.setBounds(160,468,165,30);
        MiniStatmnt.addActionListener(this);
        label.add(MiniStatmnt);

        balance=new JButton("Balance Enquiry");
        balance.setBackground(new Color(55, 6, 245));
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System",Font.BOLD,16));
        balance.setBounds(403,430,166,30);
        balance.addActionListener(this);
        label.add(balance);

        PINchng=new JButton("PIN Change");
        PINchng.setBackground(new Color(55, 6, 245));
        PINchng.setForeground(Color.WHITE);
        PINchng.setFont(new Font("System",Font.BOLD,16));
        PINchng.setBounds(403,468,167,30);
        PINchng.addActionListener(this);
        label.add(PINchng);

        exit=new JButton("EXIT");
        exit.setBackground(new Color(245, 6, 14));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System",Font.BOLD,16));
        exit.setBounds(403,509,167,30);
        exit.addActionListener(this);
        label.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
            System.exit(0);
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(PIN).setVisible(true);
        }
        else if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new Withdrawal(PIN).setVisible(true);
        }
        else if(ae.getSource()==fastCash)
        {
            setVisible(false);
            new FastCash(PIN).setVisible(true);
        }
        else if(ae.getSource()==PINchng)
        {
            setVisible(false);
            new PinChange(PIN).setVisible(true);
        }
        else if(ae.getSource()==balance)
        {
            setVisible(false);
            new BalanceEnquiry(PIN).setVisible(true);
        }
        else if(ae.getSource()==MiniStatmnt)
        {
            new MiniStatement(PIN).setVisible(true);
        }
    }
    public  static void main(String[] args)
    {
        new Transactions("");
    }
}
