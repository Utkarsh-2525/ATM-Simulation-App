import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener
{
    JButton print, back;
    JLabel CardNo;
    MiniStatement(String PIN)
    {
        setTitle("Mini Statement");
        setLayout(null);

        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/Melogo.png")).getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(255,500,150,150);
        add(label);

        JLabel values=new JLabel();
        add(values);

        JLabel balance=new JLabel();
        balance.setBounds(35,350,250,30);
        add(balance);

        back=new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,13));
        back.setBounds(22,550,80,20);
        back.addActionListener(this);
        add(back);


        print=new JButton("PRINT");
        print.setFont(new Font("System",Font.BOLD,13));
        print.setBounds(150,550,80,20);
        print.addActionListener(this);
        add(print);


        JLabel title=new JLabel("Bank by M.Utkarsh");
        title.setBounds(95,15,200,30);
        title.setFont(new Font("Cadre",Font.PLAIN,22));
        add(title);
        title=new JLabel("Github Profile: https://github.com/Utkarsh-2525");
        title.setBounds(35,40,350,20);
        title.setFont(new Font("Cadre",Font.PLAIN,14));
        add(title);
        title=new JLabel("-----------------Mini Statement-----------------");
        title.setBounds(22,90,400,20);
        title.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(title);

        CardNo=new JLabel();
        CardNo.setFont(new Font("Times New Roman",Font.BOLD,18));
        CardNo.setBounds(35,150,400,30);
        add(CardNo);

        try{
            ConnToDB obj=new ConnToDB();
            ResultSet set=obj.st.executeQuery("select * from login where pin='"+PIN+"'");
            while(set.next())
            {
                CardNo.setText("Card Number: "+set.getString("cardnumber").substring(0,4)+"XXXXXXXX"+set.getString("cardnumber").substring(12));
            }
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        try{
            ConnToDB obj=new ConnToDB();
            int AvBal=0;
            ResultSet set=obj.st.executeQuery("select * from bank where pin='"+PIN+"'");
            while(set.next())
            {
                if(set.getString("type").equals("Deposit")) {
                    values.setText(values.getText() + "<html>" + set.getString("date").substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + set.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + set.getString("amount") + "<br>");
                    AvBal += Integer.parseInt(set.getString("amount"));
                }
                else {
                    values.setText(values.getText() + "<html>" + set.getString("date").substring(0, 10) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + set.getString("type") + "&nbsp;&nbsp;&nbsp;" + set.getString("amount") + "<br>");
                    AvBal -= Integer.parseInt(set.getString("amount"));
                }
            }
            balance.setText("Current balance: ₹"+ AvBal);
            balance.setFont(new Font("Times New Roman",Font.BOLD,17));
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        values.setBounds(35,200,400,100);
        values.setFont(new Font("Times New Roman",Font.BOLD,14));

        setUndecorated(true);
        setSize(400,600);
        setLocation(900,200);
        getContentPane().setBackground(new Color(238, 248, 245, 255));
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==print)
                new GeneratePDF(Login.cardnovalue.getText());
        setVisible(false);
    }
    public static void main(String[] args)
    {
        new MiniStatement("");
    }
}
