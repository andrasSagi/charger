package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public User(double account) {
        balance = account;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, balance);
        transactions.add(transaction);
    }

    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(TransactionType.WITHDRAW, 0 - amount, balance);
        transactions.add(transaction);
    }

    public void transferTo(User receiver, double amount) {
        balance -= amount;
        receiver.receiveTransfer(amount);
        Transaction transaction = new Transaction(TransactionType.TRANSFER, 0 - amount, balance);
        transactions.add(transaction);
    }

    private void receiveTransfer(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(TransactionType.TRANSFER, amount, balance);
        transactions.add(transaction);
    }
}
