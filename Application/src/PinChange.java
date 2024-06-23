import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener
{
    String PIN_Num;
    JPasswordField PIN,RePIN;
    JButton change,back;
    PinChange(String PIN_Num)
    {
        this.PIN_Num=PIN_Num;
        ImageIcon i1=new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Change Your PIN");
        text.setBounds(275,200,700,35);
        text.setFont(new Font("System",Font.BOLD,25));
        label.add(text);

        JLabel PINtext=new JLabel("New PIN");
        PINtext.setBounds(165,325,200,20);
        PINtext.setFont(new Font("System",Font.BOLD,18));
        label.add(PINtext);

        PIN=new JPasswordField();
        PIN.setBounds(370,325,150,20);
        PIN.setFont(new Font("System",Font.BOLD,18));
        PIN.setBackground(new Color(197, 220, 242));
        label.add(PIN);

        JLabel RePINtext=new JLabel("Re-Enter New PIN");
        RePINtext.setBounds(165,365,250,20);
        RePINtext.setFont(new Font("System",Font.BOLD,18));
        label.add(RePINtext);

        RePIN=new JPasswordField();
        RePIN.setBounds(370,365,150,20);
        RePIN.setBackground(new Color(197, 220, 242));
        RePIN.setFont(new Font("System",Font.BOLD,18));
        label.add(RePIN);

        change=new JButton("CHANGE PIN");
        change.setBounds(415,467,150,32);
        change.setBackground(new Color(143, 247, 134));
        change.setFont(new Font("System",Font.BOLD,16));
        change.addActionListener(this);
        label.add(change);

        back=new JButton("BACK");
        back.setBounds(415,510,150,32);
        back.setBackground(new Color(252, 252, 126));
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        label.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
            try{
                String N_PIN=PIN.getText();
                String Re_PIN=RePIN.getText();
                if(!N_PIN.equals(Re_PIN)) {
                    JOptionPane.showMessageDialog(null, "New and Re-Enter does not match!");
                    return;
                }
                if(N_PIN=="" || Re_PIN=="") {
                    JOptionPane.showMessageDialog(null, "New PIN cannot be empty!!");
                    return;
                }
                ConnToDB obj=new ConnToDB();
                String bank="update bank set pin= '"+N_PIN+"' where pin='"+PIN_Num+"'";
                String login="update login set pin= '"+N_PIN+"' where pin='"+PIN_Num+"'";
                String signupthree="update signupthree set pin= '"+N_PIN+"' where pin='"+PIN_Num+"'";

                obj.st.executeUpdate(bank);
                obj.st.executeUpdate(login);
                obj.st.executeUpdate(signupthree);

                JOptionPane.showMessageDialog(null, "PIN successfully changed!");
                setVisible(false);
                new Transactions(N_PIN).setVisible(true);
            }
            catch(Exception exc)
            {
                System.out.println(exc);
            }
        }
        else{
            setVisible(false);
            new Transactions(PIN_Num).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new PinChange("").setVisible(true);
    }
}
