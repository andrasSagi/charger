package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double account;
    private List<Transaction> transactions = new ArrayList<>();

    public User(double account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account += amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, account);
    }
}
