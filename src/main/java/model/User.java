package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double balance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public User(double account) {
        balance = account;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, balance);
        transactionHistory.add(transaction);
    }

    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(TransactionType.WITHDRAW, 0 - amount, balance);
        transactionHistory.add(transaction);
    }

    public void transferTo(User receiver, double amount) {
        balance -= amount;
        receiver.receiveTransfer(amount);
        Transaction transaction = new Transaction(TransactionType.TRANSFER, 0 - amount, balance);
        transactionHistory.add(transaction);
    }

    private void receiveTransfer(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(TransactionType.TRANSFER, amount, balance);
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        for (Transaction transaction: transactionHistory) {
            System.out.println(transaction.toString());
        }
    }

    public List<Transaction> filterByTransactionType(TransactionType type) {
        List<Transaction> filteredHistory = new ArrayList<>();
        for (Transaction transaction: transactionHistory) {
            if (transaction.getType().equals(type)) {
                filteredHistory.add(transaction);
            }
        }
        return filteredHistory;
    }
}
