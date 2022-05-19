import java.awt.*;
import javax.swing.*;

public class accountInformation extends AtmMachine{
    JFrame frame = new JFrame();
    JLabel imageLabel = new JLabel();
    JLabel firstName = new JLabel("First name:");
    JLabel lastName = new JLabel("Last name:");
    JLabel username = new JLabel("Username:");
    JLabel address = new JLabel("Address:");
    JLabel fn = new JLabel(accountInformation[0]); // The users first name
    JLabel ln = new JLabel(accountInformation[1]); // The users last name
    JLabel un = new JLabel(accountInformation[2]); // The users username
    JLabel adr = new JLabel(accountInformation[3]); // The users address
    public accountInformation() {
        frame.setSize(500,500);
        frame.setResizable(false);
        imageLabel.setFont(new Font(null, Font.BOLD, 20));
        frame.setVisible(true);
        imageLabel.setIcon(new ImageIcon("/Users/etu/Dropbox/My Mac (Etus-MacBook-Air.local)/Documents/defaultProfilePic.jpeg"));
        imageLabel.setText("Account Information");
        frame.add(imageLabel);
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel.setVerticalTextPosition(JLabel.TOP);
        imageLabel.add(firstName); imageLabel.add(lastName); imageLabel.add(username); imageLabel.add(address);
        imageLabel.add(fn); imageLabel.add(ln); imageLabel.add(un); imageLabel.add(adr);
        firstName.setBounds(15, 370, 75, 30);
        lastName.setBounds(15, 390, 75, 30);
        username.setBounds(15, 410, 75, 30);
        address.setBounds(15, 430, 75, 30);
        fn.setBounds(95, 370, 75, 30);
        ln.setBounds(95, 390, 75, 30);
        un.setBounds(95, 430, 200, 30);
        adr.setBounds(95, 410, 75, 30);
        adr.setSize(200, 30);
        
    }
}