import javax.swing.*;
import java.awt.event.*;

public class ATM {
    private static double balance = 10000;
    private static JTextArea transactionHistoryArea = new JTextArea();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Automated Tellar Machinie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel balanceLabel = new JLabel("My account balance is Rs." + balance);
        mainPanel.add(balanceLabel,SwingConstants.CENTER);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("How much amount you want to withdraw:");
                double amount = Double.parseDouble(input);
                if (balance >= amount) {
                    balance -= amount;
                    balanceLabel.setText("Balance: Rs" + balance);
                    transactionHistoryArea.append("- Rs" + amount + " (Withdraw)\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });
        mainPanel.add(withdrawButton,SwingConstants.CENTER);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("How much amount you want to deposit ?:");
                double amount = Double.parseDouble(input);
                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
                transactionHistoryArea.append("+ $" + amount + " (Deposit)\n");
            }
        });
        mainPanel.add(depositButton,SwingConstants.CENTER);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter amount to transfer:");
                double amount = Double.parseDouble(input);
                if (balance >= amount) {
                    String targetAccount = JOptionPane.showInputDialog("Enter target account number:");
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                    transactionHistoryArea.append("- $" + amount + " (Transfer to account " + targetAccount + ")\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });
        mainPanel.add(transferButton,SwingConstants.CENTER);

        JButton historyButton = new JButton("Transaction History");
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, new JScrollPane(transactionHistoryArea), "Transaction History", JOptionPane.PLAIN_MESSAGE);
            }
        });
        mainPanel.add(historyButton,SwingConstants.CENTER);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(quitButton,SwingConstants.CENTER);

        frame.add(mainPanel,SwingConstants.CENTER);
        frame.setVisible(true);
    }
}