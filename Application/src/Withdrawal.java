import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amt;
    String PIN;

    Withdrawal(String PIN) {
        this.PIN = PIN;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")).getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(i1);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Enter amount to Withdraw:");
        text.setFont(new Font("System", Font.BOLD, 17));
        text.setBounds(170, 220, 400, 20);
        label.add(text);

        amt = new JTextField();
        amt.setFont(new Font("Raleway", Font.BOLD, 16));
        amt.setBounds(170, 270, 200, 25);
        amt.setBackground(new Color(232, 247, 233));
        amt.setForeground(Color.BLACK);
        label.add(amt);

        withdraw = new JButton("WithDraw");
        withdraw.setBackground(new Color(2, 116, 3));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.setBounds(403, 468, 167, 30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back = new JButton("Back");
        back.setBackground(new Color(245, 6, 14));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(403, 509, 167, 30);
        back.addActionListener(this);
        label.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(PIN).setVisible(true);
        } else {
            String amount = amt.getText();
            Date date = new Date();
            if (amount == "")
                JOptionPane.showMessageDialog(null, "Deposit Amount cannot be Empty!");
            else {
                ConnToDB obj = new ConnToDB();
                int balance=0;
                try {
                    ResultSet set = obj.st.executeQuery("select * from bank where pin='"+PIN+"'");
                    while (set.next()) {
                        if (set.getString("type").equals("Deposit"))
                            balance += Integer.parseInt(set.getString("amount"));
                        else
                            balance -= Integer.parseInt(set.getString("amount"));
                    }
                    if(balance>Integer.parseInt(amount)){
                        String query = "insert into bank values('" + PIN + "','" + date + "','Withdraw','" + amount + "')";
                        obj.st.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "₹" + amount + " withdrawn successfully");
                        setVisible(false);
                        new Transactions(PIN).setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                        return;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}