package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public User(double account) {
        this.balance = account;
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
}
