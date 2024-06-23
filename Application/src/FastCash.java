import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton deposit,withdraw,PINchng,fastCash,MiniStatmnt,balance,exit;
    String PIN;
    FastCash(String PIN)
    {
        this.PIN=PIN;
        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Please select withdrawal amount");
        text.setBounds(225,300,700,35);
        text.setFont(new Font("System",Font.BOLD,18));
        label.add(text);

        deposit=new JButton("₹100");
        deposit.setBackground(new Color(55, 6, 245));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(160,392,165,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw=new JButton("₹500");
        withdraw.setBounds(403,392,165,30);
        withdraw.setBackground(new Color(55, 6, 245));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastCash=new JButton("₹1000");
        fastCash.setBackground(new Color(55, 6, 245));
        fastCash.setForeground(Color.WHITE);
        fastCash.setFont(new Font("System",Font.BOLD,16));
        fastCash.setBounds(160,430,165,30);
        fastCash.addActionListener(this);
        label.add(fastCash);

        MiniStatmnt=new JButton("₹2000");
        MiniStatmnt.setBackground(new Color(55, 6, 245));
        MiniStatmnt.setForeground(Color.WHITE);
        MiniStatmnt.setFont(new Font("System",Font.BOLD,16));
        MiniStatmnt.setBounds(160,468,165,30);
        MiniStatmnt.addActionListener(this);
        label.add(MiniStatmnt);

        balance=new JButton("₹5000");
        balance.setBackground(new Color(55, 6, 245));
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System",Font.BOLD,16));
        balance.setBounds(403,430,166,30);
        balance.addActionListener(this);
        label.add(balance);

        PINchng=new JButton("₹10000");
        PINchng.setBackground(new Color(55, 6, 245));
        PINchng.setForeground(Color.WHITE);
        PINchng.setFont(new Font("System",Font.BOLD,16));
        PINchng.setBounds(403,468,167,30);
        PINchng.addActionListener(this);
        label.add(PINchng);

        exit=new JButton("Back");
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
        if(ae.getSource()==exit) {
            setVisible(false);
            new Transactions(PIN).setVisible(true);
        }
        else
        {
            String amt=((JButton)ae.getSource()).getText().substring(1);
            ConnToDB obj=new ConnToDB();
            try
            {
                ResultSet set=obj.st.executeQuery("select * from bank where pin='"+PIN+"'");
                int balance=0;
                while(set.next())
                {
                    if(set.getString("type").equals("Deposit"))
                        balance+=Integer.parseInt(set.getString("amount"));
                    else
                        balance-=Integer.parseInt(set.getString("amount"));
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amt))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+PIN+"','"+date+"','Withdraw','"+amt+"')";
                obj.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"₹"+amt+" debited Successfully!");
                setVisible(false);
                new Transactions(PIN).setVisible(true);            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
    }
    public  static void main(String[] args)
    {
        new FastCash("");
    }
}
