import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JButton login,clear,signup;
    static JTextField cardnovalue;
    static JPasswordField PINvalue;
    Login()
    {
        setTitle("Automated Teller Machine");
        setLayout(null);
        setUndecorated(true);

        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg")).getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("WELCOME TO A.T.M.");
        text.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,35));
        text.setBounds(240,40,370,40);
        add(text);

        JLabel CardNo=new JLabel("Enter Your Card No.:");
        CardNo.setFont(new Font("BASKERVILLE",Font.ROMAN_BASELINE,20));
        CardNo.setBounds(125,160,190,40);
        add(CardNo);

        cardnovalue=new JTextField();
        cardnovalue.setFont(new Font("SANS SERIF",Font.BOLD,16));
        cardnovalue.setBounds(325,171,180,20);
        add(cardnovalue);

        JLabel PIN=new JLabel("Enter Your PIN:");
        PIN.setFont(new Font("BASKERVILLE",Font.ROMAN_BASELINE,20));
        PIN.setBounds(125,200,350,40);
        add(PIN);

        PINvalue=new JPasswordField();
        PINvalue.setFont(new Font("SANS SERIF",Font.BOLD,20));
        PINvalue.setBounds(325,210,180,20);
        add(PINvalue);

        login=new JButton("SIGN IN");
        login.setBounds(325,255,85,25);
        login.setBackground(new Color(44, 66, 245));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        signup=new JButton("SIGN UP");
        signup.setBounds(325,300,85,25);
        signup.setBackground(new Color(6, 219, 3));
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);

        JButton exit=new JButton("EXIT");
        exit.setBounds(420,300,85,25);
        exit.setBackground(new Color(248, 67, 67));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(e->{
            dispose();
        });

        clear=new JButton("CLEAR");
        clear.setBounds(420,255,85,25);
        clear.setBackground(Color.YELLOW);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(new Color(247, 240, 230));

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        JLabel label2=new JLabel(i2);
        add(label2);


        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardnovalue.setText("");
            PINvalue.setText("");
        }
        else if (ae.getSource()==signup)
        {
            setVisible(false);
            new SignUpFirst().setVisible(true);
        }
        else if (ae.getSource()==login)
        {
            ConnToDB db=new ConnToDB();
            String card_nmbr= cardnovalue.getText();
            String PIN= PINvalue.getText();
            String query="select * from login where cardnumber= '"+card_nmbr+"' and pin= '"+PIN+"'";
            try
            {
                ResultSet set=db.st.executeQuery(query);
                if(set.next())
                {
                    setVisible(false);
                    new Transactions(PIN).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}