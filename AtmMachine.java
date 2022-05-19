import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.HashMap;
import javax.swing.JOptionPane;  
public class AtmMachine extends JFrame implements ActionListener{
     private double balance;                              
     private double previousTransaction;
     static JFrame frame;
     static JLabel loginUserLabel = new JLabel("Username");
     static JLabel loginPassLabel = new JLabel("Password");
     static JLabel createFirstNameLabel = new JLabel("First name");
     static JLabel createLastNameLabel = new JLabel("Last name");
     static JLabel createUsernameLabel = new JLabel("Username");
     static JLabel createPasswordLabel = new JLabel("Password");
     static JLabel createAddressLabel = new JLabel("Address");
     static JPanel panel = new JPanel();
     static JButton loginButton = new JButton();
     static JButton doneButton = new JButton();
     private static JTextField loginUserTextBox;
     private static JPasswordField loginPasswordField;
     private static JTextField createFirstnameTextBox;
     private static JTextField createLastnameTextBox;
     private static JTextField createUsernameTextBox;
     private static JPasswordField createPasswordTextBox;
     private static JTextField createAddressTextBox;
     static JLabel label;
     static JLabel loginLabel;
     static JLabel createAccountLabel;
     static ImageIcon image;
     static JLabel displayImage;
     static HashMap<String, String> map = new HashMap<>();
     static  String[] accountInformation = new String[5]; 
     String firstName, lastName, address, createdUserName, createdPassword, loginPassword;
    //Methods
    static void displayAtmMenu() {                                                    
        frame = new JFrame();
        label = new JLabel();
        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        loginLabel.setFocusable(false);
        loginLabel.setBounds(190, 85, 100, 50);
        loginLabel.setForeground(Color.RED);
        
        createAccountLabel = new JLabel();
        createAccountLabel.setText("Create an account");
        createAccountLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        createAccountLabel.setFocusable(false);
        
        createAccountLabel.setBounds(110, 210, 315, 200);
        createAccountLabel.setForeground(Color.RED);    
        
        label.setText("ATM Machine");
        label.setSize(500, 500);
        label.setBounds(200, 25, 100, 50);
        
        loginUserLabel.setBounds(200, 160,80, 25);
        loginUserLabel.setVisible(true);
        
        loginPassLabel.setBounds(200,200, 80, 25);
        
        createFirstNameLabel.setBounds(200, 340, 80, 25);
        createLastNameLabel.setBounds(200, 380, 80, 25);
        createUsernameLabel.setBounds(200, 420, 80, 25);
        createPasswordLabel.setBounds(200, 460, 80, 25);
        createAddressLabel.setBounds(200, 500, 80, 25);
        
        loginUserTextBox = new JTextField(20);
        loginUserTextBox.setBounds(270,160,125,25);
        
        loginPasswordField = new JPasswordField();
        loginPasswordField.setBounds(270, 200, 125, 25);
        
        createFirstnameTextBox = new JTextField();
        createFirstnameTextBox.setBounds(270, 340, 125, 25);
        
        createLastnameTextBox = new JTextField();
        createLastnameTextBox.setBounds(270, 380, 125, 25);
        
        createUsernameTextBox = new JTextField();
        createUsernameTextBox.setBounds(270, 420, 125, 25);
        
        createPasswordTextBox = new JPasswordField();
        createPasswordTextBox.setBounds(270, 460, 125, 25);
        
        createAddressTextBox = new JTextField();
        createAddressTextBox.setBounds(270, 500, 125, 25);
        
        loginButton.setText("Login");
        loginButton.setBounds(190, 230, 80, 25);
        loginButton.addActionListener(new AtmMachine());
        
        doneButton.setText("Done");
        doneButton.setBounds(190, 530, 80, 25);
        doneButton.addActionListener(e -> JOptionPane.showMessageDialog(null, 
                "Account successfully created!\n You may now login"
                + " using your credentials."));
        
       frame.setSize(500,600);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(loginUserLabel);
       frame.add(loginPassLabel);
       frame.add(createFirstNameLabel);
       frame.add(createLastNameLabel);
       frame.add(createUsernameLabel);
       frame.add(createPasswordLabel);
       frame.add(createAddressLabel);
       frame.add(label);
       frame.add(loginUserTextBox);
       frame.add(loginPasswordField);
       frame.add(createFirstnameTextBox);
       frame.add(createLastnameTextBox);
       frame.add(createUsernameTextBox);
       frame.add(createPasswordTextBox);
       frame.add(createAddressTextBox);
       
       frame.setTitle("ATM Machine");
       frame.setLayout(null);
       frame.setVisible(true);
       frame.add(loginLabel);
       frame.add(createAccountLabel);
       frame.add(loginButton);
       frame.add(doneButton);
       frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String p = "";
        for(int i = 0; i < createPasswordTextBox.getPassword().length; i++) {
            p = p + createPasswordTextBox.getPassword()[i];
        }
        createdUserName = createUsernameTextBox.getText();
        createdPassword = p;
        loginPassword = "";
        for(int j = 0; j < loginPasswordField.getPassword().length; j++) {
            loginPassword = loginPassword + loginPasswordField.getPassword()[j];
        }
        // Grabbing the first and last name and address entered by the user to store in our arraylist
        firstName = createFirstnameTextBox.getText();
        lastName = createLastnameTextBox.getText();
        address = createAddressTextBox.getText();
        storeAccountInfo(firstName, lastName, address, createdUserName, createdPassword);
        //Verifying valid usernames and passwords
        if(!map.containsKey(createdUserName)) 
            map.put(createdUserName, createdPassword);     
        if(!map.containsKey(loginUserTextBox.getText()) || !map.containsValue(loginPassword)) {
            JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }
        else {
            frame.dispose();
            new accountDashboard();
        }
    }
    void deposit(double amount) {
        try {
            if(amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }       
    }   
    void withdraw(double amount) {
        try {
            if(amount > 0) {
                balance = balance - amount;
                previousTransaction = -amount;
            }        
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }
    String previousTransaction() {
        if(previousTransaction < 0)
            return "Withdrew: -$" + String.format("%.2f", Math.abs(previousTransaction));
        else if(previousTransaction > 0)
            return "Deposited: $" + String.format("%.2f", previousTransaction);
        else
            return "No previous transactions.";
    }  
    String showBalance() {
        return "Current balance: $" + String.format("%.2f", balance);
    }
    
    private void storeAccountInfo(String firstName, String lastName, String address, 
            String username, String password) {
        accountInformation[0] = firstName; accountInformation[1] = lastName; accountInformation[2] = address; accountInformation[3] = username; accountInformation[4] = password;
    }
    public static void main(String[] args) {
        displayAtmMenu();
    }  
}