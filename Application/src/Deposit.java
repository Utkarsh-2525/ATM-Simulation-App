import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener
{
    JButton deposit,back;
    JTextField amt;
    String PIN;
    Deposit(String PIN)
    {
        this.PIN=PIN;
        setLayout(null);
        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Enter amount to deposit:");
        text.setFont(new Font("System",Font.BOLD,17));
        text.setBounds(170,220,400,20);
        label.add(text);

        amt=new JTextField();
        amt.setFont(new Font("Raleway",Font.BOLD,16));
        amt.setBounds(170,270,200,25);
        amt.setBackground(new Color(232, 247, 233));
        amt.setForeground(Color.BLACK);
        label.add(amt);

        deposit=new JButton("Deposit");
        deposit.setBackground(new Color(2, 116, 3));
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(403,468,167,30);
        deposit.addActionListener(this);
        label.add(deposit);

        back=new JButton("Back");
        back.setBackground(new Color(245, 6, 14));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System",Font.BOLD,16));
        back.setBounds(403,509,167,30);
        back.addActionListener(this);
        label.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(PIN).setVisible(true);
        }
        else
        {
            String amount=amt.getText();
            Date date=new Date();
            if(amount=="")
                JOptionPane.showMessageDialog(null,"Deposit Amount cannot be Empty!");
            else {
                try {
                ConnToDB obj=new ConnToDB();
                String query="insert into bank values('"+PIN+"','"+date+"','Deposit','"+amount+"')";
                obj.st.executeUpdate(query);
                setVisible(false);
                new Transactions(PIN).setVisible(true);
                }
                catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                JOptionPane.showMessageDialog(null,"₹"+amount+" deposited successfully");
            }
        }
    }
    public static void main(String[] args)
    {
        new Deposit("");
    }
}
