import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class accountDashboard implements ActionListener{
    JFrame jf = new JFrame();
    JLabel jl = new JLabel("Choose An Option From The Menu:");
    JPanel jp = new JPanel();
    static JButton depositButton = new JButton();
    static JLabel depositLabel = new JLabel();
    static JButton withdrawButton = new JButton();
    static JLabel withdrawLabel = new JLabel("Withdraw");
    static JButton previousTransactionButton;
    static JLabel previousTranLabel = new JLabel("Previous transaction");
    static JButton checkBalanceButton = new JButton(); 
    static JLabel checkBalanceLabel = new JLabel("Check balance");
    static JButton exitButton;
    static JLabel exitLabel = new JLabel("Exit");
    static JButton accountInformationButton;
    static JButton logoutButton;
    static Account account = new Account();
    accountDashboard() {
        jl.setBounds(60, -20, 370, 235);
        jl.setFont(new Font(null, Font.BOLD, 20));
        jf.add(jl);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 600);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.getContentPane().setBackground(Color.WHITE);
        
        depositButton.setBounds(20,140 , 200 , 50);
        depositButton.setOpaque(true);
        depositButton.setBorderPainted(false);
        depositButton.setBackground(Color.BLACK);
        depositButton.setText("Deposit");
        depositButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        depositButton.setSize(210, 50);
        depositButton.setForeground(Color.WHITE);
        depositButton.setFocusable(false);
        jf.add(depositButton);
        //depositButton.addActionListener(e -> JOptionPane.showInputDialog(null, "Enter an amount to deposit", "Deposit", JOptionPane.INFORMATION_MESSAGE));
        depositButton.addActionListener(this);
        
        withdrawButton.setOpaque(true);
        withdrawButton.setBorderPainted(false);
        withdrawButton.setBackground(Color.BLACK);
        withdrawButton.setText("Withdraw");
        withdrawButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        withdrawButton.setSize(210, 50);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setBounds(270, 140, 210, 50);
        withdrawButton.setFocusable(false);
        jf.add(withdrawButton);
        withdrawButton.addActionListener(this);
        
        previousTransactionButton = new JButton();
        previousTransactionButton.setBounds(20, 220, 210, 50);
        previousTransactionButton.setOpaque(true);
        previousTransactionButton.setBorderPainted(false);
        previousTransactionButton.setBackground(Color.BLACK);
        previousTransactionButton.setText("Previous transaction");
        previousTransactionButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        previousTransactionButton.setSize(210, 50);
        previousTransactionButton.setForeground(Color.WHITE);
        previousTransactionButton.setFocusable(false);
        jf.add(previousTransactionButton);
        previousTransactionButton.addActionListener(this);
        
        checkBalanceButton = new JButton();
        checkBalanceButton.setBounds(270, 220, 210, 50);
        checkBalanceButton.setOpaque(true);
        checkBalanceButton.setBorderPainted(false);
        checkBalanceButton.setBackground(Color.BLACK);
        checkBalanceButton.setText("Check balance");
        checkBalanceButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        checkBalanceButton.setSize(210, 50);
        checkBalanceButton.setForeground(Color.WHITE);
        checkBalanceButton.setFocusable(false);
        checkBalanceButton.addActionListener(this);
        jf.add(checkBalanceButton);
        
        accountInformationButton = new JButton();
        accountInformationButton.setBounds(20,300 ,210, 50);
        accountInformationButton.setOpaque(true);
        accountInformationButton.setBorderPainted(false);
        accountInformationButton.setBackground(Color.BLACK);
        accountInformationButton.setText("Account information");
        accountInformationButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        accountInformationButton.setSize(210, 50);
        accountInformationButton.setForeground(Color.WHITE);
        accountInformationButton.setFocusable(false);
        accountInformationButton.addActionListener(this);
        jf.add(accountInformationButton);
        
        logoutButton = new JButton();
        logoutButton.setBounds(270,300 ,210, 50);
        logoutButton.setOpaque(true);
        logoutButton.setBorderPainted(false);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setText("Logout");
        logoutButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        logoutButton.setSize(210, 50);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        jf.add(logoutButton);
        
        exitButton = new JButton();
        exitButton.setBounds(150,380 ,200, 50);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.setBackground(Color.BLACK);
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        exitButton.setSize(200, 50);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        jf.add(exitButton);
        jf.setResizable(false);
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == depositButton) {
            String depositAmount = JOptionPane.showInputDialog(null, "Enter an amount to deposit", "Deposit", JOptionPane.INFORMATION_MESSAGE); 
            /* Convert the amount the user enters to a double then make an account object to access the deposit method that will take 
               whatever value the user entered. We do the same with withdraw
            */
            Double d = Double.parseDouble(depositAmount);   
            account.deposit(d);
        }     
       if(e.getSource() == withdrawButton) {
           try {
               String withdrawAmount = JOptionPane.showInputDialog(null, "Enter an amount to withdraw", "Withdraw", JOptionPane.INFORMATION_MESSAGE);
                Double w = Double.parseDouble(withdrawAmount);
                account.withdraw(w);
           } catch(Exception exception) {
               JOptionPane.showMessageDialog(null, "Uh oh. Nothing was withdrawn.", "No withdrawal", JOptionPane.ERROR_MESSAGE);
           }
           
       }
       if(e.getSource() == previousTransactionButton) 
           JOptionPane.showMessageDialog(null, account.previousTransaction());              
       if(e.getSource() == checkBalanceButton) 
           JOptionPane.showMessageDialog(null, account.showBalance());
       if(e.getSource() == accountInformationButton)
           new accountInformation();
       if(e.getSource() == exitButton)
           jf.dispose();
       if(e.getSource() == logoutButton) {
           jf.dispose(); 
           AtmMachine atm = new AtmMachine(); atm.displayAtmMenu();
       }
           
    }
}