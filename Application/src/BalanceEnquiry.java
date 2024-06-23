import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back;
    String Pin_Num;
    BalanceEnquiry(String Pin_Num)
    {
        this.Pin_Num=Pin_Num;
        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,900,900);
        add(label);

        back=new JButton("BACK");
        back.setBounds(415,510,150,32);
        back.setBackground(new Color(252, 252, 126));
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        label.add(back);

        ConnToDB obj=new ConnToDB();
        int balance = 0;
        try {
            ResultSet set = obj.st.executeQuery("select * from bank where pin='"+Pin_Num+"'");
            while (set.next()) {
                if (set.getString("type").equals("Deposit"))
                    balance += Integer.parseInt(set.getString("amount"));
                else
                    balance -= Integer.parseInt(set.getString("amount"));
            }
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        JLabel l1=new JLabel("Your current balance: ₹"+balance);
//        l1.setBackground(new Color(197, 220, 242));
        l1.setBounds(170,300,500,30);
        l1.setFont(new Font("System",Font.BOLD,20));
        label.add(l1);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(Pin_Num).setVisible(true);
    }

    public static void main(String[] args)
    {
        new BalanceEnquiry("");
    }
}
